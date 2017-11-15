package com.training.hello;

import java.util.HashMap;
import java.util.Map;

public class HelloManager {
	private Map<String, Hello> map = new HashMap<>();

	public HelloManager() {
		this.map.put("tr",
		             new Hello("Merhaba"));
		this.map.put("en",
		             new Hello("Hello"));
		this.map.put("es",
		             new Hello("Ola"));

	}

	public Hello getHelloByLanguage(final String language) {
		String shortVersion = StaticUtility.shortVersion(this.changeString(language));
		return this.map.get(shortVersion);
	}

	private String changeString(final String input) {
		return input.toLowerCase();
	}

}
