import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import peoplestore.generated.People;

/*
 * HealthProfileWriter class exposes its createNewPerson method
 * which returns a new random People.Person item
 */
public class HealthProfileWriter {  	
	/*
	 * gregorianCalendar is a GregorianCalendar used to manage dates
	 */
	private static GregorianCalendar gregorianCalendar = new GregorianCalendar();
	
	/*
	 * lastNames is an array of people's possible first names
	 */
	private static String[] firstNames = new String[] {
	        "Ada", "Albert", "Alexandra", "Alfredo", "Allen", "Andre", "Angelica",
	        "Anna", "Anthony", "Antonio", "Ashley", "Audrey", "Beatrice",
	        "Benjamin", "Billy", "Bobby", "Bradley", "Bryant", "Candace",
	        "Carole", "Carrie", "Claire", "Clifford", "Clint", "Clyde", "Cory",
	        "Dale", "Danielle", "Daryl", "Delia", "Devin", "Douglas", "Eddie",
	        "Ella", "Erica", "Erika", "Eva", "Frank", "Gayle", "George", "Georgia",
	        "Geraldine", "Gina", "Gwen", "Hector", "Homer", "Irene", "James",
	        "Jamie", "Jeremiah", "Joann", "Josefina", "Juan", "Karen", "Kenneth",
	        "Laurie", "Lee", "Leland", "Leroy", "Levi", "Lewis", "Lillian",
	        "Lillie", "Lorenzo", "Louise", "Lucas", "Lynn", "Marc", "Marcella",
	        "Marlon", "Marvin", "Micheal", "Miranda", "Miriam", "Misty", "Naomi",
	        "Natasha", "Nelson", "Oliver", "Pete", "Rafael", "Randall", "Raul",
	        "Rebecca", "Reginald", "Roger", "Ruby", "Rufus", "Sabrina", "Sean",
	        "Steven", "Stuart", "Terence", "Terry", "Van", "Velma", "Vincent",
	        "Wanda", "Willard", "Winifred"
	};
	
