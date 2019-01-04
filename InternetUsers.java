//Jake Steckel
//CSC241-03
//Assignment 3

import java.io.*;
import java.util.*;
public class InternetUsers
{
  
   public static void main(String[] args) throws FileNotFoundException
   {
      File file = new File("CountrySortedAlpha.txt");
      Scanner inputFile = new Scanner(file);     
      String[] country = new String[201];
      int[] userPercent = new int[201];
      Integer[] percent = new Integer[201]; 
      
      inputFromFile(country, userPercent);  
      inputFile.close();                    
      
      for(int i=0; i < 201; i++)
      {
         percent[i] = userPercent[i];     
      }
      
      System.out.println();
      System.out.println();
      System.out.println("        SHELL SORT         ");
      System.out.println();
      
      shellSort(percent, country);
      
      for(int i=200; i >= 0; i--)  
      {
         if(percent[i] > 9)
         {
            System.out.println(country[i] + percent[i]);
         }
         else
         {
            System.out.println(country[i] + " " + percent[i]);
         }   
      }
      
      for(int i=0; i<201; i++) //Keep percent arrays equal
      {
         userPercent[i] = percent[i];     
      }
      
      System.out.println();
      System.out.println();
      System.out.println("               HASH TABLE             ");
      System.out.println();
      
      hashing(country, userPercent); //Display hash method (includes search)
           
   }

   
   public static void inputFromFile(String[] country, int[] userPercent) throws FileNotFoundException
   {
      File file = new File("CountrySortedAlpha.txt");
      Scanner inputFile = new Scanner(file);
      
      for(int i=0; i<201; i++)
      {
         String fileNextLine = inputFile.nextLine();
         
         country[i] = fileNextLine.substring(0, 26); 
         
         String percentIndex;
         
         char check = fileNextLine.substring(27, 28).charAt(0);;
        
         if(Character.isDigit(check)) 
         {
            percentIndex = fileNextLine.substring(27, 29); 
            userPercent[i] = Integer.parseInt(percentIndex);
            System.out.println(country[i] + userPercent[i]); 
         }
         else  
         {
            percentIndex = fileNextLine.substring(28, 29);
            userPercent[i] = Integer.parseInt(percentIndex);
            System.out.println(country[i] +  " " + userPercent[i]);
         }  
         
      }
   }
   
   public static <Integer extends Comparable<? super Integer>> void shellSort(Integer[] userPercent, String[] country)
	{
      int j;
      
	   for(int gap = userPercent.length / 2; gap > 0; gap /= 2) //altered shell sort from book
	   {                                                        
	     for(int i = gap; i < userPercent.length; i++)
	     {
	        Integer temp = userPercent[i];
           String t = country[i];
           
	        for(j = i; j >= gap && temp.compareTo(userPercent[j - gap]) < 0; j -= gap)
	        {
	          userPercent[j] = userPercent[j - gap];
             country[j] = country[j - gap];
	        }
           
	        userPercent[j] = temp;
           country[j] = t;
           
	     }
	   }
	}
   
   public static void hashing(String[] country, int[] userPercent)
   {
      String[] hashTable = new String[251];
      int[] percentage = new int[251];
      String[] countryTrim = new String[country.length]; 
      
   
      for(int i=200; i>=0; i--)
      {       
         countryTrim[i] = country[i].trim();    
         int hashValue = 0;
         for(int j=0; j<countryTrim[i].length(); j++)
         {
            char c = countryTrim[i].charAt(j);
            hashValue += (int) c;               
         }
         
         hashValue = hashValue % 250;
         
         for(int p=0; p<250; p++)
         {
            if(hashTable[hashValue] == null && hashValue < 250) 
            {
               hashTable[hashValue] = country[i];
               percentage[hashValue] = userPercent[i];
               System.out.println(hashTable[hashValue] + " " + percentage[hashValue] + " hash to: " + hashValue); 
               hashTable[hashValue] = countryTrim[i];
               break;
            }
            else if(hashTable[hashValue] != null && hashValue < 250) 
            {      
               hashValue++;
               continue;
            }
            else                                               
            {
               hashValue = 0; 
               continue;
            }
         }        
            
      } 
      
      System.out.println();
      String input = " ";
      Scanner one = new Scanner(System.in);
      
      while(!input.equals("-1")) 
      {
         System.out.println();
         System.out.println("Type name of country to find (case sensitive), type '-1' when done \n");
         input = one.nextLine();
         
         if(input.equals("-1")) 
         {
            System.out.println("Program ended");
            System.exit(0);
         }
               
         int hashValue = 0;
         for(int j=0; j<input.length(); j++) 
         {  
            char c = input.charAt(j);
            hashValue += (int) c;   
         }
            
         hashValue = hashValue % 250;            
        
         if(hashTable[hashValue] == null) 
         {
            System.out.println("Country not found");
         }
         else if(hashTable[hashValue] != null)
         {
            while(hashTable[hashValue] != null)
            {
               if(hashTable[hashValue].equals(input))  
               {
                  System.out.println(hashValue + ":  " + hashTable[hashValue] + "\t\t\t\t" + percentage[hashValue]);
                  break;
               }
   
               if(hashTable[hashValue+1] == null && hashValue < 249) 
               {
                  System.out.println("Country not found!");
                  break;
               }
               else if(hashValue == 249 && hashTable[0] == null) 
               {
                  System.out.println("Country not found!");
                  break;
               }
                  
               System.out.println(hashValue + ":  " + hashTable[hashValue]);
               if(hashValue == 249)
               {
                  hashValue = 0;
               }
               else
               {
                  hashValue++;
               }
            }
         }                      
      }                
   }  
}