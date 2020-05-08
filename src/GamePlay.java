import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    //some variables i need for setting coordinates
    
    //ball coordinates
    int ball_x_axis = 30;
    int ball_y_axis = 30;
    int ball_x_dir = -1;
    int ball_y_dir = -2;
    
    
    //play flag false if not playing
    boolean play_flag = false;
    
    //board coordinates
    int board_x = 0; //its value will change according to the position of the board 
    final int board_width = 80;
    final int board_height = 10;
    final int board_y_axis = 530;
    
    Timer timer;
    
    GraphicsCreator graphicsCreator;
    
    public GamePlay() {
        setFocusable(true);
        addKeyListener(this);
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(play_flag) {
                    ball_x_axis += ball_x_dir;
                    ball_y_axis += ball_y_dir;
                    
                    if(ball_x_axis <= 0) {
                        ball_x_dir = -ball_x_dir;
                    }
                    if(ball_y_axis <= 0) {
                        ball_y_dir = -ball_y_dir;
                    }
                    if(ball_x_axis >= 600-30) {
                        ball_x_dir = -ball_x_dir;
                    }
                    //now we need colliding function with the board
                    Rectangle board_rect = new Rectangle(board_x, board_y_axis, board_width, board_height);
                    Rectangle ball_rect = new Rectangle(ball_x_axis, ball_y_axis, 20, 20);
                    if (ball_rect.intersects(board_rect)) {
                        ball_y_dir = -ball_y_dir;
                    }
                    
                    if(ball_y_axis > 600) {
                        //game over
                    }
                    repaint();
                    
                }
            }
            
        };
        timer = new Timer(5, listener );
        graphicsCreator = new GraphicsCreator();
        
        //graphicsCreator.paintGraphics(graphics);
        
        // TODO Auto-generated constructor stub
    }
    
    public void paint(Graphics g) {
       
        //set background color
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
        
        //paint the board
        g.setColor(Color.blue);
        g.drawRect(board_x, board_y_axis, board_width, board_height);
        g.fillRect(board_x, board_y_axis, board_width, board_height);
        
        //paint the ball
        g.setColor(Color.yellow);
        g.drawOval(ball_x_axis, ball_y_axis, 20, 20);
        g.fillOval(ball_x_axis, ball_y_axis, 20, 20);
        
        
       
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
        System.out.println("i m fucking called");
        if(play_flag) {
          repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        timer.start();
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
           // System.out.println("pressing key left");
            play_flag = true;
           // System.out.println(board_x);
            if(board_x > 0) {
                board_x -= 20;
            }
            //System.out.println(board_x);
  
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //System.out.println("pressing key right");
            play_flag = true;
            //System.out.println(board_x);
            if(board_x < 600-board_width-20) {
                board_x += 20;
            }
            //System.out.println(board_x);
            
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
