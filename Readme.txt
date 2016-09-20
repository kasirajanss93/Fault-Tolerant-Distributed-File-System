1.Compile java files in JDK 1.5

	javac -Xlint:1024 -d . *.java

2.Change class path to wscompile and compile the config_interface.xml

	wscompile -define -mapping mapping.xml -d . -nd . -classpath . config_interface.xml

3.Start the Default Sun App Server Deploy tool

	include the mapping.xml,WSDL file and packages

4.Click on the Globe after delpoying. add Aliases then changer the EndPointReference.

	localhost:<port>/<war name>/<alias name>?WSDL to check if deployed.

5.compile the Client side wsdl

	wscompile -gen:client -keep -d . -nd . -classpath . config_wsdl.xml

6.classpath.bat

	compile and run the Client file.
