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

	public static final String bithumbKRW = "https://api.bithumb.com/public/ticker"; //Not sure // need to fix handshake error
	// still not implemented
	public static final String bitcurexUSD = "https://bitcurex.com/api/usd/ticker.json"; // 2 Seconds Not sure
	//still not implemented no timestamp
	public static final String bitkonanUSD = "https://bitkonan.com/api/ticker";
	// still not implemented no timestamp
	public static final String campbxUSD = "https://campbx.com/api/xticker.php";
	public static final String hitbtcUSD = "https://api.hitbtc.com/api/1/public/BTCUSD/ticker";
	public static final String ibwtUSD = "https://ibwt.co.uk/API/trades"; // accepts requests very rarely, but there is a call for all the trades made for that day
	public static final String itbitUSD = "https://api.itbit.com/v1/markets/XBTUSD/ticker";
	public static final String lakebtcUSD = "https://www.lakebtc.com/api_v1/ticker";
	public static final String krakenUSD = "https://api.kraken.com/0/public/Ticker";
	public static final String localbitcoinsUSD = "https://localbitcoins.com/bitcoinaverage/ticker-all-currencies/";
	public static final String okcoinUSD = "https://www.okcoin.com/api/v1/ticker.do?symbol=btc_usd"; //40 requests per second
	public static final String vircurexUSD = "https://api.vircurex.com/api/get_info_for_1_currency.json?base=BTC&alt=USD"; // every 5s
	public static final String therocktradingUSD = "https://api.therocktrading.com/v1/funds/BTCUSD/ticker";//slow

	//newly added on november
	public static final String btccCNY = "https://data.btcchina.com/data/ticker?market=btccny"; // not sure but I assume that is several request per second
	public static final String krakenEUR = "https://api.kraken.com/0/public/Ticker?pair=XBTEUR"; // USD
	public static final String itbitEUR = "https://api.itbit.com/v1/markets/XBTEUR/ticker"; //XBTUSD XBTSGD XBTEUR
	public static final String hitbtcEUR = "https://api.hitbtc.com/api/1/public/BTCEUR/ticker";
	public static final String bitIndonesiaIDR = "https://vip.bitcoin.co.id/api/btc_idr/ticker";
	public static final String okcoinCNY = "https://www.okcoin.cn/api/ticker.do"; //40 requests per second


	public final static int exchangeAmount = 16;
	public static final BitcoinExchange[] bitcoinExchangekList = new BitcoinExchange[exchangeAmount];

	public static void setUpExhanges(){

/*		bitcoinExchangekList[0] = new BitcoinExchange(bitcurexUSD);
		bitcoinExchangekList[0].setDelay(2000);*/
		bitcoinExchangekList[0] = new BitcoinExchange(btceUSD);
		bitcoinExchangekList[0].setDelay(2000);

		bitcoinExchangekList[1] = new BitcoinExchange(bitfinexUSD);
		bitcoinExchangekList[1].setDelay(1000);

		bitcoinExchangekList[2] = new BitcoinExchange(bitstampUSD);
		bitcoinExchangekList[2].setDelay(2000);

		bitcoinExchangekList[3] = new BitcoinExchange(korbitKRW);
		bitcoinExchangekList[3].setDelay(2000);

		bitcoinExchangekList[4] = new BitcoinExchange(bitbayUSD);
		bitcoinExchangekList[4].setDelay(2000);

		bitcoinExchangekList[5] = new BitcoinExchange(anxhkUSD);
		bitcoinExchangekList[5].setDelay(350);

		bitcoinExchangekList[6] = new BitcoinExchange(bitkonanUSD);
		bitcoinExchangekList[6].setDelay(2000);

		bitcoinExchangekList[7] = new BitcoinExchange(campbxUSD);
		bitcoinExchangekList[7].setDelay(2000);

		bitcoinExchangekList[8] = new BitcoinExchange(hitbtcUSD);
		bitcoinExchangekList[8].setDelay(2000);

/*		bitcoinExchangekList[9] = new BitcoinExchange(bitcurexUSD);
		bitcoinExchangekList[9].setDelay(3000);*/

		bitcoinExchangekList[9] = new BitcoinExchange(okcoinUSD);
		bitcoinExchangekList[9].setDelay(300);

		bitcoinExchangekList[10] = new BitcoinExchange(btccCNY);
		bitcoinExchangekList[10].setDelay(350);

		bitcoinExchangekList[11] = new BitcoinExchange(itbitEUR);
		bitcoinExchangekList[11].setDelay(1000);

		bitcoinExchangekList[12] = new BitcoinExchange(hitbtcEUR);
		bitcoinExchangekList[12].setDelay(2000);

		bitcoinExchangekList[13] = new BitcoinExchange(bitIndonesiaIDR);
		bitcoinExchangekList[13].setDelay(1000);

		bitcoinExchangekList[14] = new BitcoinExchange(krakenEUR);
		bitcoinExchangekList[14].setDelay(1000);

		bitcoinExchangekList[15] = new BitcoinExchange(okcoinCNY);
		bitcoinExchangekList[15].setDelay(300);

		for(int i = 0; i < exchangeAmount;i++){
			bitcoinExchangekList[i].setInprogress(false);
			bitcoinExchangekList[i].setPrevious("");
		}
	}
}
