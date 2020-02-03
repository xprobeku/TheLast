Car Rental Management System
Configuration
Database

Make sure mysql server is running.

Correct db configuraiton at resources/application.properties. Three field need to be corrected:
spring.datasource.url=jdbc:mysql://localhost:3306/thelast?useSSL=false
spring.datasource.username=root
spring.datasource.password=adminadmin

Run application
Using commandline:
$ mvn spring-boot:run

Using eclipse:

Import project into eclipse
Right click on project -> Maven -> Update Project ...
Wait for downloading
Run configuration:
4.1 Ensure you have the Maven plugin installed into Eclipse.
4.2 Click Run > Run Configurations > Maven Build > new launch configuration:
4.3 Base directory: browse to the root of your project
4.4 Goals: spring-boot::run.
4.5 Click Apply then click Run.

GIT
Create local branch

$ git branch dev
$ git push -u origin dev
(create local branch 'dev' & push it to remote)

FF merge

checkout dev commit #1 onto dev commit #2 onto dev checkout master merge dev to master

3-bases merge

checkout dev commit #1 onto dev commit #2 onto dev checkout master commit #3 onto master merge dev to master
