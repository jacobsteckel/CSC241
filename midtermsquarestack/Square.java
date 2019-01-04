//jake steckel
//csc241
//midterm

package midtermsquarestack;

public class Square 
{
    //square shaped stack
    private int size=0;    //the size of the edges, not the total number of entries
    private int[][] s = new int[5][5];
    private int row,col; //location of last entry - the top of the stack
    private int timesLooped=0;
 
    public Square(int n)
    {//constructor
       //n is the size
       size = n;
       for(int i=0; i < 5; i++)
       {
         for(int j=0; j < 5; j++)
         {
            s[i][j] = 0;
         }
       }
       //fill with all 0's

       //initialize row and column (like initializing top=-1 in linear stack
       row=0; col=-1;        
    }
    public void display()
    {
        for(int i = 0; i < 5; i++)
        {
           for(int j=0; j<5; j++)
              if(s[i][j] > 9)
              {
                 System.out.print(s[i][j] + "   ");
              }
              else
              {
                 System.out.print(s[i][j] + "    ");
                
              }
              System.out.println();   
        }
        
        System.out.println("Corner Sum: " +cornerSum() + "\t    Edge Sum: " + edgeSum());
        System.out.println("Diagonal Sum: " +diagonalSum() + "\t Square Sum: " + squareSum());
              
        //formatted display with 4 spaces for each entry

        //display the results of the 4 calculation methods
    }
    public boolean push(int newInt)
    {
        if(s.length > 25)
        {
           System.out.println("Square is full");
           return false;
        }
        
        else
        {
           for(int i = s.length-1; i>=0; i--)
           {
               for(int j=s[0].length-1; j>=0; j--)
               {
                  s[i][j] = newInt-1;
                  newInt--;
               }
           }           
        } 
        return true;  
        
    //return false and display "Square is full" if full
    //push across the first row, then the second row, etc. 
    }
    
    public int pop()
    {
        int p;
        if(size>0)
        {
            for(int i = s.length-1; i>=0; i--)
            {
               for(int j=s[0].length-1; j>=0; j--)
               {
                    p = s[i][j]-timesLooped;
                    return p;
               }
            }
            size--;
            timesLooped++;
        }
        else
        {
            System.out.println("Square is empty");
            return -1;
        }
        return 0;
    //pop the last entry pushed or display "Square is empty" and return -1 if empty
    }
    
    //4 calculation methods
    public int cornerSum()
    {
        int cornerSum = 0;
        
        for(int i=0; i < 5; i++)
        {
           for(int j=0; j<5; j++)
           {
              cornerSum = s[0][0] + s[0][s.length-1] + s[s.length-1][0] + s[s.length-1][s.length-1];
           }
        }
        return cornerSum;
        //all 4 corners
    }
    
    public int edgeSum()
    {
        int edgeSum = 0;
        
        for(int i = 0; i < s.length; i ++) 
        {
            for(int j = 0; j < s[i].length; j++) 
            {
                if(i == 0 || i == s.length - 1) 
                {
                    edgeSum += s[i][j];
                }
                else {
                    edgeSum += s[i][s[i].length - 1 ] + s[i][0];
                    break;
                }
            }
        }
        return edgeSum;
        //all 4 edges, including the corners
    }
    
    public int diagonalSum()
    {
        //both diagonals: NW to SE and SW to NE
        int diagonalSum = 0;
        int index = 0;
        
        for(int i=0; i<5; i++)
        {
           diagonalSum += s[i][i];
        }
        for(int j=4; j>=0; j--)
        {
           diagonalSum += s[index][j];
           index++;  
        }
        diagonalSum -= s[index/2][index/2];
        return diagonalSum;
    }
    public int squareSum()
    {
        int squareSum=0;
    
        for(int i=0; i<5; i++)
        {
           for(int j=0; j<5; j++)
           {
              squareSum += s[i][j];
           }
        }
        return squareSum;     
        //all entries
    }
}
