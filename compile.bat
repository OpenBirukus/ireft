ECHO OFF

SET currdir =C:\BTesfaye\dev\ireft\ireft-master\
::%CD%

ECHO %currdir%

del src\ireft\ireft\*.class /Q

del out\ireft.jar

"C:\Program Files\Java\jdk1.8.0_60\bin\javac.exe"    -d    %currdir%src\ireft %currdir%src\ireft\*.java

"C:\Program Files\Java\jdk1.8.0_60\bin\jar.exe"      -cvfm %currdir%out\ireft.jar %currdir%src\manifest.mf ireft.Main -C %currdir%src\ireft %currdir%src\ireft\ireft\*.class

::"C:\Program Files\Java\jdk1.8.0_60\bin\java.exe"     -jar  %currdir%out\ireft.jar

::"C:\Program Files\Java\jdk1.8.0_60\bin\java.exe"     -cp   %currdir%out\ireft.jar iref.Main

::"C:\Program Files\Java\jdk1.8.0_60\bin\java" -classpath C:\BTesfaye\dev\ireft\ireft-master\out\production\gitmaster ireft.Main
ECHO ON

