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
    final int ball_height = 20;
    final int ball_width = 20;
    
    //play flag false if not playing
    boolean play_flag = false;
    
    //board coordinates
    int board_x = 0; //its value will change according to the position of the board 
    final int board_width = 80;
    final int board_height = 10;
    final int board_y_axis = 530;
    
    Timer timer;
    
    GraphicsCreator graphicsCreator;
    BrickBuilder brickBuilder;
    ActionListener listener;
    
    public GamePlay() {
        setFocusable(true);
        addKeyListener(this);
        brickBuilder = new BrickBuilder();
        
        listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionPerformed1(e);
            }
            
        };
        timer = new Timer(5, listener );
        
    }
    
    public void resetGameCoordinates() {
        ball_x_axis = 30;
        ball_y_axis = 30;
        ball_x_dir = -1;
        ball_y_dir = -2;
        
        //play flag false if not playing
        play_flag = false;
        
        //board coordinates
        board_x = 0; //its value will change according to the position of the board 
        
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
        g.drawOval(ball_x_axis, ball_y_axis, ball_width, ball_height);
        g.fillOval(ball_x_axis, ball_y_axis, ball_width, ball_height);
        
        brickBuilder.repaint(g,new int[]{ball_x_axis, ball_y_axis, ball_width, ball_height}, this);
        
        if(play_flag) {
            String str = "Score : " + brickBuilder.getBrokenBricksCount()*10; 
            g.drawString(str, 460, 30);
        }
        else{
            String str = "";
            if(brickBuilder.getBrokenBricksCount() == brickBuilder.getTotalBricksCount()) {
                str = "Congrats, You won the game. ";
                str +=  "Your Score : " + (brickBuilder.getBrokenBricksCount()*10) + ". Press Enter to restart game" ;
            }
            else if(ball_y_axis >= board_y_axis) {
                str = "Game Over. ";
                str +=  "Your Score : " + (brickBuilder.getBrokenBricksCount()*10) + ". Press Enter to restart game" ;
            }
            
            g.drawString(str, 100, 300);
        }
        
    }
    
    public void resetBallDirections() {
        ball_x_dir = -ball_x_dir;
        ball_y_dir = -ball_y_dir;
    }

    public GamePlay(LayoutManager layout) {
        super(layout);
    }

    public GamePlay(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public GamePlay(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public void actionPerformed1(ActionEvent e) {
        if(play_flag) {
            ball_x_axis += ball_x_dir;
            ball_y_axis += ball_y_dir;
            
            if(ball_x_axis <= 0) {
                ball_x_dir = -ball_x_dir;
            }
            if(ball_y_axis <= 0) {
                ball_y_dir = -ball_y_dir;
            }
            if(ball_x_axis >= board_y_axis) {
                ball_x_dir = -ball_x_dir;
            }
            
            //now we need colliding function with the board
            Rectangle board_rect = new Rectangle(board_x, board_y_axis, board_width, board_height);
            Rectangle ball_rect = new Rectangle(ball_x_axis, ball_y_axis, ball_width, ball_height);
            if (ball_rect.intersects(board_rect)) {
                ball_y_dir = -ball_y_dir;
            }
            
            //check if game is over : if all bricks are destroyed 
            if(brickBuilder.getBrokenBricksCount() == brickBuilder.getTotalBricksCount() || ball_y_axis >= board_y_axis) {
                play_flag = false;
                System.out.println("game over,genius"); 
             }
            
            repaint();
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        timer.start();
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            play_flag = true;
            if(board_x > 0) {
                board_x -= 20;
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            play_flag = true;
            if(board_x < 600-board_width-20) {
                board_x += 20;
            }
            
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(play_flag == false) {
                restartGame();
            }
        }
    }

    private void restartGame() {
        brickBuilder.resetGame(); 
        resetGameCoordinates();
        play_flag = true;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
