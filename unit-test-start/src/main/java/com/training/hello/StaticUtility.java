package com.training.hello;

public class StaticUtility {
	public static String shortVersion(final String language) {
		switch (language.toLowerCase()) {
		case "turkish":
			return "tr";
		case "english":
			return "en";
		case "spanish":
			return "es";
		default:
			return "tr";
		}
	}
}
