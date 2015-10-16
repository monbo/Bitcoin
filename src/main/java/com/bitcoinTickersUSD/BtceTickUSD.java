package com.bitcoinTickersUSD;

public class BtceTickUSD {
	public static String Btce(String jsonText){
	String generatedJsonText;
	String temp; // temp String to get keyword

	/*{"btc_usd":{"high":232.96899,"low":225.98199,"avg":229.47549,"vol":1624949.95349,
	"vol_cur":7121.07947,"last":232.11,"buy":232.683,"sell":232.396,"updated":1442508133}}*/

		//Bid
		temp  = jsonText.substring(jsonText.lastIndexOf("buy")+4); // "bid has 5 characters, I only need its value
		generatedJsonText = "{\"bid\":" + getKeyWordNoQuote(temp) +",";
		//Ask
		temp  = jsonText.substring(jsonText.lastIndexOf("sell")+5); // "ask has 5 characters, I only need its value
		generatedJsonText = generatedJsonText +"\"ask\":" + getKeyWordNoQuote(temp) +",";
		//High
		temp  = jsonText.substring(jsonText.lastIndexOf("high")+5); 
		generatedJsonText = generatedJsonText +"\"high\":" + getKeyWordNoQuote(temp) +",";
	
		//Low
		temp  = jsonText.substring(jsonText.lastIndexOf("low")+4);
		generatedJsonText = generatedJsonText +"\"low\":" + getKeyWordNoQuote(temp) +",";
	
		//Last
		temp  = jsonText.substring(jsonText.lastIndexOf("last")+5);
		generatedJsonText = generatedJsonText +"\"last\":" + getKeyWordNoQuote(temp) +",";
	
		//Volume
		temp  = jsonText.substring(jsonText.lastIndexOf("vol")+4); 
		generatedJsonText = generatedJsonText +"\"volume\":" + getKeyWordNoQuote(temp) +",";
		//Timestamp
		temp  = jsonText.substring(jsonText.lastIndexOf("updated")+8); // "timestamp" has 11 characters, I only need its value
		generatedJsonText = generatedJsonText + "\"timestamp\": " + getKeyWordNoQuote(temp) +"}";
		return generatedJsonText;
	
}
private static String getKeyWordNoQuote(String temp)
{ // thismethod is used if the number doesnt have any quote
	if(temp.contains(","))
		return temp.substring(temp.indexOf(":")+1, temp.indexOf(","));
	else
		return temp.substring(temp.indexOf(":")+1, temp.indexOf("}")); // minuses are used to remove quotes
}
}
