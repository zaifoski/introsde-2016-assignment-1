import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import peoplestore.generated.People;

/*
 * HealthProfileReaderJaxbJson class reads People.Person items from people.json file
 * HealthProfileReaderJaxbJson exposes to other classes its unmarshallJson method for unmarshalling json files
 */
public class HealthProfileReaderJaxbJson {  	
	/*
	 * people is an array of People
	 * where the elements of the json file are mapped
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
	 * unmarshallJson function takes as input the File to unmarshall
	 * and returns an array of people of unmarshalled json file
	 */
	public static People unmarshallJson(File toUnmarshall) throws JAXBException, JsonParseException, JsonMappingException, IOException{
	
		// Jackson Object Mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		// Adding the Jackson Module to process JAXB annotations
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        
		// configure as necessary
		mapper.registerModule(module);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

		return (People) mapper.readValue(toUnmarshall, People.class);
	}

	/*
 	 * main function reads People.Person items from people.json file
 	 */
	public static void main(String[] args) throws Exception {
        //read people if already present in file, otherwise do nothing
		try {        
			people = unmarshallJson(new File("people.json")) ;
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