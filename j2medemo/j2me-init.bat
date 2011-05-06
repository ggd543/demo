@ECHO OFF
ECHO %1 
IF "%1" == "" (
   ECHO Pls spefiy the MIDlet-Name
   GOTO END
)

SET MIDlet_Name=%1

mkdir %MIDlet_Name%
IF %ERRORLEVEL% NEQ 0 (
	echo %MIDlet_NAME% alread exists
	GOTO END
)

echo -------------- set up the directory -----------------
mkdir %MIDlet_Name%\src
mkdir %MIDlet_Name%\resources
mkdir %MIDlet_Name%\lib
mkdir %MIDlet_Name%\test

@echo @echo off>>build.bat
@echo SET MIDlet_Name=%MIDlet_Name%>>build.bat
type build>>build.bat
move build.bat %MIDlet_Name%\

echo ------------ generate project.properties --------------
@echo MIDlet-Name: %MIDlet_Name%>>project.properties
@echo MIDlet-Version: 1.0.0>>project.properties
@echo MIDlet-Vendor: Unknown>>project.properties
@echo MIDlet-1: %MIDlet_Name%, , %MIDlet_Name%MIDlet>>project.properties
@echo MicroEdition-Configuration: CLDC-1.1>>project.properties
@echo MicroEdition-Profile: MIDP-2.0>>project.properties
move project.properties %MIDlet_Name%\

echo --------------generate the midlet source file-------------
SET MIDlet_FILE=%MIDlet_Name%MIDlet.java
@echo import javax.microedition.midlet.*;>>%MIDlet_FILE%
@echo public class %MIDlet_Name%MIDlet extends MIDlet{>>%MIDlet_FILE%
@echo 	public %MIDlet_Name%MIDlet() {>>%MIDlet_FILE%
@echo 	}>>%MIDlet_FILE%
@echo 	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {>>%MIDlet_FILE%
@echo 	}>>%MIDlet_FILE%
@echo 	protected void pauseApp() {>>%MIDlet_FILE%
@echo 	}>>%MIDlet_FILE%
@echo 	protected void startApp() throws MIDletStateChangeException{>>%MIDlet_FILE%
@echo 	}>>%MIDlet_FILE%
@echo }>>%MIDlet_FILE%
move %MIDlet_FILE% %MIDlet_Name%\src\

if "%2" == "-p" (
	mkdir %MIDlet_Name%\resources\images
	mkdir %MIDlet_Name%\resources\sounds
	@echo. >>polish.css
	@echo. >>messages.txt
	move messages.txt %MIDlet_Name%\resources\
	move polish.css %MIDlet_Name%\resources\
	copy build.xml %MIDlet_Name%\
)

:END
pause
