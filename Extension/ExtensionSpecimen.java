/*
 *Papa Yaw Owusu Nti
 *March 11th, 2024
 *CS 231 B
 *Project 3
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class ExtensionSpecimen extends Agent{

    boolean moved, getHealed, getInfected;
    int radius;
    Random randObj = new Random();

    //calls the super class constructor and sets the radius field.
    public ExtensionSpecimen(double x0, double y0, int radius) {
        super(x0,y0);
        this.radius = radius;
        moved = getHealed = getInfected = false;

    }

    //sets the cell's radius of sensitivity to the value of radius.
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // returns the cell's radius of sensitivity.
    public int getRadius() {
        return this.radius;
    }

    //draws a circle of radius 5 at the Agent's location.
    public void draw(Graphics g){
        if(getInfected) 
                g.setColor(new Color(125, 125, 125));
        else if (getHealed)
                g.setColor(new Color(0,225,0)); 
        else 
                g.setColor(new Color(0,0,225));
                //g.setColor(new Color(randObj.nextInt(255), randObj.nextInt(255), randObj.nextInt(255)));
    
         g.fillOval((int) getX(), (int) getY(), 5, 5);   
     }


    public void updateState(Landscape scape) {
        if (scape.getNeighbors(getX(), getY(), radius).size() > 1) {
            int randx = randObj.nextInt(-50,50);
            int randy = randObj.nextInt(-50,50);

            double toMoveX = this.getX() + randx;
            double toMoveY = this.getY() + randy;
            boolean getInfected = (toMoveX > 140 && toMoveX < 310) &&(toMoveY > 140 && toMoveY < 310);
            boolean getHealed = (toMoveX > 0 && toMoveX < 60) || (toMoveX > 440 && toMoveX < 500);

             if (getInfected) {
                this.getInfected = true;
                this.setX(toMoveX);
                this.setY(toMoveY);
                // this.moved = false;
            } else if (getHealed) {
                this.getHealed = true;
                this.setX(toMoveX);
                this.setY(toMoveY);
                // this.moved = false;
            } else {
                //this.moved = true;
                double newX = (this.getX() + randx < 0 || (this.getX() + randx) >= scape.getWidth())? randObj.nextInt(0,scape.getWidth()): this.getX() +randx;
                double newY = (this.getY() + randy < 0 || (this.getY() + randy) >= scape.getWidth())? randObj.nextInt(0,scape.getHeight()): this.getY() +randy;
                this.setX(newX);
                this.setY(newY);
            }

        }
    }

}
