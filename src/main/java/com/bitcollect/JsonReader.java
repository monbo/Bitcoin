package com.bitcollect;

import org.bson.Document;
import org.json.JSONObject;
import org.json.JSONException;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import com.ning.http.client.*;
import com.ning.http.util.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class JsonReader {

	private static String readAll(Reader rd) throws IOException{
		StringBuilder sb = new StringBuilder();
		int cp;
		while((cp = rd.read()) !=-1){
			sb.append((char)cp);
		}
		return sb.toString();
	}

	public static Document readJsonFromUrl(String url) throws IOException, ExecutionException, JSONException {
		HttpURLConnection openConnection = null;
		InputStream inputStream = null;
		JSONObject json = null;
		try {
			URL address = new URL(url);
			openConnection = (HttpURLConnection) address.openConnection();
			HttpURLConnection.setFollowRedirects(false);
			openConnection.setConnectTimeout(3 * 1000);
			openConnection.setRequestMethod("GET");
			openConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
			openConnection.connect();

			inputStream = openConnection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String jsonText = readAll(reader);
			json = new JSONObject(jsonText);
			return Document.parse(GenerateTickJson.GenerateJson(url, json));

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
			if (openConnection != null) {
				openConnection.disconnect();

			}
		}
		return null;
	}
}