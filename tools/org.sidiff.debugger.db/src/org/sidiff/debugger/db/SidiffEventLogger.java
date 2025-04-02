package org.sidiff.debugger.db;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.services.ContextSensitiveService;
import org.sidiff.common.services.ServiceContext;
import org.sidiff.common.services.events.SCEvent;
import org.sidiff.common.services.events.SCEventListener;
import org.sidiff.common.util.Debugger;
import org.sidiff.common.xml.XMLParser;
import org.sidiff.core.correspondences.CorrespondencesService;
import org.sidiff.core.matching.IterativeMatchingEvent;
import org.sidiff.core.matching.MatchingEvent;
import org.sidiff.core.matching.iterative.Matcher;
import org.sidiff.core.similarities.SimilaritiesService;
import org.sidiff.core.similarities.Similarity;
import org.sidiff.core.similaritiescalculator.SimilarityCalculationEvent;
import org.sidiff.debugger.db.dumps.CorrespondencesDevelopmentDump;
import org.sidiff.debugger.db.dumps.RoundDump;
import org.sidiff.debugger.db.dumps.SimilaritiesDevelopmentDump;


public class SidiffEventLogger implements ContextSensitiveService, SCEventListener, Debugger
{
	private static final String SWITCHED_INTO_BOTTOMUP_STRING = "SWITCHED_INTO_BOTTOMUP";
	private static final String SWITCHED_INTO_TOPDOWN_STRING = "SWITCHED_INTO_TOPDOWN";
	private static final String NEW_ROUND_STARTED_STRING = "NEW_ROUND_STARTED";
	private static final String ROUND_STOPPED_STRING = "ROUND_STOPPED";
	private static final String MATCHING_FINISHED_STRING = "MATCHING_FINISHED";
	
	private static final String MATCH_CREATED_EVENT_STRING = "MATCH_CREATED_EVENT";
	private static final String MATCH_REVOKED_EVENT_STRING = "MATCH_REVOKED_EVENT";
	
	private static final String START_COMPARISON_STRING = "START_COMPARISON";
	private static final String STOP_COMPARISON_STRING = "STOP_COMPARISON";
	private static final String START_COMPAREFUNCTION_STRING = "START_COMPAREFUNCTION";
	private static final String STOP_COMPAREFUNCTION_STRING = "STOP_COMPAREFUNCTION";
	
	private static SidiffEventLogger mInstance = null;
	
	private ServiceContext mContext;
	private Resource mResourceA;
	private Resource mResourceB;
	
	private MySQLDatabase mDB;
	private int mRoundNumber;
	private int mEventNumber;
	private DebuggerConfig mConfig;
	
	private SidiffEventLogger()
	{
		mContext = null;
		mResourceA = null;
		mResourceB = null;
		
		mDB = null;
		mRoundNumber = 0;
		mEventNumber = 0;
		mConfig = null;
	}
	
	public static SidiffEventLogger getInstance()
	{
		if (mInstance == null)
		{
			mInstance = new SidiffEventLogger();
		}
		
		return mInstance;
	}
	
