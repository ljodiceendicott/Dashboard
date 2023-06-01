/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseRetrieve;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jodic
 */
public class StockFromJson {
     public static StockFromJson sfj;
    private Gson g;
    private ArrayList<StockInfo>  listnames;
    private HashMap<String,String> list;
    
 
    private StockFromJson(){
        listnames = new ArrayList<>();
        list = new HashMap<>();
        try{
        File defStockInfo = new File(getClass().getResource("/tickers.json").getFile()); 
        g = new Gson();
            try (BufferedReader buffread = new BufferedReader(new FileReader(defStockInfo))) {
                String inputLine;
                StringBuilder sb = new StringBuilder();
                while((inputLine = buffread.readLine()) != null){
                    sb.append(inputLine);
                    sb.append("\n");
                }   //getinto the data
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(sb.toString());
                JsonObject objRoot = root.getAsJsonObject();
                JsonElement valueElem = objRoot.get("data");
                JsonArray stockNameInfo = valueElem.getAsJsonArray();
                
                //take data and put it into an arraylist<stockInfo>
                for (int i = 0; i<500; i++) {
                    JsonObject obj = stockNameInfo.get(i).getAsJsonObject();
                    if(obj.get("has_eod").getAsBoolean()){
                    String name = obj.get("name").getAsString();
                    String symbol= obj.get("symbol").getAsString();
                    list.put(symbol, name);
                    listnames.add(new StockInfo(symbol,name));
                    }
                }
                buffread.close();
            }
        }  catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Can not find file");
            System.out.print(ex.getStackTrace());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Issue reading in the file");
            System.out.print(ex.getStackTrace());
        }
}
    public static StockFromJson getInstance(){
        if(sfj == null){
            return new StockFromJson(); 
        }
        else{
            return sfj;
        }
    }
    public DefaultListModel<StockInfo> addToDlm(DefaultListModel<StockInfo> dlm){
        for(int i = 0; i<listnames.size(); i++){
           dlm.addElement(listnames.get(i));
        } 
        return dlm;
    }
    public boolean isVerifiedLocal(String symbol){
        if(list.containsKey(symbol))
            return true;
        return false;
        }
    public ArrayList<StockInfo> getList(){
        return listnames;
    } 
    public static void main(String[] args){
        StockFromJson s = StockFromJson.getInstance();
    }
}
