   /*
 * Author: Papa Yaw Owusu Nti
 * Date: March 11th, 2024
 * Class: CS 231 B
 * Project: Project 3
 * Description: The ReportExploration: CommandLine arguments are <number_of_agents> <radius>
    */
public class ReportExploration {
    public static void main(String[] args) throws InterruptedException {

        Landscape scape = new Landscape(500, 500);
        LandscapeDisplay display = new LandscapeDisplay(scape);

        // Check if the command line argument is provided
        if (args.length < 2) {
            System.out.println("Usage: where are your arguments? |java AgentSimulation <number_of_agents><radius>|");
            System.exit(1);
        }

        // Parse the command line argument for the number of agents
        int N = Integer.parseInt(args[0]);

        // Parse the command line argument for the radius of agent
        int radius = Integer.parseInt(args[1]);

        // Generate and randomly place N SocialAgents with a radius of 25/user spcified
        for (int i = 0; i < N; i++) {
            double x = Math.random() * 500;
            double y = Math.random() * 500;
            // scape.addAgent(new SocialAgent(x, y, 25));
            scape.addAgent(new SocialAgent(x,y,radius));
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
        // System.out.println("Number of iterations for " + N + "agents"+ " is: " + iterations);
        System.out.println("Number of iterations for " + radius + " radius " + " is " + iterations);
    }
}





