//jake steckel
//csc241-01
//assignment 2

public class Cashiers
{
   private int custNum = 1;
   private int[][] qArray = new int[3][6];
   private int[] size = new int[3];
   private int[] front = new int[3];
   private int[] back = new int[3];

   public Cashiers() //constructor
   {
      for(int i=0; i<front.length; i++)
      {
         front[i] = 0;
         back[i] = 0;
         size[i] = 0;
      }
   }

   public void clear() //clears array
   {
      for(int i=0; i<qArray.length; i++)
      {
         for(int j=0; j<qArray[0].length; j++)
         {
            qArray[i][j] = 0;
         }
         
         front[i] = 0;
         back[i] = 0;
         size[i] = 0;
      } 
      System.out.println("Cleared!");  
   }

   public void fill()//fills array
   {
      for(int i=0; i<qArray.length; i++)
      {
         for(int j=0; j<qArray[0].length; j++)
         {
            qArray[i][j] = 0;
         }
         
         front[i] = 0;
         back[i] = 0;
         size[i] = 0;
      }
      for(int i=0; i<qArray.length; i++)
      {
         for(int j=0; j<qArray[0].length; j++)
         {
            qArray[i][j] = custNum; 
            custNum++;
         }
         front[i] = 0;
         back[i] = 5; 
         size[i] = 6; 
      }    
      System.out.println("Filled!");
   }

   public void display() //Displays array
   {
      
      for(int i=0; i<qArray.length; i++)
      {
         for(int j=0; j<qArray[0].length; j++)
         {
            String frontString = qArray[i][j] + "F"; //Add "F" to front of the queue
            String backString = qArray[i][j] + "B"; //Add "B" to back of the queue
            
            String[][] strQueueArr = new String[3][6]; 
            
            for(int h=0; h<qArray.length; h++)
            {
               for(int p=0; p<qArray[0].length; p++)
               {
                  String contents = Integer.toString(qArray[h][p]);
                  strQueueArr[h][p] = contents;                   
               }
            }
                     
            if(strQueueArr[i][j] == strQueueArr[i][front[i]] && strQueueArr[i][j] == strQueueArr[i][back[i]])
            {
               strQueueArr[i][j] = frontString + "B";     
               System.out.print(strQueueArr[i][j] + "\t");
            }
             
            else if(strQueueArr[i][j] == strQueueArr[i][front[i]])
            {
               strQueueArr[i][j] = frontString;
               System.out.print(strQueueArr[i][j] + " \t");
            }
            else if(strQueueArr[i][j] == strQueueArr[i][back[i]])
            {
               strQueueArr[i][j] = backString;  
               System.out.print(strQueueArr[i][j] + " \t");
            }
            else
            {
               System.out.print(strQueueArr[i][j] + "\t\t");
            }
         }
         System.out.println();
      }
   }

   public int dequeue(int value)//deletes customer
   { 
      int delete = 0; 
      
      if(size[value] == 0) 
      {
         System.out.println("This queue is already empty!");  
         return 0;
      }
      
      if(size[value] == 1)
      {
         size[value]--; 
         qArray[value][front[value]] = 0;
         delete = qArray[0][front[0]];
      }
         
      
      if(value == 0 && size[0] > 1)
      {
         size[0]--; 
         qArray[0][front[0]] = 0;
         delete = qArray[0][front[0]];
      
         if(front[0] == 5) 
         {
            front[0] = 0;
         }
         else 
         {
            front[0]++;
         } 
      }
      
      if(value == 1 && size[1] > 1)
      {
         size[1]--; 
         qArray[1][front[1]] = 0;
         delete = qArray[1][front[1]];
      
         if(front[1] == 5)
         {
            front[1] = 0;
         }
         else 
         {
            front[1]++;
         } 
      }
       
      if(value == 2 && size[2] > 1)
      {
         size[2]--;
         qArray[2][front[2]] = 0;
         delete = qArray[2][front[2]];
      
         if(front[2] == 5)
         {
            front[2] = 0;
         }
         else 
         {
            front[2]++;
         } 
      }
      return delete;
   }

   public boolean enqueue()//adds new customer
   {
      boolean end = false;
      
      if(size[0] == 6 && size[1] == 6 && size[2] == 6)
      {
         System.out.println("The queue is full!");
         return true;
      }
      
      else if(size[0] == 0) 
      {
         qArray[0][back[0]] = custNum; 
         size[0]++; 
         custNum++; 
      }
      
      else if(size[1] == 0)
      {
         qArray[1][back[1]] = custNum;
         size[1]++;
         custNum++;
      }
      
      else if(size[2] == 0)
      {
         qArray[2][back[2]] = custNum;
         size[2]++;
         custNum++;
      }

      else if(size[0] <= size[1] && size[0] <= size[2]) 
      {
         
         if(back[0] == 5){ 
            back[0] = 0;
         }
         else
         {
            back[0]++;
         }
         size[0]++;       
         qArray[0][back[0]] = custNum;
         custNum++;
            
         end = true;
      }

      else if(size[1] < size[0] && size[1] <= size[2]) 
      {
         if(back[1] == 5)
         { 
            back[1] = 0;
         }
         else
         {
            back[1]++;
         }
         size[1]++;
         qArray[1][back[1]] = custNum;
         custNum++;
            
         end = true;
      }
      
      else if(size[2] < size[0] && size[2] < size[1]) 
      {
         if(back[2] == 5){ 
            back[2] = 0;
         }
         else
         {
            back[2]++;
         }
         size[2]++;
         qArray[2][back[2]] = custNum;
         custNum++;
            
         end = true;         
      }
      return end;
   }
}


