Anleitung zum Erstellen des Dependency-Übersicht:

1.) Ausführen des DependencyCreators
    java DependencyCreator ${workspace_loc} ${workspace_loc}/DependencyTool/resources ${workspace_loc}/DependencyTool/output
    1. Parameter = Ordner in dem die zu analysierenden Plugins liegen
    2. Parameter = resources-Ordner
    3. Parameter = Ordner für die Ausgabe

2.) in resources-Ordner wechseln
3.) compile.sh ausführen

Die fertige Übersicht steht anschließend im Ordner "output".



Optionale Erweiterung zum Filtern der beachteten Bundles:

- Bundles die ausgeschlossen werden sollen, können über reguläre Ausdrücke in der Datei
resources/removeFromTable.txt spezifiziert werden (1 Ausdruck pro Zeile!)
- Bundles die ausschließlich vom Graph ausgeschlossen werden sollen, können über reguläre Ausdrücke in der Datei
resources/removeFromGraph.txt spezifiziert werden (1 Ausdruck pro Zeile!)