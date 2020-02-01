import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;

class Freecell{
    //4 Piles
    private static ArrayList<String> pileC = new ArrayList<>();
    private static ArrayList<String> pileD = new ArrayList<>();
    private static ArrayList<String> pileH = new ArrayList<>();
    private static ArrayList<String> pileS = new ArrayList<>();

    /*
    //9 Columns
    private static ArrayList<String> column1 = new ArrayList<>(List.of("c9","h5","dQ","d6","c7","s8","hQ"));
    private static ArrayList<String> column2 = new ArrayList<>(List.of("s5","c2","s7","s2","cQ","c5"));
    private static ArrayList<String> column3 = new ArrayList<>(List.of("h6","sJ","d2","hX","d5","cA","hA"));
    private static ArrayList<String> column4 = new ArrayList<>(List.of("dK","cJ","cX","hJ","c4","c8"));
    private static ArrayList<String> column5 = new ArrayList<>(List.of("d9","dA","h7","d8","s3","sX","h2"));
    private static ArrayList<String> column6 = new ArrayList<>(List.of("dX","s6","c3","s9","d7","dJ"));
    private static ArrayList<String> column7 = new ArrayList<>(List.of("h8","sA","sK","hK","c6","s4","h9"));
    private static ArrayList<String> column8 = new ArrayList<>(List.of("d3","cK","sQ","h4","h3","d4"));
    private static ArrayList<String> column9 = new ArrayList<>();
    */

    //For testing purposes only
    private static ArrayList<String> column1 = new ArrayList<>(List.of("cK","cQ","cJ","cX","c9","c8","c7","c6","c5","c4","c3","c2","cA"));
    private static ArrayList<String> column2 = new ArrayList<>(List.of("sA"));
    private static ArrayList<String> column3 = new ArrayList<>(List.of("s2","s3","s4","s5","s6","s7","s8","s9"));
    private static ArrayList<String> column4 = new ArrayList<>(List.of("dK","hK","hQ","hJ","hX"));
    private static ArrayList<String> column5 = new ArrayList<>(List.of("d9","dA","h7","d8","s3","sX","h2"));
    private static ArrayList<String> column6 = new ArrayList<>(List.of("dX","s6","c3","s9","d7","dJ"));
    private static ArrayList<String> column7 = new ArrayList<>(List.of("h8","sA","sK","hK","c6","s4","h9"));
    private static ArrayList<String> column8 = new ArrayList<>(List.of("d3","cK","sQ","h4","h3","d4"));
    private static ArrayList<String> column9 = new ArrayList<>();

    //3 User inputs
    private static String firstList;
    private static String element;
    private static String target;
    private static boolean status = false;
    

