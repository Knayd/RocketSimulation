public class Rocket implements SpaceShip {

    double cost,weight,maxweight;
    double cLaunchExp;
    double cLandingcrash;

    public boolean launch()
    {
        return true;
    }
    public boolean land()
    {
        return true;
    }

    public boolean canCarry(Item item)
    {

        if((item.weight+this.weight)<=this.maxweight)
        {
            return true;
        }
        else
        {
            return false;
        }


    }
    public void carry(Item item)
    {
        this.weight+=item.weight;
    }

}
