package com.bitcollect;

public class KorBitTickKRW {
	public static String KorBit(String jsonText){
	String generatedJsonText;
	String temp; // temp String to get keyword
	//System.out.println(jsonText);
	/*{"timestamp":1442507889000,"last":"277800",
	 * "bid":"277800","ask":"277900","low":"272500","high":"277900","volume":"393.72877601"}*/
		//Timestamp
		temp  = jsonText.substring(jsonText.lastIndexOf("timestamp")+10); // "timestamp" has 11 characters, I only need its value
		generatedJsonText = "{\"timestamp\":" + getKeyWordNoQuote(temp) + ",";
	// Because timestamp is the first word in this thick
		//Bid
		temp  = jsonText.substring(jsonText.lastIndexOf("bid")+5); // "bid has 5 characters, I only need its value
		generatedJsonText = generatedJsonText +" \"bid\":" + getKeyWord(temp) +",";
		//Ask
		temp  = jsonText.substring(jsonText.lastIndexOf("ask")+5); // "ask has 5 characters, I only need its value
		generatedJsonText = generatedJsonText +" \"ask\":" + getKeyWord(temp) +",";
		//High
		temp  = jsonText.substring(jsonText.lastIndexOf("high")+6); 
		generatedJsonText = generatedJsonText +" \"high\":" + getKeyWord(temp) +",";
	
		//Low
		temp  = jsonText.substring(jsonText.lastIndexOf("low")+5);
		generatedJsonText = generatedJsonText +" \"low\":" + getKeyWord(temp) +",";
	
		//Last
		temp  = jsonText.substring(jsonText.lastIndexOf("last")+6);
		generatedJsonText = generatedJsonText +" \"last\":" + getKeyWord(temp) +",";
	
		//Volume
		temp  = jsonText.substring(jsonText.lastIndexOf("volume")+8); 
		generatedJsonText = generatedJsonText +" \"volume\":" + getKeyWord(temp) +"}";
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
public static String getKeyWordNoQuote(String temp){ // thismethod is used if the number doesnt have any quote
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
