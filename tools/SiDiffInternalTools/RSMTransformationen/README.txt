Anleitung zum Transformieren eines RSM-Modells in Java Code

Vorbereitung:
1.) Sicherstellen, dass das Projekt "SiDiffInternalTools" ausgecheckt ist

Transformation
1.) Modell aus RSM exportieren (als Ecore)
2.) exportierte Ecore-Datei in Projektordner kopieren, hierbei muss die Endung .ecore durch .rsm ersetzt werden
3.) Ant-Skript im Projektordner ausführen

Die lokale .rsm-Datei soll nicht mit eingecheckt werden!

Falls noch kein Ant-Skript existiert:
1.) template_for_personal_antfile.xml aus SiDiffInternalTools/RSMTransformationen kopieren
2.) Properties im neuen Ant-Skript anpassen
3.) ggf. eigene Verarbeitungsschritte einfügen
4.) fertig

 