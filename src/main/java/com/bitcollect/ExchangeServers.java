package com.bitcollect;

public class ExchangeServers {
	public static final String btceUSD = "https://btc-e.com/api/3/ticker/btc_usd"; // 2 Seconds
	public static final String bitfinexUSD = "https://api.bitfinex.com/v1/pubticker/btcusd"; // 1 Second
	public static final String bitstampUSD = "https://bitstamp.net/api/ticker/";// 2 Second
	public static final String korbitKRW = "https://api.korbit.co.kr/v1/ticker/detailed";// 2 Second
	//No timestamp bitbay
	public static final String bitbayUSD = "https://bitbay.net/API/Public/BTCUSD/ticker.json"; //2s not sure
	public static final String anxhkUSD = "https://anxpro.com/api/2/BTCUSD/money/ticker"; // 0.3s
/*Currently all users and IP addresses are throttled to 30 request of any type per second. You will get an error result if you are throttled.
	Additionally there is a max of 60 requests per ten seconds and 50,000 requests per hour.
	Information queries - such as get depth/results/ticker are throttled to 5 per second.
	Finally there is a maximum of 50 open orders at any one time, with a total of 50 adds per hour.*/

	//public static final String bithumbKRW = "https://api.bithumb.com/public/tickers";
	// still not implemented
	public static final String bitcurexUSD = "https://bitcurex.com/api/usd/ticker.json"; // 2 Seconds Not sure
	//still not implemented no timestamp
	public static final String bitkonanUSD = "https://bitkonan.com/api/ticker";
	// still not implemented no timestamp
	public static final String campbxUSD = "https://campbx.com/api/xticker.php";
	public static final String hitbtcUSD = "https://api.hitbtc.com/api/1/public/BTCUSD/ticker";
	public static final String ibwtUSD = "https://ibwt.co.uk/API/trades";
	public static final String itbitUSD = "https://api.itbit.com/v1/markets/XBTUSD/ticker";
	public static final String lakebtcUSD = "https://www.lakebtc.com/api_v1/ticker";
	public static final String krakenUSD = "https://api.kraken.com/0/public/Ticker";
	public static final String localbitcoinsUSD = "https://localbitcoins.com/bitcoinaverage/ticker-all-currencies/";
	public static final String okcoinUSD = "https://www.okcoin.com/api/v1/ticker.do?symbol=btc_usd";
	public static final String vircurexUSD = "https://api.vircurex.com/api/get_info_for_1_currency.json?base=BTC&alt=USD"; // every 5s
	public static final String therocktradingUSD = "https://api.therocktrading.com/v1/funds/BTCUSD/ticker";//slow

	public static String[] serverList =
			{
					btceUSD, bitfinexUSD,
					bitstampUSD, korbitKRW,
					bitbayUSD, anxhkUSD
			};
}