	public void logRounds(SCEvent event)
	{
		if (event instanceof IterativeMatchingEvent &&
		    (event.getEventID() == IterativeMatchingEvent.ROUND_STOPPED ||
		    event.getEventID() == IterativeMatchingEvent.MATCHING_FINISHED))
		{
			try
			{
				String updateLogsString = DebuggerUtil.conc("INSERT INTO `logs` (",
                                                              "`round`, ",
                                                              "`timestamp`) ",
                                                            "VALUES (",
                                                              String.valueOf(mRoundNumber), ", ",
                                                              "NOW())"); 
				
				PreparedStatement insertLogsStatement = mDB.getConnection().prepareStatement(updateLogsString);
				insertLogsStatement.executeUpdate();
				insertLogsStatement.close();
				
				for (EObject object : mContext.getService(CorrespondencesService.class).getElementsWithCorrespondences(mResourceA))
				{
					for (EObject correspondence : mContext.getService(CorrespondencesService.class).getCorrespondences(object))
					{
						String updateCorrespondencesString = DebuggerUtil.conc("INSERT INTO `correspondences` (",
                                                                                 "`logs_round`, ",
                                                                                 "`object_a`, ",
                                                                                 "`object_b`) ",
                                                                               "VALUES (",
                                                                                 String.valueOf(mRoundNumber), ", ",
                                                                                 "\"", EcoreHelper.getAffectedFeatureValue(object), "\", ",
                                                                                 "\"", EcoreHelper.getAffectedFeatureValue(correspondence), "\")");
						
						PreparedStatement insertCorrespondencesStatement = mDB.getConnection().prepareStatement(updateCorrespondencesString);
						insertCorrespondencesStatement.executeUpdate();
						insertCorrespondencesStatement.close();
					}
				}
				
				for (EObject object : EMFUtil.getAllContentAsIterable(mResourceA))
				{
					for (Similarity similarity : mContext.getService(SimilaritiesService.class).getSimilarities(object))
					{
						String updateSimilaritiesString = DebuggerUtil.conc("INSERT INTO `similarities` (",
                                                                              "`logs_round`, ",
                                                                              "`object_a`, ",
                                                                              "`object_b`, ",
                                                                              "`similarity`) ",
                                                                            "VALUES (",
                                                                              String.valueOf(mRoundNumber), ", ",
                                                                              "\"", EcoreHelper.getAffectedFeatureValue(similarity.getObject()), "\", ",
                                                                              "\"", EcoreHelper.getAffectedFeatureValue(similarity.getSimilarObject()), "\", ",
                                                                              String.valueOf(similarity.getSimilarity()), ")");
						
						PreparedStatement insertSimilaritiesStatement = mDB.getConnection().prepareStatement(updateSimilaritiesString);
						insertSimilaritiesStatement.executeUpdate();
						insertSimilaritiesStatement.close();
					}
				}
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
	}
	
	public void logEvents(SCEvent event)
	{
		try
		{
			if (event instanceof IterativeMatchingEvent)
			{
				String eventInfo = "NULL";
				String newRoundNumber = "NULL";
				String switchedMatcher = "NULL";
				
				if (event.getEventID() == IterativeMatchingEvent.SWITCHED_INTO_BOTTOMUP)
				{
					Matcher matcher = event.getObject(IterativeMatchingEvent.SWITCHED_MATCHER_FEATURE, Matcher.class);
					
					eventInfo = "\"" + SWITCHED_INTO_BOTTOMUP_STRING + "\"";
					switchedMatcher = "\"" + matcher.getClass().getSimpleName() + "\"";
				}
				else if (event.getEventID() == IterativeMatchingEvent.SWITCHED_INTO_TOPDOWN)
				{
					Matcher matcher = event.getObject(IterativeMatchingEvent.SWITCHED_MATCHER_FEATURE, Matcher.class);
					
					eventInfo = "\"" + SWITCHED_INTO_TOPDOWN_STRING + "\"";
					switchedMatcher = "\"" + matcher.getClass().getSimpleName() + "\"";
				}
				else if (event.getEventID() == IterativeMatchingEvent.NEW_ROUND_STARTED)
				{
					int round = event.getObject(IterativeMatchingEvent.NEW_ROUND_NUMBER_FEATURE, Integer.class);
	
					eventInfo = "\"" + NEW_ROUND_STARTED_STRING + "\"";
					newRoundNumber = "\"" + String.valueOf(round) + "\"";
				}
				// additional events from viktor
				else if (event.getEventID() == IterativeMatchingEvent.ROUND_STOPPED)
				{
					eventInfo = "\"" + ROUND_STOPPED_STRING + "\"";
				}
				else if (event.getEventID() == IterativeMatchingEvent.MATCHING_FINISHED)
				{
					eventInfo = "\"" + MATCHING_FINISHED_STRING + "\"";
				}
				
				String updateEventsString = DebuggerUtil.conc("INSERT INTO `events` (" +
                                                                "id, ",
                                                                "event_type, ",
                                                                "round) ",
                                                              "VALUES (",
                                                                String.valueOf(mEventNumber), ", ", 
                                                                "\"iterativematching_event\", ",
                                                                String.valueOf(mRoundNumber), ")");
				
				String updateIterativeMatchingEventsString = DebuggerUtil.conc("INSERT INTO `iterativematching_events` (",
                                                                                 "events_id, ",
                                                                                 "event_info, ", 
                                                                                 "switched_matcher, ",
                                                                                 "new_round_number) ",
                                                                               "VALUES (",
                                                                                 String.valueOf(mEventNumber), ", ",
                                                                                 eventInfo, ", ",
                                                                                 switchedMatcher, ", ",
                                                                                 String.valueOf(newRoundNumber), ")");
				
				PreparedStatement insertEventsStatement = mDB.getConnection().prepareStatement(updateEventsString);
				insertEventsStatement.executeUpdate();
				insertEventsStatement.close();
				
				PreparedStatement insertIterativeMatchingEventsStatement = mDB.getConnection().prepareStatement(updateIterativeMatchingEventsString);
				insertIterativeMatchingEventsStatement.executeUpdate();
				insertIterativeMatchingEventsStatement.close();
				
				mEventNumber++;
			}
			else if (event instanceof MatchingEvent)
			{
				String eventInfo = "NULL";
				String objectA = "NULL";
				String objectB = "NULL";
				
				if (event.getEventID() == MatchingEvent.MATCH_CREATED_EVENT)
				{
					eventInfo = "\"" + MATCH_CREATED_EVENT_STRING + "\"";
					objectA = "\"" + EcoreHelper.getAffectedFeatureValue(event.getObject(MatchingEvent.MATCHED_ELEMENT_A_FEATURE, EObject.class)) + "\"";
					objectB = "\"" + EcoreHelper.getAffectedFeatureValue(event.getObject(MatchingEvent.MATCHED_ELEMENT_B_FEATURE, EObject.class)) + "\"";
				}
				else if (event.getEventID() == MatchingEvent.MATCH_REVOKED_EVENT)
				{
					eventInfo = "\"" + MATCH_REVOKED_EVENT_STRING + "\"";
					objectA = "\"" + EcoreHelper.getAffectedFeatureValue(event.getObject(MatchingEvent.MATCHED_ELEMENT_A_FEATURE, EObject.class)) + "\"";
					objectB = "\"" + EcoreHelper.getAffectedFeatureValue(event.getObject(MatchingEvent.MATCHED_ELEMENT_B_FEATURE, EObject.class)) + "\"";
				}
				
				String updateEventsString = DebuggerUtil.conc("INSERT INTO `events` (",
                                                                "id, ",
                                                                "event_type, ",
                                                                "round) ",
                                                              "VALUES (",
                                                                String.valueOf(mEventNumber), ", ", 
                                                                "\"matching_event\", ",
                                                                String.valueOf(mRoundNumber), ")");
				
				String updateMatchingEventsString = DebuggerUtil.conc("INSERT INTO `matching_events` (",
                                                                        "events_id, ",
                                                                        "event_info, ",
                                                                        "object_a, ",
                                                                        "object_b) ",
                                                                      "VaLUES (",
                                                                        String.valueOf(mEventNumber), ", ",
                                                                        "", eventInfo, ", ",
                                                                        "", objectA, ", ",
                                                                        "", objectB, ")");
				
				PreparedStatement insertEventsStatement = mDB.getConnection().prepareStatement(updateEventsString);
				insertEventsStatement.executeUpdate();
				insertEventsStatement.close();
				
				PreparedStatement insertMatchingEvents = mDB.getConnection().prepareStatement(updateMatchingEventsString);
				insertMatchingEvents.executeUpdate();
				insertMatchingEvents.close();
				
				mEventNumber++;
			}
			else if (event instanceof SimilarityCalculationEvent)
			{
				String eventInfo = "NULL";
				String objectA = "NULL";
				String objectB = "NULL";
				String compareFunction = "NULL";
				String comparisonSimilarityValue = "NULL";
				String result = "NULL";
				
				if (event.getEventID() == SimilarityCalculationEvent.START_COMPARISON)
				{
					eventInfo = "\"" + START_COMPARISON_STRING + "\"";
					objectA = "\"" + EcoreHelper.getAffectedFeatureValue(event.getObject(SimilarityCalculationEvent.COMPARISON_ELEMENT_A_FEATURE, EObject.class)) + "\"";
					objectB = "\"" + EcoreHelper.getAffectedFeatureValue(event.getObject(SimilarityCalculationEvent.COMPARISON_ELEMENT_B_FEATURE, EObject.class)) + "\"";
				}
				else if (event.getEventID() == SimilarityCalculationEvent.STOP_COMPARISON)
				{
					eventInfo = "\"" + STOP_COMPARISON_STRING + "\"";
					objectA = "\"" + EcoreHelper.getAffectedFeatureValue(event.getObject(SimilarityCalculationEvent.COMPARISON_ELEMENT_A_FEATURE, EObject.class)) + "\"";
					objectB = "\"" + EcoreHelper.getAffectedFeatureValue(event.getObject(SimilarityCalculationEvent.COMPARISON_ELEMENT_B_FEATURE, EObject.class)) + "\"";
					comparisonSimilarityValue = String.valueOf(event.getObject(SimilarityCalculationEvent.COMPARISON_SIMILARITY_VALUE, Float.class));
				}
				else if (event.getEventID() == SimilarityCalculationEvent.START_COMPAREFUNCTION)
				{
					eventInfo = "\"" + START_COMPAREFUNCTION_STRING + "\"";
					compareFunction = "\"" + event.getObject(SimilarityCalculationEvent.COMPAREFUNCTION_FEATURE, Object.class).getClass().getSimpleName() + "\"";
				}
				else if (event.getEventID() == SimilarityCalculationEvent.STOP_COMPAREFUNCTION)
				{
					eventInfo = "\"" + STOP_COMPAREFUNCTION_STRING + "\"";
					result = String.valueOf(event.getObject(SimilarityCalculationEvent.RESULT_FEATURE, Float.class));
				}
				
				String updateEventsString = DebuggerUtil.conc("INSERT INTO `events` (",
                                                                "id, ",
                                                                "event_type, ",
                                                                "round) ",
                                                              "VALUES (",
                                                                String.valueOf(mEventNumber), ", " ,
                                                                "\"similaritycalculation_event\", ",
                                                                String.valueOf(mRoundNumber), ")");
				
				String updateSimilarityCalculationEventsString = DebuggerUtil.conc("INSERT INTO `similaritycalculation_events` (",
                                                                                     "events_id, ",
                                                                                     "event_info, ",
                                                                                     "object_a, ",
                                                                                     "object_b, ",
                                                                                     "compare_function, ",
                                                                                     "comparison_similarity_value, ",
                                                                                     "result) ",
                                                                                   "VaLUES (",
                                                                                     String.valueOf(mEventNumber), ", ",
                                                                                     "", eventInfo, ", ",
                                                                                     "", objectA, ", ", 
                                                                                     "" + objectB, ", ",
                                                                                     compareFunction, ", ",
                                                                                     String.valueOf(comparisonSimilarityValue), ", ",
                                                                                     String.valueOf(result), ")"); 
				
				PreparedStatement insertEventsStatement = mDB.getConnection().prepareStatement(updateEventsString);
				insertEventsStatement.executeUpdate();
				insertEventsStatement.close();
				
				PreparedStatement insertSimilarityCalculationEventsStatement = mDB.getConnection().prepareStatement(updateSimilarityCalculationEventsString);
				insertSimilarityCalculationEventsStatement.executeUpdate();
				insertSimilarityCalculationEventsStatement.close();
				
				mEventNumber++;
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	
	@Override
	public void eventDispatched(SCEvent event)
	{
		if (event instanceof IterativeMatchingEvent &&
		    event.getEventID() == IterativeMatchingEvent.NEW_ROUND_STARTED)
		{
			mRoundNumber = event.getObject(IterativeMatchingEvent.NEW_ROUND_NUMBER_FEATURE, Integer.class);
		}
		
		logRounds(event);
		logEvents(event);
		
		if (event instanceof IterativeMatchingEvent &&
		    event.getEventID() == IterativeMatchingEvent.MATCHING_FINISHED)
		{
			try
			{
				mDB.close();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
			
			if (mConfig.getExportMode().equals("all"))
			{
				exportAll();
			}
			else if (mConfig.getExportMode().equals("single"))
			{
				exportSimilaritiesDevelopmentsOfObject(mConfig.getExportObject(), mConfig.getExportResource());
				exportCorrespondencesDevelopmentsOfObject(mConfig.getExportObject(), mConfig.getExportResource());
			}
		}
	}

	@Override
	public void initialize(ServiceContext serviceContext, Object... args)
	{
		mContext = serviceContext;
		mResourceA = (Resource) args[0];
		mResourceB = (Resource) args[1];
		
		mDB = new MySQLDatabase();
		mRoundNumber = 0;
		
		try
		{
			mConfig = DebuggerUtil.readConfig(XMLParser.parseStream(IOUtil.getInputStream("config.xml")));
			
			if (mConfig.getDatabaseAutoReset())
			{
				dropTables();
				createTables();
			}
			
			// let connection open for the logging session
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			mDB.getConnection().setAutoCommit(true);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			System.err.println("Can't log due to a config loading error!");
			return;
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
			System.err.println("Can't log due to a database error!");
			return;
		}
		
		mContext.addEventListener(null, SidiffEventLogger.getInstance());
	}
	
	private RoundDump createRoundDumpFromLogs(int round)
	{
		RoundDump logsDump = new RoundDump();
		
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			
			String querySimilaritiesString = DebuggerUtil.conc("SELECT * FROM `similarities`",
                                                               "WHERE `logs_round`=", String.valueOf(round));
			
			PreparedStatement similaritiesStatement = mDB.getConnection().prepareStatement(querySimilaritiesString);
			ResultSet similaritiesResult = similaritiesStatement.executeQuery();
			
			while (similaritiesResult.next())
			{
				String objectA = similaritiesResult.getString("object_a");
				String objectB = similaritiesResult.getString("object_b");
				float similarityValue = similaritiesResult.getFloat("similarity");
				
				logsDump.setSimilarity(objectA, objectB, similarityValue);
			}
			
			similaritiesStatement.close();
			
			String queryCorrespondencesString = DebuggerUtil.conc("SELECT * FROM `correspondences`",
                                                                  "WHERE `logs_round`=", String.valueOf(round));
			
			PreparedStatement correspondencesStatement = mDB.getConnection().prepareStatement(queryCorrespondencesString);;
			ResultSet correspondencesResult = correspondencesStatement.executeQuery();
			
			while (correspondencesResult.next())
			{
				String objectA = correspondencesResult.getString("object_a");
				String objectB = correspondencesResult.getString("object_b");
				
				logsDump.setCorrespondence(objectA, objectB, true);
			}
			
			correspondencesStatement.close();
			
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return logsDump;
	}
	
	private RoundDump createRoundDumpFromEvents(int round)
	{
		RoundDump eventsDump = new RoundDump();
		
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			
			for (int i = 0; i <= round; i++)
			{
				String queryEventsString = DebuggerUtil.conc("SELECT * FROM `events`",
                                                             "WHERE `round`=", String.valueOf(i));
				
				PreparedStatement eventsStatement = mDB.getConnection().prepareStatement(queryEventsString);
				ResultSet eventsResult = eventsStatement.executeQuery();
				
				while (eventsResult.next())
				{
					int eventID = eventsResult.getInt("id");
					String eventType = eventsResult.getString("event_type");
					
					if (eventType.equals("similaritycalculation_event"))
					{
						String querySimilarityCalculationEventsString = DebuggerUtil.conc("SELECT * FROM `similaritycalculation_events`",
                                                                                          "WHERE `events_id`=", String.valueOf(eventID));
						
						PreparedStatement similaritiyCalculationEventsStatement = mDB.getConnection().prepareStatement(querySimilarityCalculationEventsString);
						ResultSet similarityCalculationEventsResult = similaritiyCalculationEventsStatement.executeQuery();
						
						// while-loop not necessary here
						while (similarityCalculationEventsResult.next())
						{
							String eventInfo = similarityCalculationEventsResult.getString("event_info");
							
							if (eventInfo.equals(STOP_COMPARISON_STRING))
							{
								String objectA = similarityCalculationEventsResult.getString("object_a");
								String objectB = similarityCalculationEventsResult.getString("object_b");
								float similarityValue = similarityCalculationEventsResult.getFloat("comparison_similarity_value");
								
								eventsDump.setSimilarity(objectA, objectB, similarityValue);
							}
						}
						
						similaritiyCalculationEventsStatement.close();
					}
					else if (eventType.equals("matching_event"))
					{
						String queryMatchingEventsString = DebuggerUtil.conc("SELECT * FROM `matching_events`",
                                                                             "WHERE `events_id`=", String.valueOf(eventID));
						
						PreparedStatement matchingEventsStatement = mDB.getConnection().prepareStatement(queryMatchingEventsString);
						ResultSet matchingEventsResult = matchingEventsStatement.executeQuery();
						
						// while-loop not necessary here
						while (matchingEventsResult.next())
						{
							String eventInfo = matchingEventsResult.getString("event_info");
							
							if (eventInfo.equals(MATCH_CREATED_EVENT_STRING))
							{
								String objectA = matchingEventsResult.getString("object_a");
								String objectB = matchingEventsResult.getString("object_b");
								
								eventsDump.setCorrespondence(objectA, objectB, true);
							}
							else if (eventInfo.equals(MATCH_REVOKED_EVENT_STRING))
							{
								String objectA = matchingEventsResult.getString("object_a");
								String objectB = matchingEventsResult.getString("object_b");
								
								eventsDump.setCorrespondence(objectA, objectB, false);
							}
						}
						
						matchingEventsStatement.close();
					}
				}
			}
			
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return eventsDump;
	}
	
	private SimilaritiesDevelopmentDump createSimilaritiesDevelopmentDump()
	{
		SimilaritiesDevelopmentDump similaritiesDump = new SimilaritiesDevelopmentDump();
		
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			
			String queryEventsString = DebuggerUtil.conc("SELECT * FROM `events`");
			
			PreparedStatement eventsStatement = mDB.getConnection().prepareStatement(queryEventsString);
			ResultSet eventsResult = eventsStatement.executeQuery();
			
			while (eventsResult.next())
			{
				int eventID = eventsResult.getInt("id");
				String eventType = eventsResult.getString("event_type");
				int round = eventsResult.getInt("round");
				
				if (eventType.equals("similaritycalculation_event"))
				{
					String querySimilarityCalculationEventsString = DebuggerUtil.conc("SELECT * FROM `similaritycalculation_events`",
                                                                                      "WHERE `events_id`=", String.valueOf(eventID));
					
					PreparedStatement similaritiyCalculationEventsStatement = mDB.getConnection().prepareStatement(querySimilarityCalculationEventsString);
					ResultSet similarityCalculationEventsResult = similaritiyCalculationEventsStatement.executeQuery();
					
					// while-loop not necessary here
					while (similarityCalculationEventsResult.next())
					{
						String eventInfo = similarityCalculationEventsResult.getString("event_info");
						
						if (eventInfo.equals(STOP_COMPARISON_STRING))
						{
							String objectA = similarityCalculationEventsResult.getString("object_a");
							String objectB = similarityCalculationEventsResult.getString("object_b");
							float similarityValue = similarityCalculationEventsResult.getFloat("comparison_similarity_value");
							
							similaritiesDump.addSimilarity(objectA, objectB, similarityValue, round);
						}
					}
					
					similaritiyCalculationEventsStatement.close();
				}
			}
			
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return similaritiesDump;
	}
	
	private CorrespondencesDevelopmentDump createCorrespondencesDevelopmentDump()
	{
		CorrespondencesDevelopmentDump correspondencesDump = new CorrespondencesDevelopmentDump();
		
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			
			String queryEventsString = DebuggerUtil.conc("SELECT * FROM `events`");
			
			Statement eventsStatement = mDB.getConnection().createStatement();
			ResultSet eventsResult = eventsStatement.executeQuery(queryEventsString);
			
			while (eventsResult.next())
			{
				int eventID = eventsResult.getInt("id");
				String eventType = eventsResult.getString("event_type");
				int round = eventsResult.getInt("round");
				
				if (eventType.equals("matching_event"))
				{
					String queryMatchingEventsString = DebuggerUtil.conc("SELECT * FROM `matching_events`",
                                                                         "WHERE `events_id`=", String.valueOf(eventID));
					
					Statement matchingEventsStatement = mDB.getConnection().createStatement();
					ResultSet matchingEventsResult = matchingEventsStatement.executeQuery(queryMatchingEventsString);
					
					// while-loop not necessary here
					while (matchingEventsResult.next())
					{
						String eventInfo = matchingEventsResult.getString("event_info");
						
						if (eventInfo.equals(MATCH_CREATED_EVENT_STRING))
						{
							String objectA = matchingEventsResult.getString("object_a");
							String objectB = matchingEventsResult.getString("object_b");
							
							correspondencesDump.addCorrespondence(objectA, objectB, true, round);
						}
						else if (eventInfo.equals(MATCH_REVOKED_EVENT_STRING))
						{
							String objectA = matchingEventsResult.getString("object_a");
							String objectB = matchingEventsResult.getString("object_b");
							
							correspondencesDump.addCorrespondence(objectA, objectB, false, round);
						}
					}
					
					matchingEventsStatement.close();
				}
			}
			
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return correspondencesDump;
	}
	
	public String createTables()
	{
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			MySQLScript create = DebuggerUtil.readCreateTablesScript();
			mDB.executeScript(create);
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return "Finished!";
	}
	
	public String dropTables()
	{		
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			MySQLScript drop = DebuggerUtil.readDropTablesScript();
			mDB.executeScript(drop);
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return "Finished!";
	}
	
	public String listResource(String resource)
	{
		if (!resource.equals("A") && !resource.equals("B")) return "";
		
		String output = "";
		
		if (resource.equals("A"))
		{
			for (EObject object : EMFUtil.getAllContentAsIterable(mResourceA))
			{
				output += EcoreHelper.getAffectedFeatureValue(object) + "\n";
			}
		}
		else if (resource.equals("B"))
		{
			for (EObject object : EMFUtil.getAllContentAsIterable(mResourceB))
			{
				output += EcoreHelper.getAffectedFeatureValue(object) + "\n";
			}
		}
		
		return output;
	}
	
	public String listSimilarities()
	{
		String output = "";
		
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			
			PreparedStatement logsStatement = null;
			PreparedStatement similaritiesStatement = null;
			
			ResultSet logsResult = null;
			ResultSet similaritiesResult = null;
			
			String queryLogsString = "SELECT * FROM `logs`";
			logsStatement = mDB.getConnection().prepareStatement(queryLogsString);
			
			logsResult = logsStatement.executeQuery();
			
			while (logsResult.next())
			{
				int round = logsResult.getInt("round");
				Timestamp timestamp = logsResult.getTimestamp("timestamp");
				
				String querySimilaritiesString = DebuggerUtil.conc("SELECT * FROM `similarities`",
					                                               "WHERE `logs_round`=", String.valueOf(round));
				
				similaritiesStatement = mDB.getConnection().prepareStatement(querySimilaritiesString);
				similaritiesResult = similaritiesStatement.executeQuery();
				
				while (similaritiesResult.next())
				{
					String objectA = similaritiesResult.getString("object_a");
					String objectB = similaritiesResult.getString("object_b");
					float similarity = similaritiesResult.getFloat("similarity");
					
					output += "[" + timestamp.toString() + "] round=" + round + ", object_a=" + objectA + ", object_b=" + objectB + ", similarity=" + similarity + "\n";
				}
				
				similaritiesStatement.close();
			}
			
			logsStatement.close();
			
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		output += "Finished!";
		
		return output;
	}
	
	public String listCorrespondences()
	{
		String output = "";
		
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			
			PreparedStatement logsStatement = null;
			PreparedStatement correspondencesStatement = null;
			
			ResultSet logsResult = null;
			ResultSet correspondencesResult = null;
			
			String queryLogsString = "SELECT * FROM `logs`";
			logsStatement = mDB.getConnection().prepareStatement(queryLogsString);
			
			logsResult = logsStatement.executeQuery();
			
			while (logsResult.next())
			{
				int round = logsResult.getInt("round");
				Timestamp timestamp = logsResult.getTimestamp("timestamp");
				
				String queryCorrespondencesString = DebuggerUtil.conc("SELECT * FROM `correspondences`",
					                                                  "WHERE `logs_round`=", String.valueOf(round));
				
				correspondencesStatement = mDB.getConnection().prepareStatement(queryCorrespondencesString);
				correspondencesResult = correspondencesStatement.executeQuery();
				
				while (correspondencesResult.next())
				{
					String objectA = correspondencesResult.getString("object_a");
					String objectB = correspondencesResult.getString("object_b");
					
					output += "[" + timestamp.toString() + "] round=" + round + ", object_a=" + objectA + ", object_b=" + objectB + "\n";
				}
				
				correspondencesStatement.close();
			}
			
			logsStatement.close();
			
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		output += "Finished!";
		
		return output;
	}
	
	public String listSimilaritiesOfObject(String object, String resource)
	{
		if (!resource.equals("A") && !resource.equals("B")) return "";
		
		String output = "";
		
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			
			PreparedStatement logsStatement = null;
			PreparedStatement similaritiesStatement = null;
			
			ResultSet logsResult = null;
			ResultSet similaritiesResult = null;
			
			String queryLogsString = "SELECT * FROM `logs`";
			logsStatement = mDB.getConnection().prepareStatement(queryLogsString);
			
			logsResult = logsStatement.executeQuery();
			
			while (logsResult.next())
			{
				int round = logsResult.getInt("round");
				Timestamp timestamp = logsResult.getTimestamp("timestamp");
				
				if (resource.equals("A"))
				{
					String querySimilaritiesString = DebuggerUtil.conc("SELECT * FROM `similarities`",
					                                                   "WHERE `object_a`=\"", object, "\" AND `logs_round`=", String.valueOf(round));
					
					similaritiesStatement = mDB.getConnection().prepareStatement(querySimilaritiesString);
					
					similaritiesResult = similaritiesStatement.executeQuery();
				}
				else if (resource.equals("B"))
				{
					String querySimilaritiesString = DebuggerUtil.conc("SELECT * FROM `similarities` ", 
					                                                   "WHERE `object_b`=\"", object, "\" AND `logs_round`=", String.valueOf(round));
					
					similaritiesStatement = mDB.getConnection().prepareStatement(querySimilaritiesString);
					
					similaritiesResult = similaritiesStatement.executeQuery();
				}
				
				while (similaritiesResult.next())
				{
					String objectA = similaritiesResult.getString("object_a");
					String objectB = similaritiesResult.getString("object_b");
					float similarity = similaritiesResult.getFloat("similarity");
					
					output += "[" + timestamp.toString() + "] round=" + round + ", object_a=" + objectA + ", object_b=" + objectB + ", similarity=" + similarity + "\n";
				}
				
				similaritiesStatement.close();
			}
			
			logsStatement.close();
			
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		output += "Finished!";
		
		return output;
	}
	
	public String listCorrespondencesOfObject(String object, String resource)
	{
		if (!resource.equals("A") && !resource.equals("B")) return "";
		
		String output = "";
		
		try
		{
			mDB.connect(mConfig.getDatabaseUser(), mConfig.getDatabasePassword(), mConfig.getDatabaseName(), mConfig.getDatabaseServer(), mConfig.getDatabasePort());
			
			PreparedStatement logsStatement = null;
			PreparedStatement correspondencesStatement = null;
			
			ResultSet logsResult = null;
			ResultSet correspondencesResult = null;
			
			String queryLogsString = "SELECT * FROM `logs`";
			logsStatement = mDB.getConnection().prepareStatement(queryLogsString);
			
			logsResult = logsStatement.executeQuery();
			
			while (logsResult.next())
			{
				int round = logsResult.getInt("round");
				Timestamp timestamp = logsResult.getTimestamp("timestamp");
				
				if (resource.equals("A"))
				{
					String queryCorrespondencesString = DebuggerUtil.conc("SELECT * FROM `correspondences`",
                                                                          "WHERE `object_a`=\"", object, "\" AND `logs_round`=", String.valueOf(round));
					
					correspondencesStatement = mDB.getConnection().prepareStatement(queryCorrespondencesString);
					
					correspondencesResult = correspondencesStatement.executeQuery(queryCorrespondencesString);
				}
				else if (resource.equals("B"))
				{
					String queryCorrespondencesString = DebuggerUtil.conc("SELECT * FROM `correspondences` ", 
                                                                          "WHERE `object_b`=\"", object, "\" AND `logs_round`=", String.valueOf(round));
					
					correspondencesStatement = mDB.getConnection().prepareStatement(queryCorrespondencesString);
					
					correspondencesResult = correspondencesStatement.executeQuery(queryCorrespondencesString);
				}
				
				while (correspondencesResult.next())
				{
					String objectA = correspondencesResult.getString("object_a");
					String objectB = correspondencesResult.getString("object_b");
					
					output += "[" + timestamp.toString() + "] round=" + round + ", object_a=" + objectA + ", object_b=" + objectB + "\n";
				}
				
				correspondencesStatement.close();
			}
			
			logsStatement.close();
			
			mDB.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		output += "Finished!";
		
		return output;
	}
	
	public String verifyRound(String roundString)
	{
		String output = "";
		
		int round = Integer.parseInt(roundString);
		
		output += "Verifying round " + round + "...\n";
		
		RoundDump logsDump = createRoundDumpFromLogs(round);
		RoundDump eventsDump = createRoundDumpFromEvents(round);
		
		boolean similaritiesLogsIsPartOfEvents = DebuggerUtil.roundDumpSimilaritiesAIsPartOfB(logsDump, eventsDump);
		boolean similaritiesEventsIsPartOfLogs = DebuggerUtil.roundDumpSimilaritiesAIsPartOfB(eventsDump, logsDump);
		boolean correspondencesLogsIsPartOfEvents = DebuggerUtil.roundDumpCorrespondencesAIsPartOfB(logsDump, eventsDump);
		boolean correspondencesEventsIsPartOfLogs = DebuggerUtil.roundDumpCorrespondencesAIsPartOfB(eventsDump, logsDump);
		
		output += "Similarities of Logs in Events: " + similaritiesLogsIsPartOfEvents + "\n";
		output += "Similarities of Events in Logs: " + similaritiesEventsIsPartOfLogs + "\n";
		output += "Correspondences of Logs in Events: " + correspondencesLogsIsPartOfEvents + "\n";
		output += "Correspondences of Events in Logs: " + correspondencesEventsIsPartOfLogs + "\n";
		
		return output;
	}
	
	public String verifyAll()
	{
		String output = "";
		
		for (int i = 0; i <= mRoundNumber; i++)
		{
			output += verifyRound(String.valueOf(i)) + "\n";
		}
		
		output += "Finished!";
		
		return output;
	}
	
	public String exportSimilaritiesDevelopmentsOfObject(String object, String resource)
	{
		try
		{
			SimilaritiesDevelopmentDump dump = createSimilaritiesDevelopmentDump();
			
			(new File(mConfig.getExportDirectory() + "similarities/")).mkdirs();
			
			String fileName = object.replace(":", ""); // remove not allowed chars
			
			DebuggerUtil.writeStringToFile(IOUtil.getOutputStreamIntoFile(mConfig.getExportDirectory() + "similarities/" + fileName + ".csv"),
                                           DebuggerUtil.createSimilaritiesDevelopmentExport(dump,
                                                                                            object,
                                                                                            resource));
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return "Finished!";
	}
	
	public String exportCorrespondencesDevelopmentsOfObject(String object, String resource)
	{
		try
		{
			CorrespondencesDevelopmentDump dump = createCorrespondencesDevelopmentDump();
			
			(new File(mConfig.getExportDirectory() + "correspondences/")).mkdirs();
			
			String fileName = object.replace(":", ""); // remove not allowed chars
			
			DebuggerUtil.writeStringToFile(IOUtil.getOutputStreamIntoFile(mConfig.getExportDirectory() + "correspondences/" + fileName + ".csv"),
                                           DebuggerUtil.createCorrespondencesDevelopmentExport(dump,
                                                                                               object,
                                                                                               resource));
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return "Finished!";
	}
	
	public String exportSimilaritiesDevelopments()
	{
		try
		{
			SimilaritiesDevelopmentDump dump = createSimilaritiesDevelopmentDump();
			
			(new File(mConfig.getExportDirectory() + "similarities/A/")).mkdirs();
			(new File(mConfig.getExportDirectory() + "similarities/B/")).mkdirs();
			
			for (EObject object : EMFUtil.getAllContentAsIterable(mResourceA))
			{
				String objectString = EcoreHelper.getAffectedFeatureValue(object);
				String fileName = objectString.replace(":", ""); // remove not allowed chars
				
				DebuggerUtil.writeStringToFile(IOUtil.getOutputStreamIntoFile(mConfig.getExportDirectory() + "similarities/A/" + fileName + ".csv"),
                                               DebuggerUtil.createSimilaritiesDevelopmentExport(dump,
                                                                                                objectString,
                                                                                                "A"));
			}
			
			for (EObject object : EMFUtil.getAllContentAsIterable(mResourceB))
			{
				String objectString = EcoreHelper.getAffectedFeatureValue(object);
				String fileName = objectString.replace(":", ""); // remove not allowed chars
				
				DebuggerUtil.writeStringToFile(IOUtil.getOutputStreamIntoFile(mConfig.getExportDirectory() + "similarities/B/" + fileName + ".csv"),
                                               DebuggerUtil.createSimilaritiesDevelopmentExport(dump,
                                                                                                objectString,
                                                                                                "B"));
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return "Finished!";
	}
	
	public String exportCorrespondencesDevelopments()
	{
		try
		{
			CorrespondencesDevelopmentDump dump = createCorrespondencesDevelopmentDump();
			
			(new File(mConfig.getExportDirectory() + "correspondences/A/")).mkdirs();
			(new File(mConfig.getExportDirectory() + "correspondences/B/")).mkdirs();
			
			for (EObject object : EMFUtil.getAllContentAsIterable(mResourceA))
			{
				String objectString = EcoreHelper.getAffectedFeatureValue(object);
				String fileName = objectString.replace(":", ""); // remove not allowed chars
				
				DebuggerUtil.writeStringToFile(IOUtil.getOutputStreamIntoFile(mConfig.getExportDirectory() + "correspondences/A/" + fileName + ".csv"),
                                               DebuggerUtil.createCorrespondencesDevelopmentExport(dump,
                                                                                                   objectString,
                                                                                                   "A"));
			}
			
			for (EObject object : EMFUtil.getAllContentAsIterable(mResourceB))
			{
				String objectString = EcoreHelper.getAffectedFeatureValue(object);
				String fileName = objectString.replace(":", ""); // remove not allowed chars
				
				DebuggerUtil.writeStringToFile(IOUtil.getOutputStreamIntoFile(mConfig.getExportDirectory() + "correspondences/B/" + fileName + ".csv"),
                                               DebuggerUtil.createCorrespondencesDevelopmentExport(dump,
                                                                                                   objectString,
                                                                                                   "B"));
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return "Finished!";
	}
	
	public String exportAll()
	{
		exportSimilaritiesDevelopments();
		exportCorrespondencesDevelopments();
		
		return "Finished!";
	}

	@Override
	public String help()
	{
		return "createTables: creates the necessary tables manually\n" +
		       "dropTables: drops the tables manually\n" +
		       "listResource [resource]: lists all objects of the specified resource\n" +
		       "listSimilarities: lists all final similarities\n" +
		       "listCorrespondences: lists all final correspondences\n" +
		       "listSimilaritiesOfObject [object, resource]: lists all similarities of the object in the specified resource\n" +
		       "listCorrespondencesOfObject [object, resource]: lists all correspondences of the object in the specified resource\n" +
		       "verifyRound [round]: verify a specified round by the event logs\n" +
		       "verifyAll: verify all rounds by the event logs\n" +
		       "exportSimilaritiesDevelopmentsOfObject [object, resource]: exports the developments of the similarities of one object into a file" +
		       "exportCorrespondencesDevelopmentsOfObjec [object, resource]: exports the developments of the correspondences of one object into a file" +
		       "exportSimilaritiesDevelopments: exports the developments of all similarities into files\n" +
		       "exportCorrespondencesDevelopments: exports the developments of all correspondences into files\n" +
		       "exportAll: exports the developments of all similarities and correspondences into files\n";
	}
}
