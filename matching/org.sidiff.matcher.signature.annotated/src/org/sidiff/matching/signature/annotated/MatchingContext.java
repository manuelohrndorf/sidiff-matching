package org.sidiff.matching.signature.annotated;

import org.eclipse.emf.ecore.EObject;


public interface MatchingContext {

	
	public final static String SIGNATURE_KEY = "SIGNATURE";
	public final static String PATH_ANNOTATION = "PATH"; // TODO: Eigentlich Position im Dokument -> Sollte fuer jeden Objekttyp individuell konfigurierbar sein -> Map
	
	/**
	 * Definiert die die uebergebenen Objekte als Korrespondierend!
	 * 
	 * @param matcher Matcher der die Korrespondenzerkl�rung veranlasst.
	 * @param objectA Zu Matchendes Element.
	 * @param objectB Zu Matchendes Element.
	 * @return true, falls es infolge des Matches zu weiteren Matches gekommen ist!
	 */
	public void match(Object matcher,EObject objectA,EObject objectB);
	
	/**
	 * Prueft, ob die das uebergebene Elemente gematcht werden duerfen.
	 * 
	 * @param objectA Zu Matchendes Element.
	 * @param objectB Zu Matchendes Element.
	 * 
	 * @return true, falls die uebergebenen Objekte gematcht werden duerfen.
	 */
	public boolean isMatchPermitted(EObject objectA,EObject objectB);

	
	/**
	 * Prueft, ob die uebergebenen objekte gematcht wurden.
	 * 
	 * @param objectA Zu pruefendes objekt.
	 * @param objectB Zu pruefendes objekt.
	 * 
	 * @return true, falls die uebergebenen objekte gematcht wurden.
	 */
	public boolean hasMatched(EObject objectA, EObject objectB);

	/**
	 * Prueft, ob das uebergebenn objekt bereits gematcht wurde.
	 * 
	 * @param object Zu pruefendes objekt.
	 * 
	 * @return true, falls das uebergebene objekt bereits gematcht wurde.
	 */
	public boolean hasMatch(EObject object); 

}
