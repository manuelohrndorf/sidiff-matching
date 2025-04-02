#!/bin/sh
#Erstellung der Tabellen und Verzeichnisse, wenn ein neues feature kompiliert wird
#Parameter 1 = feature Version
nbdir="/users/sidiff/nightly-build"

cp $nbdir/history/builds-default.html $nbdir/history/$1-builds.html
mkdir  $nbdir/history/$1/
chmod 755 $nbdir/history/$1/
chmod 644 $nbdir/history/$1-builds.html

entry="<!--$1-->
    <tr>
      <td><a href="$1-builds.html">$1 wasn't build successfully yet...<\/a><\/td>
      <td><\/td>
      <td><\/td>
      <td><\/td>
      <td><\/td>
    <\/tr>
  <\/table>"
perl -pi -e "s/<\/table>/$entry/g" $nbdir/history/index.html