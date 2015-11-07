package com.bitcollect;

import com.bitcoinTickersKRW.BithumbTickKRW;
import com.bitcoinTickersKRW.KorbitTickKRW;
import com.bitcoinTickersUSD.AnxhkTickUSD;
import com.bitcoinTickersUSD.BitbayTickUSD;
import com.bitcoinTickersUSD.BitcurexTickUSD;
import com.bitcoinTickersUSD.BitfinexTickUSD;
import com.bitcoinTickersUSD.BitkonanTickUSD;
import com.bitcoinTickersUSD.BitstampTickUSD;
import com.bitcoinTickersUSD.BtceTickUSD;
import com.bitcoinTickersUSD.CampbxTickUSD;
import com.bitcoinTickersUSD.HitbtcTickUSD;

import org.json.JSONException;
import org.json.JSONObject;

class GenerateTickJson {



	public static String GenerateJson(String url,JSONObject json) throws JSONException {
		switch(url) {
			case ExchangeServers.btceUSD:
				return BtceTickUSD.btce(json);
			case ExchangeServers.bitfinexUSD:
				return BitfinexTickUSD.bitfinex(json);
			case ExchangeServers.bitstampUSD:
				return BitstampTickUSD.bitstamp(json); // sends json to a class where it is going to be mapped and generated accordingly
			case ExchangeServers.korbitKRW:
				return KorbitTickKRW.korbit(json);
			case ExchangeServers.bitbayUSD:
				return BitbayTickUSD.bitbay(json);
			case ExchangeServers.anxhkUSD:
				return AnxhkTickUSD.anxhk(json);
			case ExchangeServers.bithumbKRW:
				return BithumbTickKRW.bithumb(json);
			case ExchangeServers.bitcurexUSD:
				return BitcurexTickUSD.bitcurex(json);
			case ExchangeServers.bitkonanUSD:
				return BitkonanTickUSD.bitkonan(json);
			case ExchangeServers.campbxUSD:
				return CampbxTickUSD.campbx(json);
			case ExchangeServers.hitbtcUSD:
				return HitbtcTickUSD.hitbtc(json);
			default:
				return null;

		}
	}

}
