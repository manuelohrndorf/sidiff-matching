package de.imotep;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseException;

import com.google.inject.Inject;
import com.google.inject.Injector;

import de.imotep.SimpleFeatureExpressionStandaloneSetup;

public class SimpleFeatureExpressionParser {

	@Inject
	private IParser parser;

	public SimpleFeatureExpressionParser() {
		setupParser();
	}

	private void setupParser() {
		Injector injector = new SimpleFeatureExpressionStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	/**
	 * Parses data provided by an input reader using Xtext and returns the root
	 * node of the resulting object tree.
	 * 
	 * @param reader
	 *            Input reader
	 * @return root object node
	 * @throws IOException
	 *             when errors occur during the parsing process
	 */
	public EObject parse(Reader reader) throws IOException {
		IParseResult result = parser.parse(reader);
		if (result.hasSyntaxErrors()) {
			throw new ParseException("Provided input contains syntax errors.");
		}
		return result.getRootASTElement();
	}

	public EObject parse(String string) throws IOException {
		StringReader reader = new StringReader(string);
		return parse(reader);
	}
}
