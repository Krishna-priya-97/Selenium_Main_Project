package Utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	static Faker faker;
	
	public static String getTaskName() {
		
		faker=new Faker();
		return faker.company().profession();
	}

}
