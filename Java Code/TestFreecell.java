/**
 * The TestFreecell class is used tp test the freecell
 * 
 * @Author: Chang Kai Boon
 * 
 */
import java.util.*;


public class TestFreecell{
    static Scanner input = new Scanner(System.in);
    /**
     * Rstart method restart the game
     */
    public static void restart() {
        clearScreen();
        Freecell newCell = new Freecell();
        newCell.assignment();
        newCell.printAll();
        do {
            System.out.print("1. Enter x to EXIT ,Press Enter to continue: ");
            String varX = input.nextLine();
            if(varX.equals("x") || varX.equals("X")){
                System.out.println("========================");
                System.out.println("Exit The Program!");
                System.out.println("========================");
                System.exit(0);
            }
            System.out.print("2. Enter r to RESTART ,Press Enter to continue: ");
            String varR = input.nextLine();
            if(varR.equals("r") || varR.equals("R")){
                restart();
            }
            System.out.println("==================================");
            newCell.getFirst();
            newCell.getElement();
            newCell.getLast();                               
            newCell.movePile();
            newCell.MakeSelection();
            newCell.checkCommand();
            newCell.checkColumn();
            newCell.printAll();
        }while(true);
    }

    /**
     * clearScreen method help to clearScreen every one cycle
     */
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /**
     * main function of the freecell program
     * @param args
     */
    public static void main(String[] args) {

        Freecell freecell = new Freecell();
        freecell.assignment();
        freecell.printAll();
        do{
            System.out.print("1. Enter x to EXIT ,Press Enter to continue: ");
            String varX = input.nextLine();
            if(varX.equals("x") || varX.equals("X")){
                System.out.println("========================");
                System.out.println("Exit The Program!");
                System.out.println("========================");
                System.exit(0);
            }
            System.out.print("2. Enter r to RESTART ,Press Enter to continue: ");
            String varR = input.nextLine();
            if(varR.equals("r") || varR.equals("R")){
                restart();
            } 
            System.out.println("==================================");
            freecell.getFirst();
            freecell.getElement();
            freecell.getLast();                               
            freecell.movePile();
            freecell.MakeSelection(); 
            freecell.checkCommand();
            freecell.checkColumn();
            freecell.printAll();
        }while(true);

    }
}
