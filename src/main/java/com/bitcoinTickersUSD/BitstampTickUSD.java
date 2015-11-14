package com.bitcoinTickersUSD;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BitstampTickUSD {
	//	{"high": "246.43", "last": "244.75", "timestamp": "
	//		1444489124", "bid": "244.11", "vwap": "244.77", "volume": "17853.80938745", "
	//				+ ""low": "243.00", "ask": "244.75"}
	public static String bitstamp(JSONObject json) throws JSONException {
		//this exchange sites doesnt have timestamp
		//Date timestamp = new Date();


		Double bid = json.getDouble("bid");
		Double ask = json.getDouble("ask");
		Double high = json.getDouble("high");
		Double low = json.getDouble("low");
		Double last = json.getDouble("last");
		Double volume = json.getDouble("volume");
		//vwap Volume Weighted Average Price
		Double vwap = json.getDouble("vwap");
		Double timestamp = json.getDouble("timestamp");


		return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":"
				+ low + ",\"last\":" + last + ",\"volume\":" + volume + ",\"vwap\":" + vwap + ",\"timestamp\": " + timestamp + "}";
	}
}

