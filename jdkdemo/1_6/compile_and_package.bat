del *.jar /q /f
rd target_1.5 /s /q
rd target_1.6 /s /q
mkdir target_1.5
mkdir target_1.6

set "JAVA_HOME=C:\PROGRA~2\Java\jdk1.6.0_37"
set PATH=%JAVA_HOME%\bin;%PATH%

javac  -classpath %JAVA_HOME%\lib\dt.jar -d target_1.5 -source 1.5 -target 1.5 -encoding UTF-8 src\com\ggd543\jdkdemo\*.java
jar -cvf stringapp-1.5.jar -C target_1.5 .

javac -classpath %JAVA_HOME%\lib\dt.jar -d target_1.6 -source 1.6 -target 1.6 -encoding UTF-8 src\com\ggd543\jdkdemo\*.java
jar -cvf stringapp-1.6.jar -C target_1.6 .

pause