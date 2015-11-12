package com.bitcoinTickersUSD;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 8.
 */
public class OkcoinTickUSD {
/*
    {"date":"1446964932","ticker":{"buy":"388.99","high":"394.9","last":"388.99","low":"378.79","sell":"389.0","vol":"9617.364"}}
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

