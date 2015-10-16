package com.bitcoinTickersUSD;

public class BitFinexTickUSD {
	public static String BitFinex(String jsonText){
		String generatedJsonText;
		String temp; // temp String to get keyword

	/*{"mid":"234.225","bid":"234.22","ask":"234.23","last_price":"234.23","low":
		"227.68","high":"235.71",
		"volume":"10486.6563152","timestamp":"1442508084.584543815"}*/

	
		//Bid
		temp  = jsonText.substring(jsonText.lastIndexOf("bid")+5); // "bid has 5 characters, I only need its value
		generatedJsonText = "{\"bid\":" + getKeyWord(temp) +",";
		//Ask
		temp  = jsonText.substring(jsonText.lastIndexOf("ask")+5); // "ask has 5 characters, I only need its value
		generatedJsonText = generatedJsonText +"\"ask\":" + getKeyWord(temp) +",";
		//High
		temp  = jsonText.substring(jsonText.lastIndexOf("high")+6); 
		generatedJsonText = generatedJsonText +"\"high\":" + getKeyWord(temp) +",";
	
		//Low
		temp  = jsonText.substring(jsonText.lastIndexOf("low")+5);
		generatedJsonText = generatedJsonText +"\"low\":" + getKeyWord(temp) +",";
	
		//Last
		temp  = jsonText.substring(jsonText.lastIndexOf("last_price")+12);
		generatedJsonText = generatedJsonText +"\"last\":" + getKeyWord(temp) +",";
	
		//Volume 
		temp  = jsonText.substring(jsonText.lastIndexOf("volume")+8); 
		generatedJsonText = generatedJsonText +"\"volume\":" + getKeyWord(temp) +",";
		//Timestamp
		temp  = jsonText.substring(jsonText.lastIndexOf("timestamp")+10); // "timestamp" has 11 characters, I only need its value
		generatedJsonText = generatedJsonText +"\"timestamp\": " + getKeyWord(temp) +"}";
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
