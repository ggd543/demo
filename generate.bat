@echo off
if "%1" == "" (
	echo pls specify a new project directory
	GOTO END
)

SET BASE_DIR=%1
mkdir %BASE_DIR%
IF %ERRORLEVEL% NEQ 0 (
	echo %BASE_DIR% has already existed.
	GOTO END
)

mkdir %BASE_DIR%\src\main\java
mkdir %BASE_DIR%\src\test\java
mkdir %BASE_DIR%\src\resources
mkdir %BASE_DIR%\src\main\resources
mkdir %BASE_DIR%\src\test\resources
mkdir %BASE_DIR%\lib

SET ANT_PROJECT_NAME=%BASE_DIR:\=_%
@ECHO ^<?xml version="1.0" encoding="utf-8" ?^>>>build.xml
@ECHO ^<project name="%ANT_PROJECT_NAME%" default="jar" basedir="."^>>>build.xml
@ECHO 	^<import file="${basedir}/template.xml"/^>>>build.xml
@ECHO ^</project^>>>build.xml

move build.xml %BASE_DIR%\build.xml
copy template.xml %BASE_DIR%\template.xml
copy lib\*.jar %BASE_DIR%\lib\

:END
PAUSE