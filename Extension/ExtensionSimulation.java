/*
 *Papa Yaw Owusu Nti
 *March 11th, 2024
 *CS 231 B
 *Project 3
 */

import java.util.Scanner;
import java.util.Random;
public class ExtensionSimulation {

    /*
    *test function that creates a new 
    *LandscapeDisplay and populates it with 200 agents.
    */ 
    
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the radius of sensivity for Virus class: (An integer greater than 0. Example: 100)");
        int virusRadius = sc.nextInt();
        System.out.println("Enter the radius of sensitivity for Antivirus class: (An integer greater than 0. Example: 100)");
        int antiVirusRadius = sc.nextInt();
        System.out.println("Enter the radius of sensitivity for Specimen class: (An integer greater than 0. Example: 100)");
        int specimenRadius = sc.nextInt();

        Landscape scape = new Landscape(500, 500);
        LandscapeDisplay display = new LandscapeDisplay(scape);
        Random gen = new Random();


        // Creates 100 Viral Agents, 100 AntiViral Agents and 100 Specimen.
        for (int i = 0; i < 100; i++) {
            scape.addAgent(new ExtensionAntivirus(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    virusRadius));
            scape.addAgent(new ExtensionVirus(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    antiVirusRadius));
            scape.addAgent(new ExtensionSpecimen(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    specimenRadius));

        }

        // Uncomment below when updateAgents() has been implemented
        while(true){
            Thread.sleep(200);
            scape.updateAgents();
            display.repaint();
        }
    }
}