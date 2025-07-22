package Utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	static Faker faker;

	public static String getTaskName() {

		faker = new Faker();
		return faker.company().profession();
	}

	public static String getEmployeeNamePrefix() {

		faker = new Faker();
		return faker.name().prefix();
	}

	public static String getEmailId() {

		faker = new Faker();
		String name = faker.name().firstName().toLowerCase();
		String number = faker.number().digits(2);
		String domain = faker.internet().domainName();
		return name + number + "@" + domain;
	}
	
	public static String getEmployeeAddress() {
		
		faker=new Faker();
		String buildNo=faker.address().buildingNumber();
		String street=faker.address().streetName();
		String city=faker.address().cityName();
		String state=faker.address().state();
		String pincode=faker.address().zipCode();
		String country=faker.address().country();
		return buildNo+","+street+","+city+","+state+":"+pincode+","+country;
	}
}
