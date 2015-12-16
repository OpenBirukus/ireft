ECHO %userprofile%

compile.bat

del /Q %userprofile%\AppData\Local\Ireft

mkdir %userprofile%\AppData\Local\Ireft

copy out\ireft.jar %userprofile%\AppData\Local\Ireft

echo start javaw -jar %userprofile%\AppData\Local\Ireft\ireft.jar > %userprofile%\AppData\Local\Ireft\runIreft.bat

echo start javaw -jar %userprofile%\AppData\Local\Ireft\ireft.jar > %userprofile%\Desktop\startIreft.bat