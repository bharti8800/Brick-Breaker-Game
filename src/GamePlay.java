import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    //some variables i need for setting coordinates
    
    //ball coordinates
    int ball_x = 0;
    int ball_y = 0;
    
    //play flag false if not playing
    boolean play_flag = false;
    
    //board coordinates
    int board_x = 200;
    final int board_width = 5;
    
    GraphicsCreator graphicsCreator;
    
    public GamePlay() {
        graphicsCreator = new GraphicsCreator();
        Graphics graphics = this.getGraphics();
        graphicsCreator.paintGraphics(graphics);
        addKeyListener(this);
        // TODO Auto-generated constructor stub
    }

    public GamePlay(LayoutManager layout) {
        super(layout);
        // TODO Auto-generated constructor stub
    }

    public GamePlay(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        // TODO Auto-generated constructor stub
    }

    public GamePlay(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(play_flag) {
          //  graphicsCreator.paintBoard(board_x);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            
            if(board_x > 200) {
                board_x -= 20;
            }
  
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            
            if(board_x < 800) {
                board_x += 20;
            }
            
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
