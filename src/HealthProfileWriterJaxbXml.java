import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import peoplestore.generated.People;
/*
 * HealthProfileWriterJaxbXml class writes People.Person items to the people.xml file
 */
public class HealthProfileWriterJaxbXml {  
	/*
	 * people is an array of People
	 * where the elements of the xml file are mapped
	 */
	private static People people = new People();
	/*
	 * maxId is a String
	 * represented the highest id of elements of the people array
	 */
	private static String maxId = "0";
	
	/*
	 * main function writes to people.xml files
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
		
		JAXBContext jc = JAXBContext.newInstance(People.class);

		//create marshaller object
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        //re-add people if already present in file, otherwise do nothing
        try {			
        	FileReader toUnmarshall = new FileReader("people.xml");
			/*unmarshal old content and add it to the new file*/
	        people = HealthProfileReaderJaxbXml.unmarshallXml(toUnmarshall);
	        
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
        
        m.marshal(people,new File("people.xml")); // marshalling into a file
        m.marshal(people, System.out);			  // marshalling into the system default output
    }
}