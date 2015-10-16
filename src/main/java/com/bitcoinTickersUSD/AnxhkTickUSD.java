package com.bitcoinTickersUSD;


public class AnxhkTickUSD {
/*"result":"success","data":{"high":{"currency":"USD",
"display":"261.16028 USD","display_short":"261.16 USD",
"value":"261.16028","value_int":"26116028"},
"low":{"currency":"USD","display":"241.42413 USD",
"display_short":"241.42 USD","value":"241.42413",
"value_int":"24142413"},"avg":{"currency":"USD",
"display":"246.11952 USD","display_short":
"246.12 USD","value":"246.11952","value_int":
"24611952"},"vwap":{"currency":"USD","display":
"0.04339 USD","display_short":"0.04 USD","value":
"0.04339","value_int":"4339"},"vol":{"currency":
"BTC","display":"1,347.60241921 BTC","display_short":
"1,347.60 BTC","value":"1347.60241921","value_int":"134760241921"},
"last":{"currency":"USD","display":"247.76795 USD","display_short":"247.77 USD",
"value":"247.76795","value_int":"24776795"},"buy":{"currency":"USD","display":
"247.53599 USD","display_short":"247.54 USD","value":"247.53599","value_int":
"24753599"},"sell":{"currency":"USD","display":"248.00000 USD","display_short":
	"248.00 USD","value":"248.00000","value_int":"24800000"},"now":1444735104710000,
"dataUpdateTime":1444735102666000}}*/
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
