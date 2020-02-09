/**
 * The Freecell class combine Card and OrderedStack together
 * 
 * @Author: Chang Kai Boon
 * 
 */

import java.util.*;

public class Freecell extends Card{

    //Four piles
    /**
     * 4 OrderedStack to represents 4 pile(Clubs,Diamonds,Hearts,Spades)
     */
    private OrderedStack<Card> pileC = new OrderedStack<>();
    private OrderedStack<Card> pileD = new OrderedStack<>();
    private OrderedStack<Card> pileH = new OrderedStack<>(); 
    private OrderedStack<Card> pileS = new OrderedStack<>();

    //Deck
    /**
     * ArrayList Deck represents 52 cards, will be added into columns randomly
     */
    private ArrayList<Card> Deck = new ArrayList<>(
        List.of(new Card("c","9"),new Card("d","5"), new Card("d","Q"), new Card("d","6")
        , new Card("c","7"), new Card("s","8"), new Card("h","Q"),new Card("s","5"), new Card("c","2")
        , new Card("s","7"), new Card("s","2"), new Card("c","Q"),new Card("c","5"), new Card("h","6")
        , new Card("s","J"), new Card("d","2"), new Card("h","X"),new Card("h","5"), new Card("c","A")
        , new Card("h","A"), new Card("d","K"), new Card("c","J"),new Card("c","X"), new Card("h","J")
        , new Card("c","4"), new Card("c","8"), new Card("d","9"),new Card("d","A"), new Card("h","7")
        , new Card("d","8"), new Card("s","3"), new Card("s","X"),new Card("h","2"), new Card("d","X")
        , new Card("s","6"), new Card("c","3"), new Card("s","9"),new Card("d","7"), new Card("d","J")
        , new Card("h","8"), new Card("s","A"), new Card("s","K"),new Card("h","K"), new Card("c","6")
        , new Card("s","4"), new Card("h","9"), new Card("d","3"),new Card("c","K"), new Card("s","Q")
        , new Card("h","4"),new Card("h","3"), new Card("d","4"))
    );

    //Nine columns
    /**
     * Card will be inserted into columns respectively
     */
    private ArrayList<Card> column1 = new ArrayList<>();
    private ArrayList<Card> column2 = new ArrayList<>();
    private ArrayList<Card> column3 = new ArrayList<>();
    private ArrayList<Card> column4 = new ArrayList<>();
    private ArrayList<Card> column5 = new ArrayList<>();
    private ArrayList<Card> column6 = new ArrayList<>();
    private ArrayList<Card> column7 = new ArrayList<>();
    private ArrayList<Card> column8 = new ArrayList<>();
    private ArrayList<Card> column9 = new ArrayList<>();
    
    
    private boolean pileStatus = false;
    private boolean columnStatus = false;
    private String first = "";
    private String element = "";
    private String last = "";
    private String a1,a2;
    private int index;
    private Card tempCard = new Card();

    Scanner input = new Scanner (System.in);
    
    /**
     * Insert the card from deck to columns respectively
     */
    public void assignment(){
        Collections.shuffle(Deck);
        for(int i=0; i< 7; i++){
            column1.add(Deck.get(i));
        }

        for(int i=7; i<13; i++){
            column2.add(Deck.get(i));
        }

        for(int i=13; i<20; i++){
            column3.add(Deck.get(i));
        }

        for (int i=20; i<26; i++){
            column4.add(Deck.get(i));
        }

        for (int i=26; i<33; i++){
            column5.add(Deck.get(i));
        }

        for (int i=33; i<39; i++){
            column6.add(Deck.get(i));
        }

        for(int i=39; i<46 ; i++){
            column7.add(Deck.get(i));
        }

        for(int i=46; i<52; i++){
            column8.add(Deck.get(i));
        }

    }

    /**
     * Random shuffle the columns after insert the cards 
     */
    public void randomShuffle(){
        Collections.shuffle(column1);
        Collections.shuffle(column2);
        Collections.shuffle(column3);
        Collections.shuffle(column4);
        Collections.shuffle(column5);
        Collections.shuffle(column6);
        Collections.shuffle(column7);
        Collections.shuffle(column8);
        Collections.shuffle(column9);
    }

    /**
     * Get the first user input
     */
    public void getFirst(){
        System.out.print("command > ");
        first = input.next();
    }

    /**
     * Get the second user input
     */
    public void getElement(){
        element = input.next();
        a1 = element.substring(0,1).toLowerCase();
        a2 = element.substring(1).toUpperCase();
        tempCard.updateValue(a1,a2);
        
    }

    /**
     * Get the third user input
     */
    public void getLast(){
        last = input.next();
        if(last.equals(first)){
            columnRotation();
        }
    }

