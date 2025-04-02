#!/bin/sh

nbdir="/users/sidiff/nightly-build"
#fÃ¼r jedes vorhandene feature
#equinox="$nbdir/eclipse/plugins/org.eclipse.equinox.launcher_1.0.101.R34x_v20081125.jar"
#equinox="$nbdir/eclipse/plugins/org.eclipse.equinox.launcher_1.0.201.R35x_v20090715.jar"
equinox="$nbdir/eclipse/plugins/org.eclipse.equinox.launcher_1.2.0.v20110502.jar"
#buildxml="$nbdir/eclipse/plugins/org.eclipse.pde.build_3.4.1.R34x_v20080805/scripts/build.xml"
#buildxml="$nbdir/eclipse/plugins/org.eclipse.pde.build_3.5.1.R35x_20090820/scripts/build.xml"
buildxml="$nbdir/eclipse/plugins/org.eclipse.pde.build_3.7.0.v20110512-1320/scripts/build.xml"
buildscripts="$nbdir/build/scripts"

cd $nbdir/build/scripts

dos2unix $nbdir/build/features/features-of-nightlybuild.txt

for feature in `cat $nbdir/build/features/features-of-nightlybuild.txt`; do
echo "BUILDING $feature NOW"
#Aufruf des builds
#Start einer Eclipse Instanz ohne Oberfläche zum kompilieren:
#java -jar /users/sidiff/nightly-build/eclipse/plugins/org.eclipse.equinox.launcher_1.0.101.R34x_v20081125.jar 
#
#ant ausführen:
#-application org.eclipse.ant.core.antRunner 
#
#buildfile angeben:
#-f /users/sidiff/nightly-build/eclipse/plugins/org.eclipse.pde.build_3.4.1.R34x_v20080805/scripts/build.xml 
#
#build S:ripts angeben
#-Dbuilder=/users/sidiff/nightly-build/build/scripts 
#
#Logging in log Datei und
#-l build$rev.log -logger org.apache.tools.ant.listener.MailLogger 
#
#Revision angeben
#-DbuildRev=$rev
  java -jar $equinox -application org.eclipse.ant.core.antRunner -f $buildxml -Dbuilder=$buildscripts -l build.log -logger org.apache.tools.ant.listener.MailLogger -DbuildRev=$1 -DbuildTarget=$feature -DMailLogger.failure.to=`cat $nbdir/build/scripts/email.txt` -DMailLogger.failure.subject="FAILURE $feature-$1"
#Log Datei in build Verzeichnis kopieren
#  mv build.log $nbdir/build/build/N.Build-$1/build.log #macht jetzt archivebuild.sh
#Build archivieren
  sh $buildscripts/archivebuild.sh $1 $feature
  rm -rf $nbdir/build/build/
done
