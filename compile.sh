#!/bin/bash
CURRDIR=`pwd`

rm src/ireft/ireft/*.class 

rm out/ireft.jar

JAVAPATH=/opt/jdk1.8.0_60/bin

$JAVAPATH/javac  -d    $CURRDIR/src/ireft $CURRDIR/src/ireft/*.java

$JAVAPATH/jar    -cvfm $CURRDIR/out/ireft.jar $CURRDIR/src/manifest.mf ireft.Main \
			-C $CURRDIR/src/ireft $CURRDIR/src/ireft/ireft/*.class


# run
#$JAVAPATH/java -jar out/ireft.jar
