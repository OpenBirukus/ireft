#!/bin/bash
#
#
#
#


JAVA=/opt/jdk1.8.0_60/bin

########################################################

rm -rf ~/.Ireft
mkdir ~/.Ireft/
cp out/ireft.jar ~/.Ireft/ireft.jar

echo "#!/bin/bash">~/.Ireft/ireft.sh
echo "$JAVA -jar ~/.Ireft/ireft.jar">>~/Ireft/ireft.sh

chmod +x ~/Ireft/ireft.sh

echo "$JAVA -jar ~/.Ireft/ireft.jar &" >> ~/.profile
