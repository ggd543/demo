del *.jar /q /f
rd target_1.5 /s /q
rd target_1.6 /s /q
mkdir target_1.5
mkdir target_1.6

set DIR=%~dp0.
set "JAVA_HOME=C:\PROGRA~2\Java\jdk1.5.0_16"
set PATH=%JAVA_HOME%\bin;%PATH%

rem JDK 1.5 使用JDK 1.5格式的字节码
javac  -classpath %JAVA_HOME%\lib\dt.jar;%DIR%\lib\stringapp-1.5.jar -d target_1.5 -source 1.5 -target 1.5 -encoding UTF-8 src\com\ggd543\jdkdemo\*.java
jar -cvf stringmain-1.5_1.5.jar -C target_1.5 .
java -cp %JAVA_HOME%\lib\dt.jar;%DIR%\lib\stringapp-1.5.jar;%DIR%\stringmain-1.5_1.5.jar com.ggd543.jdkdemo.StringMain 

pause 
exit 0

rem JDK 1.5 使用JDK 1.6格式的字节码(是不行的)
javac  -classpath %JAVA_HOME%\lib\dt.jar;%DIR%\lib\stringapp-1.6.jar -d target_1.5 -source 1.5 -target 1.5 -encoding UTF-8 src\com\ggd543\jdkdemo\*.java
jar -cvf stringmain-1.5_1.6.jar -C target_1.5 .
java -cp %JAVA_HOME%\lib\dt.jar;%DIR%\lib\stringapp-1.6.jar;%DIR%\stringmain-1.5_1.6.jar com.ggd543.jdkdemo.StringMain 

rem JDK 1.6 使用JDK 1.5格式的字节码
set "JAVA_HOME=C:\PROGRA~2\Java\jdk1.6.0_37"
set PATH=%JAVA_HOME%\bin;%PATH%
javac -classpath %JAVA_HOME%\lib\dt.jar;%DIR%\lib\stringapp-1.5.jar -d target_1.6 -source 1.6 -target 1.6 -encoding UTF-8 src\com\ggd543\jdkdemo\*.java
jar -cvf stringmain-1.6_1.5.jar -C target_1.6 .
java -cp %JAVA_HOME%\lib\dt.jar;%DIR%\lib\stringapp-1.5.jar;%DIR%\stringmain-1.6_1..jar com.ggd543.jdkdemo.StringMain 

pause