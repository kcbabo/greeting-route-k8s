package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GreeterBean {
	
	private Random random = new Random();
	private List<String> names = new ArrayList<String>();
	
	public GreeterBean() {
		names.add("Keith");
		names.add("Diogenes");
		names.add("Bill");
		names.add("Steve");
		names.add("George");
		names.add("Fabio");
	}

	public String greet(String name) {
		return "Howdy, " + name + "! Howya doin', buddy?";
	}
	
	public String generateName() {
		return names.get(random.nextInt(5));
	}
}
