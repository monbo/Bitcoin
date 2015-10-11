package com.bitcollect;

public class BitStampTickUSD {
	public static String BitStamp(String jsonText){
		String generatedJsonText;
		String temp; // temp String to get keyword

//	{"high": "246.43", "last": "244.75", "timestamp": "
//		1444489124", "bid": "244.11", "vwap": "244.77", "volume": "17853.80938745", "
//				+ ""low": "243.00", "ask": "244.75"}
		//Timestamp
		temp  = jsonText.substring(jsonText.lastIndexOf("timestamp")+11); // "timestamp" has 11 characters, I only need its value
		generatedJsonText = "{\"timestamp\":" + getKeyWord(temp) +",";
		
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
}
