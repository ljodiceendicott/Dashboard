/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiCalls;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author lukej
 */
public class CovidConnection implements ApiConnection{
   private transient String confirmed;
   private transient String deaths;
   private transient String updated;
   private String name;
    private transient Gson gson;
    
   public CovidConnection(String state){
        this.name = state; 
        //code for current day of Covid
        try{
            
            URL  apiURL = new URL("https://covid-api.mmediagroup.fr/v1/cases?country=US");
            URLConnection yc = apiURL.openConnection();

            InputStream inStream = yc.getInputStream();
            InputStreamReader inStreamReader = new InputStreamReader(inStream);

            BufferedReader in = new BufferedReader(inStreamReader);
            String inputLine;
            StringBuilder sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null){
                sb.append(inputLine);
                sb.append("\n");
            }
           // JsonParser jp = new JsonParser();
           // JsonElement root = jp.parse(sb.toString());
           // JsonObject stateobj = root.getAsJsonObject();
            //this.deaths = stateobj.get("TotalDeaths").getAsString();
           // JsonArray ja = stateobj.get("casesByState").getAsJsonArray();
            //for(int i =0; i<ja.size(); i++){
            //    if(ja.get(i).getAsJsonObject().get("name").getAsString()==this.name){
           //         this.confirmed=ja.get(i).getAsJsonObject().get("casesReported").getAsString();
            //    }
           // }
            
            
            JsonParser jp= new JsonParser();
            JsonElement root = jp.parse(sb.toString());
            JsonObject stateJson = root.getAsJsonObject();
            JsonElement stateele = stateJson.get(state);
            JsonObject stateobj = stateele.getAsJsonObject();
            this.confirmed = stateobj.get("confirmed").getAsString();
            
            this.deaths = stateobj.get("deaths").getAsString();
            this.updated = stateobj.get("updated").getAsString();
           
            in.close();
        }
        catch(IOException e){
         System.out.println("Bad Connection: ERROR:"+e);
        }
}
   public static void main(String[] args){
       CovidConnection cc = new CovidConnection("Massachusetts");
       System.out.println(cc);
   }
    @Override
   public String setConnection(String key, String topic){
       //will replace putting the code for connection in the constructor
       return"";
   }
   private void getYesterday(String state){
       //getting yesterdays data
   }
public void print(){
    System.out.println("Covid Today in "+this.getName()+"\n Confirmed Cases:"+this.getConfirmed());
}
@Override
public String toString(){
    return "Covid Today in "+this.getName()+"\n Confirmed Cases:"+this.getConfirmed();
}

    /**
     * @return the confirmed
     */
    public String getConfirmed() {
        return confirmed;
    }

    /**
     * @return the recovered
     */
    

    /**
     * @return the deaths
     */
    public String getDeaths() {
        return deaths;
    }

    /**
     * @return the updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}