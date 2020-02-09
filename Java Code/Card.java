/**
 * This Card class represents the card
 * 
 * @Author: Chang Kai Boon
 * 
 */
import java.util.*;

public class Card implements Comparable<Card>{
    private String face;
    private String value;

    /**
     * No-arg Constructor
     */
    public Card(){

    }
    /**
     * Overloaded Constructor
     * @param face 4 Suits(Clubs(C),Diamonds(D),Hearts(H),Spades(S))
     * @param value 13 Value(A-9,X,J,Q,K)
     * Initialize the card with specified face and value
     */
    public Card(String face, String value){
        this.face = face;
        this.value = value;
    }

    /**
     * Update the face and value of the card
     * @param face 4 Suits(Clubs(C),Diamonds(D),Hearts(H),Spades(S))
     * @param value 13 Value(A-9,X,J,Q,K)
     * Update the card with user input
     */
    public void updateValue(String face, String value){
        this.face = face;
        this.value = value;
    }

    /**
     * Return face of the card
     * @return return face value
     * Get Card's face value
     */
    public String getFace(){
        return face;
    }

    /**
     * Return value of the card
     * @return Value value
     * Get Card's card value
     */
    public String getValue(){
        return value;
    }

    /**
     * ToString method to show readable output
     */
    public String toString(){
        return getFace() + getValue();
    }

    /**
     * Compare Face of two card
     * @param Card
     * @return return true if two card's face are same
     */
    public boolean comparePile(Card c){
        if(face == c.face){
            return true; 
        }
        return false;
    }

    /**
     * Compare Value of two card
     * @param c
     * @return return true if two card' value are the same
     */
    public int compareValue(Card c){
       return value.compareTo(c.value);
    }

    /**
     * Override Comparable<E> compareTo
     */
    public int compareTo(Card c){
        return 0;
    }

}




