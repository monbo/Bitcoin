package com.bitcoinTickerEUR;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 8.
 */
public class hitbtcTickerEUR {

    public static String hitbtc(JSONObject json) throws JSONException {

/*        {"ask":"375.30","bid":"371.49","last":"371.48",
                "low":"365.79","high":"381.87","open":"371.59","volume":"331.64","volume_quote":"124680.01","timestamp":1446972559564}*/
            System.out.print(json);
        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);

        String bid = out.get("bid");System.out.print(bid);
        String ask = out.get("ask");
        String high = out.get("high");
        String low = out.get("low");
        String last = out.get("last");
        String volume = out.get("volume");
        String volume_quote = out.get("volume_quote");
        String open = out.get("open");
        String timestamp = out.get("timestamp");

        return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":"
                + low + ",\"last\":" + last + ",\"volume\":" + volume + ",\"open\":"+ open + ",\"volume_quote\":"+ volume_quote + ",\"timestamp\": " + timestamp + "}";
    }
}
