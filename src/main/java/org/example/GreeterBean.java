package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.camel.Exchange;

public class GreeterBean {
	
	private Random random = new Random();
	private List<String> names = new ArrayList<String>();
	
	public GreeterBean() {
		names.add("Keith");
		names.add("rettori");
		names.add("Bill");
		names.add("Steve");
		names.add("George");
		names.add("Fabio");
	}
	
	public String postProcess(String msg) {
		msg = msg.replaceAll("&lt;", "<");
		msg = msg.replaceAll("&gt;", ">");
		msg = msg.replaceAll("&quot;", "\"");
		return msg;
	}
	
	public String generateName() {
		String name = names.get(random.nextInt(5));
		System.out.println("Using name: " + name);
		return REQUEST.replaceAll("\\$NAME", name);
	}
	
	private static final String REQUEST = 
			"<batch-execution lookup=\"HelloRulesSession\">"
			+ "<insert>"
			+   "<org.openshift.quickstarts.decisionserver.hellorules.Person>"
			+   "<name>$NAME</name>"
			+   "</org.openshift.quickstarts.decisionserver.hellorules.Person>"
			+ "</insert>"
			+ "<fire-all-rules/>"
			+ "<query out-identifier=\"greetings\" name=\"get greeting\"/>"
			+ "</batch-execution>";
}
