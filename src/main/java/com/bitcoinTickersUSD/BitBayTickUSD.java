package com.bitcoinTickersUSD;

import java.sql.Timestamp;
import java.util.Date;
public class BitBayTickUSD {
	public static String BitBay(String jsonText){
		String generatedJsonText;
		String temp; // temp String to get keyword

		Date timestamp = new Date();
		/*{"max":0,"min":0,"last":224,"bid":222,"ask":287.39,"vwap":223.93,"average":224,"volume":0}*/
			//temp  = jsonText.substring(jsonText.lastIndexOf("updated")+6); // "timestamp" has 11 characters, I only need its value
			
		
			//Bid
			temp  = jsonText.substring(jsonText.lastIndexOf("bid")+4); // "bid has 5 characters, I only need its value
			generatedJsonText = "{\"bid\":" + getKeyWordNoQuote(temp) +",";
		
			//Ask
			temp  = jsonText.substring(jsonText.lastIndexOf("ask")+4); // "ask has 5 characters, I only need its value
			generatedJsonText = generatedJsonText +"\"ask\":" + getKeyWordNoQuote(temp) +",";
	
			//High
			temp  = jsonText.substring(jsonText.lastIndexOf("max")+4); 
			generatedJsonText = generatedJsonText +"\"high\":" + getKeyWordNoQuote(temp) +",";
			//Low
			temp  = jsonText.substring(jsonText.lastIndexOf("min")+4);
			generatedJsonText = generatedJsonText +"\"low\":" + getKeyWordNoQuote(temp) +",";
			
			//Last
			temp  = jsonText.substring(jsonText.lastIndexOf("last")+5);
			generatedJsonText = generatedJsonText +"\"last\":" + getKeyWordNoQuote(temp) +",";
		
			//Volume
			temp  = jsonText.substring(jsonText.lastIndexOf("volume")+7); 
			generatedJsonText = generatedJsonText +"\"volume\":" + getKeyWordNoQuote(temp) +",";
			
			//Last
			temp  = jsonText.substring(jsonText.lastIndexOf("vwap")+5);
			generatedJsonText = generatedJsonText +"\"vwap\":" + getKeyWordNoQuote(temp) +",";
			//Timestamp
			generatedJsonText = generatedJsonText + "\"timestamp\":"  + timestamp.getTime() + "}";
			return generatedJsonText;
		
	}
	static String getKeyWord(String temp){
		int firstQuote = 0;
		int secondQuote = 0;
		firstQuote = temp.indexOf("\""); // finds index that begins with "
		if(temp.contains(","))
			secondQuote = temp.indexOf(","); // finds index that begins with ,
		else
			secondQuote = temp.indexOf("}");
		return temp.substring(firstQuote+1, secondQuote-1); // minuses are used to remove quotes
		
	}
	 static String getKeyWordNoQuote(String temp){ // thismethod is used if the number doesnt have any quote
			int firstQuote = 0;
			int secondQuote = 0;
			firstQuote = temp.indexOf(":"); // finds index that begins with "
			if(temp.contains(","))
				secondQuote = temp.indexOf(","); // finds index that begins with ,
			else
				secondQuote = temp.indexOf("}");
			return temp.substring(firstQuote+1, secondQuote); // minuses are used to remove quotes
			
		}
}
