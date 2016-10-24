# introsde-2016-assignment-1

HealthProfileReaderXPath has some functions to read the people.xml file using XPath.
HealthProfileReaderJaxbXml has some functions to unmarshall and read the people.xml file using Jaxb.
HealthProfileReaderJaxbJson has some functions to unmarshall and read the people.json file using Jaxb.
HealthProfileWriterJaxbXml has some functions to add people to the people.xml file.
HealthProfileWriterJaxbJson has some functions to add people to the people.json file.
HealthProfileWriter has some functions to create new people.
HealthProfileWriter is used both by HealthProfileWriterJaxbXml and by HealthProfileWriterJaxbJson.

Given a file path and a query, you can perform the query on the file. 
Given an xml node, you can print all its descedents' pair of attribute name and attribute value.
Given the id of a person in the database, you can display its health info.
You can access weight, height or bmi of a person.
You can calculte bmi of a person.
You can access all people that satisfy some condition on weight.
You can print all people both from an xml or from a json file.
You can add people both to an xml or json file and have feedback on your action.

ant execute.evaluation
    executes the samples as required by the assignment

ant compile
ant execute.<class_name>
    executes only the class <class_name> with the sample inputs required by the assignment

