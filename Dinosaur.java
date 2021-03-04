
/**
 * Write a description of class Dinosaur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Dinosaur
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private int g;
    private String gender;
    private int health; //1-100
    private int battleCount;
    private int win;
    private static int population;

    /**
     * Default constructor for objects of class Dinosaur
     */
    public Dinosaur()
    {
        type = "Dino";
        age = 0;
        g = (int)(Math.random()*10);
        if (g<5)
        {
            this.gender = "female";
        }
        else
        {
            this.gender = "male";
        }
        this.health=10;
    }

    /**
     * Explict constructor for Dino Class
     */
    public Dinosaur(String t)
    {
        this.type = t; //so it's not alias 
        this.age = 0;
        this.health = 10;
        g = (int)(Math.random()*10);
        if (g<5)
        {
            this.gender = "female";
        }
        else
        {
            this.gender = "male";
        }
    }

    /******* Getters *******/
    // Getters return private data
    public String getType()
    {
        return this.type;

    }
    
    public static int getPopulation()
    {
        return Dinosaur.population;
    }
    
    public int getAge()
    {
        return this.age;

    }

    public String getGender()
    {
        return this.gender;
    }

    public int getHealth()
    {
        return this.health;
    }

    public int getbattleCount()
    {
        return this.battleCount;
    }  

    public int getWin()
    {
        return this.win;
    }

    /******** Setters ********/
    public void setType(String t)
    {
        this.type = t; //no return
    }
    
    public static void setPopulation(int p)
    {
        Dinosaur.population = p;
    }
    
    public void setAge(int a)
    {
        this.age = a;
    }

    public void setHealth(int h)
    {
        this.health = h;
    }

    public void setGender(String g)
    {
        this.gender = g;
    }

    public void setbattleCount(int bc)
    {
        this.battleCount = 0;
    }

    public void setWin(int w)
    {
        this.win = 0;
    }

    public boolean equals(Dinosaur d) //has to pass an object
    {
        if(this.type.equals(d.getType()))
        {
            if(this.age == d.getAge())
            {
                if(this.health == d.getHealth())
                {
                    if(this.gender.equals(d.getGender()))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void ageUp()
    {
        if(this.health > 0)
        {
            this.age++;

            //if age is less than 10, health incrases by 10
            if(this.age < 10)
            {
                this.health = this.health + 10;
            }        
            //no change to health if age is between 10-24

            //health decrease by 5 if age is 25-30
            else if (this.age >= 25 && this.age <= 30)
            {
                this.health-=5;
            }
            //if health decreases by 10 if age is greater than 30
            else
            {
                this.health-=10;
            }
        }  
    }

    public double getBattleFactor(Dinosaur other)
    {
        double answer = 0;
        double hFactor = (this.health/100.0)*0.67;
        double expFactor = (double)this.battleCount/(this.battleCount + other.getbattleCount());
        expFactor *= 0.33;
        
        if(this.battleCount + other.getbattleCount ()>0)
        {
            expFactor = (double)this.battleCount/(this.battleCount+other.getbattleCount());
            expFactor *= 0.33;
        }

        answer = hFactor + expFactor;
        return answer;
    }
    
    public void update(Dinosaur loser)
    {
        //reduce health of losing dino
        loser.setHealth(loser.getHealth()-10);
        this.setHealth(this.getHealth()-5);
        
        //Reset health to zero if health goes negative
        if(loser.getHealth()<=0)
        {
            loser.setHealth(0);
            //change population
            loser.setPopulation(loser.getPopulation()-1);
        }
        //increase wins for "this" dino
        this.win++;
        //increase battleCount for both
        this.battleCount++;
        //reduce health of winner by a little 
    }
    
    public abstract boolean attack (Dinosaur other);

    /**
     * return Dino as a string
     */
    public String toString()
    {
        String answer = this.type + " " + this.age + " " + this.health + " "+ this.gender;
        return answer;
    }
}
