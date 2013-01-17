del *.jar /q /f
rd target_1.5 /s /q
mkdir target_1.5

set DIR=%~dp0.
set "JAVA_HOME=C:\PROGRA~2\Java\jdk1.5.0_16"
set PATH=%JAVA_HOME%\bin;%PATH%
javac  -classpath %JAVA_HOME%\lib\dt.jar;%DIR%\lib\stringapp-1.5.jar -d target_1.5 -source 1.5 -target 1.5 -encoding UTF-8 src\com\ggd543\jdkdemo\*.java
jar -cvf stringmain-1.5.jar -C target_1.5 .

java -cp %JAVA_HOME%\lib\dt.jar;%DIR%\lib\stringapp-1.5.jar;%DIR%\stringmain-1.5.jar com.ggd543.jdkdemo.StringMain 
pause