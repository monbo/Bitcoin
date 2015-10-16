package com.bitcoinTickersKRW;

public class BithumbTickKRW {
	public static String Bithumb(String jsonText){
		String generatedJsonText;
		String temp; // temp String to get keyword

/*		{
		    "status": "0000",
		    "data": {
		        "opening_price": "504000",
		        "closing_price": "505000",
		        "min_price": "504000",
		        "max_price": "516000",
		        "average_price": "509533.3333",
		        "units_traded": "14.71960286",
		        "volume_1day": "14.71960286",
		        "volume_7day": "15.81960286",
		        "date": 1417141032622
		    }
		}*/
		//Bid
		temp  = jsonText.substring(jsonText.lastIndexOf("opening_price")+15); // I assume opening price is a bid price
		generatedJsonText = "{\"bid\":" + getKeyWord(temp) +",";
		//Ask
		temp  = jsonText.substring(jsonText.lastIndexOf("closing_price")+15); //I assume closing price is sell price
		generatedJsonText = generatedJsonText +"\"ask\":" + getKeyWord(temp) +",";
		//High
		temp  = jsonText.substring(jsonText.lastIndexOf("max_price")+10); 
		generatedJsonText = generatedJsonText +"\"high\":" + getKeyWord(temp) +",";
	
		//Low
		temp  = jsonText.substring(jsonText.lastIndexOf("min_price")+10);
		generatedJsonText = generatedJsonText +"\"low\":" + getKeyWord(temp) +",";
	
		//Last
		temp  = jsonText.substring(jsonText.lastIndexOf("last_price")+12);
		generatedJsonText = generatedJsonText +"\"last\":" + getKeyWord(temp) +",";
	
		//Volume general 24h
		temp  = jsonText.substring(jsonText.lastIndexOf("volume_1day")+11); 
		generatedJsonText = generatedJsonText +"\"volume\":" + getKeyWord(temp) +",";
		//Volume 7days
		temp  = jsonText.substring(jsonText.lastIndexOf("volume_7day")+11); 
		generatedJsonText = generatedJsonText +"\"volume\":" + getKeyWord(temp) +",";
		//Timestamp
		temp  = jsonText.substring(jsonText.lastIndexOf("date")+5); // "timestamp" has 11 characters, I only need its value
		generatedJsonText = generatedJsonText +"\"timestamp\": " + getKeyWordNoQuote(temp) +"}";
		return generatedJsonText;
	
}
private static String getKeyWord(String temp){
	if(temp.contains(","))
		return temp.substring(temp.indexOf("\"")+1, temp.indexOf(",")-1);
	else
		return temp.substring(temp.indexOf("\"")+1, temp.indexOf("}")-1); // minuses are used to remove quotes
	
}
private static String getKeyWordNoQuote(String temp)
{ // thismethod is used if the number doesnt have any quote
	if(temp.contains(","))
		return temp.substring(temp.indexOf(":")+1, temp.indexOf(","));
	else
		return temp.substring(temp.indexOf(":")+1, temp.indexOf("}")); // minuses are used to remove quotes
}
}
