The Object Relational Mapping backed for the RMS Web project 

This project contains the core entities for the RMS Web. 

NOTE: In order to use this project 
1. import the project usgin eclipse as existing Maven project 
2. Configure your JPA data source to point to the desired database this may include
	a. Downloading the specific JDBC drivers for your database 
	b.  Configure the data source under Window > Show View > Data source explorer 
3. Right click the project name and generate the database using JPA tools > Generate Tables from Entities
4. Update Maven dependencies
5. Run Maven “clean install”.


This will install the project inside your local maven repository.