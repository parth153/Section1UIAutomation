@echo off
::navigate to the maven bin directory

SET PROJECT_HOME=%cd%

cd .\Maven\bin
::clean the target folder
call mvn clean -f %PROJECT_HOME%\CompareRetailFunds\pom.xml
::compile the tests
call mvn compile -f %PROJECT_HOME%\CompareRetailFunds\pom.xml
::install the dependencies and run the test
call mvn install -f %PROJECT_HOME%\CompareRetailFunds\pom.xml

pause