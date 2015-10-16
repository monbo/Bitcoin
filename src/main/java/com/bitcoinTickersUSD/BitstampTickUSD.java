package com.bitcoinTickersUSD;

public class BitstampTickUSD {
	public static String Bitstamp(String jsonText){
		String generatedJsonText;
		String temp; // temp String to get keyword

//	{"high": "246.43", "last": "244.75", "timestamp": "
//		1444489124", "bid": "244.11", "vwap": "244.77", "volume": "17853.80938745", "
//				+ ""low": "243.00", "ask": "244.75"}

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
		temp  = jsonText.substring(jsonText.lastIndexOf("last")+6);
		generatedJsonText = generatedJsonText +"\"last\":" + getKeyWord(temp) +",";
		
		//Volume
		temp  = jsonText.substring(jsonText.lastIndexOf("volume")+8); 
		generatedJsonText = generatedJsonText +"\"volume\":" + getKeyWord(temp) +",";
		
		//vwap Volume Weighted Average Price
		temp  = jsonText.substring(jsonText.lastIndexOf("vwap")+6); 
		generatedJsonText = generatedJsonText +"\"vwap\":" + getKeyWord(temp) +",";
		
		
		//Timestamp
		temp  = jsonText.substring(jsonText.lastIndexOf("timestamp")+11); // "timestamp" has 11 characters, I only need its value
		generatedJsonText = generatedJsonText + "\"timestamp\":" + getKeyWord(temp) +"}";
		
		return generatedJsonText;
		
	}
	private static String getKeyWord(String temp){
		if(temp.contains(","))
			return temp.substring(temp.indexOf("\"")+1, temp.indexOf(",")-1);
		else
			return temp.substring(temp.indexOf("\"")+1, temp.indexOf("}")-1); // minuses are used to remove quotes
		
	}
}
