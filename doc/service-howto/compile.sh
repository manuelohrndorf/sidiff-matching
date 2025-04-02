#!/bin/sh
pdflatex service-howto_de.tex
pdflatex service-howto_de.tex
pdflatex service-howto_de.tex

pdflatex service-howto_en.tex
pdflatex service-howto_en.tex
pdflatex service-howto_en.tex

rm *.aux *.log *.toc *.out *.backup *~
