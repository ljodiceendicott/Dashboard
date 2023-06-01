/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseRetrieve;

/**
 *
 * @author jodic
 */
public class StockInfo {    
  private String symbol;
  private String name;
    public StockInfo(String symbol, String name){
        this.symbol = symbol;
        this.name = name; 
    }
     public StockInfo(String symbol){
        this.symbol = symbol;
        this.name = "no Name";
    }
    public String getSymbol(){
        return symbol;
        }
    public String toString(){
        if(this.name =="no Name"){
            return symbol;
        }
        return "("+symbol+") "+name;
            }
}

