/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboards;

import apiCalls.NewsConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import panels.NewsPanel;

/**
 *
 * @author jodic
 */
public class NewsDashboard extends javax.swing.JFrame {
ArrayList<NewsConnection> news;
Set<String> topics;
JButton[] buttons;
NewsPanel np;


    /**
     * Creates new form NewsDashboard
     */
    public NewsDashboard() {
        //Test
        topics = new HashSet<>();
        topics.add("Sports");
        topics.add("crazy news");
        topics.add("Sports");
        topics.add("crazy news");
        topics.add("Sports");
        topics.add("crazy news");
        
        String[] array =topics.toArray(new String[topics.size()]);
        //https://www.techiedelight.com/convert-set-to-array-java/ Helped understand how to usethe Set.toArray method
        initComponents();
       // stories = new JLabel[]{jlStoryOne,jlStoryTwo,jlStoryThree};
        System.out.println(topics.toString());
    }
    
    
    
    public NewsDashboard(ArrayList<NewsConnection> news){
        initComponents();
        this.news = news;
        buttons = new JButton[]{jbtnStoryOne,jbtnStoryTwo,jbtnStoryThree,jbtnStoryFour};
        this.np = npOne;
        np.setValues(news.get(0));
                //(news.get(0));
        //get the names of the news topics
        topics = new HashSet<>();
        for(int i = 0; i<news.size(); i++){
            topics.add(news.get(i).getSection());
        }
        String[] topic = topics.toArray(new String[topics.size()]);
        for(int i= 0; i<topic.length; i++){
        buttons[i].setText(topic[i]);
        }
        if(buttons.length>topic.length){
            for(int j=topic.length;j<buttons.length; j++){
                buttons[j].setVisible(false);
            }
        }
        }
    
       private void changeValues(JButton btn){
           String topic = btn.getText();
           if(!topic.equals(np.getTopicname())){
               for(int i = 0; i<news.size(); i++){
                   if(news.get(i).getSection().equals(topic)){
                    np.setValues(news.get(i));
                    }
               }
               
            }
       }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        npOne = new panels.NewsPanel();
        jbtnStoryOne = new javax.swing.JButton();
        jbtnStoryTwo = new javax.swing.JButton();
        jbtnStoryThree = new javax.swing.JButton();
        jbtnStoryFour = new javax.swing.JButton();

        setTitle("Top News Stories");
        setResizable(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("To read more about a story, Click on a headline. Will give you ");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("the title, as well as link to read full article on:  www.nytimes.com");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Information gotten from New York Times API");

        jbtnStoryOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStoryOneActionPerformed(evt);
            }
        });

        jbtnStoryTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStoryTwoActionPerformed(evt);
            }
        });

        jbtnStoryThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStoryThreeActionPerformed(evt);
            }
        });

        jbtnStoryFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStoryFourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(npOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnStoryOne, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jbtnStoryThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnStoryFour, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnStoryTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnStoryTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jbtnStoryOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnStoryFour, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jbtnStoryThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(npOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnStoryOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStoryOneActionPerformed
       this.changeValues(jbtnStoryOne);
    }//GEN-LAST:event_jbtnStoryOneActionPerformed

    private void jbtnStoryThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStoryThreeActionPerformed
    this.changeValues(jbtnStoryThree);
    }//GEN-LAST:event_jbtnStoryThreeActionPerformed

    private void jbtnStoryTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStoryTwoActionPerformed
     this.changeValues(jbtnStoryTwo);
    }//GEN-LAST:event_jbtnStoryTwoActionPerformed

    private void jbtnStoryFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStoryFourActionPerformed
         this.changeValues(jbtnStoryFour);
    }//GEN-LAST:event_jbtnStoryFourActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewsDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewsDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewsDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewsDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewsDashboard().setVisible(true);
            }
        });
    }

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbtnStoryFour;
    private javax.swing.JButton jbtnStoryOne;
    private javax.swing.JButton jbtnStoryThree;
    private javax.swing.JButton jbtnStoryTwo;
    private panels.NewsPanel npOne;
    // End of variables declaration//GEN-END:variables
}
