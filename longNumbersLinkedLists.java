//Jake Steckel
//CSC241-01
//Assignment 1

import java.util.*;

public class longNumbersLinkedLists
{
   public static void main(String[] args)
   {
      Scanner stdIn = new Scanner(System.in);
      String longNumber;
      LinkedList mainList = new LinkedList();
      LinkedList sumList = new LinkedList();
      LinkedList temp = null;
      //declare other variables
      int sum = 0;
      int carry= 0;
      int maxWidth = 0;
      //repeatedly input longNumbers, using -1 to indicate that you are done
      System.out.println("Enter a Number: (enter -1 after last #)");
      longNumber = stdIn.nextLine();
      while(!longNumber.equals("-1"))
      {
        //add a new LinkedList at the beginning of the mainList
        mainList.addFirst(new LinkedList());
        //use get(0) to set temp to be this new LinkedList
        temp = (LinkedList) mainList.get(0);
        //for each character in your longNumber, subtract 48 to get the digit and then add it
        //at the beginning of temp
        for (int i = 0; i < longNumber.length(); i++)
        {
            temp.addFirst((int)(longNumber.charAt(i)-48));        
        }
        //keep track of maxWidth, the number of digits of the widest longNumber input so far
        if(maxWidth < longNumber.length())
        {
            maxWidth=longNumber.length();
        }
        System.out.println("Enter a Number: ");
        longNumber = stdIn.nextLine();
      }
      //initialize carry to be 0
      carry=0;
      //make maxWidth passes
      for(int i = 0; i < maxWidth; i++)
      {
        sum=0;
        //in each pass, loop through all of the LinkedLists in mainList
        for(int j = 0; j < mainList.size(); j++)
        {
            //for each one, let temp be the Linked List for one longNumber
            temp=(LinkedList)mainList.get(j);
            if(temp.size() > 0)
            {
               //if temp is not empty, remove its first entry and add to the sum
               sum += (int)temp.removeFirst();
            }
       }
       //add sum%10 at the beginning of sumList
       //set carry equal to sum/10 (integer division)
       sumList.addFirst((sum+carry)%10);
       carry = (sum + carry) / 10;
     }
     //Now ready for output
     //if carry at the end of processing is not 0, print it and stay on the same line
     if(carry != 0)
     {
         System.out.print(carry);
     }
     for(int i = sumList.size(); i > 0; i--)
     {
         //repeatedly remove one digit from the beginning of sumList until all have been removed
         //for each, add a 48 to get a character and print it out on the same line
         System.out.print((char)((int)sumList.removeFirst()+48));
     }
     //remove the digits from sumList until empty
     sumList.clear();
   }//end main
}//end class
