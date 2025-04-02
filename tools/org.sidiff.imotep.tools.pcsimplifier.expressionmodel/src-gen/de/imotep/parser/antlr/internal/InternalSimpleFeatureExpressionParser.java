package de.imotep.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.imotep.services.SimpleFeatureExpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimpleFeatureExpressionParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_NEGATION", "RULE_BINARY_OPEATOR", "RULE_WS", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=7;
    public static final int RULE_STRING=9;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_INT=8;
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_BINARY_OPEATOR=6;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_NEGATION=5;

    // delegates
    // delegators


        public InternalSimpleFeatureExpressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleFeatureExpressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleFeatureExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSimpleFeatureExpression.g"; }



     	private SimpleFeatureExpressionGrammarAccess grammarAccess;

        public InternalSimpleFeatureExpressionParser(TokenStream input, SimpleFeatureExpressionGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "SimpleFeatureExpression";
       	}

       	@Override
       	protected SimpleFeatureExpressionGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSimpleFeatureExpression"
    // InternalSimpleFeatureExpression.g:64:1: entryRuleSimpleFeatureExpression returns [EObject current=null] : iv_ruleSimpleFeatureExpression= ruleSimpleFeatureExpression EOF ;
    public final EObject entryRuleSimpleFeatureExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleFeatureExpression = null;


        try {
            // InternalSimpleFeatureExpression.g:64:64: (iv_ruleSimpleFeatureExpression= ruleSimpleFeatureExpression EOF )
            // InternalSimpleFeatureExpression.g:65:2: iv_ruleSimpleFeatureExpression= ruleSimpleFeatureExpression EOF
            {
             newCompositeNode(grammarAccess.getSimpleFeatureExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleFeatureExpression=ruleSimpleFeatureExpression();

            state._fsp--;

             current =iv_ruleSimpleFeatureExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleFeatureExpression"


    // $ANTLR start "ruleSimpleFeatureExpression"
    // InternalSimpleFeatureExpression.g:71:1: ruleSimpleFeatureExpression returns [EObject current=null] : ( ( (lv_var_0_0= RULE_ID ) ) | ( ( (lv_neg_1_0= RULE_NEGATION ) ) ( (lv_var_2_0= RULE_ID ) ) ) | ( ( (lv_neg_3_0= RULE_NEGATION ) ) otherlv_4= '(' ( (lv_braExpr_5_0= ruleBracedExpression ) ) otherlv_6= ')' ) | (otherlv_7= '(' ( (lv_braExpr_8_0= ruleBracedExpression ) ) otherlv_9= ')' ) ) ;
    public final EObject ruleSimpleFeatureExpression() throws RecognitionException {
        EObject current = null;

        Token lv_var_0_0=null;
        Token lv_neg_1_0=null;
        Token lv_var_2_0=null;
        Token lv_neg_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_braExpr_5_0 = null;

        EObject lv_braExpr_8_0 = null;



        	enterRule();

        try {
            // InternalSimpleFeatureExpression.g:77:2: ( ( ( (lv_var_0_0= RULE_ID ) ) | ( ( (lv_neg_1_0= RULE_NEGATION ) ) ( (lv_var_2_0= RULE_ID ) ) ) | ( ( (lv_neg_3_0= RULE_NEGATION ) ) otherlv_4= '(' ( (lv_braExpr_5_0= ruleBracedExpression ) ) otherlv_6= ')' ) | (otherlv_7= '(' ( (lv_braExpr_8_0= ruleBracedExpression ) ) otherlv_9= ')' ) ) )
            // InternalSimpleFeatureExpression.g:78:2: ( ( (lv_var_0_0= RULE_ID ) ) | ( ( (lv_neg_1_0= RULE_NEGATION ) ) ( (lv_var_2_0= RULE_ID ) ) ) | ( ( (lv_neg_3_0= RULE_NEGATION ) ) otherlv_4= '(' ( (lv_braExpr_5_0= ruleBracedExpression ) ) otherlv_6= ')' ) | (otherlv_7= '(' ( (lv_braExpr_8_0= ruleBracedExpression ) ) otherlv_9= ')' ) )
            {
            // InternalSimpleFeatureExpression.g:78:2: ( ( (lv_var_0_0= RULE_ID ) ) | ( ( (lv_neg_1_0= RULE_NEGATION ) ) ( (lv_var_2_0= RULE_ID ) ) ) | ( ( (lv_neg_3_0= RULE_NEGATION ) ) otherlv_4= '(' ( (lv_braExpr_5_0= ruleBracedExpression ) ) otherlv_6= ')' ) | (otherlv_7= '(' ( (lv_braExpr_8_0= ruleBracedExpression ) ) otherlv_9= ')' ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt1=1;
                }
                break;
            case RULE_NEGATION:
                {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==RULE_ID) ) {
                    alt1=2;
                }
                else if ( (LA1_2==13) ) {
                    alt1=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalSimpleFeatureExpression.g:79:3: ( (lv_var_0_0= RULE_ID ) )
                    {
                    // InternalSimpleFeatureExpression.g:79:3: ( (lv_var_0_0= RULE_ID ) )
                    // InternalSimpleFeatureExpression.g:80:4: (lv_var_0_0= RULE_ID )
                    {
                    // InternalSimpleFeatureExpression.g:80:4: (lv_var_0_0= RULE_ID )
                    // InternalSimpleFeatureExpression.g:81:5: lv_var_0_0= RULE_ID
                    {
                    lv_var_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(lv_var_0_0, grammarAccess.getSimpleFeatureExpressionAccess().getVarIDTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSimpleFeatureExpressionRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"var",
                    						lv_var_0_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleFeatureExpression.g:98:3: ( ( (lv_neg_1_0= RULE_NEGATION ) ) ( (lv_var_2_0= RULE_ID ) ) )
                    {
                    // InternalSimpleFeatureExpression.g:98:3: ( ( (lv_neg_1_0= RULE_NEGATION ) ) ( (lv_var_2_0= RULE_ID ) ) )
                    // InternalSimpleFeatureExpression.g:99:4: ( (lv_neg_1_0= RULE_NEGATION ) ) ( (lv_var_2_0= RULE_ID ) )
                    {
                    // InternalSimpleFeatureExpression.g:99:4: ( (lv_neg_1_0= RULE_NEGATION ) )
                    // InternalSimpleFeatureExpression.g:100:5: (lv_neg_1_0= RULE_NEGATION )
                    {
                    // InternalSimpleFeatureExpression.g:100:5: (lv_neg_1_0= RULE_NEGATION )
                    // InternalSimpleFeatureExpression.g:101:6: lv_neg_1_0= RULE_NEGATION
                    {
                    lv_neg_1_0=(Token)match(input,RULE_NEGATION,FOLLOW_3); 

                    						newLeafNode(lv_neg_1_0, grammarAccess.getSimpleFeatureExpressionAccess().getNegNEGATIONTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleFeatureExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"neg",
                    							lv_neg_1_0,
                    							"de.imotep.SimpleFeatureExpression.NEGATION");
                    					

                    }


                    }

                    // InternalSimpleFeatureExpression.g:117:4: ( (lv_var_2_0= RULE_ID ) )
                    // InternalSimpleFeatureExpression.g:118:5: (lv_var_2_0= RULE_ID )
                    {
                    // InternalSimpleFeatureExpression.g:118:5: (lv_var_2_0= RULE_ID )
                    // InternalSimpleFeatureExpression.g:119:6: lv_var_2_0= RULE_ID
                    {
                    lv_var_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(lv_var_2_0, grammarAccess.getSimpleFeatureExpressionAccess().getVarIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleFeatureExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"var",
                    							lv_var_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSimpleFeatureExpression.g:137:3: ( ( (lv_neg_3_0= RULE_NEGATION ) ) otherlv_4= '(' ( (lv_braExpr_5_0= ruleBracedExpression ) ) otherlv_6= ')' )
                    {
                    // InternalSimpleFeatureExpression.g:137:3: ( ( (lv_neg_3_0= RULE_NEGATION ) ) otherlv_4= '(' ( (lv_braExpr_5_0= ruleBracedExpression ) ) otherlv_6= ')' )
                    // InternalSimpleFeatureExpression.g:138:4: ( (lv_neg_3_0= RULE_NEGATION ) ) otherlv_4= '(' ( (lv_braExpr_5_0= ruleBracedExpression ) ) otherlv_6= ')'
                    {
                    // InternalSimpleFeatureExpression.g:138:4: ( (lv_neg_3_0= RULE_NEGATION ) )
                    // InternalSimpleFeatureExpression.g:139:5: (lv_neg_3_0= RULE_NEGATION )
                    {
                    // InternalSimpleFeatureExpression.g:139:5: (lv_neg_3_0= RULE_NEGATION )
                    // InternalSimpleFeatureExpression.g:140:6: lv_neg_3_0= RULE_NEGATION
                    {
                    lv_neg_3_0=(Token)match(input,RULE_NEGATION,FOLLOW_4); 

                    						newLeafNode(lv_neg_3_0, grammarAccess.getSimpleFeatureExpressionAccess().getNegNEGATIONTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleFeatureExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"neg",
                    							lv_neg_3_0,
                    							"de.imotep.SimpleFeatureExpression.NEGATION");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,13,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getSimpleFeatureExpressionAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalSimpleFeatureExpression.g:160:4: ( (lv_braExpr_5_0= ruleBracedExpression ) )
                    // InternalSimpleFeatureExpression.g:161:5: (lv_braExpr_5_0= ruleBracedExpression )
                    {
                    // InternalSimpleFeatureExpression.g:161:5: (lv_braExpr_5_0= ruleBracedExpression )
                    // InternalSimpleFeatureExpression.g:162:6: lv_braExpr_5_0= ruleBracedExpression
                    {

                    						newCompositeNode(grammarAccess.getSimpleFeatureExpressionAccess().getBraExprBracedExpressionParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_braExpr_5_0=ruleBracedExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleFeatureExpressionRule());
                    						}
                    						set(
                    							current,
                    							"braExpr",
                    							lv_braExpr_5_0,
                    							"de.imotep.SimpleFeatureExpression.BracedExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getSimpleFeatureExpressionAccess().getRightParenthesisKeyword_2_3());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSimpleFeatureExpression.g:185:3: (otherlv_7= '(' ( (lv_braExpr_8_0= ruleBracedExpression ) ) otherlv_9= ')' )
                    {
                    // InternalSimpleFeatureExpression.g:185:3: (otherlv_7= '(' ( (lv_braExpr_8_0= ruleBracedExpression ) ) otherlv_9= ')' )
                    // InternalSimpleFeatureExpression.g:186:4: otherlv_7= '(' ( (lv_braExpr_8_0= ruleBracedExpression ) ) otherlv_9= ')'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_5); 

                    				newLeafNode(otherlv_7, grammarAccess.getSimpleFeatureExpressionAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalSimpleFeatureExpression.g:190:4: ( (lv_braExpr_8_0= ruleBracedExpression ) )
                    // InternalSimpleFeatureExpression.g:191:5: (lv_braExpr_8_0= ruleBracedExpression )
                    {
                    // InternalSimpleFeatureExpression.g:191:5: (lv_braExpr_8_0= ruleBracedExpression )
                    // InternalSimpleFeatureExpression.g:192:6: lv_braExpr_8_0= ruleBracedExpression
                    {

                    						newCompositeNode(grammarAccess.getSimpleFeatureExpressionAccess().getBraExprBracedExpressionParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_braExpr_8_0=ruleBracedExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleFeatureExpressionRule());
                    						}
                    						set(
                    							current,
                    							"braExpr",
                    							lv_braExpr_8_0,
                    							"de.imotep.SimpleFeatureExpression.BracedExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getSimpleFeatureExpressionAccess().getRightParenthesisKeyword_3_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleFeatureExpression"


    // $ANTLR start "entryRuleBracedExpression"
    // InternalSimpleFeatureExpression.g:218:1: entryRuleBracedExpression returns [EObject current=null] : iv_ruleBracedExpression= ruleBracedExpression EOF ;
    public final EObject entryRuleBracedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBracedExpression = null;


        try {
            // InternalSimpleFeatureExpression.g:218:57: (iv_ruleBracedExpression= ruleBracedExpression EOF )
            // InternalSimpleFeatureExpression.g:219:2: iv_ruleBracedExpression= ruleBracedExpression EOF
            {
             newCompositeNode(grammarAccess.getBracedExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBracedExpression=ruleBracedExpression();

            state._fsp--;

             current =iv_ruleBracedExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBracedExpression"


    // $ANTLR start "ruleBracedExpression"
    // InternalSimpleFeatureExpression.g:225:1: ruleBracedExpression returns [EObject current=null] : ( ( (lv_expr1_0_0= ruleSimpleFeatureExpression ) ) ( ( (lv_op_1_0= RULE_BINARY_OPEATOR ) ) ( (lv_expr2_2_0= ruleSimpleFeatureExpression ) ) )* ) ;
    public final EObject ruleBracedExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        EObject lv_expr1_0_0 = null;

        EObject lv_expr2_2_0 = null;



        	enterRule();

        try {
            // InternalSimpleFeatureExpression.g:231:2: ( ( ( (lv_expr1_0_0= ruleSimpleFeatureExpression ) ) ( ( (lv_op_1_0= RULE_BINARY_OPEATOR ) ) ( (lv_expr2_2_0= ruleSimpleFeatureExpression ) ) )* ) )
            // InternalSimpleFeatureExpression.g:232:2: ( ( (lv_expr1_0_0= ruleSimpleFeatureExpression ) ) ( ( (lv_op_1_0= RULE_BINARY_OPEATOR ) ) ( (lv_expr2_2_0= ruleSimpleFeatureExpression ) ) )* )
            {
            // InternalSimpleFeatureExpression.g:232:2: ( ( (lv_expr1_0_0= ruleSimpleFeatureExpression ) ) ( ( (lv_op_1_0= RULE_BINARY_OPEATOR ) ) ( (lv_expr2_2_0= ruleSimpleFeatureExpression ) ) )* )
            // InternalSimpleFeatureExpression.g:233:3: ( (lv_expr1_0_0= ruleSimpleFeatureExpression ) ) ( ( (lv_op_1_0= RULE_BINARY_OPEATOR ) ) ( (lv_expr2_2_0= ruleSimpleFeatureExpression ) ) )*
            {
            // InternalSimpleFeatureExpression.g:233:3: ( (lv_expr1_0_0= ruleSimpleFeatureExpression ) )
            // InternalSimpleFeatureExpression.g:234:4: (lv_expr1_0_0= ruleSimpleFeatureExpression )
            {
            // InternalSimpleFeatureExpression.g:234:4: (lv_expr1_0_0= ruleSimpleFeatureExpression )
            // InternalSimpleFeatureExpression.g:235:5: lv_expr1_0_0= ruleSimpleFeatureExpression
            {

            					newCompositeNode(grammarAccess.getBracedExpressionAccess().getExpr1SimpleFeatureExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_expr1_0_0=ruleSimpleFeatureExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBracedExpressionRule());
            					}
            					set(
            						current,
            						"expr1",
            						lv_expr1_0_0,
            						"de.imotep.SimpleFeatureExpression.SimpleFeatureExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimpleFeatureExpression.g:252:3: ( ( (lv_op_1_0= RULE_BINARY_OPEATOR ) ) ( (lv_expr2_2_0= ruleSimpleFeatureExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_BINARY_OPEATOR) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSimpleFeatureExpression.g:253:4: ( (lv_op_1_0= RULE_BINARY_OPEATOR ) ) ( (lv_expr2_2_0= ruleSimpleFeatureExpression ) )
            	    {
            	    // InternalSimpleFeatureExpression.g:253:4: ( (lv_op_1_0= RULE_BINARY_OPEATOR ) )
            	    // InternalSimpleFeatureExpression.g:254:5: (lv_op_1_0= RULE_BINARY_OPEATOR )
            	    {
            	    // InternalSimpleFeatureExpression.g:254:5: (lv_op_1_0= RULE_BINARY_OPEATOR )
            	    // InternalSimpleFeatureExpression.g:255:6: lv_op_1_0= RULE_BINARY_OPEATOR
            	    {
            	    lv_op_1_0=(Token)match(input,RULE_BINARY_OPEATOR,FOLLOW_5); 

            	    						newLeafNode(lv_op_1_0, grammarAccess.getBracedExpressionAccess().getOpBINARY_OPEATORTerminalRuleCall_1_0_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getBracedExpressionRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"op",
            	    							lv_op_1_0,
            	    							"de.imotep.SimpleFeatureExpression.BINARY_OPEATOR");
            	    					

            	    }


            	    }

            	    // InternalSimpleFeatureExpression.g:271:4: ( (lv_expr2_2_0= ruleSimpleFeatureExpression ) )
            	    // InternalSimpleFeatureExpression.g:272:5: (lv_expr2_2_0= ruleSimpleFeatureExpression )
            	    {
            	    // InternalSimpleFeatureExpression.g:272:5: (lv_expr2_2_0= ruleSimpleFeatureExpression )
            	    // InternalSimpleFeatureExpression.g:273:6: lv_expr2_2_0= ruleSimpleFeatureExpression
            	    {

            	    						newCompositeNode(grammarAccess.getBracedExpressionAccess().getExpr2SimpleFeatureExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_expr2_2_0=ruleSimpleFeatureExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBracedExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"expr2",
            	    							lv_expr2_2_0,
            	    							"de.imotep.SimpleFeatureExpression.SimpleFeatureExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBracedExpression"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000042L});

}