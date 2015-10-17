package com.BooleanOperations;

import static com.bitcollect.ExchangeServers.*;

/**
 * Created by simonas on 15. 10. 17.
 */
public class ServerAccesabilityTimeCheck {
    void ServerTimerList()
    {
        /*for (String server:serverList) {
            switch(){
                case btceUSD:
                    this.collection = database.getCollection("btceUSD");	// get database collection
                    break;
                case bitbayUSD:
                    this.collection = database.getCollection("bitbayUSD");	// get database collection
                    break;
                case bitstampUSD:
                    this.collection = database.getCollection("bitstampUSD");	// get database collection
                    break;
                case korbitKRW:
                    this.collection = database.getCollection("korbitKRW");	// get database collection
                    break;
                case bitfinexUSD:
                    this.collection = database.getCollection("bitfinexUSD");	// get database collection
                    break;
                case anxhkUSD:
                    this.collection = database.getCollection("anxhkUSD");	// get database collection
                    break;
*//*					case ExchangeServers.bithumbKRW:
						this.collection = database.getCollection("bithumbKRW");	// get database collection
						break;*//* // Kolkas neveikia del http request kaltes
                default:
                    break;
            }
        }*/
    }

     public boolean ServerTimerCheck(String server)
    {

        switch(server){
            case btceUSD:
                //if(ExchangeServersTimer.bitstampUSDTimerThread() == Thread.State.TIMED_WAITING))

                break;
            case bitbayUSD:

                break;
            case bitstampUSD:

                break;
            case korbitKRW:

                break;
            case bitfinexUSD:

                break;
            case anxhkUSD:

                break;
/*					case ExchangeServers.bithumbKRW:
						this.collection = database.getCollection("bithumbKRW");	// get database collection
						break;*/ // Kolkas neveikia del http request kaltes
            default:
                break;
    }
        new java.util.Timer().schedule(

             new java.util.TimerTask() {
                 @Override
                 public void run() {

                 }
             },
             5000
        );

       /* switch(){
            case btceUSD:
                this.collection = database.getCollection("btceUSD");	// get database collection
                break;
            case bitbayUSD:
                this.collection = database.getCollection("bitbayUSD");	// get database collection
                break;
            case bitstampUSD:
                this.collection = database.getCollection("bitstampUSD");	// get database collection
                break;
            case korbitKRW:
                this.collection = database.getCollection("korbitKRW");	// get database collection
                break;
            case bitfinexUSD:
                this.collection = database.getCollection("bitfinexUSD");	// get database collection
                break;
            case anxhkUSD:
                this.collection = database.getCollection("anxhkUSD");	// get database collection
                break;*/
/*					case ExchangeServers.bithumbKRW:
						this.collection = database.getCollection("bithumbKRW");	// get database collection
						break;*/ // Kolkas neveikia del http request kaltes
         /*   default:
                break;*/
        return true;
    }
}
