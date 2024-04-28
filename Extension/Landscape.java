/*
 * Author: Papa Yaw Owusu Nti
 * Date: March 11th, 2024
 * Class: CS 231 B
 * Project: Project 3
 * Description: The Landscape class represents the environment in which agents interact. 
 * It maintains information about the size of the landscape and the agents within it. 
 * The class provides methods for adding agents, drawing them on the landscape, and determining neighboring agents 
 * within a specified radius. Additionally, The updateAgents method randomly selects an agent, creates a new AntiSocialAgent at 
 * its position, and updates the state of all agents. The toString method provides a string representation of the landscape, 
 * indicating the number of agents present.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Landscape {
    private int width;
    private int height;
    private LinkedList<Agent> agents;

    // Constructor
    public Landscape(int w, int h) {
        this.width = w;
        this.height = h;
        this.agents = new LinkedList<>();
    }
    // Getter for height
    public int getHeight() {
        return height;
    }

    // Getter for width
    public int getWidth() {
        return width;
    }

    // Method to add agent to the landscape
    public void addAgent(Agent a) {
        agents.add(a);
    }

    // Method to draw all agents on the landscape
    public void draw(Graphics g) {
        for (Agent agent : agents) {
            agent.draw(g);
        }
    }

    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius) {
        LinkedList<Agent> neighbors = new LinkedList<>();
        for (Agent agent : agents) {
            double X_position = agent.getX();
            double Y_position = agent.getY();
            double distanceX = X_position- x0;
            double distanceY = Y_position - y0;
            double distanceSquared = distanceX * distanceX + distanceY * distanceY;
            double distance = Math.sqrt(distanceSquared);
            if (distance <= radius) {
                neighbors.add(agent);
            }
        }
        return neighbors;
    }
    

    // Method to represent the landscape as a string
    @Override
    public String toString() {
        return "Landscape with " + agents.size() + " agents";
    }

    // return the number of agents that moved during the update.
    public int updateAgents() {
        int movedAgents = 0;

        // // Randomly select an agent from the list
        if (!agents.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(agents.size());
            Agent selectedAgent = agents.remove(index);

            // Store its x, y coordinates, and radius
            double x = selectedAgent.getX();
            double y = selectedAgent.getY();
            int radius = selectedAgent.getRadius();

            // Make a new AntiSocialAgent with the stored coordinates and radius
            AntiSocialAgent newAgent = new AntiSocialAgent(x, y, radius);
            agents.add(newAgent);

            // Update the state of each agent in the linked list
            for (Agent agent : agents) {
                agent.updateState(this);
                if (agent.moved) {
                    movedAgents++;
                }
            }
        
        }
        return movedAgents;
    }
   
}
