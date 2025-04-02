#!/bin/sh
OUTDIR="../output"
dot -Tpng -o ../output/dependencyGraph.png ../output/dependencyGraph.txt
pdflatex dependencies.tex
rm *.aux
rm *.log
rm *~
mv dependencies.pdf $OUTDIR/
rm ../output/*.t*
#mv ../output/* $OUTDIR/
