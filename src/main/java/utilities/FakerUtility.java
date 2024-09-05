package utilities;

import com.github.javafaker.Faker;

public class FakerUtility { //Or Random Utility. Add Dependency to POM
	public static String getRandomName() 
 	{ 
 		Faker faker = new Faker(); 
 		return faker.name().name(); 
 	} 
 	public static String getRandomFullName() 
 	{ 
 		Faker faker = new Faker(); 
 		return faker.name().fullName(); 
 	} 
 	public static String getRandomUserName() 
 	{ 
 		Faker faker = new Faker(); 
 		return faker.name().username(); 
 	} 
 	public static String getRandomFirstName() 
 	{ 
 		Faker faker = new Faker(); 
 		return faker.name().firstName(); 
 	} 
 	public static String getRandomLastName() 
 	{ 
 		Faker faker = new Faker(); 
 		return faker.name().lastName(); 
 	} 
 	public static String getRandomNameWithMiddleName() 
 	{ 
 		Faker faker = new Faker(); 
 		return faker.name().nameWithMiddle(); 
 	} 
 	public static String getRandomFullAddress() 
 	{ 
 		Faker faker = new Faker(); 
 		return faker.address().fullAddress(); 
 	} 
 	public static String getRandomPhoneNumber() 
 	{ 
 		Faker faker = new Faker(); 
 		return faker.phoneNumber().cellPhone(); 
 	} 
 	/*public static String getRandomBloodGroup() 
 	{ 
 		Faker faker = new Faker(); 
 		return faker.name().bloodGroup(); */
 	}


