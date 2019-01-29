@echo
set root=D:\bj\apache-tomcat-8.0.32
rem set root=D:\apache-tomcat-test
set logdate=%date:~0,4%-%date:~5,2%-%date:~8,2%

echo "stopping tomcat service bjwwj..."
net stop bjwwj

echo "del tomcat webapps files..."
rd/s/q %root%\webapps\admin
del/f/s/q %root%\webapps\admin.war
echo "clear tomcat work dir..."
rd/s/q %root%\work\Catalina

echo "svn update..."
svn up
echo "mvn package..."
@call beta_236.bat
echo "copy war to tomcat webapps..."
copy target\admin.war %root%\webapps\
echo "start tomcat service bjwwj..."
net start bjwwj

echo "view logs..."
tail -f %root%\logs\Catalina.%logdate%.log