    //Methods for freecell
    public static void deepShuffle(){
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

    public static void printAll(){
        System.out.println("Pile C: " + pileC);
        System.out.println("Pile D: " + pileD);
        System.out.println("Pile H: " + pileH);
        System.out.println("Pile S: " + pileS);
        System.out.println("Column 1 : "+ column1);
        System.out.println("Column 2 : "+ column2);
        System.out.println("Column 3 : "+ column3);
        System.out.println("Column 4 : "+ column4);
        System.out.println("Column 5 : "+ column5);
        System.out.println("Column 6 : "+ column6);
        System.out.println("Column 7 : "+ column7);
        System.out.println("Column 8 : "+ column8);
        System.out.println("Column 9 : "+ column9);
    }

    public static void moveMore(ArrayList<String> list1, String string, ArrayList<String> list2){
        if(status){
            int num = list1.indexOf(string);
            System.out.println(num);
            ArrayList<String> tempList = new ArrayList<>();
            for(int i=num; i <list1.size(); i++){
                String value = list1.get(i);
                tempList.add(value);
            
            }
            list2.addAll(tempList);

            for(int i = list1.size()-1; i>=num; i--){
                String value = list1.get(i);
                list1.remove(value);
            }
        }
        status = false;
    }

    public static void makeSelection(){
        if(firstList.equals("1") && target.equals("c")){
            checkPile(column1,element,pileC);
            moveMore(column1,element,pileC);
        }else if (firstList.equals("1") && target.equals("d")){
            checkPile(column1,element,pileD);
            moveMore(column1,element,pileD);
        }else if (firstList.equals("1") && target.equals("h")){
            checkPile(column1,element,pileH);
            moveMore(column1,element,pileH);
        }else if (firstList.equals("1") && target.equals("s")){
            checkPile(column1,element,pileS);
            moveMore(column1,element,pileS);
        }else if (firstList.equals("1") && target.equals("2")){
            checkMove(column1,element,column2);
            moveMore(column1,element,column2);
        }else if (firstList.equals("1") && target.equals("3")){
            checkMove(column1,element,column3);
            moveMore(column1,element,column3);
        }else if (firstList.equals("1") && target.equals("4")){
            checkMove(column1,element,column4);
            moveMore(column1,element,column4);
        }else if (firstList.equals("1") && target.equals("5")){
            checkMove(column1,element,column5);
            moveMore(column1,element,column5);
        }else if (firstList.equals("1") && target.equals("6")){
            checkMove(column1,element,column6);
            moveMore(column1,element,column6);
        }else if (firstList.equals("1") && target.equals("7")){
            checkMove(column1,element,column7);
            moveMore(column1,element,column7);
        }else if (firstList.equals("1") && target.equals("8")){
            checkMove(column1,element,column8);
            moveMore(column1,element,column8);
        }else if (firstList.equals("1") && target.equals("9")){
            checkMove(column1,element,column9);
            moveMore(column1,element,column9);
        }else if (firstList.equals("2") && target.equals("c")){
            checkPile(column2,element,pileC);
            moveMore(column2,element,pileC);
        }else if (firstList.equals("2") && target.equals("d")){
            checkPile(column2,element,pileD);
            moveMore(column2,element,pileD);
        }else if (firstList.equals("2") && target.equals("h")){
            checkPile(column2,element,pileH);
            moveMore(column2,element,pileH);
        }else if (firstList.equals("2") && target.equals("s")){
            checkPile(column2,element,pileS);
            moveMore(column2,element,pileS);
        }else if (firstList.equals("2") && target.equals("1")){
            checkMove(column2,element,column1);
            moveMore(column2,element,column1);
        }else if (firstList.equals("2") && target.equals("3")){
            checkMove(column2,element,column3);
            moveMore(column2,element,column3);
        }else if (firstList.equals("2") && target.equals("4")){
            checkMove(column2,element,column4);
            moveMore(column2,element,column4);
        }else if (firstList.equals("2") && target.equals("5")){
            checkMove(column2,element,column5);
            moveMore(column2,element,column5);
        }else if (firstList.equals("2") && target.equals("6")){
            checkMove(column2,element,column6);
            moveMore(column2,element,column6);
        }else if (firstList.equals("2") && target.equals("7")){
            checkMove(column2,element,column7);
            moveMore(column2,element,column7);
        }else if (firstList.equals("2") && target.equals("8")){
            checkMove(column2,element,column8);
            moveMore(column2,element,column8);
        }else if (firstList.equals("2") && target.equals("9")){
            checkMove(column2,element,column9);
            moveMore(column2,element,column9);
        }else if (firstList.equals("3") && target.equals("c")){
            checkPile(column3,element,pileC);
            moveMore(column3,element,pileC);
        }else if (firstList.equals("3") && target.equals("d")){
            checkPile(column3,element,pileD);
            moveMore(column3,element,pileD);
        }else if (firstList.equals("3") && target.equals("h")){
            checkPile(column3,element,pileH);
            moveMore(column3,element,pileH);
        }else if (firstList.equals("3") && target.equals("s")){
            checkPile(column3,element,pileS);
            moveMore(column3,element,pileS);
        }else if (firstList.equals("3") && target.equals("1")){
            checkMove(column3,element,column1);
            moveMore(column3,element,column1);
        }else if (firstList.equals("3") && target.equals("2")){
            checkMove(column3,element,column2);
            moveMore(column3,element,column2);
        }else if (firstList.equals("3") && target.equals("4")){
            checkMove(column3,element,column4);
            moveMore(column3,element,column4);
        }else if (firstList.equals("3") && target.equals("5")){
            checkMove(column3,element,column5);
            moveMore(column3,element,column5);
        }else if (firstList.equals("3") && target.equals("6")){
            checkMove(column3,element,column6);
            moveMore(column3,element,column6);
        }else if (firstList.equals("3") && target.equals("7")){
            checkMove(column3,element,column7);
            moveMore(column3,element,column7);
        }else if (firstList.equals("3") && target.equals("8")){
            checkMove(column3,element,column8);
            moveMore(column3,element,column8);
        }else if (firstList.equals("3") && target.equals("9")){
            checkMove(column3,element,column9);
            moveMore(column3,element,column9);
        }else if (firstList.equals("4") && target.equals("c")){
            checkPile(column4,element,pileC);
            moveMore(column4,element,pileC);
        }else if (firstList.equals("4") && target.equals("d")){
            checkPile(column4,element,pileD);
            moveMore(column4,element,pileD);
        }else if (firstList.equals("4") && target.equals("h")){
            checkPile(column4,element,pileH);
            moveMore(column4,element,pileH);
        }else if (firstList.equals("4") && target.equals("s")){
            checkPile(column4,element,pileS);
            moveMore(column4,element,pileS);
        }else if (firstList.equals("4") && target.equals("1")){
            checkMove(column4,element,column1);
            moveMore(column4,element,column1);
        }else if (firstList.equals("4") && target.equals("2")){
            checkMove(column4,element,column2);
            moveMore(column4,element,column2);
        }else if (firstList.equals("4") && target.equals("3")){
            checkMove(column4,element,column3);
            moveMore(column4,element,column3);
        }else if (firstList.equals("4") && target.equals("5")){
            checkMove(column4,element,column5);
            moveMore(column4,element,column5);
        }else if (firstList.equals("4") && target.equals("6")){
            checkMove(column4,element,column6);
            moveMore(column4,element,column6);
        }else if (firstList.equals("4") && target.equals("7")){
            checkMove(column4,element,column7);
            moveMore(column4,element,column7);
        }else if (firstList.equals("4") && target.equals("8")){
            checkMove(column4,element,column8);
            moveMore(column4,element,column8);
        }else if (firstList.equals("4") && target.equals("9")){
            checkMove(column4,element,column9);
            moveMore(column4,element,column9);
        }else if (firstList.equals("5") && target.equals("c")){
            checkPile(column5,element,pileC);
            moveMore(column5,element,pileC);
        }else if (firstList.equals("5") && target.equals("d")){
            checkPile(column5,element,pileD);
            moveMore(column5,element,pileD);
        }else if (firstList.equals("5") && target.equals("h")){
            checkPile(column5,element,pileH);
            moveMore(column5,element,pileH);
        }else if (firstList.equals("5") && target.equals("s")){
            checkPile(column5,element,pileS);
            moveMore(column5,element,pileS);
        }else if (firstList.equals("5") && target.equals("1")){
            checkMove(column5,element,column1);
            moveMore(column5,element,column1);
        }else if (firstList.equals("5") && target.equals("2")){
            checkMove(column5,element,column2);
            moveMore(column5,element,column2);
        }else if (firstList.equals("5") && target.equals("3")){
            checkMove(column5,element,column3);
            moveMore(column5,element,column3);
        }else if (firstList.equals("5") && target.equals("4")){
            checkMove(column5,element,column4);
            moveMore(column5,element,column4);
        }else if (firstList.equals("5") && target.equals("6")){
            checkMove(column5,element,column6);
            moveMore(column5,element,column6);
        }else if (firstList.equals("5") && target.equals("7")){
            checkMove(column5,element,column7);
            moveMore(column5,element,column7);
        }else if (firstList.equals("5") && target.equals("8")){
            checkMove(column5,element,column8);
            moveMore(column5,element,column8);
        }else if (firstList.equals("5") && target.equals("9")){
            checkMove(column5,element,column9);
            moveMore(column5,element,column9);
        }else if (firstList.equals("6") && target.equals("c")){
            checkPile(column6,element,pileC);
            moveMore(column6,element,pileC);
        }else if (firstList.equals("6") && target.equals("d")){
            checkPile(column6,element,pileD);
            moveMore(column6,element,pileD);
        }else if (firstList.equals("6") && target.equals("h")){
            checkPile(column6,element,pileH);
            moveMore(column6,element,pileH);
        }else if (firstList.equals("6") && target.equals("s")){
            checkPile(column6,element,pileS);
            moveMore(column6,element,pileS);
        }else if (firstList.equals("6") && target.equals("1")){
            checkMove(column6,element,column1);
            moveMore(column6,element,column1);
        }else if (firstList.equals("6") && target.equals("2")){
            checkMove(column6,element,column2);
            moveMore(column6,element,column2);
        }else if (firstList.equals("6") && target.equals("3")){
            checkMove(column6,element,column3);
            moveMore(column6,element,column3);
        }else if (firstList.equals("6") && target.equals("4")){
            checkMove(column6,element,column4);
            moveMore(column6,element,column4);
        }else if (firstList.equals("6") && target.equals("5")){
            checkMove(column6,element,column5);
            moveMore(column6,element,column5);
        }else if (firstList.equals("6") && target.equals("7")){
            checkMove(column6,element,column7);
            moveMore(column6,element,column7);
        }else if (firstList.equals("6") && target.equals("8")){
            checkMove(column6,element,column8);
            moveMore(column6,element,column8);
        }else if (firstList.equals("6") && target.equals("9")){
            checkMove(column6,element,column9);
            moveMore(column6,element,column9);
        }else if (firstList.equals("7") && target.equals("c")){
            checkPile(column7,element,pileC);
            moveMore(column7,element,pileC);
        }else if (firstList.equals("7") && target.equals("d")){
            checkPile(column7,element,pileD);
            moveMore(column7,element,pileD);
        }else if (firstList.equals("7") && target.equals("h")){
            checkPile(column7,element,pileH);
            moveMore(column7,element,pileH);
        }else if (firstList.equals("7") && target.equals("s")){
            checkPile(column7,element,pileS);
            moveMore(column7,element,pileS);
        }else if (firstList.equals("7") && target.equals("1")){
            checkMove(column7,element,column1);
            moveMore(column7,element,column1);
        }else if (firstList.equals("7") && target.equals("2")){
            checkMove(column7,element,column2);
            moveMore(column7,element,column2);
        }else if (firstList.equals("7") && target.equals("3")){
            checkMove(column7,element,column3);
            moveMore(column7,element,column3);
        }else if (firstList.equals("7") && target.equals("4")){
            checkMove(column7,element,column4);
            moveMore(column7,element,column4);
        }else if (firstList.equals("7") && target.equals("5")){
            checkMove(column7,element,column5);
            moveMore(column7,element,column5);
        }else if (firstList.equals("7") && target.equals("6")){
            checkMove(column7,element,column6);
            moveMore(column7,element,column6);
        }else if (firstList.equals("7") && target.equals("8")){
            checkMove(column7,element,column8);
            moveMore(column7,element,column8);
        }else if (firstList.equals("7") && target.equals("9")){
            checkMove(column7,element,column9);
            moveMore(column7,element,column9);
        }else if (firstList.equals("8") && target.equals("c")){
            checkPile(column8,element,pileC);
            moveMore(column8,element,pileC);
        }else if (firstList.equals("8") && target.equals("d")){
            checkPile(column8,element,pileD);
            moveMore(column8,element,pileD);
        }else if (firstList.equals("8") && target.equals("h")){
            checkPile(column8,element,pileH);
            moveMore(column8,element,pileH);
        }else if (firstList.equals("8") && target.equals("s")){
            checkPile(column8,element,pileS);
            moveMore(column8,element,pileS);
        }else if (firstList.equals("8") && target.equals("1")){
            checkMove(column8,element,column1);
            moveMore(column8,element,column1);
        }else if (firstList.equals("8") && target.equals("2")){
            checkMove(column8,element,column2);
            moveMore(column8,element,column2);
        }else if (firstList.equals("8") && target.equals("3")){
            checkMove(column8,element,column3);
            moveMore(column8,element,column3);
        }else if (firstList.equals("8") && target.equals("4")){
            checkMove(column8,element,column4);
            moveMore(column8,element,column4);
        }else if (firstList.equals("8") && target.equals("5")){
            checkMove(column8,element,column5);
            moveMore(column8,element,column5);
        }else if (firstList.equals("8") && target.equals("6")){
            checkMove(column8,element,column6);
            moveMore(column8,element,column6);
        }else if (firstList.equals("8") && target.equals("7")){
            checkMove(column8,element,column7);
            moveMore(column8,element,column7);
        }else if (firstList.equals("8") && target.equals("9")){
            checkMove(column8,element,column9);
            moveMore(column8,element,column9);
        }else if (firstList.equals("9") && target.equals("c")){
            checkPile(column9,element,pileC);
            moveMore(column9,element,pileC);
        }else if (firstList.equals("9") && target.equals("d")){
            checkPile(column9,element,pileD);
            moveMore(column9,element,pileD);
        }else if (firstList.equals("9") && target.equals("h")){
            checkPile(column9,element,pileH);
            moveMore(column9,element,pileH);
        }else if (firstList.equals("9") && target.equals("s")){
            checkPile(column9,element,pileS);
            moveMore(column9,element,pileS);
        }else if (firstList.equals("9") && target.equals("1")){
            checkMove(column9,element,column1);
            moveMore(column9,element,column1);
        }else if (firstList.equals("9") && target.equals("2")){
            checkMove(column9,element,column2);
            moveMore(column9,element,column2);
        }else if (firstList.equals("9") && target.equals("3")){
            checkMove(column9,element,column3);
            moveMore(column9,element,column3);
        }else if (firstList.equals("9") && target.equals("4")){
            checkMove(column9,element,column4);
            moveMore(column9,element,column4);
        }else if (firstList.equals("9") && target.equals("5")){
            checkMove(column9,element,column5);
            moveMore(column9,element,column5);
        }else if (firstList.equals("9") && target.equals("6")){
            checkMove(column9,element,column6);
            moveMore(column9,element,column6);
        }else if (firstList.equals("9") && target.equals("7")){
            checkMove(column9,element,column7);
            moveMore(column9,element,column7);
        }else if (firstList.equals("9") && target.equals("8")){
            checkMove(column9,element,column8);
            moveMore(column9,element,column8);
        }
    }

    public static void checkMove(ArrayList<String> list1, String string, ArrayList<String> list2){
        String str0 = String.valueOf(string.charAt(0)); // element index 0
        String str1 = String.valueOf(string.charAt(1)); // element index 1
        int index = list1.indexOf(string);
        
        if(list2.size() == 0){
            if(target.equals("c") && str0.equals("c") && str1.equals("A")){
                status = true;
            }else if(target.equals("d") && str0.equals("d") && str1.equals("A")){
                status = true;
            }else if(target.equals("h") && str0.equals("h") && str1.equals("A")){
                status = true;
            }else if(target.equals("s") && str0.equals("s") && str1.equals("A")){
                status = true;
            }else if (!(target.equals("c") || target.equals("d")|| target.equals("h")|| target.equals("s"))){
                status = true;
            }
        }else{
            String last = list2.get(list2.size()-1); 
            String str2 = String.valueOf(last.charAt(1)); //item in target column
            if(str1.equals("A") && str2.equals("2")){
                status = true;
            }else if(str1.equals("9") && str2.equals("X")){
                status = true;
            }else if(str1.equals("X") && str2.equals("J")){
                status = true;
            }else if(str1.equals("J") && str2.equals("Q")){
                status = true;
            }else if (str1.equals("Q") && str2.equals("K")){
                status = true;
            }else if (str2.compareTo(str1) == 1){
                status = true;
            }

        }
        
        for(int i = index; i < list1.size()-1; i++){
            String first = String.valueOf(list1.get(i));
            String second = String.valueOf(list1.get(i+1));
            String firstback = String.valueOf(first.charAt(1));
            String secondback = String.valueOf(second.charAt(1));
            if(firstback.compareTo(secondback) == 1){
                status = true; // Compare last card is larger than move card by exactly one points
                continue;
            }else if(firstback.compareTo(secondback) > 30 && firstback.compareTo(secondback) < 32){
                status = true; //Compare X and 9
                continue;
            }else if (firstback.compareTo(secondback) > -7 && firstback.compareTo(secondback) < -5){
                status = true; //Compare K and Q
                continue;
            }else if (firstback.compareTo(secondback) > -16 && firstback.compareTo(secondback) < -13){
                status = true; //Compare 2 and A(-15) ; Compare J and X(-14)
                continue;
            }else if (firstback.compareTo(secondback) == 1){
                status = false;
                break; 
            }else if (firstback.compareTo(secondback) < 0){
                status = false;
                break;
            }else if (firstback.compareTo(secondback) > 1){
                status = false;
                break;
            }
        }
    }

    public static void checkPile(ArrayList<String> list1, String string, ArrayList<String> list2){
        String str0 = String.valueOf(string.charAt(0)); // element index 0
        String str1 = String.valueOf(string.charAt(1)); // element index 1
        int index = list1.indexOf(string);
        if(list2.size() == 0){
            //Add A into respective pile
            if(target.equals("c") && str0.equals("c") && str1.equals("A")){
                status = true;
            }else if(target.equals("d") && str0.equals("d") && str1.equals("A")){
                status = true;
            }else if(target.equals("h") && str0.equals("h") && str1.equals("A")){
                status = true;
            }else if(target.equals("s") && str0.equals("s") && str1.equals("A")){
                status = true;
            }else if (!(target.equals("c") || target.equals("d")|| target.equals("h")|| target.equals("s"))){
                status = true;
            }
        }else{
            // If list2 got element inside, get the latest element and compare with the element we want to add and respective pile,
            //If the moveCard exactly one bigger than the latest element, add it into the respective pile
            String last = list2.get(list2.size()-1); 
            String str2 = String.valueOf(last.charAt(1)); //item in target column
            if(str1.equals("2") && str2.equals("A")){
                status = true;
            }else if(str1.equals("X") && str2.equals("9")){
                status = true;
            }else if(str1.equals("J") && str2.equals("X")){
                status = true;
            }else if(str1.equals("Q") && str2.equals("J")){
                status = true;
            }else if (str1.equals("K") && str2.equals("Q")){
                status = true;
            }else if (str2.compareTo(str1) == -1){
                status = true;
            }
        }
        /*
        for(int i = index; i < list1.size()-1; i++){
            String first = String.valueOf(list1.get(i));
            String second = String.valueOf(list1.get(i+1));
            String firstback = String.valueOf(first.charAt(1));
            String secondback = String.valueOf(second.charAt(1));
            if(firstback.compareTo(secondback) == 1){
                status = true; // Compare last card is larger than move card by exactly one points
                continue;
            }else if(firstback.compareTo(secondback) > 30 && firstback.compareTo(secondback) < 32){
                status = true; //Compare X and 9
                continue;
            }else if (firstback.compareTo(secondback) > -7 && firstback.compareTo(secondback) < -5){
                status = true; //Compare K and Q
                continue;
            }else if (firstback.compareTo(secondback) > -16 && firstback.compareTo(secondback) < -13){
                status = true; //Compare 2 and A(-15) ; Compare J and X(-14)
                continue;
            }else if (firstback.compareTo(secondback) == 1){
                status = false;
                break; 
            }else if (firstback.compareTo(secondback) < 0){
                status = false;
                break;
            }else if (firstback.compareTo(secondback) > 1){
                status = false;
                break;
            }
        }
        */
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //deepShuffle();
        printAll();
        //String end = " ";
        System.out.println("-----------------------------------------");
        do{
            try{
                System.out.print("Command > ");
                firstList = input.next();
                //System.out.print("Enter the element in the source column: ");
                element = input.next();
                //System.out.print("Enter the target column: ");
                target = input.next();
                makeSelection();
                printAll();
                //System.out.print("Press y to continue, x to exit: ");
                //end = input.next();
            }
            catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            
        }while(!target.equals("x"));
        
    }

}


class TestFreecell{
    public static void main(String[]args){
        /*
        
        String s1 = "a2";
        String a = String.valueOf(s1.charAt(1));
        String s2 = "aA";
        String b = String.valueOf(s2.charAt(1));
        System.out.println("Result: " + a.compareTo(b));
        if(a.compareTo(b) == 1){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        
        
        String value = test1.get(test1.size()-1);
        System.out.println("value: " + value);
        String element = "d2";
        String t = String.valueOf(element.charAt(1));
        if(value.equals("cA") && t.equals("2")){
            System.out.println("Success");
        }else{
            System.out.println("Failed");
        }
        */
        //New testing
        /*
        ArrayList<String> test1 = new ArrayList<>(List.of("c1","cA"));
        ArrayList<String> test2 = new ArrayList<>(List.of("sA","s6","d8","h4","s3","s8","c2"));
        boolean status = true;
        String n1 = "s6";
        int it1 = test2.indexOf(n1);
        System.out.println("index: " + it1);
        for(int i = it1; i<test2.size()-1;i++){
            String first = String.valueOf(test2.get(i));
            String second = String.valueOf(test2.get(i+1));
            String firstback = String.valueOf(first.charAt(1));
            String secondback = String.valueOf(second.charAt(1));
            //System.out.println("result" + i + ": " +firstback.compareTo(secondback));
            if(firstback.compareTo(secondback) > 1){
                status = false;
                System.out.println("Cannot move");
                break;
            }else{
                System.out.println("Can move");
            }
        }
        */
        /*
        for(int i = it1; i < test2.size()-1; i++){
            System.out.println(test2.get(i).compareTo(test2.get(i+1)));
            if(test2.get(i).compareTo(test2.get(i+1)) > 1){
                status = false;
                System.out.println("Cannot move");
                break;
            }else{
                System.out.println("Can move");
            }
        }
        

        //String back1 = String.valueOf(n1.charAt(1));
        String a = String.valueOf(test2.get(it1));
        System.out.println("a = " + a);
        String ai = String.valueOf(a.charAt(1));
        System.out.println("ai = " + ai);
        */
        String a1 = "K";
        String a2 = "Q";
        System.out.println("Result = " +a2.compareTo(a1));
        int test = 15;
        if(test > 0 && test < 16){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

}

class testGit{
    public static void main(String[] args){
        System.out.println("testing git");
    }
}
