package com.bitcoinTickersUSD;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONException;


import com.bitcollect.JsonItemIterator;

/*{"lowest_tx_price_h": "0.0000", "last30d_max_h": "295.6399", "curr": "usd", "currency": "usd",
        "total_volume_h": "0.0000", "highest_tx_price":0,"average_price_h": "0.0000", "market":
        "btcusd", "total_spent_h": "0.0000", "best_bid": 2797002, "last24_volume_h": "0.0000",
        "last30d_volume": 38283827468100000000, "total_volume": 0, "total_spent": 0, "best_bid_h": "279.7002",
        "lowest_tx_price": 0, "highest_tx_price_h": "0.0000", "last_tx_price": 2823593, "last30d_min_h": "234.9000",
        "last24_volume": 0, "last30d_volume_h": "3828.3827", "price_change": 0.8426071428571325, "best_ask": 2869999,
        "lowest_tx_spread": 100, "last_tx_price_h": "282.3593", "highest_tx_spread": -100.0, "best_ask_h": "286.9999", "average_price": 0}*/
public class BitcurexTickUSD{
    public static String bitcurex(JSONObject json) throws JSONException {
        //this exchange sites doesnt have timestamp
        Date timestamp = new Date();

        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);

        String bid = out.get("best_bid_h");
        String ask = out.get("best_ask_h");
        String high = out.get("highest_tx_price_h");
        String low =  out.get("lowest_tx_price_h");
        String last = out.get("last_tx_price_h");
        String volume = out.get("last24_volume_h");

        //System.out.print(bid);
        return "{\"bid\":" + bid + ",\"ask\":" +ask + ",\"high\":" + high + ",\"low\":"+ low + ",\"last\":" + last +",\"volume\":" + volume +",\"timestamp\": "+timestamp.getTime() +"}";
    }
}
/*
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
        return generatedJsonText;*/
