import java.io.IOException;
import java.text.ParseException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * HealthProfileReaderXPath class executes some xPath queries on the people.xml file 
 */
public class HealthProfileReaderXPath {  
	
	/*
	 * xPath function accepts
	 * as first input a string representing the path of the file you want to access
	 * as second input a string representing the query you want to ask to that file
	 * e.g. "people.xml","/people/person[@id=4]/healthprofile/weight/text()"
	 * executes the xPath query and returns the list of nodes
	 */
	private static NodeList xPath(String filePath, String query) throws
		ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document doc = builder.parse(filePath);

	    XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
	    XPathExpression expr = xpath.compile(query);

	    Object result = expr.evaluate(doc, XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;

	    return nodes;
	}
	
	/*
	 * getHealthInfo function accepts
	 * as first input a string representing the id of the person you want to access
	 * as second input a string representing the health info you want to print
	 * e.g. "weight" or "height"
	 * and returns the health info requested
	 */
	private static String getHealthInfo(String id, String healthInfo) throws Exception {
		String filePath = "people.xml";
		String query = "/people/person[@id="+id+"]/healthprofile/"+healthInfo+"/text()";
		NodeList nodes = xPath(filePath,query);
	    if(nodes==null || nodes.item(0) == null || nodes.item(0).getNodeValue() == null){
			return "You did not input a valid id";
	    }
		return nodes.item(0).getNodeValue();
	}

	
	/*
	 * getChildren function recursively constructs a string of all children of the input node
	 * in the form <attribute_name>: <attribute_value> and then returns it
	 */	
	private static String getChildren(Node node) throws DOMException, ParseException, DatatypeConfigurationException{
		NodeList list = node.getChildNodes();
		String result = new String();
		if(list.item(0) != null && list.item(0).getNodeType() == Node.TEXT_NODE)
        	result += ((Element) node).getTagName() + ": ";
	    for (int j = 0; j < list.getLength(); ++j) {
	        Node child = list.item(j);
	        if (child.getNodeType() == Node.TEXT_NODE){
	        	result += child.getTextContent().toString();
	        }
	        else
	        	result += getChildren(child);
	    }
	    return result;
	}
	
	/*
	 * printAllPeople function prints all people in the list with detail
	 */		
	private static void printAllPeople() throws Exception {
		String filePath = "people.xml";
		String query = "/people";
		NodeList nodes = xPath(filePath,query);
		System.out.println("All people:");
		System.out.println(getChildren(nodes.item(0)));	
	}
	
	/*
	 * printHealthProfile function accepts id as parameter
	 * and prints the HealthProfile of the person with that id
	 */	
	private static void printHealthProfile(String id) throws Exception {
		String healthString = "height: "
				+ getHealthInfo(id,"height") + "; weight: "
				+ getHealthInfo(id,"weight") + "; bmi: "
				+ getHealthInfo(id,"bmi");
        System.out.println("Health Profile of person with id = "+ id +": "+healthString);
	}
	
	/*
	 * printWeightCondition function accepts a weight and an operator (=, > , <) as parameters
	 * and prints people that fulfill that condition (i.e., >80Kg, =75Kg, etc.).
	 */	
	private static void printWeightCondition(String weight, String operator) throws Exception {
		String query = "/people/person[healthprofile/weight"+operator+weight+"]";
		NodeList nodes = xPath("people.xml", query);
		System.out.println(
				"\nPeople that have a weight "+ operator + " "+ weight + ":"
        );
		for(int i = 0; i < nodes.getLength(); i++)
			System.out.println(getChildren(nodes.item(i)));
	}
	
	/*
	 * the main function accepts from 0 to 3 arguments
	 * 1st: the id of the person you want to print some health details of
	 * 2nd and 3rd: a weight and an operator (=, > , <) respectively
	 * and prints people that fulfill that condition (i.e., >80Kg, =75Kg, etc.)
	 * if less than 3 arguments are passed, some defaults value will be used
	 * if more than 3 arguments are passed, they will be ignored
	 */
	public static void main(String[] args) throws Exception {        
		String id = "1";
		String weight = "60";
		String operator = ">=";
		if (args.length >= 1) id = args[0];
		if (args.length >= 2) weight = args[1];
		if (args.length >= 3) operator = args[2];
		printAllPeople();
		printHealthProfile(id);
		printWeightCondition(weight,operator);
    }
}