	/*
	 * lastNames is an array of people's possible last names
	 */
	private static String[] lastNames = new String[] {"Abbott", "Acevedo", "Acosta", "Adams", "Adkins", "Aguilar", "Aguirre", "Albert", "Alexander", "Alford", "Allen", "Allison", "Alston", "Alvarado", "Alvarez", "Anderson", "Andrews", "Anthony", "Armstrong", "Arnold", "Ashley", "Atkins", "Atkinson", "Austin", "Avery", "Avila", "Ayala", "Ayers", "Bailey", "Baird", "Baker", "Baldwin", "Ball", "Ballard", "Banks", "Barber", "Barker", "Barlow", "Barnes", "Barnett", "Barr", "Barrera", "Barrett", "Barron", "Barry", "Bartlett", "Barton", "Bass", "Bates", "Battle", "Bauer", "Baxter", "Beach", "Bean", "Beard", "Beasley", "Beck", "Becker", "Bell", "Bender", "Benjamin", "Bennett", "Benson", "Bentley", "Benton", "Berg", "Berger", "Bernard", "Berry", "Best", "Bird", "Bishop", "Black", "Blackburn", "Blackwell", "Blair", "Blake", "Blanchard", "Blankenship", "Blevins", "Bolton", "Bond", "Bonner", "Booker", "Boone", "Booth", "Bowen", "Bowers", "Bowman", "Boyd", "Boyer", "Boyle", "Bradford", "Bradley", "Bradshaw", "Brady", "Branch", "Bray", "Brennan", "Brewer", "Bridges", "Briggs", "Bright", "Britt", "Brock", "Brooks", "Brown", "Browning", "Bruce", "Bryan", "Bryant", "Buchanan", "Buck", "Buckley", "Buckner", "Bullock", "Burch", "Burgess", "Burke", "Burks", "Burnett", "Burns", "Burris", "Burt", "Burton", "Bush", "Butler", "Byers", "Byrd", "Cabrera", "Cain", "Calderon", "Caldwell", "Calhoun", "Callahan", "Camacho", "Cameron", "Campbell", "Campos", "Cannon", "Cantrell", "Cantu", "Cardenas", "Carey", "Carlson", "Carney", "Carpenter", "Carr", "Carrillo", "Carroll", "Carson", "Carter", "Carver", "Case", "Casey", "Cash", "Castaneda", "Castillo", "Castro", "Cervantes", "Chambers", "Chan", "Chandler", "Chaney", "Chang", "Chapman", "Charles", "Chase", "Chavez", "Chen", "Cherry", "Christensen", "Christian", "Church", "Clark", "Clarke", "Clay", "Clayton", "Clements", "Clemons", "Cleveland", "Cline", "Cobb", "Cochran", "Coffey", "Cohen", "Cole", "Coleman", "Collier", "Collins", "Colon", "Combs", "Compton", "Conley", "Conner", "Conrad", "Contreras", "Conway", "Cook", "Cooke", "Cooley", "Cooper", "Copeland", "Cortez", "Cote", "Cotton", "Cox", "Craft", "Craig", "Crane", "Crawford", "Crosby", "Cross", "Cruz", "Cummings", "Cunningham", "Curry", "Curtis", "Dale", "Dalton", "Daniel", "Daniels", "Daugherty", "Davenport", "David", "Davidson", "Davis", "Dawson", "Day", "Dean", "Decker", "Dejesus", "Delacruz", "Delaney", "Deleon", "Delgado", "Dennis", "Diaz", "Dickerson", "Dickson", "Dillard", "Dillon", "Dixon", "Dodson", "Dominguez", "Donaldson", "Donovan", "Dorsey", "Dotson", "Douglas", "Downs", "Doyle", "Drake", "Dudley", "Duffy", "Duke", "Duncan", "Dunlap", "Dunn", "Duran", "Durham", "Dyer", "Eaton", "Edwards", "Elliott", "Ellis", "Ellison", "Emerson", "England", "English", "Erickson", "Espinoza", "Estes", "Estrada", "Evans", "Everett", "Ewing", "Farley", "Farmer", "Farrell", "Faulkner", "Ferguson", "Fernandez", "Ferrell", "Fields", "Figueroa", "Finch", "Finley", "Fischer", "Fisher", "Fitzgerald", "Fitzpatrick", "Fleming", "Fletcher", "Flores", "Flowers", "Floyd", "Flynn", "Foley", "Forbes", "Ford", "Foreman", "Foster", "Fowler", "Fox", "Francis", "Franco", "Frank", "Franklin", "Franks", "Frazier", "Frederick", "Freeman", "French", "Frost", "Fry", "Frye", "Fuentes", "Fuller", "Fulton", "Gaines", "Gallagher", "Gallegos", "Galloway", "Gamble", "Garcia", "Gardner", "Garner", "Garrett", "Garrison", "Garza", "Gates", "Gay", "Gentry", "George", "Gibbs", "Gibson", "Gilbert", "Giles", "Gill", "Gillespie", "Gilliam", "Gilmore", "Glass", "Glenn", "Glover", "Goff", "Golden", "Gomez", "Gonzales", "Gonzalez", "Good", "Goodman", "Goodwin", "Gordon", "Gould", "Graham", "Grant", "Graves", "Gray", "Green", "Greene", "Greer", "Gregory", "Griffin", "Griffith", "Grimes", "Gross", "Guerra", "Guerrero", "Guthrie", "Gutierrez", "Guy", "Guzman", "Hahn", "Hale", "Haley", "Hall", "Hamilton", "Hammond", "Hampton", "Hancock", "Haney", "Hansen", "Hanson", "Hardin", "Harding", "Hardy", "Harmon", "Harper", "Harrell", "Harrington", "Harris", "Harrison", "Hart", "Hartman", "Harvey", "Hatfield", "Hawkins", "Hayden", "Hayes", "Haynes", "Hays", "Head", "Heath", "Hebert", "Henderson", "Hendricks", "Hendrix", "Henry", "Hensley", "Henson", "Herman", "Hernandez", "Herrera", "Herring", "Hess", "Hester", "Hewitt", "Hickman", "Hicks", "Higgins", "Hill", "Hines", "Hinton", "Hobbs", "Hodge", "Hodges", "Hoffman", "Hogan", "Holcomb", "Holden", "Holder", "Holland", "Holloway", "Holman", "Holmes", "Holt", "Hood", "Hooper", "Hoover", "Hopkins", "Hopper", "Horn", "Horne", "Horton", "House", "Houston", "Howard", "Howe", "Howell", "Hubbard", "Huber", "Hudson", "Huff", "Huffman", "Hughes", "Hull", "Humphrey", "Hunt", "Hunter", "Hurley", "Hurst", "Hutchinson", "Hyde", "Ingram", "Irwin", "Jackson", "Jacobs", "Jacobson", "James", "Jarvis", "Jefferson", "Jenkins", "Jennings", "Jensen", "Jimenez", "Johns", "Johnson", "Johnston", "Jones", "Jordan", "Joseph", "Joyce", "Joyner", "Juarez", "Justice", "Kane", "Kaufman", "Keith", "Keller", "Kelley", "Kelly", "Kemp", "Kennedy", "Kent", "Kerr", "Key", "Kidd", "Kim", "King", "Kinney", "Kirby", "Kirk", "Kirkland", "Klein", "Kline", "Knapp", "Knight", "Knowles", "Knox", "Koch", "Kramer", "Lamb", "Lambert", "Lancaster", "Landry", "Lane", "Lang", "Langley", "Lara", "Larsen", "Larson", "Lawrence", "Lawson", "Le", "Leach", "Leblanc", "Lee", "Leon", "Leonard", "Lester", "Levine", "Levy", "Lewis", "Lindsay", "Lindsey", "Little", "Livingston", "Lloyd", "Logan", "Long", "Lopez", "Lott", "Love", "Lowe", "Lowery", "Lucas", "Luna", "Lynch", "Lynn", "Lyons", "Macdonald", "Macias", "Mack", "Madden", "Maddox", "Maldonado", "Malone", "Mann", "Manning", "Marks", "Marquez", "Marsh", "Marshall", "Martin", "Martinez", "Mason", "Massey", "Mathews", "Mathis", "Matthews", "Maxwell", "May", "Mayer", "Maynard", "Mayo", "Mays", "Mcbride", "Mccall", "Mccarthy", "Mccarty", "Mcclain", "Mcclure", "Mcconnell", "Mccormick", "Mccoy", "Mccray", "Mccullough", "Mcdaniel", "Mcdonald", "Mcdowell", "Mcfadden", "Mcfarland", "Mcgee", "Mcgowan", "Mcguire", "Mcintosh", "Mcintyre", "Mckay", "Mckee", "Mckenzie", "Mckinney", "Mcknight", "Mclaughlin", "Mclean", "Mcleod", "Mcmahon", "Mcmillan", "Mcneil", "Mcpherson", "Meadows", "Medina", "Mejia", "Melendez", "Melton", "Mendez", "Mendoza", "Mercado", "Mercer", "Merrill", "Merritt", "Meyer", "Meyers", "Michael", "Middleton", "Miles", "Miller", "Mills", "Miranda", "Mitchell", "Molina", "Monroe", "Montgomery", "Montoya", "Moody", "Moon", "Mooney", "Moore", "Morales", "Moran", "Moreno", "Morgan", "Morin", "Morris", "Morrison", "Morrow", "Morse", "Morton", "Moses", "Mosley", "Moss", "Mueller", "Mullen", "Mullins", "Munoz", "Murphy", "Murray", "Myers", "Nash", "Navarro", "Neal", "Nelson", "Newman", "Newton", "Nguyen", "Nichols", "Nicholson", "Nielsen", "Nieves", "Nixon", "Noble", "Noel", "Nolan", "Norman", "Norris", "Norton", "Nunez", "Obrien", "Ochoa", "Oconnor", "Odom", "Odonnell", "Oliver", "Olsen", "Olson", "Oneal", "Oneil", "Oneill", "Orr", "Ortega", "Ortiz", "Osborn", "Osborne", "Owen", "Owens", "Pace", "Pacheco", "Padilla", "Page", "Palmer", "Park", "Parker", "Parks", "Parrish", "Parsons", "Pate", "Patel", "Patrick", "Patterson", "Patton", "Paul", "Payne", "Pearson", "Peck", "Pena", "Pennington", "Perez", "Perkins", "Perry", "Peters", "Petersen", "Peterson", "Petty", "Phelps", "Phillips", "Pickett", "Pierce", "Pittman", "Pitts", "Pollard", "Poole", "Pope", "Porter", "Potter", "Potts", "Powell", "Powers", "Pratt", "Preston", "Price", "Prince", "Pruitt", "Puckett", "Pugh", "Quinn", "Ramirez", "Ramos", "Ramsey", "Randall", "Randolph", "Rasmussen", "Ratliff", "Ray", "Raymond", "Reed", "Reese", "Reeves", "Reid", "Reilly", "Reyes", "Reynolds", "Rhodes", "Rice", "Rich", "Richard", "Richards", "Richardson", "Richmond", "Riddle", "Riggs", "Riley", "Rios", "Rivas", "Rivera", "Rivers", "Roach", "Robbins", "Roberson", "Roberts", "Robertson", "Robinson", "Robles", "Rocha", "Rodgers", "Rodriguez", "Rodriquez", "Rogers", "Rojas", "Rollins", "Roman", "Romero", "Rosa", "Rosales", "Rosario", "Rose", "Ross", "Roth", "Rowe", "Rowland", "Roy", "Ruiz", "Rush", "Russell", "Russo", "Rutledge", "Ryan", "Salas", "Salazar", "Salinas", "Sampson", "Sanchez", "Sanders", "Sandoval", "Sanford", "Santana", "Santiago", "Santos", "Sargent", "Saunders", "Savage", "Sawyer", "Schmidt", "Schneider", "Schroeder", "Schultz", "Schwartz", "Scott", "Sears", "Sellers", "Serrano", "Sexton", "Shaffer", "Shannon", "Sharp", "Sharpe", "Shaw", "Shelton", "Shepard", "Shepherd", "Sheppard", "Sherman", "Shields", "Short", "Silva", "Simmons", "Simon", "Simpson", "Sims", "Singleton", "Skinner", "Slater", "Sloan", "Small", "Smith", "Snider", "Snow", "Snyder", "Solis", "Solomon", "Sosa", "Soto", "Sparks", "Spears", "Spence", "Spencer", "Stafford", "Stanley", "Stanton", "Stark", "Steele", "Stein", "Stephens", "Stephenson", "Stevens", "Stevenson", "Stewart", "Stokes", "Stone", "Stout", "Strickland", "Strong", "Stuart", "Suarez", "Sullivan", "Summers", "Sutton", "Swanson", "Sweeney", "Sweet", "Sykes", "Talley", "Tanner", "Tate", "Taylor", "Terrell", "Terry", "Thomas", "Thompson", "Thornton", "Tillman", "Todd", "Torres", "Townsend", "Tran", "Travis", "Trevino", "Trujillo", "Tucker", "Turner", "Tyler", "Tyson", "Underwood", "Valdez", "Valencia", "Valentine", "Valenzuela", "Vance", "Vang", "Vargas", "Vasquez", "Vaughan", "Vaughn", "Vazquez", "Vega", "Velasquez", "Velazquez", "Velez", "Villarreal", "Vincent", "Vinson", "Wade", "Wagner", "Walker", "Wall", "Wallace", "Waller", "Walls", "Walsh", "Walter", "Walters", "Walton", "Ward", "Ware", "Warner", "Warren", "Washington", "Waters", "Watkins", "Watson", "Watts", "Weaver", "Webb", "Weber", "Webster", "Weeks", "Weiss", "Welch", "Wells", "West", "Wheeler", "Whitaker", "White", "Whitehead", "Whitfield", "Whitley", "Whitney", "Wiggins", "Wilcox", "Wilder", "Wiley", "Wilkerson", "Wilkins", "Wilkinson", "William", "Williams", "Williamson", "Willis", "Wilson", "Winters", "Wise", "Witt", "Wolf", "Wolfe", "Wong", "Wood", "Woodard", "Woods", "Woodward", "Wooten", "Workman", "Wright", "Wyatt", "Wynn", "Yang", "Yates", "York", "Young", "Zamora", "Zimmerman"
	};
	
