import java.util.ArrayList;

public class DinoDriver2
{
    public static void  main(String[] args)
    {
        //Dinosaur[] pop = new Dinosaur[25];
        ArrayList<Dinosaur> dinoPop = new ArrayList<Dinosaur>();

        for(int i=0; i<30; i++)
        {
            double rand = Math.random();
            if(rand<0.33) //make TRex
            {
                Dinosaur t = new TRex();
                dinoPop.add(t);
            }
            else if(rand <0.67) //make a Velociraptor
            {
                dinoPop.add(1, new Velociraptor());
            }
            else //make a Tricerotop
            {
                Dinosaur tr = new Tricerotop();
                dinoPop.add(tr);
            }
        }
        /*
        for (int i=0; i<pop.length; i++)
        {
        // double rand = Math.random();
        // if(rand < 0.33)
        // {
        pop[i] = new TRex();
        // }
        // else if(rand < 0.67)
        // {
        // pop[i] = new Velociraptor();
        // }
        // else
        // {
        // pop[i] = new Tricerotop();
        // }
        
        System.out.println(pop[i]);
        }
         */
        DinoDriver2.growUp(dinoPop);
        for (int i=0; i<9; i++)
        {
            System.out.println("########### Round " +(i-1) + "#########");
            //DinoDriver2.battleRound(pop);
        }

        //output my population
        for(Dinosaur d : dinoPop)//d gets assigned to pop[i];
        {
            // int rand = (int)(Math.random()*pop.length);
            // if(pop[i].attack(pop[rand]))
            //if (d.getHealth()>0)
            System.out.println(d);

        }

    }

    private static void battleRound(ArrayList<Dinosaur> p)
    {
        //modify this code to call the update method with the correct
        //dinos winning and losing
        //System.out.println(p[0].attack(p[1]));

        int attWins = 0;
        int battles = 0;
        //traverse the array, and have all dino battle one other dino
        for( Dinosaur d : p)
        {
            if(d.getHealth()>0)
            {
                int rand = (int)(Math.random()*p.size());

                //write if statement that tests if def is dead OR
                //d is the same as the attacking dino
                //Def cannot be attacking dino NOR dead 

                do
                {
                    rand=(int)(Math.random()*p.size());
                }
                while(p.get(rand).getHealth()==0||p.get(rand)==d);

                // System.out.print("Getting different defender");
                // if(p[rand]==d)
                // {
                // System.out.println("Def is attacker.");

                // }
                // else
                // {
                // System.out.println("Def is dead.");
                // }

                battles++;
                //boolean attackerWon = p[0].attack(p[1]);
                if (d.attack(p.get(rand)))
                {
                    d.update(p.get(rand));
                    attWins++;
                }
                else
                {
                    p.get(rand).update(d);
                }
            }
        }
        //round is over
        //tweak this so we don't choose dead dino
    }
    //System.out.println("****Total Battles" +battles+" & attacker wins"+attWins);


    private static void growUp(ArrayList<Dinosaur> p) //d = t1 they aliases
    {
        int rand =(int)(Math.random()*35);
        //d.setbattleCount(rand);
        for(int i=0; i<rand; i++)
        {
            //p.ageUp();
        }
    }
}

