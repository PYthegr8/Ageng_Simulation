/*
 *Papa Yaw Owusu Nti
 *March 11th, 2024
 *CS 231 B
 *Project 3
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class ExtensionAntivirus extends Agent{

    boolean moved;
    int radius;
    Random randObj = new Random();

    //calls the super class constructor and sets the radius field.
    public ExtensionAntivirus(double x0, double y0, int radius) {
        super(x0,y0);
        this.radius = radius;
        moved = false;
    }

    //sets the cell's radius of sensitivity to the value of radius.
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // returns the cell's radius of sensitivity.
    public int getRadius() {
        return this.radius;
    }

    //Draw heart shaped
    public void heartShape(Graphics g, int x, int y) {
        int [] x0 = {x + 10, x + 11,x + 9,x + 0,x + 0, x + 3, x + 15, x + 18, x + 19};
        int [] y0 = {y -10, y - 17,y - 19,y - 3,y + 0, y + 0, y - 7, y - 9, y - 12 };

        g.fillPolygon(x0, y0, 9);
    }
    //draws a circle of radius 5 at the Agent's location.
    public void draw(Graphics g){
         if(!moved) {
            g.setColor(new Color(255, 0, 0));
         }
                
         else {
            g.setColor(new Color(randObj.nextInt(255), randObj.nextInt(255), randObj.nextInt(255)));
         }
    
         heartShape(g, (int) getX(), (int) getY());   
     }


    public void updateState(Landscape scape) {

        this.moved = true;
        int randNum = randObj.nextInt(60);
        if ( randNum > 30 ) {
            this.setX(440 + randNum);
        } else {
            this.setX(randNum);
        }

    }

}