	/*
	 * generateNameFromArray function returns a new random name
	 * selected from an array of people's names
	 */
	private static String generateNameFromArray(String nameType){
		if(nameType == "firstName"){
			return firstNames[generateRandomInt(firstNames.length-1,0)];
		} else {
			return lastNames[generateRandomInt(lastNames.length-1,0)];
		}
	}
	
	/*
	 * generateRandomName function returns a new random String
	 * that is plausible as a person's name
	 * This method is never used but could be useful for generating random names
	 */
	private static String generateRandomName(){
		Random rand = new Random();
		String name = Long.toString(Math.abs(rand.nextLong() % 3656158440062976L), 36)
			    .replaceAll("[0-9]", "");
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
	}
	
	/*
	 * generateRandomInt function returns a new random Integer
	 * included in the range [2nd arg, 1st arg]
	 */
	private static Integer generateRandomInt(int max, int min){
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	/*
	 * generateRandomWeight function returns a new random String
	 * representing a new random weight
	 */
	private static String generateRandomWeight(){    
		return generateRandomInt(200,45).toString();
	}
	
	/*
	 * generateRandomWeight function returns a new random String
	 * representing a new random height
	 */
	private static String generateRandomHeight(){
		int heightCm = generateRandomInt(220,145);
		float heightM = (float) heightCm / 100;
		return ""+heightM;
	}
	
	/*
	 * calculateBmi function takes as input
	 * a String representing a weight
	 * and a String representing a height
	 * uses them to calculate the bmi and then
	 * returns a String representing it
	 */
	private static String calculateBmi(String weight, String height){
		float weightF = Float.parseFloat(weight);
		float heightF = Float.parseFloat(height);
		float bmiF = weightF/(heightF*heightF);
		return ""+bmiF;
	}
	
	/*
	 * generateDate function creates a new random date
	 * takes as input a String to choose between
	 * - birthdate: assumes only adults are allowed in the database
	 * - lastUpdate: assumes the database existed for 18 years
	 * and returns the new date of type XMLGregorianCalendar
	 */
	private static XMLGregorianCalendar generateDate(String fieldName) throws DatatypeConfigurationException{
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int nowYear = gregorianCalendar.get(Calendar.YEAR);
		int year;
		if(fieldName.equals("birthdate"))
			year = generateRandomInt(nowYear-18, nowYear-130);
		else
			year = generateRandomInt(nowYear-1, nowYear-18);
        gregorianCalendar.set(Calendar.YEAR, year);
        int dayOfYear = generateRandomInt(gregorianCalendar.getActualMaximum(Calendar.DAY_OF_YEAR),1);
        gregorianCalendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		return date;
	}
	
	/*
	 * createNewPerson function creates a new random People.Person and returns it
	 */
	public static People.Person createNewPerson() throws DatatypeConfigurationException {
		People.Person newRandomPerson = new People.Person();
		newRandomPerson.setFirstname(generateNameFromArray("firstName"));
		newRandomPerson.setLastname(generateNameFromArray("lastName"));
		gregorianCalendar.setTime(new Date());
		newRandomPerson.setBirthdate(generateDate("birthdate"));
		People.Person.Healthprofile hpNewRandomPerson = new People.Person.Healthprofile();
		hpNewRandomPerson.setHeight(generateRandomHeight());
		hpNewRandomPerson.setWeight(generateRandomWeight());
		hpNewRandomPerson.setBmi(calculateBmi(hpNewRandomPerson.getWeight(),hpNewRandomPerson.getHeight()));
		hpNewRandomPerson.setLastupdate(generateDate("lastUpdate"));
		newRandomPerson.setHealthprofile(hpNewRandomPerson);
		
		return newRandomPerson;
	}
}