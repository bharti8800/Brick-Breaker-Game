import java.awt.Graphics;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        
        //create a jpanel
        GamePlay gameplay = new GamePlay();
        
        //create a jframe
        JFrame jframe = new JFrame();
        jframe.setBounds(200, 100, 600, 600);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        
        //add jpanel to jframe
        jframe.add(gameplay);
        
    }

}
