#!/bin/sh
export LANG="de_DE.UTF-8"
nbdir="/users/sidiff/nightly-build"
cd ~
#Revisions Nummer aus SVN holen
rev=`svn log http://svn.informatik.uni-siegen.de/SiDiff/trunk -r HEAD | awk 'NR==2' | sed -e "s/\ .*//g"`
if test -f $nbdir/lastrevision.txt
then
  true
else
  echo "r0" > $nbdir/lastrevision.txt
fi

#java einstellen
export PATH=/usr/local/bin:$PATH
java -version > $nbdir/javaversion.txt 2>&1
echo $PATH > $nbdir/path.txt

lastrev=`cat $nbdir/lastrevision.txt`

if [ "$rev" != "$lastrev" ]
  then
    echo $rev > $nbdir/lastrevision.txt
    echo "Starting checkout"
    sh $nbdir/build/scripts/checkout.sh
    echo "Setting versions"
    sh $nbdir/build/scripts/setversion.sh
    echo "Running build"
    sh $nbdir/build/scripts/build.sh $rev
  else
    true
fi
