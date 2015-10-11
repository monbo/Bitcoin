package com.bitcollect;

import java.sql.Timestamp;
import java.util.Calendar;

public class BitBayTickUSD {
	public static String BitBay(String jsonText){
		String generatedJsonText;
		String temp; // temp String to get keyword

		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		/*{"max":0,"min":0,"last":224,"bid":222,"ask":287.39,"vwap":223.93,"average":224,"volume":0}*/
			//temp  = jsonText.substring(jsonText.lastIndexOf("updated")+6); // "timestamp" has 11 characters, I only need its value
			generatedJsonText = "{\"timestamp\":"  +",";
		
/*			//Bid
			temp  = jsonText.substring(jsonText.lastIndexOf("bid")+5); // "bid has 5 characters, I only need its value
			generatedJsonText = generatedJsonText +" \"bid\":" + getKeyWord(temp) +",";
			//Ask
			temp  = jsonText.substring(jsonText.lastIndexOf("ask")+5); // "ask has 5 characters, I only need its value
			generatedJsonText = generatedJsonText +" \"ask\":" + getKeyWord(temp) +",";
			//High
			temp  = jsonText.substring(jsonText.lastIndexOf("max")+3); 
			generatedJsonText = generatedJsonText +" \"high\":" + getKeyWord(temp) +",";
		
			//Low
			temp  = jsonText.substring(jsonText.lastIndexOf("min")+5);
			generatedJsonText = generatedJsonText +" \"low\":" + getKeyWord(temp) +",";
		
			//Last
			temp  = jsonText.substring(jsonText.lastIndexOf("last")+6);
			generatedJsonText = generatedJsonText +" \"last\":" + getKeyWord(temp) +",";
		
			//Volume
			temp  = jsonText.substring(jsonText.lastIndexOf("volume")+7); 
			generatedJsonText = generatedJsonText +" \"volume\":" + getKeyWord(temp) +"}";*/
			//System.out.println("Bitbay" + generatedJsonText);
			return generatedJsonText;
		
	}
	public static String getKeyWord(String temp){
		int firstQuote = 0;
		int secondQuote = 0;
		firstQuote = temp.indexOf("\""); // finds index that begins with "
		if(temp.contains(","))
			secondQuote = temp.indexOf(","); // finds index that begins with ,
		else
			secondQuote = temp.indexOf("}");
		return temp.substring(firstQuote+1, secondQuote-1); // minuses are used to remove quotes
		
	}
}
