/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInfo;

import apiCalls.CovidConnection;
import apiCalls.StockConnection;
import apiCalls.NewsConnection;
import DatabaseRetrieve.StockFromJson;
import DatabaseRetrieve.StockInfo;
import java.util.ArrayList;

/**
 *
 * @author jodic
 */

public class CustomUser{
public String profileName;
protected ArrayList<NewsConnection> newsApiTopics;
private boolean isNews;

protected ArrayList<StockConnection> stockslist;
private boolean isStocks;

private CovidConnection covidApiTopic;
private boolean isCovid;

private ArrayList<StockConnection> sc;
transient private StockFromJson sfj;

private boolean UseDefaults;


//Custom User calls   
        //used for default user
    public CustomUser(){
       newsApiTopics = new ArrayList<>();
       stockslist = new ArrayList<>();
      //weatherList = new ArrayList<>();
       
   }

    public void setpfpName(String name){
        this.profileName = name;
    }
    
    @Override
    public String toString(){
        return profileName;
    }
//Covid information calls
    public void setCovid(CovidConnection cc){
        this.covidApiTopic = cc;       
    }
     public void setIsCovid(boolean c){
       this.isCovid=c;
    }
   public CovidConnection getCovidinfo(){
        return covidApiTopic;
    }
     public boolean isCovid() {
         return isCovid;
     }       
        
//News information calls
    public void setNews(ArrayList<NewsConnection> news){
        this.newsApiTopics = news;
    }
     public void setIsNews(boolean b) {
        this.isNews=b;
    }
     public boolean isNews() {
        return isNews;
    }
       public ArrayList<NewsConnection> getNews() {
      return newsApiTopics;
    }

       
//stock information calls
     public void setStocks(ArrayList<StockInfo> si){
        for(int i= 0; i<si.size(); i++){
            this.stockslist.add(new StockConnection(si.get(i).getSymbol()));
        }
    }
     public void setStocksDef(ArrayList<StockConnection> si){
        for(int i= 0; i<si.size(); i++){
            this.stockslist.add(si.get(i));
       }
    }
     public ArrayList<StockConnection> getStocks(){
        return this.stockslist;
    }
     
    public void setIsStocks(boolean b){
        this.isStocks = b;
    }
      public boolean isStocks(){
         return isStocks;
     }    
}