    /**
     * Implements Column Rotation, the last element in the list move to first element
     */
    public void columnRotation(){
        switch(first){
            case "1": 
                column1.add(0,column1.remove(column1.size()-1));
                break;
            case "2":
                column2.add(0,column2.remove(column2.size()-1));
                break;
            case "3":
                column3.add(0,column3.remove(column3.size()-1));
                break;
            case "4":
                column4.add(0,column4.remove(column4.size()-1));
                break;
            case "5":
                column5.add(0,column5.remove(column5.size()-1));
                break;
            case "6":
                column6.add(0,column6.remove(column6.size()-1));
                break;
            case "7":
                column7.add(0,column7.remove(column7.size()-1));
                break;
            case "8":
                column8.add(0,column8.remove(column8.size()-1));
                break;
            case "9":
                column9.add(0,column9.remove(column9.size()-1));
                break;
        }

    }

    /**
     * Check user input
     */
    public void checkCommand(){
        if(!(first.equals("1") || first.equals("2") || first.equals("3") || first.equals("4") ||
            first.equals("5") || first.equals("6") || first.equals("7") || first.equals("8") || first.equals("9")
            || first.equals(" "))){
            System.out.println("===================================");
            System.out.println("Invalid command, Please Try Again");
            System.out.println("===================================");
        }
    }

    /**
     * Check whether the column can be inserted or not
     */
    public void checkColumn(){
        if (!(last.equals("1") || last.equals("2") || last.equals("3") || last.equals("4") || last.equals("5")||
            last.equals("6") || last.equals("7") || last.equals("8") || last.equals("9") || last.equals("c") || 
            last.equals("d") || last.equals("h") || last.equals("s") || last.equals(" "))){
            System.out.println("=============================================");
            System.out.println("Invalid column to Insert, Please Try Again");
            System.out.println("=============================================");
        }
    }

    /**
     * Show card not in the Column message
     */
    public void CardNotInColumn(){
        System.out.println("===============================");
        System.out.println("The Card not in the Column!");
        System.out.println("===============================");
    }

    /**
     * Show card not matched pile message
     */
    public void PileNotMatch(){
        System.out.println("============================================");
        System.out.println("The Card is not match to the Pile selected!");
        System.out.println("=============================================");
    }

    /**
     * Show wrong move message
     */
    public void wrongMove(){
        System.out.println("==================================================");
        System.out.println("Cannot move card because not follow game rules!");
        System.out.println("==================================================");
    }

    
    /**
     * Check user input card in the column or not
     * @param c user input card
     * @param al column of the card in
     */
    public void checkIndex(Card c, ArrayList<Card> al){
        for(int i = 0; i < al.size(); i++){
            if((al.get(i).getFace().equals(c.getFace())) && (al.get(i).getValue().equals(c.getValue()))){
                index = i;
                break;
            }
        }
    }

