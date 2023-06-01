/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInfo;


import apiCalls.CovidConnection;
import apiCalls.NewsConnection;
import apiCalls.StockConnection;
import Dashboards.DashBoardControlPanel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author jodic
 */
public class UserData {
    private Gson g;
   private static UserData ud;
    private  ArrayList<CustomUser> userlist;

  
   
   private UserData(){
       userlist = new ArrayList<>();       
      
   }
   
   public static UserData getInstance(){
       if(ud==null)
           ud =new UserData();
       return ud;
   }
   public void writeUser(CustomUser cu){
       this.writetoFile(cu);
   }
   private void writetoFile(CustomUser cu){
       //Use this path as a start location for getting and saving files
        String strUserDir = System.getProperty("user.dir");
        
       g = new Gson();
       //add filter to this JFileChooser for only JSON files
       FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "User Json Files", "json", "json");
      JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
      jfc.setFileFilter(filter);
      try{ 
      int ret = jfc.showSaveDialog(null);
       if(ret != JFileChooser.APPROVE_OPTION)
           return;
       File f = jfc.getSelectedFile();
       FileWriter output = new FileWriter(f);
           output.write(g.toJson(cu));
       
       output.close();
      
      } catch (IOException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   private CustomUser getUserinfo(CustomUser cu){
       CustomUser tempu = new CustomUser();
       if(cu.isCovid()){
           tempu.setIsCovid(true);
           tempu.setCovid(new CovidConnection(cu.getCovidinfo().getName()));
       }
       if(cu.isNews()){
           tempu.setIsNews(true);
           ArrayList<NewsConnection> tmpstories = new ArrayList<>(); 
           for(int i=0; i<cu.getNews().size(); i++){
               tmpstories.add(new NewsConnection(cu.getNews().get(i).getSection()));
           }
           tempu.setNews(tmpstories);
       }
       //if stocks
       if(cu.isStocks()){
           tempu.setIsStocks(true);
           ArrayList<StockConnection> tmpstocklist = new ArrayList<>();
           for(int i=0; i<cu.getStocks().size(); i++){
               tmpstocklist.add(new StockConnection(cu.getStocks().get(i).getSymb()));
           }
               tempu.setStocksDef(tmpstocklist);
       }
       
       
       
       
       
       return tempu;
   }
   public void readfromFile(){
       g = new Gson();
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Json Files", "json", "json");
      JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
      jfc.setFileFilter(filter);
      try{ 
      int ret = jfc.showSaveDialog(null);
       if(ret != JFileChooser.APPROVE_OPTION)
           return;
        File f = jfc.getSelectedFile();
        BufferedReader buffread = new BufferedReader(new FileReader(f));
        CustomUser cu = g.fromJson(buffread, CustomUser.class);
        CustomUser updated = this.getUserinfo(cu);
        DashBoardControlPanel dcp = new DashBoardControlPanel(updated);
        dcp.setVisible(true);
   }    catch (FileNotFoundException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
   