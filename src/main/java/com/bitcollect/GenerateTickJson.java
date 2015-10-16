package com.bitcollect;
import com.bitcoinTickersKRW.BithumbTickKRW;
import com.bitcoinTickersKRW.KorbitTickKRW;
import com.bitcoinTickersUSD.AnxhkTickUSD;
import com.bitcoinTickersUSD.BitBayTickUSD;
import com.bitcoinTickersUSD.BitFinexTickUSD;
import com.bitcoinTickersUSD.BitStampTickUSD;
import com.bitcoinTickersUSD.BtceTickUSD;

public class GenerateTickJson {

	public static String GenerateJson(String url, String jsonText){
		String generatedJsonText = "";
		switch(url){
			case ExchangeServers.btceUSD:
				generatedJsonText = BtceTickUSD.BitStamp(jsonText);
				break;
			case ExchangeServers.bitfinexUSD:
				generatedJsonText = BitFinexTickUSD.BitFinex(jsonText);
				break;
			case ExchangeServers.bitstampUSD:
				generatedJsonText = BitStampTickUSD.BitStamp(jsonText);
				break;
			case ExchangeServers.korbitKRW:
				generatedJsonText = KorbitTickKRW.KorBit(jsonText);
				break;
			case ExchangeServers.bitbayUSD:
				generatedJsonText = BitBayTickUSD.BitBay(jsonText);
				break;
			case ExchangeServers.anxhkUSD:
				generatedJsonText = AnxhkTickUSD.Anxhk(jsonText);
				break;
/*			case ExchangeServers.bithumbKRW:
				generatedJsonText = BithumbTickKRW.Bithumb(jsonText);
				break;*/
			default:
				generatedJsonText = "";
				break;
					
		}
		
		return generatedJsonText;
	}

}
