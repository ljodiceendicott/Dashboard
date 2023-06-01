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
 public class NewsStory{
   private String storylink;
   private String last_updated;
   private String pubdate;
   private String title;
   private String desc;
   
   public NewsStory(String storylink, String lastup, String pubdate, String title, String desc){
       this.storylink = storylink;
       this.last_updated = lastup;
       this.pubdate = pubdate;
       this.title = title;
       this.desc = desc;
   }
   @Override
   public String toString(){
       return getTitle();
   }

    /**
     * @return the storylink
     */
    public String getStorylink() {
        return storylink;
    }

    /**
     * @return the last_updated
     */
    public String getLast_updated() {
        return last_updated;
    }

    /**
     * @return the pubdate
     */
    public String getPubdate() {
        return pubdate;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
 }