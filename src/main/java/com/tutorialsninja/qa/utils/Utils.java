package com.tutorialsninja.qa.utils;

import java.util.Date;

public  class Utils {
	
	
public static String generateTimesstamp() {
		
		Date date = new Date();
		
		String timesstamp= date.toString().replace(" ", "_").replace(":", "_");
		
		return "nk"+timesstamp+"@gmail.com";
	} 

}
