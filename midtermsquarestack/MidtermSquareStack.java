
package midtermsquarestack;

public class MidtermSquareStack {

    public static void main(String[] args) {
        //construct a 5 x 5 square
        Square sq = new Square(5);
        sq.display();
        //fill the square from 1 to 25 and 26 (one too many) - and display square
        for (int i=1;i<27;i++) sq.push(i);
        sq.display(); 
        //pop 5 entries & display square
        for (int j=1;j<6;j++)
            System.out.println("pop = "+sq.pop());
        sq.display();
        //pop 21 entries - one too many - and display square
        for (int j=1;j<22;j++)
            System.out.println("pop = "+sq.pop());
        sq.display();
         
    }
    
}
