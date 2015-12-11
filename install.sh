#!/bin/bash
#
#
#
#


JAVA=/opt/jdk1.8.0_60/bin



########################################################
JAVAC=$JAVA/javac

$JAVAC -d src/ src/*.java

$JAVA/jar cfm out/ireft.jar src/manifest.mf ireft/*.class 

rm src/*.class

echo "#!/bin/bash">>ireft.sh
echo "java -jar ireft.jar">>ireft.sh

chmod +x ireft.sh

./ireft.sh
