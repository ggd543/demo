@ECHO OFF
ECHO %1 
IF "%1" == "" (
   ECHO Pls spefiy the MIDlet-Name
   GOTO END
)
SET MIDlet_Name=%1

IF NOT EXIST %WTK_HOME% (
    echo Not found WTK_HOME variable	
    goto END
)

echo ----------------- Find the third party library --------------------
mkdir lib
SET LIB=
IF %ERRORLEVEL%  NEQ 0 (
   FOR /F "delims=" %%i IN ('dir lib\*.jar /b') DO SET LIB=%LIB%;lib\%%i 
)
echo %LIB%

echo ------------------- Set up Envirnment Viriable ------------------
SET MIDP_API_2_0=%WTK_HOME%\lib\midp_2.0.jar
SET CLDC_API_1_1=%WTK_HOME%\lib\cldc_1.1.jar
SET MIDP_CP=%MIDP_API_2_0%;%CLDC_API_1_1%

REM SET PATH=%SCALA_2_7_7_HOME%\bin;%PATH%
REM SET CLASSPATH=%JRE_1_4_2_CP%;%SCALA_2_7_7_CP%
rem pause

echo --------------------- compile --------------------
rmdir /S /Q tmpclasses classes dist 
mkdir tmpclasses classes dist 

javac -source 1.4 -target 1.4 -d tmpclasses -bootclasspath %MIDP_CP% -cp %CLASSPATH%;%LIB% src\*.java 
rem scalac -d tmpclasses -bootclasspath %MIDP_CP% -cp %CLASSPATH% src\*.scala

IF %ERRORLEVEL% NEQ  0 (
    ECHO There is a compilation error 
	GOTO END
)

echo ---------------------- preverify ---------------------------
preverify -d classes -classpath %MIDP_CP%;%CLASSPATH%;%LIB% tmpclasses


echo ---------------------- make a jar file ---------------------
copy /Y MANIFEST.MF classes
copy lib classes
cd classes
jar xf *.jar
del /S /Q *.jar
mkdir META-INF
move /Y MANIFEST.MF META-INF
jar cvfm %MIDlet_Name%.jar META-INF\MANIFEST.MF -C . .
cd ..
move /Y classes\%MIDlet_Name%.jar dist

ECHO ------------------- deploy the jar file and prepare the .jad file ----------
copy /Y %MIDlet_Name%.jad dist
@echo.>> dist\%MIDlet_Name%.jad
for %%i IN (dist\%MIDlet_Name%.jar) do @echo MIDlet-Jar-Size: %%~zi >> dist\%MIDlet_Name%.jad

echo ----------------- start up the emulator ----------------
emulator -Xdescriptor:dist\%MIDlet_Name%.jad

:END
pause
