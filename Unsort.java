//Jake Steckel
//CSC241-03
//Assignment 3

import java.io.*;
import java.util.*;
import java.util.Random;

public class Unsort
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner input = new Scanner(new File("E:\\csc241\\CountrySortedAlpha.txt"));  
      PrintWriter output = new PrintWriter("E:\\csc241\\Unsorted.txt");
      String[] arr = new String[201];
      
      Random random = new Random();
      int sz = 201;
      
      for(int i=0; i<201; i++)
      {
         input.hasNextLine();
         arr[i]=input.nextLine();
         System.out.println(arr[i]);
      }
      
      do
      {
         for(int p=0; p<201; p++)
         {
            int rand = random.nextInt(201);
            
            if(p == rand && arr[p]!= null)
            {
               output.println(arr[p]);
               arr[p]= null;
               sz--;
            }
            
         }
      } while(sz != 0);
            
      System.out.println("New Unsorted File Created");
      output.close();
   }
}