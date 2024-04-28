/*
 * Author: Papa Yaw Owusu Nti
 * Date: March 11th, 2024
 * Class: CS 231 B
 * Project: Project 3
 * Description: The AgentSimulation class serves as the main driver program for simulating agent behavior in a landscape. 
 * It initializes a landscape with specified dimensions and a display for visualization. 
 * The number of agents and their initial positions are determined by the command line argument. 
 * The simulation runs in a loop until either no agents move or a maximum number of iterations is reached. 
 * During each iteration, agents update their state and the display is refreshed to reflect any changes.
 */


public class AgentSimulation {
    public static void main(String[] args) throws InterruptedException {

        Landscape scape = new Landscape(500, 500);
        LandscapeDisplay display = new LandscapeDisplay(scape);

        // Check if the command line argument is provided
        if (args.length < 1) {
            System.out.println("Usage: where are your arguments? |java AgentSimulation <number_of_agents>|");
            System.exit(1);
        }

        // Parse the command line argument for the number of agents
        int N = Integer.parseInt(args[0]);

        // Generate and randomly place N SocialAgents with a radius of 25
        for (int i = 0; i < N; i++) {
            double x = Math.random() * 500;
            double y = Math.random() * 500;
            scape.addAgent(new SocialAgent(x, y, 25));
        }


        // Set initial count of agents moved to a non-zero value
        int agentsMoved = 1;
        // Run the simulation loop until no agents moved or maximum iterations reached
        int iterations = 0;


        while (agentsMoved > 0 && iterations < 5000) {
            Thread.sleep(100);
            agentsMoved = scape.updateAgents(); // Update agents and get the number of agents moved
            display.repaint(); // Repaint the LandscapeDisplay
            iterations++;
        }
    
    }
}
