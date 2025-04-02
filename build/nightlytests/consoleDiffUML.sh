#!/bin/sh

#consoleDiffUML Benchmark

##########
#variables
##########
PATH="/usr/local/bin:$PATH"
nbdir="/users/sidiff/nightly-build"

if [ "$#" = "1" ]
 then
   lastRevision="$1"
   lastBenchmark="r0"
 else 
   lastRevision=`cat $nbdir/lastrevision.txt`
   lastBenchmark=`cat $nbdir/benchmark/lastbenchmark.txt`
fi
time=`date '+%H%M'`
date=`date '+%Y%m%d'`
timestamp=$date"-"$time
feature="org.sidiff.feature.consolediff.uml.standalone"
app="org.sidiff.pipeline.SPCApplication"

##########
#Benchmarking SiDiff Application
##########


echo $PATH > /tmp/foo
java -version >> /tmp/foo

if [ "$lastRevision" != "$lastBenchmark" ]
	then  
	if [ -f $nbdir/history/$feature/$lastRevision/$feature-$lastRevision-Build.zip ] 
		then 
                  

		##########		
		#copy and extract latest build
		##########
	
		mkdir $nbdir/benchmark/plugins

		cp $nbdir/history/$feature/$lastRevision/$feature-$lastRevision-Build.zip $nbdir/benchmark/plugins/

		unzip $nbdir/benchmark/plugins/$feature-$lastRevision-Build.zip -d $nbdir/benchmark/plugins/
          	


		##########
		#build Config
		##########

		mkdir $nbdir/benchmark/config

		echo "#Configuration file: $timestamp" > $nbdir/benchmark/config/config.ini 		
		echo "osgi.bundles=\\" >> $nbdir/benchmark/config/config.ini
		
		for item in `ls /users/sidiff/nightly-build/benchmark/plugins/sidiff/plugins/*.jar`
		do
			echo $item"@start,\\" >> $nbdir/benchmark/config/config.ini
		done

		echo "osgi.bundles.defaultStartLevel=4" >> $nbdir/benchmark/config/config.ini


		##########
        #run benchmark
        ##########
		
		#/usr/bin/time -f %E -o /users/sidiff/nightly-build/benchmark/time.txt java -Dosgi.noShutdown=false -DLOGEVENTS="MESSAGE" -DLOGCHANNEL="ConsoleLogChannel" -jar /users/sidiff/nightly-build/benchmark/runtime/org.eclipse.osgi_3.5.1.R35x_v20090827.jar -configuration /users/sidiff/nightly-build/benchmark/config -clean -consolelog -data /users/sidiff/nightly-build/benchmark -out_matching /users/sidiff/nightly-build/benchmark/matching1.out -out_diff /users/sidiff/nightly-build/benchmark/diff1.out -application $app -file1 /users/sidiff/nightly-build/benchmark/model/AirTravelModel16.emx -file2 /users/sidiff/nightly-build/benchmark/model/AirTravelModel17.emx -options org.sidiff.core.matching.IDBasedMatchingService=false,org.sidiff.core.matching.HashMatchingService=true,org.sidiff.core.matching.IterativeMatchingService=true -out /users/sidiff/nightly-build/benchmark/result.xml > /users/sidiff/nightly-build/benchmark/appTime.txt
		#/usr/bin/time -f %E -o /users/sidiff/nightly-build/benchmark/time.txt java -Dosgi.noShutdown=false -DLOGEVENTS="MESSAGE" -DLOGCHANNEL="ConsoleLogChannel" -jar /users/sidiff/nightly-build/benchmark/runtime/org.eclipse.osgi_3.5.1.R35x_v20090827.jar -configuration /users/sidiff/nightly-build/benchmark/config -clean -consolelog -out_matching /users/sidiff/nightly-build/benchmark/matching1.out -out_diff /users/sidiff/nightly-build/benchmark/result.xml -application $app -file1 /users/sidiff/nightly-build/benchmark/model/AirTravelModel16.emx -file2 /users/sidiff/nightly-build/benchmark/model/AirTravelModel17.emx -options org.sidiff.core.matching.IDBasedMatchingService=false,org.sidiff.core.matching.HashMatchingService=true,org.sidiff.core.matching.IterativeMatchingService=true > /users/sidiff/nightly-build/benchmark/appTime.txt
		/usr/bin/time -f %E -o /users/sidiff/nightly-build/benchmark/time.txt java -Dosgi.noShutdown=false -DLOGEVENTS="MESSAGE" -DLOGCHANNEL="ConsoleLogChannel" -jar /users/sidiff/nightly-build/benchmark/runtime/org.eclipse.osgi_3.7.1.R37x_v20110808-1106.jar -configuration /users/sidiff/nightly-build/benchmark/config -clean -consolelog -matching_filename /users/sidiff/nightly-build/benchmark/matching1.out -difference_filename /users/sidiff/nightly-build/benchmark/result.xml -application $app -modelA /users/sidiff/nightly-build/benchmark/model/AirTravelModel16.emx -modelB /users/sidiff/nightly-build/benchmark/model/AirTravelModel17.emx -options org.sidiff.core.matching.IDBasedMatchingService=false,org.sidiff.core.matching.HashMatchingService=true,org.sidiff.core.matching.IterativeMatchingService=true > /users/sidiff/nightly-build/benchmark/appTime.txt 
		
		execTime1=`cat /users/sidiff/nightly-build/benchmark/time.txt`
		appTime1=`grep Runtime /users/sidiff/nightly-build/benchmark/appTime.txt`

        #/usr/bin/time -f %E -o /users/sidiff/nightly-build/benchmark/time.txt java -Dosgi.noShutdown=false -DLOGEVENTS="MESSAGE" -DLOGCHANNEL="ConsoleLogChannel" -jar /users/sidiff/nightly-build/benchmark/runtime/org.eclipse.osgi_3.5.1.R35x_v20090827.jar -configuration /users/sidiff/nightly-build/benchmark/config -clean -data /users/sidiff/nightly-build/benchmark -out_matching /users/sidiff/nightly-build/benchmark/matching2.out -out_diff /users/sidiff/nightly-build/benchmark/diff2.out -application $app -file1 /users/sidiff/nightly-build/benchmark/model/FujabaUMLPackage_v4.0.0.xmi -file2 /users/sidiff/nightly-build/benchmark/model/FujabaUMLPackage_v4.0.1.xmi -options org.sidiff.core.matching.IDBasedMatchingService=false,org.sidiff.core.matching.HashMatchingService=true,org.sidiff.core.matching.IterativeMatchingService=true -out /users/sidiff/nightly-build/benchmark/result.xml > /users/sidiff/nightly-build/benchmark/appTime.txt
        #/usr/bin/time -f %E -o /users/sidiff/nightly-build/benchmark/time.txt java -Dosgi.noShutdown=false -DLOGEVENTS="MESSAGE" -DLOGCHANNEL="ConsoleLogChannel" -jar /users/sidiff/nightly-build/benchmark/runtime/org.eclipse.osgi_3.5.1.R35x_v20090827.jar -configuration /users/sidiff/nightly-build/benchmark/config -clean -out_matching /users/sidiff/nightly-build/benchmark/matching2.out -out_diff /users/sidiff/nightly-build/benchmark/diff2.out -application $app -file1 /users/sidiff/nightly-build/benchmark/model/FujabaUMLPackage_v4.0.0.xmi -file2 /users/sidiff/nightly-build/benchmark/model/FujabaUMLPackage_v4.0.1.xmi -options org.sidiff.core.matching.IDBasedMatchingService=false,org.sidiff.core.matching.HashMatchingService=true,org.sidiff.core.matching.IterativeMatchingService=true > /users/sidiff/nightly-build/benchmark/appTime.txt
        /usr/bin/time -f %E -o /users/sidiff/nightly-build/benchmark/time.txt java -Dosgi.noShutdown=false -DLOGEVENTS="MESSAGE" -DLOGCHANNEL="ConsoleLogChannel" -jar /users/sidiff/nightly-build/benchmark/runtime/org.eclipse.osgi_3.7.1.R37x_v20110808-1106.jar -configuration /users/sidiff/nightly-build/benchmark/config -clean -matching_filename /users/sidiff/nightly-build/benchmark/matching2.out -difference_filename /users/sidiff/nightly-build/benchmark/diff2.out -application $app -modelA /users/sidiff/nightly-build/benchmark/model/datavision/datavision38.smf.xmi -modelB /users/sidiff/nightly-build/benchmark/model/datavision/datavision136.smf.xmi -options org.sidiff.core.matching.IDBasedMatchingService=false,org.sidiff.core.matching.HashMatchingService=true,org.sidiff.core.matching.IterativeMatchingService=true > /users/sidiff/nightly-build/benchmark/appTime.txt

        execTime2=`cat /users/sidiff/nightly-build/benchmark/time.txt`
        appTime2=`grep Runtime /users/sidiff/nightly-build/benchmark/appTime.txt`
		
        #/usr/bin/time -f %E -o /users/sidiff/nightly-build/benchmark/time.txt java -Dosgi.noShutdown=false -ea -DLOGEVENTS="MESSAGE" -DLOGCHANNEL="ConsoleLogChannel" -jar /users/sidiff/nightly-build/benchmark/runtime/org.eclipse.osgi_3.5.1.R35x_v20090827.jar -configuration /users/sidiff/nightly-build/benchmark/config -consolelog -clean -data /users/sidiff/nightly-build/benchmark -out_matching /users/sidiff/nightly-build/benchmark/matching3.out -out_diff /users/sidiff/nightly-build/benchmark/diff3.out -application $app -file1 /users/sidiff/nightly-build/benchmark/model/FujabaUMLPackage_v4.0.0.xmi -file2 /users/sidiff/nightly-build/benchmark/model/FujabaUMLPackage_v4.0.1.xmi -options org.sidiff.core.matching.IDBasedMatchingService=false,org.sidiff.core.matching.HashMatchingService=false,org.sidiff.core.matching.IterativeMatchingService=true -out /users/sidiff/nightly-build/benchmark/result.xml > /users/sidiff/nightly-build/benchmark/appTime.txt
        #/usr/bin/time -f %E -o /users/sidiff/nightly-build/benchmark/time.txt java -Dosgi.noShutdown=false -DLOGEVENTS="MESSAGE" -DLOGCHANNEL="ConsoleLogChannel" -jar /users/sidiff/nightly-build/benchmark/runtime/org.eclipse.osgi_3.5.1.R35x_v20090827.jar -configuration /users/sidiff/nightly-build/benchmark/config -consolelog -clean -out_matching /users/sidiff/nightly-build/benchmark/matching3.out -out_diff /users/sidiff/nightly-build/benchmark/diff3.out -application $app -file1 /users/sidiff/nightly-build/benchmark/model/FujabaUMLPackage_v4.0.0.xmi -file2 /users/sidiff/nightly-build/benchmark/model/FujabaUMLPackage_v4.0.1.xmi -options org.sidiff.core.matching.IDBasedMatchingService=false,org.sidiff.core.matching.HashMatchingService=false,org.sidiff.core.matching.IterativeMatchingService=true > /users/sidiff/nightly-build/benchmark/appTime.txt
		/usr/bin/time -f %E -o /users/sidiff/nightly-build/benchmark/time.txt java -Dosgi.noShutdown=false -DLOGEVENTS="MESSAGE" -DLOGCHANNEL="ConsoleLogChannel" -jar /users/sidiff/nightly-build/benchmark/runtime/org.eclipse.osgi_3.7.1.R37x_v20110808-1106.jar -configuration /users/sidiff/nightly-build/benchmark/config -consolelog -clean -matching_filename /users/sidiff/nightly-build/benchmark/matching3.out -difference_filename /users/sidiff/nightly-build/benchmark/diff3.out -application $app -modelA /users/sidiff/nightly-build/benchmark/model/datavision/datavision38.smf.xmi -modelB /users/sidiff/nightly-build/benchmark/model/datavision/datavision136.smf.xmi -options org.sidiff.core.matching.IDBasedMatchingService=false,org.sidiff.core.matching.HashMatchingService=false,org.sidiff.core.matching.IterativeMatchingService=true > /users/sidiff/nightly-build/benchmark/appTime.txt
		
        execTime3=`cat /users/sidiff/nightly-build/benchmark/time.txt`
        appTime3=`grep Runtime /users/sidiff/nightly-build/benchmark/appTime.txt`

		##########
		#generate html-stats
		##########

		#echo "<tr><td>$lastRevision</td><td>$date</td><td>$time</td><td>$app</td><td><a href=\"backup/"$lastRevision"-"$timestamp"-config.ini\">config.ini</a></td><td><a href=\"backup/"$lastRevision"-"$timestamp"-result.xml\">result.xml</a></td><td>$execTime1[$appTime1]</td><td>$execTime2[$appTime2]</td><td>$execTime3[$appTime3]</td></tr>" >> $nbdir/benchmark/results.html		
		echo "<tr><td>$lastRevision</td><td>$date</td><td>$time</td><td>$app</td><td><a href=\"backup/"$lastRevision"-"$timestamp"-config.ini\">config.ini</a></td><td>$execTime1[$appTime1]</td><td>$execTime2[$appTime2]</td><td>$execTime3[$appTime3]</td></tr>" >> $nbdir/benchmark/results.html

		cat $nbdir/benchmark/header.html $nbdir/benchmark/results.html $nbdir/benchmark/footer.html > $nbdir/benchmark/benchmarks.html

        mv $nbdir/benchmark/benchmarks.html $nbdir/history

		##########
		#archive results
		##########
		
		mv $nbdir/benchmark/config/config.ini $nbdir/benchmark/backup/"$lastRevision"-"$timestamp"-config.ini

		##########
 		#clean up
		##########	

		cp $nbdir/lastrevision.txt $nbdir/benchmark/lastbenchmark.txt
		rm $nbdir/benchmark/model/*smf.xmi
		
		rm $nbdir/benchmark/model/datavision/datavision38.smf.xmi.smf.xmi
		rm $nbdir/benchmark/model/datavision/datavision136.smf.xmi.smf.xmi
		
		rm -rf $nbdir/benchmark/plugins
		rm -rf $nbdir/benchmark/config
		rm -rf $nbdir/benchmark/workspace
		rm $nbdir/benchmark/matching*.out
		rm $nbdir/benchmark/diff*.out
		rm $nbdir/benchmark/time.txt
		rm $nbdir/benchmark/appTime.txt
		rm $nbdir/benchmark/result.xml
		rm -r $nbdir/../htdocs/nb/backup
		cp -r $nbdir/benchmark/backup $nbdir/../htdocs/nb/ 
		

	fi
fi
