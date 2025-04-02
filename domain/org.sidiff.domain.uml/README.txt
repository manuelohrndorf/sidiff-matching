----------
 Achtung!
----------

Code-Generierung bitte mit Ant-Skript   "ant_generation.xml"   durchführen!


Vorgehen:
---------
1.) .emx in RSM öffnen
2.) Export -> Ecore-Modell
3.) exportierte .ecore-Datei nach "UMLModel.ecore_from_rsm~" kopieren
4.) ant_generation.xml ausführen
    - beim ersten Mal:
       - Rechtsklick auf ant_generation.xml
       - "Run As ..."  (nicht "Run As", sondern mit "...")
       - Im Dialog den Tab "JRE" öffnen
       - "Run in the same JRE as the workspace" auswählen
       - "Run" klicken
    - später:
       - Rechtsklick auf ant_generation.xml
       - "Run As"  (ohne "...")
        
