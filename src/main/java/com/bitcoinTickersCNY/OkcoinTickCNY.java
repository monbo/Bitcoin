package com.bitcoinTickersCNY;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 8.
 */
public class OkcoinTickCNY {
    /*
    {"date":"1446977151","ticker":{"buy":"2558.23","high":"2621.99","last":"2558.07","low":"2518.0","sell":"2558.28","vol":"486429.1206"}}
*/

    public static String okcoin(JSONObject json) throws JSONException {
        // Date timestamp = new Date();

        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);

        String bid = out.get("buy");
        String ask = out.get("sell");
        String high = out.get("high");
        String low = out.get("low");
        String last = out.get("last");
        String volume = out.get("vol");
        String timestamp = out.get("date");

        return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":" + low + ",\"last\":"
                + last + ",\"volume\":" + volume + ",\"timestamp\": " + timestamp + "}";
    }
}
