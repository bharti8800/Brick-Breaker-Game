import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

public class BrickBuilder {

    final int total_bricks = 24;
    int bricks_broken = 0;
    
    int brick_x = 60;
    int brick_y = 40;
    final int brick_width = 40;
    final int brick_height = 30;
    //int rect_value[] = new int[total_bricks];
     //rectangles;
    
    public BrickBuilder() {
        bricks_broken = 0;//set bricks broken to 0
        //Arrays.fill(rect_value, 1);
    }
    
    public void paint(Graphics g) {
        for(int row = 0; row<7; row++) {
            for(int col = 0; col<4; col++) {
                g.setColor(Color.green);
                g.drawRect(brick_x + (row*60 + brick_width) , brick_y + (col*40 + brick_height), brick_width, brick_height);
                g.fillRect(brick_x + (row*60 + brick_width), brick_y + (col*40 + brick_height), brick_width, brick_height); 
            }   
        }
        
    }
}
