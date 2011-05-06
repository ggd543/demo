call ..\..\init.bat
rmdir /Q /S compiled output 
mkdir compiled output
javac -source 1.4 -target 1.4 -d compiled src\msg\Msg.java
preverify -d output -classpath %MIDP_CP%;%CLASSPATH% compiled
cd output
jar cvf A.jar msg\Msg.class
cd ..
move output\A.jar ..\..\lib
pause

