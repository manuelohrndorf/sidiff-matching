#!/bin/sh
#Enters a row for a newly built feature to the feature index page
nbdir="/users/sidiff/nightly-build"
today=`date`

table="<!--$2-->
    <tr>
      <td><a href=\"$2-builds.html\">$2<\/a><\/td>
      <td>$today<\/td>
      <td>$1<\/td>
      <td><a href=\"$2\/$1\/$2-$1-Build.zip\">Download<\/a><\/td>
      <td><a href=\"$2\/$1\/build.log\">Compile Log<\/a><\/td>
    <\/tr>"



line=`grep -n "<!--$2-->" $nbdir/history/index.html | cut -d: -f1`
for i in `seq 1 6`; do
  delete=`expr $line + $i`
  sed -i "$delete g" $nbdir/history/index.html
done
sed -i '/^\s*$/d' $nbdir/history/index.html
perl -pi -e "s/<!--$2-->/$table/g" $nbdir/history/index.html