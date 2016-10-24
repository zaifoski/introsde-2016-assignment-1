import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import peoplestore.generated.People;

/*
 * HealthProfileReaderJaxbXml class reads People.Person items from people.xml file
 * HealthProfileReaderJaxbXml exposes to other classes its unmarshallXml method for unmarshalling xml files
 */
public class HealthProfileReaderJaxbXml {  	
	/*
	 * people is an array of People
	 * where the elements of the xml file are mapped
	 */
	private static People people = new People();
	
	/*
	 * constructDateString function takes an input of type XMLGregorianCalendar
	 * and returns the date as a String easily readable by humans in form dd/mm/yyyy
	 */
	private static String constructDateString(XMLGregorianCalendar date){
		String dateString = date.getDay()
    			+ "/" + date.getMonth()
    			+ "/" + date.getYear();
		return dateString;
	}
	
	/*
	 * unmarshallXml function takes as input the FileReader to unmarshall
	 * and returns an array of people of unmarshalled xml file
	 */
	public static People unmarshallXml(FileReader toUnmarshall) throws JAXBException, FileNotFoundException{
		JAXBContext jc = JAXBContext.newInstance(People.class);
	    Unmarshaller um = jc.createUnmarshaller();
		return (People) um.unmarshal(toUnmarshall);
	}

	/*
 	 * main function reads People.Person items from people.xml file
 	 */
	public static void main(String[] args) throws Exception {
        //read people if already present in file, otherwise do nothing
		try {
			people = (People) unmarshallXml(new FileReader("people.xml"));
		} catch(Exception e){}
		
        List<People.Person> list = people.getPerson();
        for (People.Person person : list) {
          System.out.println("Person: "
        		  + person.getFirstname() + " "
        		  + person.getLastname() + " | born "
        		  + constructDateString(person.getBirthdate()) + " | height:"
        		  + person.getHealthprofile().getHeight() + " | weight: "
        		  + person.getHealthprofile().getWeight() + " | bmi: "
        		  + person.getHealthprofile().getBmi() + " | last updated: "
        		  + constructDateString(person.getHealthprofile().getLastupdate()) + " | id: " 
        		  + person.getId()
        		  );
        }
    }
}