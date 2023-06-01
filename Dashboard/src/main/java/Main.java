
import RegisterWindows.StartScreen;
import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ljodice
 */
public class Main {
    public static void main(String[] args){
        //Sets the default theme for the entire project to be the Darcula Theme
        LafManager.setTheme(new DarculaTheme());
       LafManager.install();
        StartScreen ss = new StartScreen();
        ss.setVisible(true);
    }
}
