public class U2 extends Rocket {

    U2()
    {
        this.cost = 120.00;
        this.weight = 18000.0;
        this.maxweight = 29000.0;
        this.cLaunchExp = 0.04;
        this.cLandingcrash = 0.08;
    }

    public boolean launch()
    {

        double chance = (this.cLaunchExp * 100 * (this.weight/this.maxweight)); //Chance of exploding on launch
        int rdnnumber =(int) (Math.random()*100 ) + 1; //random number


        if(rdnnumber<=chance) //chance of this being true depends on the value of the "chance" variable
        {
            System.out.println("Exploded");
            return false; //crashed

        }
        else
        {
            System.out.println("Success");
            return true; //Success
        }

    }

    public boolean land()
    {
        double chance = (this.cLandingcrash * 100 * (this.weight/this.maxweight)); //Chance of crashing on landing
        int rdnnumber =(int) (Math.random()*100 ) + 1; //random number

        if(rdnnumber<=chance) //chance of this being true depends on the value of the "chance" variable
        {
            System.out.println("Crashed");
            return false; //crashed

        }
        else
        {
            System.out.println("Success");
            return true; //Success
        }
    }

}
