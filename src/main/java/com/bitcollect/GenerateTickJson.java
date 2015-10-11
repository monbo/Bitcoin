package com.bitcollect;


public class GenerateTickJson {
	static final String btcUSD = "https://btc-e.com/api/3/ticker/btc_usd";
	static final String bitfinexUSD = "https://api.bitfinex.com//v1/pubticker/btcusd";
	static final String bitstampUSD = "https://bitstamp.net/api/ticker/";
	static final String korbitKRW = "https://api.korbit.co.kr/v1/ticker/detailed";
	static final String bitbayUSD = "https://bitbay.net/API/Public/BTCUSD/ticker.json";
	public static String GenerateJson(String url, String jsonText){
		String generatedJsonText = "";
		switch(url){
			case btcUSD:
				generatedJsonText = BtcTickUSD.BitStamp(jsonText);
				break;
			case bitfinexUSD:
				generatedJsonText = BitFinexTickUSD.BitFinex(jsonText);
				break;
			case bitstampUSD:
				generatedJsonText = BitStampTickUSD.BitStamp(jsonText);
				break;
			case korbitKRW:
				generatedJsonText = KorBitTickKRW.KorBit(jsonText);
				break;
			case bitbayUSD:
				generatedJsonText = BitBayTickUSD.BitBay(jsonText);
				break;
			default:
				generatedJsonText = "";
				break;
					
		}
		
		return generatedJsonText;
	}

}
