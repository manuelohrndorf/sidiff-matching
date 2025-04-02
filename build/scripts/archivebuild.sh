#!/bin/sh
#Skript zur Archivierung von builds
#Kopiert Dateien und erstellt einen Tabelleneintrag für eine html Seite.
#Parameter 1 = buildrevision
#Parameter 2 = feature Version
today=`date`
nbdir="/users/sidiff/nightly-build"

if test -f $nbdir/history/$2-builds.html
then
  true
else
  sh $nbdir/build/scripts/registerfeature.sh $2
fi

mkdir $nbdir/history/$2/$1/

mv $nbdir/build/build/N.Build-$1/compilelogs $nbdir/history/$2/$1/
mv $nbdir/build/scripts/build.log $nbdir/history/$2/$1/
mv $nbdir/build/build/N.Build-$1/$2-Build.zip $nbdir/history/$2/$1/$2-$1-Build.zip
rm -rf $nbdir/build/build/N.Build-$1
chmod -R 755 $nbdir/history/$2/$1/


if test -f $nbdir/history/$2/$1/$2-$1-Build.zip
then
  entry="<tr id=\"active\">
  <td><img src=\"success.gif\"><\/td>
  <td>$today<\/td>
  <td>$1<\/td>
  <td><a href=\"$2\/$1\/$2-$1-Build.zip\">Download<\/a><\/td>
  <td><a href=\"$2\/$1\/build.log\">Compile Log<\/a><\/td>
  <\/tr>
<tr>"
  sh $nbdir/build/scripts/indexbuild.sh $1 $2
else
  entry="<tr id=\"active\"><td><img src=\"failure.gif\"><\/td>
  <td>$today<\/td>
  <td>$1<\/td>
  <td><\/td>
  <td><a href=\"$2\/$1\/build.log\">Compile Log<\/a><\/td>
  <\/tr>
<tr>"
fi


perl -pi -e "s/<tr id=\"active\">/$entry/g" $nbdir/history/$2-builds.html