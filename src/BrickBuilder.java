import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;

public class BrickBuilder {

    final int total_bricks = 24;
    int bricks_broken = 0;
    final int total_brick_rows = 7;
    final int total_brick_cols = 4;
    int brick_x = 60;
    int brick_y = 40;
    final int brick_width = 40;
    final int brick_height = 30;
    int rect_value[][];
     //rectangles;
    
    public BrickBuilder() {
        bricks_broken = 0;//set bricks broken to 0
        rect_value = new int[total_brick_rows][total_brick_cols];
    }
    
    public void paint(Graphics g, int[] ball,GamePlay gameplay) {
        g.setColor(Color.green);
        for(int row = 0; row<total_brick_rows; row++) {
            for(int col = 0; col<total_brick_cols; col++) {
                
                if(rect_value[row][col] != 1) {
                    //check if ball is hitting this brick
                    Rectangle ball_rect = new Rectangle(ball[0], ball[1], ball[2], ball[3]);
                    Rectangle brick_rect = new Rectangle(brick_x + (row*60 + brick_width) , brick_y + (col*40 + brick_height), brick_width, brick_height);
                    
                    if(ball_rect.intersects(brick_rect)) {
                        g.clearRect(brick_x + (row*60 + brick_width), brick_y + (col*40 + brick_height), brick_width, brick_height);
                        gameplay.resetBallDirections();
                        rect_value[row][col] = 1;
                    }
                    else {
                        g.drawRect(brick_x + (row*60 + brick_width) , brick_y + (col*40 + brick_height), brick_width, brick_height);
                        g.fillRect(brick_x + (row*60 + brick_width), brick_y + (col*40 + brick_height), brick_width, brick_height); 
                    }
                    
                }
                
            }   
        }
        
    }
}
