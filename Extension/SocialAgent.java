/*
 * Author: Papa Yaw Owusu Nti
 * Date: March 11th, 2024
 * Class: CS 231 B
 * Project: Project 3
 * Description: The SocialAgent class extends the Agent class and represents an agent that
        *  clusters in a simulation. the agent's movement status: blue if it hasn't moved and light blue if it has. 
        * The updateState method checks for the presence of neighbors within its radius. If there are less than four neighbors,
        *  indicating an uncrowded area, the agent moves to a random nearby location within a limited range. 
        * Otherwise, it remains stationary.
*/


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class SocialAgent extends Agent{

    private boolean moved;
    // Constructor
    public SocialAgent(double x0, double y0, int radius) {
        super( x0, y0);
        this.radius = radius;
        this.moved = false;
    }
    
    // Draw method
    public void draw(Graphics g){
        if(!moved) g.setColor(new Color(0, 0, 255));
        else g.setColor(new Color(125, 125, 255));
    
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape){
        Random rand = new Random();

        // Get neighbors within the radius
        LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), getRadius());

        // Check if there are less than 4 agents within its own radius
        if (neighbors.size() < 4) {
            // Set moved to true since the agent moved
            this.moved = true;
            
             // Generate random values for new coordinates
            // my random generator will generate a random number between 0,20 and substracts by 10 to get -10,10 
             double newX = getX() + (rand.nextInt(21) - 10);
             double newY = getY() + (rand.nextInt(21) - 10);
 
             // Ensure new coordinates stay within the boundaries of the landscape
             if (newX < 0) {
                 newX = 0;
             } else if (newX > scape.getWidth()) {
                 newX = scape.getWidth();
             }
             if (newY < 0) {
                 newY = 0;
             } else if (newY > scape.getHeight()) {
                 newY = scape.getHeight();
             }
 
             // Update the coordinates
             setX(newX);
             setY(newY);
 
             
        } 
        
        else {
            // Set moved to false since the agent didn't move
            this.moved = false;
        }
    }
}