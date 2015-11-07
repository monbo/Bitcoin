package com.bitcoinTickersUSD;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BitfinexTickUSD {

/*{"mid":"234.225","bid":"234.22","ask":"234.23","last_price":"234.23","low":
		"227.68","high":"235.71",
		"volume":"10486.6563152","timestamp":"1442508084.584543815"}*//*

*/

	public static String bitfinex(JSONObject json) throws JSONException {
		//this exchange sites doesnt have timestamp
		//Date timestamp = new Date();

		Map<String, String> out = new HashMap<String, String>();
		JsonItemIterator.parse(json, out);

		String bid = out.get("bid");
		String ask = out.get("ask");
		String high = out.get("high");
		String low = out.get("low");
		String last = out.get("last_price");
		String volume = out.get("volume");
		String timestamp = out.get("timestamp");

		return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":" + low + ",\"last\":"
				+ last + ",\"volume\":" + volume + ",\"timestamp\": " + timestamp + "}";
	}
}

/*
	public static String Bitfinex(String jsonText){
		String generatedJsonText;
		String temp; // temp String to get keyword

	*/
/*{"mid":"234.225","bid":"234.22","ask":"234.23","last_price":"234.23","low":
		"227.68","high":"235.71",
		"volume":"10486.6563152","timestamp":"1442508084.584543815"}*//*


	
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
private static String getKeyWord(String temp){
	if(temp.contains(","))
		return temp.substring(temp.indexOf("\"")+1, temp.indexOf(",")-1);
	else
		return temp.substring(temp.indexOf("\"")+1, temp.indexOf("}")-1); // minuses are used to remove quotes
	
}
}
*/
