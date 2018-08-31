import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        Simulation s=new Simulation();

        File phase1 = new File("phase-1.txt"); //Loads file 1
        File phase2 = new File("phase-2.txt"); //Loads file 2

        //U1 Fleet
        ArrayList<Rocket> rocketsU1P1; //Phase1
        ArrayList<Rocket> rocketsU1P2; //Phase2
        ArrayList<Rocket> rocketsU1Fleet = new ArrayList<>(); //The entire fleet of U1

        //U2 Fleet
        ArrayList<Rocket> rocketsU2P1; //Phase1
        ArrayList<Rocket> rocketsU2P2; //Phase2
        ArrayList<Rocket> rocketsU2Fleet = new ArrayList<>(); //The entire fleet of U2

        //Filling U1's Fleet
        rocketsU1P1 = s.loadU1(s.loadItems(phase1)); //First, I load the items, then I pass that list onto the other method who stores those items in the rockets, then I save that list of rockets in rocketsU1
        rocketsU1P2 = s.loadU1(s.loadItems(phase2));

        //It fills the entire fleet with the U1 rockets of phase1
        rocketsU1Fleet.addAll(rocketsU1P1);
        //It fills the entire fleet with the U1 rockets of phase2
        rocketsU1Fleet.addAll(rocketsU1P2);

         //Filling U2's Fleet
         rocketsU2P1 = s.loadU2(s.loadItems(phase1)); //First, I load the items, then I pass that list onto the other method who stores those items in the rockets, then I save that list of rockets in rocketsU2
         rocketsU2P2 = s.loadU2(s.loadItems(phase2));

        //It fills the entire fleet with the U2 rockets of phase1
        rocketsU2Fleet.addAll(rocketsU2P1);

        //It fills the entire fleet with the U2 rockets of phase2
        rocketsU2Fleet.addAll(rocketsU2P2);

         System.out.println("===========U1============");
         s.runSimulation(rocketsU1Fleet);
         System.out.println("=========================");

         System.out.println("===========U2============");
         s.runSimulation(rocketsU2Fleet);
         System.out.println("=========================");


    }
}