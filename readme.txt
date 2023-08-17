Importing the project to Eclipse IDE:

After extracting the file "EA Cloth Design", create a new javaFX project then right click import to the project in Package Explorer.
Select General, then File System and next. Next to From directory select browse and then the extraceted file. Click Finish

Running the project in Eclipse IDE:

Hover the run button above Package Explorer and click the drop down button. Then click Run Configurations.
Right click Java Application and click on New Configuration.
Then click on Arguments and in the VM arguments box paste --module-path "your path" --add-modules javafx.controls,javafx.fxml.
In your path area browse through your files. Find java then javafx-sdk-(version) then lib copy path and replace it at the command above.
Then paste the command into VM arguments, click apply and Close.

---------------------------------------------------------------------------------------------------------------------------------------------

Running the jar file:

After extracting the file "CDjar" in any location open cmd. Browse with the "cd" to your exraction location.
insert and run the command java --module-path "your path" --add-modules javafx.controls,javafx.fxml -jar CDjar.jar.
Don't forget to change your path to the path was obtained in the step "Running the project in Eclipse IDE".


