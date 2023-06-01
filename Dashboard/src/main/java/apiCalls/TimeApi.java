/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiCalls;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.util.Date;
/**
 *
 * @author jodic
 */
//https://docs.oracle.com/javase/8/docs/api/java/time/Clock.html#instant--


// this is what I had used//https://www.javatpoint.com/java-get-current-date
public class TimeApi {
    DateTimeFormatter dtf;
    LocalDateTime now;
    Date d;
    public TimeApi(){
     dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
     now = LocalDateTime.now();
     System.out.println(dtf.format(now));
    }
   public String getTime(){
       return dtf.format(now);
   }
   public String getDate(){
       return ""+java.time.LocalDate.now();
   }
   
   public static void main(String[] args){
       TimeApi ta = new TimeApi();
       System.out.println("the Current time:"+ta.getTime()+"\nThe Current Date:"+ta.getDate());
   }
}
