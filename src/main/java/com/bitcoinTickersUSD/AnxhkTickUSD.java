package com.bitcoinTickersUSD;


import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AnxhkTickUSD {
/*	"result": "success",
	"data": {
		"high": {
			"currency": "USD",
					"display": "725.38123 USD",
					"display_short": "725.38 USD",
					"value": "725.38123",
					"value_int": "72538123"
		},
		"low": {
			"currency": "USD",
					"display": "380.00000 USD",
					"display_short": "380.00 USD",
					"value": "380.00000",
					"value_int": "38000000"
		},
		"avg": {
			"currency": "USD",
					"display": "429.34018 USD",
					"display_short": "429.34 USD",
					"value": "429.34018",
					"value_int": "42934018"
		},
		"vwap": {
			"currency": "USD",
					"display": "429.34018 USD",
					"display_short": "429.34 USD",
					"value": "429.34018",
					"value_int": "42934018"
		},
		"vol": {
			"currency": "BTC",
					"display": "7.00000000 BTC",
					"display_short": "7.00 BTC",
					"value": "7.00000000",
					"value_int": "700000000"
		},
		"last": {
			"currency": "USD",
					"display": "725.38123 USD",
					"display_short": "725.38 USD",
					"value": "725.38123",
					"value_int": "72538123"
		},
		"buy": {
			"currency": "USD",
					"display": "38.85148 USD",
					"display_short": "38.85 USD",
					"value": "38.85148",
					"value_int": "3885148"
		},
		"sell": {
			"currency": "USD",
					"display": "897.25596 USD",
					"display_short": "897.26 USD",
					"value": "897.25596",
					"value_int": "89725596"
		},
		"now": 1393388594814000,
				"dataUpdateTime": 1393388594247000
	}
}*/

	public static String anxhk(JSONObject json) throws JSONException {
		//Date timestamp = new Date();
		JSONObject data = json.getJSONObject("data");
		JSONObject buy_json = data.getJSONObject("buy");
		Map<String, String> out = new HashMap<String, String>();
		JsonItemIterator.parse(buy_json, out);
		String bid = out.get("value");

		JSONObject sell_json = data.getJSONObject("sell");
		out = new HashMap<String, String>();
		JsonItemIterator.parse(sell_json, out);
		String ask = out.get("value");

		JSONObject high_json = data.getJSONObject("high");
		out = new HashMap<String, String>();
		JsonItemIterator.parse(high_json, out);
		String high = out.get("value");

		JSONObject low_json = data.getJSONObject("low");
		out = new HashMap<String, String>();
		JsonItemIterator.parse(low_json, out);
		String low = out.get("value");

		JSONObject last_json = data.getJSONObject("last");
		out = new HashMap<String, String>();
		JsonItemIterator.parse(last_json, out);
		String last = out.get("value");

		JSONObject vol_json = data.getJSONObject("vol");
		out = new HashMap<String, String>();
		JsonItemIterator.parse(vol_json, out);
		String volume = out.get("value");

		JSONObject vwap_json = data.getJSONObject("vwap");
		out = new HashMap<String, String>();
		JsonItemIterator.parse(vwap_json, out);
		String vwap = out.get("value");

		JsonItemIterator.parse(data, out);
		String timestamp = out.get("dataUpdateTime");

		return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":" + low + ",\"last\":"
				+ last + ",\"volume\":" + volume + ",\"vwap\":" + vwap + ",\"timestamp\": " + timestamp + "}";
	}
}
/*
public static String Anxhk(String jsonText){
			String generatedJsonText;
			String temp1; // temp String to get keyword
			String temp2;

			//Bid
			
			temp1 = jsonText.substring(jsonText.indexOf("buy"),jsonText.lastIndexOf("sell"));
			temp2 = temp1.substring(temp1.lastIndexOf("\"value\"")+7);
			generatedJsonText ="{\"bid\":" + getKeyWord(temp2) +",";
			
			//Ask
			temp1 = jsonText.substring(jsonText.indexOf("sell"),jsonText.lastIndexOf("now"));
			temp2 = temp1.substring(temp1.lastIndexOf("\"value\"")+7);
			generatedJsonText = generatedJsonText +"\"ask\":" + getKeyWord(temp2) +",";
			//High
			temp1 = jsonText.substring(jsonText.indexOf("high"),jsonText.lastIndexOf("low"));
			temp2 = temp1.substring(temp1.lastIndexOf("\"value\"")+7);
			generatedJsonText = generatedJsonText +"\"high\":" + getKeyWord(temp2) +",";
		
			//Low
			temp1 = jsonText.substring(jsonText.indexOf("low"),jsonText.lastIndexOf("avg"));
			temp2 = temp1.substring(temp1.lastIndexOf("\"value\"")+7);
			generatedJsonText = generatedJsonText +"\"low\":" + getKeyWord(temp2) +",";
		
			//Last
			temp1 = jsonText.substring(jsonText.indexOf("last"),jsonText.lastIndexOf("buy"));
			temp2 = temp1.substring(temp1.lastIndexOf("\"value\"")+7);
			generatedJsonText = generatedJsonText +"\"last\":" + getKeyWord(temp2) +",";
		
			//Volume
			temp1 = jsonText.substring(jsonText.indexOf("vol"),jsonText.lastIndexOf("last"));
			temp2 = temp1.substring(temp1.lastIndexOf("\"value\"")+7);
			generatedJsonText = generatedJsonText +"\"volume\":" + getKeyWord(temp2) +",";
			//vwap
			temp1 = jsonText.substring(jsonText.indexOf("vwap"),jsonText.lastIndexOf("vol"));
			temp2 = temp1.substring(temp1.lastIndexOf("\"value\"")+7);
			generatedJsonText = generatedJsonText +"\"vwap\":" + getKeyWord(temp2) +",";
			
			//Timestamp
			temp1  = jsonText.substring(jsonText.lastIndexOf("dataUpdateTime")+15); // "timestamp" has 10 characters, I only need its value
			generatedJsonText = generatedJsonText +"\"timestamp\": " + getKeyWordNoQuote(temp1) +"}";
			return generatedJsonText;
		
	}
	private static String getKeyWord(String temp){
		if(temp.contains(","))
			return temp.substring(temp.indexOf("\"")+1, temp.indexOf(",")-1);
		else
			return temp.substring(temp.indexOf("\"")+1, temp.indexOf("}")-1); // minuses are used to remove quote
	}
	private static String getKeyWordNoQuote(String temp){ // thismethod is used if the number doesnt have any quote
		if(temp.contains(","))
			return temp.substring(temp.indexOf(":")+1, temp.indexOf(","));
		else
			return temp.substring(temp.indexOf(":")+1, temp.indexOf("}")); // minuses are used to remove quotes
	}
	
}
*/