    /**
     * This card check whether the movement of card from column to pile match with the gamerule 
     * @param firstList column of the card in(Basically is the first user input)
     * @return Return true if follow gamerule else false
     */
    public boolean checkPile(ArrayList<Card> firstList){
        checkIndex(tempCard,firstList);

        if(tempCard.getValue().equals("A")){
            if(pileC.getSize()== 0 & tempCard.getFace().equals("c") && last.equals("c")){
                pileStatus = true;
            }else if (pileD.getSize()== 0 & tempCard.getFace().equals("d") && last.equals("d")){
                pileStatus = true;
            }else if (pileH.getSize()== 0 & tempCard.getFace().equals("h") && last.equals("h")){
                pileStatus = true;
            }else if (pileS.getSize()== 0 & tempCard.getFace().equals("s") && last.equals("s")){
                pileStatus = true;
            }else{
                wrongMove();
            }
        
        }else if(!"A".equals(tempCard.getValue())){
            String strC;
            String strD;
            String strH;
            String strS;

            if(last.equals("c")){
                if(pileC.getSize() == 0){
                    wrongMove();
                    return pileStatus = false;
                }else{
                    strC = pileC.peek().getValue();
                    if (tempCard.getValue().equals("2") && strC.equals("A") && tempCard.getFace().equals("c")){
                        pileStatus = true;
                    }else if(tempCard.getValue().equals("X") && strC.equals("9")&& tempCard.getFace().equals("c")){
                        pileStatus = true;
                    }else if(tempCard.getValue().equals("J") && strC.equals("X")&& tempCard.getFace().equals("c")){
                        pileStatus = true;
                    }else if (tempCard.getValue().equals("Q") && strC.equals("J")&& tempCard.getFace().equals("c")){
                        pileStatus = true;
                    }else if (tempCard.getValue().equals("K") && strC.equals("Q")&& tempCard.getFace().equals("c")){
                        pileStatus = true;
                    }else if (tempCard.getValue().compareTo(strC) == 1 && tempCard.getFace().equals("c")){
                        pileStatus = true;
                    }else{
                        wrongMove();
                        pileStatus = false;
                    }
                }
                
            }else if(last.equals("d")){  
                if(pileD.getSize() == 0){
                    wrongMove();
                    return pileStatus = false;
                }else{
                    strD = pileD.peek().getValue(); 
                    if (tempCard.getValue().equals("2") && strD.equals("A") && tempCard.getFace().equals("d")){
                        pileStatus = true;
                    }else if(tempCard.getValue().equals("X") && strD.equals("9")&& tempCard.getFace().equals("d")){
                        pileStatus = true;
                    }else if(tempCard.getValue().equals("J") && strD.equals("X")&& tempCard.getFace().equals("d")){
                        pileStatus = true;
                    }else if (tempCard.getValue().equals("Q") && strD.equals("J")&& tempCard.getFace().equals("d")){
                        pileStatus = true;
                    }else if (tempCard.getValue().equals("K") && strD.equals("Q")&& tempCard.getFace().equals("d")){
                        pileStatus = true;
                    }else if (tempCard.getValue().compareTo(strD) == 1 && tempCard.getFace().equals("d")){
                        pileStatus = true;
                    }else{
                        wrongMove();
                        pileStatus = false;
                    }
                }   
            }else if(last.equals("h")){
                if(pileH.getSize() == 0){
                    wrongMove();
                    return pileStatus = false;
                }else{
                    strH = pileH.peek().getValue();
                    System.out.println("Str H is: " + strH);
                    System.out.println("TempCard point: " + tempCard.getValue());
                    System.out.println("TempCard face: " + tempCard.getFace());
                    System.out.println(tempCard.getValue().compareTo(strH));
                    if (tempCard.getValue().equals("2") && strH.equals("A") && tempCard.getFace().equals("h")){
                        pileStatus = true;
                    }else if(tempCard.getValue().equals("X") && strH.equals("9")&& tempCard.getFace().equals("h")){
                        pileStatus = true;
                    }else if(tempCard.getValue().equals("J") && strH.equals("X")&& tempCard.getFace().equals("h")){
                        pileStatus = true;
                    }else if (tempCard.getValue().equals("Q") && strH.equals("J")&& tempCard.getFace().equals("h")){
                        pileStatus = true;
                    }else if (tempCard.getValue().equals("K") && strH.equals("Q")&& tempCard.getFace().equals("h")){
                        pileStatus = true;
                    }else if (tempCard.getValue().compareTo(strH) == 1 && tempCard.getFace().equals("h")){
                        pileStatus = true;
                    }else{
                        wrongMove();
                        pileStatus = false;
                    }
                }
            }else if(last.equals("s")){
                if(pileS.getSize() == 0){
                    wrongMove();
                    return pileStatus = false;
                }else{
                    strS = pileS.peek().getValue();
                    if (tempCard.getValue().equals("2") && strS.equals("A") && tempCard.getFace().equals("s")){
                        pileStatus = true;
                    }else if(tempCard.getValue().equals("X") && strS.equals("9")&& tempCard.getFace().equals("s")){
                        pileStatus = true;
                    }else if(tempCard.getValue().equals("J") && strS.equals("X")&& tempCard.getFace().equals("s")){
                        pileStatus = true;
                    }else if (tempCard.getValue().equals("Q") && strS.equals("J")&& tempCard.getFace().equals("s")){
                        pileStatus = true;
                    }else if (tempCard.getValue().equals("K") && strS.equals("Q")&& tempCard.getFace().equals("s")){
                        pileStatus = true;
                    }else if (tempCard.getValue().compareTo(strS) == 1 && tempCard.getFace().equals("s")){
                        pileStatus = true;
                    }else{
                        wrongMove();
                        pileStatus = false;
                    }
                }
                
            }
        }
        
            
        for(int i=index; i< firstList.size()-1; i++){
            pileStatus = false;
            Card firstInList = firstList.get(i);
            Card secondInList = firstList.get((i+1));
    
            String firstInListFront = firstInList.getFace();
            String secondInListFront = secondInList.getFace();
    
            String firstInListBack = firstInList.getValue();
            String secondInListBack = secondInList.getValue();

            if(firstInListBack.compareTo(secondInListBack) == -1 && firstInListFront.equals(secondInListFront) && firstInListFront.equals(last) && secondInListFront.equals(last)){
                pileStatus = true; // Compare last card is larger than move card by exactly one points
                continue;
            }else if(firstInListBack.compareTo(secondInListBack) > -32 && firstInListBack.compareTo(secondInListBack) < -30 && firstInListFront.equals(secondInListFront)&& firstInListFront.equals(last) && secondInListFront.equals(last)){
                pileStatus = true; //Compare X and 9
                continue;
            }else if (firstInListBack.compareTo(secondInListBack) > 5 && firstInListBack.compareTo(secondInListBack) < 7 && firstInListFront.equals(secondInListFront)&& firstInListFront.equals(last) && secondInListFront.equals(last)){
                pileStatus = true; //Compare K and Q
                continue;
            }else if (firstInListBack.compareTo(secondInListBack) > 13 && firstInListBack.compareTo(secondInListBack) < 16 && firstInListFront.equals(secondInListFront)&& firstInListFront.equals(last) && secondInListFront.equals(last)){
                pileStatus = true; //Compare 2 and A(-15) ; Compare J and X(-14)
                continue;
            }else if (firstInListBack.compareTo(secondInListBack) > -8 && firstInListBack.compareTo(secondInListBack) < -6 && firstInListFront.equals(secondInListFront)&& firstInListFront.equals(last) && secondInListFront.equals(last)){
                pileStatus = true;
                continue; 
            }else if (firstInListBack.compareTo(secondInListBack) == 1){
                PileNotMatch();
                pileStatus = false;
                break;
            }else if (firstInListBack.compareTo(secondInListBack) < -1){
                PileNotMatch();
                pileStatus = false;
                break;
            }else if(firstInListBack.compareTo(secondInListBack) == 0){
                PileNotMatch();
                pileStatus = false;
                break;
            }
        }   
       
        return pileStatus;
    }

