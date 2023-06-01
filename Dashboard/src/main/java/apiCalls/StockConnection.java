/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiCalls;

import DatabaseRetrieve.StockInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jodic
 */
public class StockConnection implements ApiConnection{
   private transient String url;
   private transient boolean isLegit;
   private transient int high;
   private transient int low;
   private String name;
   private String symb;
   private transient int close;
   private transient int open;
   private transient String updatedlast;
   private transient String splitfact; 
   private transient String key ="bbe21b9a39c90a3543d03a6d05efcc3e";
   private transient String baseLink = "http://api.marketstack.com/v1/";
   private transient String baseLinkAll = "http://api.marketstack.com/v1/tickers/";
   private transient String priceInfo = "/eod?access_key=";
   private transient String stockName = "/tickers?access_key=";
   public StockInfo nameinfo;
 
    //http://api.marketstack.com/v1/
    public StockConnection(String symb){
        url=this.setConnection(this.key,symb);
         System.out.println(url);
        try{
            this.symb = symb;
           // this.name= stock;
            URL apiUrl = new URL(this.url);
            JsonElement root = this.apiConnect(apiUrl);
            JsonObject objRoot = root.getAsJsonObject();
            JsonArray valueElem = objRoot.getAsJsonArray("data");
            JsonObject data = valueElem.get(0).getAsJsonObject();
            this.name = data.get("name").getAsString();
            this.open = data.get("open").getAsInt();
            this.close = data.get("close").getAsInt();
            this.high = data.get("high").getAsInt();
            this.low = data.get("low").getAsInt();
            this.splitfact = data.get("split_factor").getAsString();
            this.updatedlast = data.get("date").getAsString(); 
           
        } catch (MalformedURLException ex) {
           Logger.getLogger(StockConnection.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("issue w/ link");
           isLegit = false;
       } catch (IOException ex) {
           Logger.getLogger(StockConnection.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("issue w/ reading");
           isLegit = false;
       }
         catch (Exception ex){
             isLegit = false;
         }
        isLegit = true;
    }

   @Override
    public String toString(){
        return symb;
    }
    private JsonElement apiConnect(URL apiUrl) throws IOException{
        URLConnection yc = apiUrl.openConnection();
            InputStream inStream=yc.getInputStream();
            InputStreamReader inStreamReader = new InputStreamReader(inStream);
            BufferedReader in = new BufferedReader(inStreamReader);
            String inp;
             StringBuilder sb = new StringBuilder();
                   
                   while ((inp = in.readLine()) != null){
                       sb.append(inp);
                       sb.append("\n");
                   }
                   JsonParser jp = new JsonParser();
                   return jp.parse(sb.toString());
    }
    /**
 * 
 * @return the name
 */
    public String getName(){
        return name;
    }
    /**
     * @return the high
     */
    public int getHigh() {
        return high;
    }

    /**
     * @return the low
     */
    public int getLow() {
        return low;
    }

    /**
     * @return the symb
     */
    public String getSymb() {
        return symb;
    }

    /**
     * @return the close
     */
    public int getClose() {
        return close;
    }

    /**
     * @return the open
     */
    public int getOpen() {
        return open;
    }
    public boolean getIsLegit(){
        return isLegit;
    }
    /**
     * @return the updatedlast
     */
    public String getUpdatedlast() {
        return updatedlast;
    }
    

    @Override
    public String setConnection(String key, String symb) {
    return  baseLinkAll+symb+priceInfo+key;  
    }
      //http://api.marketstack.com/v1/tickers/AAPL/eod?access_key=bbe21b9a39c90a3543d03a6d05efcc3e
}
