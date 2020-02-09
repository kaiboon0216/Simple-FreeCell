/**
 * The OrderedStack class represents the Pile
 * 
 * @Author: Chang Kai Boon
 * 
 */
import java.util.*;

public class OrderedStack<E> implements Comparable<E>{
    /**
     * Data field is arrayList
     */
    private ArrayList<E> list = new ArrayList<>();

    /**
     * No-arg constructor
     */
    public OrderedStack(){

    }
    /**
     * Return the size of the list
     * @return return the size of the list
     */
    public int getSize(){
        return list.size();
    }
    /**
     * Return the whole list
     * @return return the whole list
     */
    public ArrayList<E> getList(){
        return list;
    }

    /**
     * Return the last element in the list
     * @return Return the last element in the list
     */
    public E peek() {
        return list.get(getSize()-1);
    }

    /**
     * Push the specified element into the list
     * @param e element
     * @param al ArrayList
     * @param index index of the element in the array list
     */
    public void push(E e, ArrayList<E> al, int index){
        //int index = al.indexOf(e);                                                                                                         
        System.out.println("Index: "+index);
        ArrayList<E> tempList = new ArrayList<>();
        for(int i =(index);i<al.size();i++){
            E value = al.get(i);
            tempList.add(value);

        }
        list.addAll(tempList);

        for(int i = al.size()-1; i>=(index); i--){
            E value = al.get(i);
            al.remove(value);
        }
    }
    
    /**
     * Remove the last element in the list
     * @return  Remove the last element in the list

     */
    public E pop() {
        E o = list.get(getSize()-1);
        list.remove(getSize()-1);
        return o;
    }
    
    /**
     * To check whether the list is empty
     * @return return true if the list is empty else false
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Override CompareTo method in Comparable<E>
     */
    public int compareTo(E e){
        return 0;
    } 

    /**
     * Override toString method to show readable output
     */
    @Override
    public String toString() {
        return list.toString();
    }

}
