

/**
 * Write a description of class TRex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TRex extends Dinosaur
{
    private int numEaten;

    /**
     * Constructor for objects of class TRex
     */
    public TRex()
    {
        super("TRex"); //super() must me be first line of constructor
        this.numEaten = 0;
    }
    
    public boolean attack(Dinosaur other)
    {
        //code this method such that if other is a Trex, this wins 50%
        //if velo, this wins 60%, if bronta, this wins 75%
        int myRand = (int)(Math.random()*40)+60;
        int otherRand;
        int myWeighting;
        int otherWeighting;
        double temp;
        
        if(other.getType().equals("TRex"))
        {
            otherRand = (int)(Math.random()*40)+55;
        }
        else if(other.getType().equals("Velociraptor"))
        {
            otherRand = (int)(Math.random()*40)+45;
        }
        else if(other.getType().equals("Tricerotop"))
        {
            otherRand = (int)(Math.random()*40)+40;
        }
        else
        {
            otherRand = (int)(Math.random()*50);
        }
        
        temp = myRand *this.getBattleFactor(other)+0.5;
        myWeighting = (int)(temp);
        temp = otherRand*other.getBattleFactor(this)+0.5;
        otherWeighting = (int) (temp);
        
        if(myWeighting-otherWeighting > -1)
        {
            this.update(other);
            return true;
        }
        else
        {
            other.update(this);
            return false;
        }
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
