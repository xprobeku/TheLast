Uses BOM for dependencies...
application context is in classpath 

 Username/password are the same admin/admin & guest/guest
 
Also, you need to create  the database [entiremember] in MySql

Demonstrate basic Login:
Comment out login details in security xml
ALSO change welcome.jsp to access by /spring_security_login [ in Security Version3; version 4 uses /login]
ALSO Make Sure NOT HTTPS

REVIEW encryption in Service layer during login
Credentials service

Demostrate WEB URL authorization
Demostrate method based by commenting out URL based in XML
[Server level more secure]

NOTE:  Authorization is on Add Member page
ALSO ::  can use Method based in CONTROLLER
                If global-method-security enabled in Dispatcher config

Demo Handler Interceptor...