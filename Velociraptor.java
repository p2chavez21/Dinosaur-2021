

/**
 * Write a description of class Velociraptor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Velociraptor extends Dinosaur
{
    private int numEaten;

    /**
     * Constructor for objects of class TRex
     */
    public Velociraptor()
    {
        super("Velociraptor"); //super() must me be first line of constructor
        this.numEaten = 0;
    }
    
    public boolean attack(Dinosaur other)
    {
        //code this method such that if other is a Trex, this wins 50%
        //if velo, this wins 60%, if bronta, this wins 75%
        int rand = (int)(Math.random()*101);
        int weight = rand*(int)this.getBattleFactor(other);
        boolean result = false;
        if(other.getType().equals("Velociraptor"))
        {
            if(Math.random()>0.75)
            {
                result = true;
            }
        }
        else if(other.getType().equals("TRex"))
        {
            if(Math.random()>0.5)
            {
                result = true;
            }
        }
        else if(other.getType().equals("Tricerotop"))
        {
            if(Math.random()>0.25)
                {
                result = true;
            }
        }
        return result;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        if(this.getAge() == 0)
        {
            return super.toString(); //super. calls as a method of parent class
        }
        else 
        {
            return this.getType() + " " + this.getbattleCount();
        }
    }
}
