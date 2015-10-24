package com.bitcollect;

/**
 * Created by simonas on 15. 10. 25.
 */
public class BitcoinExchange {


        private String serverURL;
        private boolean inprogress;
        private int delay;
        private String previous;

        public BitcoinExchange() {

        }
        public BitcoinExchange(String serverURL) {

            this.serverURL = serverURL;

        }
        public String getPrevious() {
            return previous;
        }

        public void setPrevious(String previous) {
            this.previous = previous;
        }
        public int getDelay(){
            return delay;
        }

        public void setDelay(int delay){
            this.delay = delay;
        }

        public String getServeURL() {

            return serverURL;

        }
        public void setServerURL(String serverName) {

            this.serverURL = serverName;

        }
        public boolean isInprogress() {

            return inprogress;

        }
        public void setInprogress(boolean inprogress) {

            this.inprogress = inprogress;

        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)

                return true;

            if (obj == null)

                return false;

            if (getClass() != obj.getClass())

                return false;

            BitcoinExchange other = (BitcoinExchange) obj;

            if (serverURL != other.serverURL)

                return false;

            if (inprogress != other.inprogress)

                return false;

            return true;

        }


        @Override

        public String toString() {

            return serverURL;

        }

}
