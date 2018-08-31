import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Simulation {

    public ArrayList loadItems(File file) //Gets a file as a parameter
    {

        Scanner scanner = null;
        try
        {
          scanner = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {

            System.out.println("No se encontro el archivo");

        }

        ArrayList<Item> itemsList = new ArrayList<>(); //This is where the items will be stored

        if(!(scanner==null)) //If the scanner didn't get a file, it'll just return the empty list
        {
            while (scanner.hasNextLine()) //Reads the entire file
            {
                String line = scanner.nextLine();
                String[] spl = line.split("="); //This is where the line gets splitted into name and weight
                Item item = new Item(); //It creates a new object for every line


                item.name = spl[0]; //Gets the name
                item.weight = Integer.parseInt(spl[1]); //Gets the weight

                itemsList.add(item); //Here's where the item gets stored in the List

            }
        }
        return itemsList;
    }

    public ArrayList loadU1(ArrayList<Item> itemslist)
    {

        ArrayList<U1> u1list = new ArrayList<>(); //This is where the rockets will be stored

        while(!itemslist.isEmpty()) //As long as the list contains something, this will run
        {
            U1 u1 = new U1(); //The new rocket

            for (int i=0; i<(itemslist.size());i++)
            {

                if (u1.canCarry(itemslist.get(i)) && !itemslist.isEmpty() ) //Checks if the rocket can carry the item
                {
                    u1.carry(itemslist.get(i)); //Adds the item's weight into the currect u1 weight
                    itemslist.remove(i); //Removes the item since its now on board
                    i=-1; //Since the itemslist size changes, this is so the for loop can start from 0 all over again
                }


            }
            u1list.add(u1); //This is where the rocket is added to the list

        }


        return u1list;
    }

    public ArrayList loadU2(ArrayList<Item> itemslist)
    {

        ArrayList<U2> u1list = new ArrayList<>(); //This is where the rockets will be stored

        while(!itemslist.isEmpty()) //As long as the list contains something, this will run
        {
            U2 u2 = new U2(); //The new rocket

            for (int i=0; i<(itemslist.size());i++)
            {

                if (u2.canCarry(itemslist.get(i)) && !itemslist.isEmpty() ) //Checks if the rocket can carry the item
                {
                    u2.carry(itemslist.get(i)); //Adds the item's weight into the current u1 weight
                    itemslist.remove(i); //Removes the item since its now on board
                    i=-1; //Since the itemslist size changes, this is so the for loop can start from 0 all over again
                }


            }
            u1list.add(u2); //This is where the rocket is added to the list

        }



        return u1list;
    }

    public double runSimulation(ArrayList<Rocket> rockets)
    {
        double cost=0.0;
        int succes=0;
        int failures=0;
        while(!rockets.isEmpty()) {
            for (int i=0;i<rockets.size();i++)
            {
                if (rockets.get(i).launch()) //if the launch is successful
                {
                    if(rockets.get(i).land()) //if the landing is also successful
                    {
                        cost+= rockets.get(i).cost; //Stores the successful rocket's cost
                        rockets.remove(rockets.get(i)); //Gets rid of the rocket
                        succes+=1;
                    }
                    else //in case the landing fails
                    {
                        cost+=rockets.get(i).cost; //Stores the exploded rocket's cost
                        failures+=1;
                    }

                }
                else //in case the launching fails
                {
                    cost+=rockets.get(i).cost; //Stores the exploded rocket's cost
                    failures+=1;
                }
            }
        }
        System.out.println("Success: " + succes + "\nFailures: " + failures + "\nCost: " + cost);
        return cost;
    }


}
