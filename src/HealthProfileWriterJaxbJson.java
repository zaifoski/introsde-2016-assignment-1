import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import peoplestore.generated.People;
/*
 * HealthProfileWriterJaxbJson class writes People.Person items to the people.json file
 */
public class HealthProfileWriterJaxbJson {  	
	/*
	 * people is an array of People
	 * where the elements of the json file are mapped
	 */
	private static People people = new People();
	/*
	 * maxId is a String
	 * represented the highest id of elements of the people array
	 */
	private static String maxId = "0";

	/*
	 * main function writes to people.json file
	 * previous contents, if present
	 * and new random People.Person items anyway
	 * accepts from 0 to 1 argument
	 * 1st arg: the number of people you want to add
	 */
	public static void main(String[] args) throws Exception {
		
		int numPeople = 1;
		if (args.length >= 1) {
			try{
				numPeople = Integer.parseInt(args[0]);
			} catch(NumberFormatException nfe){}
		}
		
		// Jackson Object Mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		// Adding the Jackson Module to process JAXB annotations
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        
		// configure as necessary
		mapper.registerModule(module);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        //re-add people if already present in file, otherwise do nothing
        try {
        	File toUnmarshall = new File("people.json");
			/*unmarshal old content and add it to the new file*/
	        people = HealthProfileReaderJaxbJson.unmarshallJson(toUnmarshall);
	        
	        List<People.Person> list = people.getPerson();
	
	        for (People.Person person : list) {
	        	if(Integer.parseInt(person.getId()) > Integer.parseInt(maxId))
	        		maxId = person.getId();
	        }
        } catch(Exception e){}
        
        //create new random People.Person, set incremental id and add them to people array
        for(int i = 0; i < numPeople; i++){
        	People.Person newRandomPerson = HealthProfileWriter.createNewPerson();
    		maxId = ""+(Integer.parseInt(maxId) + 1);
    		newRandomPerson.setId(maxId);

    		people.getPerson().add(newRandomPerson);
        }
        
        //marshalling content of people array to file and to standard output
        mapper.writeValue(new File("people.json"), people);
        mapper.writeValue(System.out, people);
    }
}