    /**
     * If checkPile return true, then the card will be moved to Pile
     * If checkPile return false, then the card will not be moved to Pile
     */
    public void movePile(){
        //Column 1
        if(first.equals("1") && last.equals("c")){
            if(checkPile(column1)){
                pileC.push(tempCard,column1,index);
            }
        }else if(first.equals("1") && last.equals("d")){
            if(checkPile(column1)){
                pileD.push(tempCard,column1,index);
            }
        }else if(first.equals("1") && last.equals("h")){
            if(checkPile(column1)){
                pileH.push(tempCard,column1,index);
            }
        }else if(first.equals("1") && last.equals("s")){
            if(checkPile(column1)){
                pileS.push(tempCard,column1,index);
            }
            //Column 2
        }else if(first.equals("2") && last.equals("c")){
            if(checkPile(column2)){
                pileC.push(tempCard,column2,index);
            }
        }else if(first.equals("2") && last.equals("d")){
            if(checkPile(column2)){
                pileD.push(tempCard,column2,index);
            }
        }else if(first.equals("2") && last.equals("h")){
            if(checkPile(column2)){
                pileH.push(tempCard,column2,index);
            }
        }else if(first.equals("2") && last.equals("s")){
            if(checkPile(column2)){
                pileS.push(tempCard,column2,index);
            }
            //Column 3  
            
        }else if(first.equals("3") && last.equals("c")){
            if(checkPile(column3)){
                pileC.push(tempCard,column3,index);
            }
        }else if(first.equals("3") && last.equals("d")){
            if(checkPile(column3)){
                pileD.push(tempCard,column3,index);
            }
        }else if(first.equals("3") && last.equals("h")){
            if(checkPile(column3)){
                pileH.push(tempCard,column3,index);
            }
        }else if(first.equals("3") && last.equals("s")){
            if(checkPile(column3)){
                pileS.push(tempCard,column3,index);
            }
            //Column 4
        }else if(first.equals("4") && last.equals("c")){
            if(checkPile(column4)){
                pileC.push(tempCard,column4,index);
            }
        }else if(first.equals("4") && last.equals("d")){
            if(checkPile(column4)){
                pileD.push(tempCard,column4,index);
            }
        }else if(first.equals("4") && last.equals("h")){
            if(checkPile(column4)){
                pileH.push(tempCard,column4,index);
            }
        }else if(first.equals("4") && last.equals("s")){
            if(checkPile(column4)){
                pileS.push(tempCard,column4,index);
            }
            //Column 5
        }else if(first.equals("5") && last.equals("c")){
            if(checkPile(column5)){
                pileC.push(tempCard,column5,index);
            }
        }else if(first.equals("5") && last.equals("d")){
            if(checkPile(column5)){
                pileD.push(tempCard,column5,index);
                }
        }else if(first.equals("5") && last.equals("h")){
            if(checkPile(column5)){
                pileH.push(tempCard,column5,index);
            }
        }else if(first.equals("5") && last.equals("s")){
            if(checkPile(column5)){
                pileS.push(tempCard,column5,index);
            }
            //Column 6
        }else if(first.equals("6") && last.equals("c")){
            if(checkPile(column6)){
                pileC.push(tempCard,column6,index);
            }
        }else if(first.equals("6") && last.equals("d")){
            if(checkPile(column6)){                     
                pileD.push(tempCard,column6,index);
            }                       
        }else if(first.equals("6") && last.equals("h")){
            if(checkPile(column6)){
                pileH.push(tempCard,column6,index);
            }
        }else if(first.equals("6") && last.equals("s")){
            if(checkPile(column6)){
                pileS.push(tempCard,column6,index);
            }
            //Column 7
        }else if(first.equals("7") && last.equals("c")){
            if(checkPile(column7)){
                pileC.push(tempCard,column7,index);
            }
        }else if(first.equals("7") && last.equals("d")){
            if(checkPile(column7)){
                pileD.push(tempCard,column7,index);
            }
        }else if(first.equals("7") && last.equals("h")){
            if(checkPile(column7)){
                pileH.push(tempCard,column7,index);
            }
        }else if(first.equals("7") && last.equals("s")){
            if(checkPile(column7)){
                pileS.push(tempCard,column7,index);
            }
            //Column 8
        }else if(first.equals("8") && last.equals("c")){
            if(checkPile(column8)){
                pileC.push(tempCard,column8,index);
            }
        }else if(first.equals("8") && last.equals("d")){
            if(checkPile(column8)){
                pileD.push(tempCard,column8,index);
            }
        }else if(first.equals("8") && last.equals("h")){
            if(checkPile(column8)){
                pileH.push(tempCard,column8,index);
            }
        }else if(first.equals("8") && last.equals("s")){
            if(checkPile(column8)){
                pileS.push(tempCard,column8,index);
            }
            //Column 9
        }else if(first.equals("9") && last.equals("c")){
            if(checkPile(column9)){
                pileC.push(tempCard,column9,index);
            }
        }else if(first.equals("9") && last.equals("d")){
            if(checkPile(column9)){
                pileD.push(tempCard,column9,index);
            }
        }else if(first.equals("9") && last.equals("h")){
            if(checkPile(column9)){
                pileH.push(tempCard,column9,index);
            }
        }else if(first.equals("9") && last.equals("s")){
            if(checkPile(column9)){
                pileS.push(tempCard,column9,index);
            }      
        }else{
            wrongMove();
        }                  
    }

