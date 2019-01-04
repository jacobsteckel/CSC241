//jake steckel
//assignment 2

import java.util.Scanner;
public class CashiersTest
{
   public static void main(String[] args) throws StringIndexOutOfBoundsException 
   {
      Cashiers c = new Cashiers();
      String inputLength;
      int end = 1; 
      char input;  
      c.display();
      
      for(int i=0; i<end; i++)
      {
         Scanner one = new Scanner(System.in);
         System.out.println("Input command: F(fill) -- E(enqueue)");
         System.out.println("1,2,3(dequeue) -- C(clear) -- Q(quit)");
         inputLength = one.nextLine(); 
         
         try 
         {
            input = inputLength.charAt(0);
         }
         catch(StringIndexOutOfBoundsException e) 
         {
            System.out.println("Invalid Input");
            end++;
            c.display();
            continue;
         }
                         
         System.out.println();
         
         if(Character.isLowerCase(input))                                           
         {                                
            input = Character.toUpperCase(input);
         }

         if(inputLength.length() > 1)
         {
            System.out.println("Invalid Input");
            end++;
            c.display();
            continue;
         }
         
         if(input=='F')
         { 
            c.fill();
         }
         
         else if(input=='E')
         {   
            c.enqueue();
         }
                  
         else if(input=='1')
         { 
            c.dequeue(0);
         }
         
         else if(input=='2')
         { 
            c.dequeue(1);
         }
         
         else if(input=='3')
         {
            c.dequeue(2);
         }
                  
         else if(input=='C')
         {
            c.clear();
         }
         
         else if(input=='Q')
         { 
            System.out.println("Ended Program");
            System.exit(0);
         }
         
         else
         {
            System.out.println("Invalid Input");
         }
         c.display(); 
         end++; 
     }   
   }
}
