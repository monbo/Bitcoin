package com.bitcollect;

import com.bitcoinTickersKRW.KorbitTickKRW;
import com.bitcoinTickersUSD.AnxhkTickUSD;
import com.bitcoinTickersUSD.BitbayTickUSD;
import com.bitcoinTickersUSD.BitfinexTickUSD;
import com.bitcoinTickersUSD.BitstampTickUSD;
import com.bitcoinTickersUSD.BtceTickUSD;

class GenerateTickJson {

	public static String GenerateJson(String url, String jsonText){
		switch(url) {
			case ExchangeServers.btceUSD:
				return BtceTickUSD.Btce(jsonText);
			case ExchangeServers.bitfinexUSD:
				return BitfinexTickUSD.Bitfinex(jsonText);
			case ExchangeServers.bitstampUSD:
				return BitstampTickUSD.Bitstamp(jsonText);
			case ExchangeServers.korbitKRW:
				return KorbitTickKRW.KorBit(jsonText);
			case ExchangeServers.bitbayUSD:
				return BitbayTickUSD.Bitbay(jsonText);

			case ExchangeServers.anxhkUSD:
				return AnxhkTickUSD.Anxhk(jsonText);

/*			case ExchangeServers.bithumbKRW:
				generatedJsonText = BithumbTickKRW.Bithumb(jsonText);
				break;*/
			default:
				return null;

		}
	}

}
