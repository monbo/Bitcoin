package com.bitcoinTickerEUR;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 8.
 */
public class KrakenTickEUR {
    public static String kraken(JSONObject json) throws JSONException {

        Date timestamp = new Date();
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

        JSONObject result = json.getJSONObject("result");
        JSONObject XXBTZEUR = result.getJSONObject("XXBTZEUR");

        String bid = XXBTZEUR.getJSONArray("b").get(0).toString();
        String ask = XXBTZEUR.getJSONArray("a").get(0).toString();
        String high = XXBTZEUR.getJSONArray("h").get(0).toString();
        String low = XXBTZEUR.getJSONArray("l").get(0).toString();
        String last = XXBTZEUR.getJSONArray("l").get(0).toString();
        String volume = XXBTZEUR.getJSONArray("p").get(0).toString();
        Double open = XXBTZEUR.getDouble("o");
        String trades = XXBTZEUR.getJSONArray("t").get(0).toString();

   // System.out.print(bid);
        return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":" + low + ",\"last\":"
                + last + ",\"volume\":" + volume + ",\"open\":" + open + ",\"trades\":" + trades +",\"timestamp\": " + timestamp.getTime() + "}";
    }
}
