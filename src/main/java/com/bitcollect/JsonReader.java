package com.bitcollect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.bson.Document;
import org.json.JSONException;



public class JsonReader {
	
	private static String readAll(Reader rd) throws IOException{
		StringBuilder sb = new StringBuilder();
		int cp;
		while((cp = rd.read()) !=-1){
			sb.append((char)cp);
		}
		return sb.toString();
	}
	
	public static Document readJsonFromUrl(String url) throws IOException, JSONException{
		//InputStream is = new URL(url).openStream();
		URLConnection openConnection = new URL(url).openConnection();
		openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0"); // reikia pakeisti url
		InputStream is = openConnection.getInputStream();
		
		try{
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			//System.out.println(url);
			//System.out.println(jsonText);
			//System.out.println();
			Document json = Document.parse(GenerateTickJson.GenerateJson(url, jsonText));
			return json;
		} finally {
			is.close();
		}
	}
}