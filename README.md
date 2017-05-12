# PbTemplateMetadata
Demonstrate a problem when metadata is used with a template with JSF.
This project uses Java DB and GlassFish 4.1.2. If you want to change the database, change the annotation @DataSourceDefinition in GestionnaireQuestion.java and add the JDBC driver to the project. The project had been tested with Payara too and WebLogic.
To start with NetBeans:
  - create a database "testquestions" with Java DB, user "toto", password "toto"
  - start the project; the data will be created automatically in the database
  
To reproduce the problem, select a question and click on Modify. You will get a PropertyNotFoundException at the submit of the form.
In the log of the server, is written "this" for the session scoped backing bean; it is also written in the page which modify a question. A phase listener is used to see the different phases of the JSF life cycle.
If you click "Modify without template", the page which modify the question has no template and it works, no exception.
