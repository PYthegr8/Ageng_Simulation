/*
 * Author: Papa Yaw Owusu Nti
 * Date: March 11th, 2024
 * Class: CS 231 B
 * Project: Project 3
 * Description: The AntiSocialAgent class extends the Agent class and represents an agent that avoid crowded areas
            in a simulation . agent's movement status: red if it hasn't moved and light red if it has.
            The updateState method checks for the presence of neighbors within a specified radius.
            If more than one neighbor is found, the agent moves to a random nearby location within a limited range.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class AntiSocialAgent extends Agent{


    // Constructor
    public AntiSocialAgent(double x0, double y0, int radius) {
        super( x0, y0 );
        this.radius = radius;
        this.moved =false;

        // remainder of constructor code
    }
    
    // Draw method
    public void draw(Graphics g){
        if(!moved) g.setColor(new Color(255, 0, 0));
        else g.setColor(new Color(255, 125, 125));
    
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }


    public void updateState(Landscape scape) {
        Random rand = new Random();
        // Get neighbors within the radius
        LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), radius);

         // Check if there is more than 1 neighbor within its radius
         if (neighbors.size() > 1) {
              // Set moved to true since the agent moved
            this.moved = true;
            // Generate random values for new coordinates
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
