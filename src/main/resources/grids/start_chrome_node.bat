@echo off
REM Set the path to files
SET SELENIUM_SERVER_JAR=selenium-server-4.21.0.jar
SET CONFIG_FILE=chrome-node.toml

REM Check if the Selenium server jar file exists
IF NOT EXIST %SELENIUM_SERVER_JAR% (
    echo Selenium server jar file not found!
    exit /b 1
)

IF NOT EXIST %CONFIG_FILE% (
    echo Configuration file not found!
    exit /b 1
)

REM Run the Selenium server
echo Starting node for Chrome...
java -jar %SELENIUM_SERVER_JAR% node --config %CONFIG_FILE% --port 5555
