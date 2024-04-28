/*
 *Papa Yaw Owusu Nti
 *March 11th, 2024
 *CS 231 B
 *Project 3
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class ExtensionVirus extends Agent{

    boolean moved;
    int radius;

    //calls the super class constructor and sets the radius field.
    public ExtensionVirus(double x0, double y0, int radius) {
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

    //Draw star shaped
    public void extensionShape(Graphics g, int x, int y) {
        int [] x0 = {x + 9, x + 12,x + 15,x + 13,x + 15};
        int [] y0 = {y + 5, y + 13,y + 14,y + 18,y + 28};

        g.fillPolygon(x0, y0, 5);
    }

    //draws a circle of radius 5 at the Agent's location.
    public void draw(Graphics g){
         if(!moved) 
                g.setColor(new Color(0, 250, 0));
         else 
                g.setColor(new Color(255, 125, 125));
    
         //g.fillOval((int) getX(), (int) getY(), 5, 5);   
         extensionShape(g, (int) getX(), (int) getY());  
    }


    public void updateState(Landscape scape) {
        if (scape.getNeighbors(getX(), getY(), radius).size() > 1) {
           this.moved = true;
           Random randObj = new Random();
           int randx = randObj.nextInt(-50,50);
           int randy = randObj.nextInt(-50,50);

        //double newX = (this.getX() + randx < 0 || (this.getX() + randx) >= scape.width)? randObj.nextInt(0,scape.getWidth()): this.getX() +randx;
        //double newY = (this.getY() + randy < 0 || (this.getY() + randy) >= scape.width)? randObj.nextInt(0,scape.getHeight()): this.getY() +randy;

        double newX = (this.getX() + randx < 200 || (this.getX() + randx) >= 300)? randObj.nextInt(150,300): 225 + randx;
        double newY = (this.getY() + randy < 200 || (this.getY() + randy) >= 300)? randObj.nextInt(150,300): 225 +randy;

        this.setX(newX);
        this.setY(newY);} else {
            this.moved = false;
        }
    }

}