    /**
     * Check whether the movement of card from one column to another match with the gamerules
     * @param firstList The column the card in
     * @param tempCard The card user want to move
     * @param secondList The destination of the card 
     */                                              
    public void checkColumn(ArrayList<Card> firstList, Card tempCard, ArrayList<Card> secondList){
        checkIndex(tempCard,firstList);    
        if(secondList.size() == 0){
            if(last.equals("c") && tempCard.getFace().equals("c") && tempCard.getValue().equals("A")){
                columnStatus = true;
            }else if(last.equals("d") && tempCard.getFace().equals("d") && tempCard.getValue().equals("A")){
                columnStatus = true;
            }else if(last.equals("h") && tempCard.getFace().equals("h") && tempCard.getValue().equals("A")){
                columnStatus = true;
            }else if(last.equals("s") && tempCard.getFace().equals("s") && tempCard.getValue().equals("A")){
                columnStatus = true;
            }else if (!(last.equals("c") || last.equals("d")|| last.equals("h")|| last.equals("s"))){
                columnStatus = true;
            }
        }else{
            Card lastEle = secondList.get(secondList.size()-1); 

            String strLastEle = lastEle.getValue(); //item in target column
            
            if(tempCard.getValue().equals("A") && strLastEle.equals("2")){
                columnStatus = true;
            }else if(tempCard.getValue().equals("9") && strLastEle.equals("X")){
                columnStatus = true;
            }else if(tempCard.getValue().equals("X") && strLastEle.equals("J")){
                columnStatus = true;
            }else if(tempCard.getValue().equals("J") && strLastEle.equals("Q")){
                columnStatus = true;
            }else if (tempCard.getValue().equals("Q") && strLastEle.equals("K")){
                columnStatus = true;
            }else if (strLastEle.compareTo(tempCard.getValue()) == 1){
                columnStatus = true;
            }else{
                columnStatus = false;
                wrongMove();
            }

        }
        
        for(int i = index; i < firstList.size()-1; i++){
            Card firstInList = firstList.get(i);
            Card secondInList = firstList.get((i+1));
            
            String firstInListBack = firstInList.getValue();
            String secondInListBack = secondInList.getValue();
    
            if(firstInListBack.compareTo(secondInListBack) == 1){
                columnStatus = true; // Compare last card is larger than move card by exactly one points
                continue;
            }else if(firstInListBack.compareTo(secondInListBack) > 30 && firstInListBack.compareTo(secondInListBack) < 32){
                columnStatus = true; //Compare X and 9
                continue;
            }else if (firstInListBack.compareTo(secondInListBack) > -7 && firstInListBack.compareTo(secondInListBack) < -5){
                columnStatus = true; //Compare K and Q
                continue;
            }else if (firstInListBack.compareTo(secondInListBack) > -16 && firstInListBack.compareTo(secondInListBack) < -13){
                columnStatus = true; //Compare 2 and A(-15) ; Compare J and X(-14)
                continue;
            }else if (firstInListBack.compareTo(secondInListBack) > 6 && firstInListBack.compareTo(secondInListBack) < 8){
                columnStatus = true;
                continue; 
            }else if (firstInListBack.compareTo(secondInListBack) < 0){
                wrongMove();
                columnStatus = false;
                break;
            }else if (firstInListBack.compareTo(secondInListBack) > 1){
                wrongMove();
                columnStatus = false;
                break;
            }
        } 
        
    }

