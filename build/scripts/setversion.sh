#!/bin/sh

#Pfad zu den ausgecheckten Bundles
nbdir="/users/sidiff/nightly-build/bundles"
builddir="/users/sidiff/nightly-build/build" 
curpath=`pwd`

rm $builddir/setversion.log

#Liste der Bundles erstellen 
ls -1 $nbdir > $builddir/bundles.txt

#Schleife über Bundles
for bundle in `cat $builddir/bundles.txt`; do
#echo $bundle
temp=""
revision=""
#revision=`svn list -v -r HEAD $nbdir/$bundle | egrep '^[ ]*[0-9]+.*\./$'| sed -e 's/^[ ]*\([0-9]\+\).*\.\/$/\1/'`
revision=`svn log $nbdir/$bundle/. | awk 'NR==2' | sed -e "s/\ .*//g"`
#echo $revision
if test -f $nbdir/$bundle/META-INF/MANIFEST.MF
then
    temp=`egrep 'Bundle-Version: [0-9]+\.[0-9]+\.[0-9]+' $nbdir/$bundle/META-INF/MANIFEST.MF` 
    if [[ $temp == "" ]]
    then
	result="No Bundle-Version entry"
    else
	#echo $revision
	sed -i 's/\(Bundle-Version: [0-9]\+\.[0-9]\+\.[0-9]\).*/\1.'$revision'/' $nbdir/$bundle/META-INF/MANIFEST.MF
	result="Okay"
    fi
else
    result="No MANIFEST.MF"
fi
#echo $temp
#echo $result
echo $bundle"....."$revision"....."$result >> $builddir/setversion.log
#echo
done

rm $builddir/bundles.txt
