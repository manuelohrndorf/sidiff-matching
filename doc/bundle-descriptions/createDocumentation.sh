#!/bin/bash
function writeTex() {
echo "\\subsection{$name}" > $texfile
#echo "\\begin{table}" >> $texfile
echo "\\label{$symbname}" >> $texfile
echo "" >> $texfile
echo "\qquad\\begin{tabular}{|p{3cm}|p{8cm}|}\\hline" >> $texfile
echo "Bundle Name & $symbname \\\\\\hline" >> $texfile
echo "Latest Version & $version \\\\\\hline" >> $texfile
type1=`echo $type | sed -e 's/ .*//g'`
type2=`echo $type | sed -e 's/[A-Za-z0-9 ]* //' | sed -e 's/, /|/g' | sed -e 's/ and /|/g'`
echo "Typ & $type1 \\\\\\hline" >> $texfile
if [ "$type1" != "$type2" ]; then
echo "belongs to" >> $texfile
origIFS=$IFS
IFS=", "
for ref in $type2; do
echo " & $ref (see \\ref{$ref}) \\\\" >> $texfile
done
IFS=$origIFS
echo "\\hline" >> $texfile
fi
echo "Activator & $activator \\\\\\hline" >> $texfile
echo "\\end{tabular}\\\\[0.1cm]" >> $texfile
#echo "\\end{table}" >> $texfile
echo "" >> $texfile
cat $desc | sed -e '1d' | sed -e 's/&/\\\\&/g' | sed -e 's/\"/\\grqq /g' >> $texfile
echo "" >> $texfile
}

texapps="applicationlist.gen.tex"
echo "\\section{Applications}" > $texapps

texlibs="librarylist.gen.tex"
echo "\\section{Library Bundles}" > $texlibs

texifaces="interfacelist.gen.tex"
echo "\\section{Interface Bundles}" > $texifaces

teximpls="implementationlist.gen.tex"
echo "\\section{Implementation Bundles}" > $teximpls

texextend="extendlist.gen.tex"
echo "\\section{Extension Bundles}" > $texextend

texeclipse="eclipselist.gen.tex"
echo "\\section{Eclipse Plugins}" > $texeclipse

texwrong="wronglist.gen.tex"
echo "\\section{Others / Uncategorized Bundles}" > $texwrong

textests="testslist.gen.tex"
echo "\\section{Test Bundles}" > $textests

texundoc="undocumentedlist.gen.tex"
echo "\\section{Undocumented Bundles}\\begin{itemize}" > $texundoc

for desc in `find ../../org.sidiff.* -maxdepth 1 -name "description.txt" | sort`; do
file=`echo "$desc" | sed -e 's/description\.txt//g'`
#manifest=`echo "$desc" | sed -e 's/description\.txt/META-INF\/MANIFEST\.MF/g'`
symbname=`echo $file | sed -e 's/\.*\///g' | sed -e 's/\///g'`
name=`grep Bundle-Name $file/META-INF/MANIFEST.MF | sed -e 's/Bundle-Name: //g'`
activator=`grep Bundle-Activator $file/META-INF/MANIFEST.MF | sed -e 's/Bundle-Activator: //g'`
version=`grep Bundle-Version $file/META-INF/MANIFEST.MF | sed -e 's/Bundle-Version: //g'`
type=`head -1 $desc`
#description=`cat $desc | sed -e '1d'`
texfile=$symbname.gen.tex

if [[ "$type" == "Application" ]]; then
echo "\\input{$texfile}" >> $texapps
else if [[ "$type" == "Library" ]]; then
echo "\\input{$texfile}" >> $texlibs
else if [[ "$type" == "Interface" ]]; then
echo "\\input{$texfile}" >> $texifaces
else if [[ "$type" == Implementation* ]]; then
echo "\\input{$texfile}" >> $teximpls
else if [[ "$type" == Test* ]]; then
echo "\\input{$texfile}" >> $textests
else if [[ "$type" == Extension* ]]; then
echo "\\input{$texfile}" >> $texextend
else if [[ "$type" == Eclipse* ]]; then
echo "\\input{$texfile}" >> $texeclipse
else
echo "\\input{$texfile}" >> $texwrong
fi
fi
fi
fi
fi
fi
fi

writeTex
done

for desc in `find ../.. -maxdepth 1 -name "org.sidiff.*" -type d | sort`; do
if [ "$desc" = "../../org.sidiff.uml.testdata" ]; then
continue
fi
if [ ! -e $desc/description.txt ]; then
echo "\\item" >> $texundoc
echo "$desc" | sed -e 's/\.*\///g' | sed -e 's/\///g' >> $texundoc
echo "" >> $texundoc
fi
done
echo "\\end{itemize}" >> $texundoc


pdflatex bundle-overview.tex
pdflatex bundle-overview.tex
pdflatex bundle-overview.tex

rm *.aux *.log *.out *.toc *.gen.tex