    /**
     * If columnStatus is true, then move the card
     * @param list1  The column the card in
     * @param tempCard The card user want to move
     * @param list2 The destination of the card
     */
    public void moveColumn(ArrayList<Card> list1, Card tempCard, ArrayList<Card> list2){
        if(columnStatus){
            ArrayList<Card> tempList = new ArrayList<>();
            for(int i=index; i <list1.size(); i++){
                Card value = list1.get(i);
                tempList.add(value);
                
            }
            list2.addAll(tempList);
    
            for(int i = list1.size()-1; i>=index; i--){
                Card value = list1.get(i);
                list1.remove(value);
            }
        }else{
            wrongMove();
        }
        columnStatus = false;  
    }

    /**
     * Move the card if user's input follow the gamerules
     */
    public void MakeSelection(){
        //Column1
        if(first.equals("1") && last.equals("2")){
            checkColumn(column1,tempCard,column2);
            moveColumn(column1,tempCard,column2);
        }else if (first.equals("1") && last.equals("3")){
            checkColumn(column1,tempCard,column3);
            moveColumn(column1,tempCard,column3);
        }else if (first.equals("1") && last.equals("4")){
            checkColumn(column1,tempCard,column4);
            moveColumn(column1,tempCard,column4);
        }else if (first.equals("1") && last.equals("5")){
            checkColumn(column1,tempCard,column5);
            moveColumn(column1,tempCard,column5);
        }else if (first.equals("1") && last.equals("6")){
            checkColumn(column1,tempCard,column6);
            moveColumn(column1,tempCard,column6);
        }else if (first.equals("1") && last.equals("7")){
            checkColumn(column1,tempCard,column7);
            moveColumn(column1,tempCard,column7);
        }else if (first.equals("1") && last.equals("8")){
            checkColumn(column1,tempCard,column8);
            moveColumn(column1,tempCard,column8);
        }else if (first.equals("1") && last.equals("9")){
            checkColumn(column1,tempCard,column9);
            moveColumn(column1,tempCard,column9);
        //Column2
        }else if (first.equals("2") && last.equals("1")){
            checkColumn(column2,tempCard,column1);
            moveColumn(column2,tempCard,column1);
        }else if (first.equals("2") && last.equals("3")){
            checkColumn(column2,tempCard,column3);
            moveColumn(column2,tempCard,column3);
        }else if (first.equals("2") && last.equals("4")){
            checkColumn(column2,tempCard,column4);
            moveColumn(column2,tempCard,column4);
        }else if (first.equals("2") && last.equals("5")){
            checkColumn(column2,tempCard,column5);
            moveColumn(column2,tempCard,column5);
        }else if (first.equals("2") && last.equals("6")){
            checkColumn(column2,tempCard,column6);
            moveColumn(column2,tempCard,column6);
        }else if (first.equals("2") && last.equals("7")){
            checkColumn(column2,tempCard,column7);
            moveColumn(column2,tempCard,column7);
        }else if (first.equals("2") && last.equals("8")){
            checkColumn(column2,tempCard,column8);
            moveColumn(column2,tempCard,column8);
        }else if (first.equals("2") && last.equals("9")){
            checkColumn(column2,tempCard,column9);
            moveColumn(column2,tempCard,column9);
        //Column3
        }else if (first.equals("3") && last.equals("1")){
            checkColumn(column3,tempCard,column1);
            moveColumn(column3,tempCard,column1);
        }else if(first.equals("3") && last.equals("2")){
            checkColumn(column3,tempCard,column2);
            moveColumn(column3,tempCard,column2);
        }else if (first.equals("3") && last.equals("4")){
            checkColumn(column3,tempCard,column4);
            moveColumn(column3,tempCard,column4);
        }else if (first.equals("3") && last.equals("5")){
            checkColumn(column3,tempCard,column5);
            moveColumn(column3,tempCard,column5);
        }else if (first.equals("3") && last.equals("6")){
            checkColumn(column3,tempCard,column6);
            moveColumn(column3,tempCard,column6);
        }else if (first.equals("3") && last.equals("7")){
            checkColumn(column3,tempCard,column7);
            moveColumn(column3,tempCard,column7);
        }else if (first.equals("3") && last.equals("8")){
            checkColumn(column3,tempCard,column8);
            moveColumn(column3,tempCard,column8);
        }else if (first.equals("3") && last.equals("9")){
            checkColumn(column3,tempCard,column9);
            moveColumn(column3,tempCard,column9);
        //Column4
        }else if (first.equals("4") && last.equals("1")){
            checkColumn(column4,tempCard,column1);
            moveColumn(column4,tempCard,column1);
        }else if (first.equals("4") && last.equals("2")){
            checkColumn(column4,tempCard,column2);
            moveColumn(column4,tempCard,column2);
        }else if(first.equals("4") && last.equals("3")){
            checkColumn(column4,tempCard,column3);
            moveColumn(column4,tempCard,column3);
        }else if (first.equals("4") && last.equals("5")){
            checkColumn(column4,tempCard,column5);
            moveColumn(column4,tempCard,column5);
        }else if (first.equals("4") && last.equals("6")){
            checkColumn(column4,tempCard,column6);
            moveColumn(column4,tempCard,column6);
        }else if (first.equals("4") && last.equals("7")){
            checkColumn(column4,tempCard,column7);
            moveColumn(column4,tempCard,column7);
        }else if (first.equals("4") && last.equals("8")){
            checkColumn(column4,tempCard,column8);
            moveColumn(column4,tempCard,column8);
        }else if (first.equals("4") && last.equals("9")){
            checkColumn(column4,tempCard,column9);
            moveColumn(column4,tempCard,column9);
        //Column5
        }else if (first.equals("5") && last.equals("1")){
            checkColumn(column5,tempCard,column1);
            moveColumn(column5,tempCard,column1);
        }else if (first.equals("5") && last.equals("2")){
            checkColumn(column5,tempCard,column2);
            moveColumn(column5,tempCard,column2);
        }else if (first.equals("5") && last.equals("3")){
            checkColumn(column5,tempCard,column3);
            moveColumn(column5,tempCard,column3);
        }else if(first.equals("5") && last.equals("4")){
            checkColumn(column5,tempCard,column4);
            moveColumn(column5,tempCard,column4);
        }else if (first.equals("5") && last.equals("6")){
            checkColumn(column5,tempCard,column6);
            moveColumn(column5,tempCard,column6);
        }else if (first.equals("5") && last.equals("7")){
            checkColumn(column5,tempCard,column7);
            moveColumn(column5,tempCard,column7);
        }else if (first.equals("5") && last.equals("8")){
            checkColumn(column5,tempCard,column8);
            moveColumn(column5,tempCard,column8);
        }else if (first.equals("5") && last.equals("9")){
            checkColumn(column5,tempCard,column9);
            moveColumn(column5,tempCard,column9);
        //Column6
        }else if (first.equals("6") && last.equals("1")){
            checkColumn(column6,tempCard,column1);
            moveColumn(column6,tempCard,column1);
        }else if (first.equals("6") && last.equals("2")){
            checkColumn(column6,tempCard,column2);
            moveColumn(column6,tempCard,column2);
        }else if (first.equals("6") && last.equals("3")){
            checkColumn(column6,tempCard,column3);
            moveColumn(column6,tempCard,column3);
        }else if (first.equals("6") && last.equals("4")){
            checkColumn(column6,tempCard,column4);
            moveColumn(column6,tempCard,column4);
        }else if(first.equals("6") && last.equals("5")){
            checkColumn(column6,tempCard,column5);
            moveColumn(column6,tempCard,column5);
        }else if (first.equals("6") && last.equals("7")){
            checkColumn(column6,tempCard,column7);
            moveColumn(column6,tempCard,column7);
        }else if (first.equals("6") && last.equals("8")){
            checkColumn(column6,tempCard,column8);
            moveColumn(column6,tempCard,column8);
        }else if (first.equals("6") && last.equals("9")){
            checkColumn(column6,tempCard,column9);
            moveColumn(column6,tempCard,column9);
        //Column7
        }else if (first.equals("7") && last.equals("1")){
            checkColumn(column7,tempCard,column1);
            moveColumn(column7,tempCard,column1);
        }else if (first.equals("7") && last.equals("2")){
            checkColumn(column7,tempCard,column2);
            moveColumn(column7,tempCard,column2);
        }else if (first.equals("7") && last.equals("3")){
            checkColumn(column7,tempCard,column3);
            moveColumn(column7,tempCard,column3);
        }else if (first.equals("7") && last.equals("4")){
            checkColumn(column7,tempCard,column4);
            moveColumn(column7,tempCard,column4);
        }else if(first.equals("7") && last.equals("5")){
            checkColumn(column7,tempCard,column5);
            moveColumn(column7,tempCard,column5);
        }else if (first.equals("7") && last.equals("6")){
            checkColumn(column7,tempCard,column6);
            moveColumn(column7,tempCard,column6);
        }else if (first.equals("7") && last.equals("8")){
            checkColumn(column7,tempCard,column8);
            moveColumn(column7,tempCard,column8);
        }else if (first.equals("7") && last.equals("9")){
            checkColumn(column7,tempCard,column9);
            moveColumn(column7,tempCard,column9);
        //Column8
        }else if (first.equals("8") && last.equals("1")){
            checkColumn(column8,tempCard,column1);
            moveColumn(column8,tempCard,column1);
        }else if (first.equals("8") && last.equals("2")){
            checkColumn(column8,tempCard,column2);
            moveColumn(column8,tempCard,column2);
        }else if (first.equals("8") && last.equals("3")){
            checkColumn(column8,tempCard,column3);
            moveColumn(column8,tempCard,column3);
        }else if (first.equals("8") && last.equals("4")){
            checkColumn(column8,tempCard,column4);
            moveColumn(column8,tempCard,column4);
        }else if(first.equals("8") && last.equals("5")){
            checkColumn(column8,tempCard,column5);
            moveColumn(column8,tempCard,column5);
        }else if (first.equals("8") && last.equals("6")){
            checkColumn(column8,tempCard,column6);
            moveColumn(column8,tempCard,column6);
        }else if (first.equals("8") && last.equals("7")){
            checkColumn(column8,tempCard,column7);
            moveColumn(column8,tempCard,column7);
        }else if (first.equals("8") && last.equals("9")){
            checkColumn(column8,tempCard,column9);
            moveColumn(column8,tempCard,column9);
        //Column9
        }else if (first.equals("9") && last.equals("1")){
            checkColumn(column9,tempCard,column1);
            moveColumn(column9,tempCard,column1);
        }else if (first.equals("9") && last.equals("2")){
            checkColumn(column9,tempCard,column2);
            moveColumn(column9,tempCard,column2);
        }else if (first.equals("9") && last.equals("3")){
            checkColumn(column9,tempCard,column3);
            moveColumn(column9,tempCard,column3);
        }else if (first.equals("9") && last.equals("4")){
            checkColumn(column9,tempCard,column4);
            moveColumn(column9,tempCard,column4);
        }else if(first.equals("9") && last.equals("5")){
            checkColumn(column9,tempCard,column5);
            moveColumn(column9,tempCard,column5);
        }else if (first.equals("9") && last.equals("6")){
            checkColumn(column9,tempCard,column6);
            moveColumn(column9,tempCard,column6);
        }else if (first.equals("9") && last.equals("7")){
            checkColumn(column9,tempCard,column7);
            moveColumn(column9,tempCard,column7);
        }else if (first.equals("9") && last.equals("8")){
            checkColumn(column9,tempCard,column8);
            moveColumn(column9,tempCard,column8);
        }else if(pileStatus == false && columnStatus == false){
            wrongMove();
        }
    }

    /**
     * Print readable output
     */
    public void printAll(){
        System.out.println("Pile C: " + pileC.toString());
        System.out.println("Pile D: " + pileD.toString());
        System.out.println("Pile H: " + pileH.toString());
        System.out.println("Pile S: " + pileS.toString());
        System.out.println("Column 1: " +column1.toString());
        System.out.println("Column 2: " +column2.toString());
        System.out.println("Column 3: " +column3.toString());
        System.out.println("Column 4: " +column4.toString());
        System.out.println("Column 5: " +column5.toString());
        System.out.println("Column 6: " +column6.toString());
        System.out.println("Column 7: " +column7.toString());
        System.out.println("Column 8: " +column8.toString());
        System.out.println("Column 9: " +column9.toString());
    }
}


