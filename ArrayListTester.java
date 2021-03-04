import java.util.ArrayList;

public class ArrayListTester
{
    //you can only put objects in ArrayList
    //List is an interface and ArrayList implements that interface

    public static void main(String[] args)
    {
        ArrayList <Integer> myList = new ArrayList<Integer>();
        System.out.println(myList.size());

        /**
        list.length //length of an array
        word.length() //length of a string
        length.size() //length of an ArrayList
         **/

        //Write code that adds 25 random Integer objects to myList.
        //Random number between 1 and 100 inclusive
        for(int i=0; i<25; i++)
        {
            int rand = (int)(Math.random()*100)+1;
            Integer integ = new Integer(rand);
            myList.add(integ);
        }
        //System.out.println(myList.size()+"\n\n");
        
        System.out.println("#######Before#######");
        for(Integer x:myList)
        {
            System.out.println(x);
        }
        //output original array list filled with objects
        //traverse the arrayList and remove any object multiple of 5
        //output the new arrayList
        
        for(int i=0; i<myList.size(); i++)
        {
            Integer temp = myList.get(i);
            int nextValue = temp.intValue();
            //auto boxing is when you're using wrapper class;
            //making objects out of primitive
            if(nextValue%5==0)
            {
                System.out.println("\t"+i);
                myList.remove(i);
                i--; //to not go out of bounds
            }
        }
        
            
        //System.out.println(myList.get(0));
    }
}
