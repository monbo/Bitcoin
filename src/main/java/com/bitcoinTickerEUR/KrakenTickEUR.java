package com.bitcoinTickerEUR;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 8.
 */
public class KrakenTickEUR {
    public static String kraken(JSONObject json) throws JSONException {
    /*    {"error":[],"result":{"XXBTZEUR":{"a":["352.89898","1","1.000"],
            "b":["351.82926","8","8.000"],"c":["352.71730","0.08221000"],"v":["876.63023582","5249.78437566"],
            "p":["353.28736","356.01438"],"t":[834,4643],"l":["347.00000","347.00000"],"h":["359.99990","361.87724"],"o":"355.89964"}}}*/
 /*       <pair_name> = pair name
                a = ask array(<price>, <whole lot volume>, <lot volume>),
        b = bid array(<price>, <whole lot volume>, <lot volume>),
        c = last trade closed array(<price>, <lot volume>),
        v = volume array(<today>, <last 24 hours>),
        p = volume weighted average price array(<today>, <last 24 hours>),
        t = number of trades array(<today>, <last 24 hours>),
        l = low array(<today>, <last 24 hours>),
        h = high array(<today>, <last 24 hours>),
        o = today's opening price*/
        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);

        String bid = out.get("b");
        String ask = out.get("a");
        String high = out.get("h");
        String low = out.get("l");
        String last = out.get("c");
        String volume = out.get("p");
        String open = out.get("o");
        String trades = out.get("t");
        String timestamp = out.get("updated");

   // System.out.print(bid);
        return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":" + low + ",\"last\":"
                + last + ",\"volume\":" + volume + ",\"open\":" + open + ",\"trades\":" + trades +",\"timestamp\": " + timestamp + "}";
    }
}
