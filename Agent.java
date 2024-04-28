/*
 *Papa Yaw Owusu Nti
 *March 11th, 2024
 *CS 231 B
 *Project 3
 * Description: This program creates the abstract Agent class defines basic attributes and behaviors for objects in a simulation. 
            * It includes fields for position,radius and movement tracking, along with getter and setter methods. 
            * It is a template for creating specific types of agents by extending it .
 */


import java.awt.Graphics;

public abstract class Agent {
    private double x;
    private double y;
    protected int radius;
    protected boolean moved;

    //  a constructor that sets the position.
    public Agent(double x0, double y0){
        this.x = x0;
        this.y = y0;
    }

    public Agent(double x0, double y0, int radius){
        this.x = x0;
        this.y = y0;
        this.radius = radius;
    }

    //  returns the x position.
    public double getX(){
        return this.x;
    }

    //  returns the y position.
    public double getY(){
        return this.y;
    }

    //  returns the radius.
    public int getRadius(){
        return radius;
    }

    //  returns the moved field.    
    public boolean getMoved(){
        return moved;
    }

    // sets the x position.
    public void setX( double newX ) {
        this.x = newX;
    }

    // sets the y position.
    public void setY( double newY ) {
        this.y = newY;
    }

    // sets the radius.
    public void setRadius( int newRadius ) {
        this.radius = newRadius;
    }

    // returns a String containing the x and y positions, e.g. "(3.024, 4.245)".
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // does nothing, for now.
    public abstract void updateState( Landscape scape );

    // does nothing, for now.
    public abstract void draw(Graphics g);

}
