package com.qa.unnamedcrud;

public class DBconfig {
	
	private static final String URL = "jdbc:mysql://localhost:3306/labs";
	private static final String USER = "root";
	private static final String PASS = "RootToot!";
	public static String getUrl() {
		return URL;
	}
	public static String getUser() {
		return USER;
	}
	public static String getPass() {
		return PASS;
	}
	
}
