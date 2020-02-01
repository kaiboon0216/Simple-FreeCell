import java.util.*;

class OrderStack<E>{
    private ArrayList<E> list = new ArrayList<>();

    public int getSize(){
        return list.size();
    }
    
    public ArrayList<E> getList(){
        return list;
    }

    public E peek() {
        return list.get(getSize()-1);
    }

    public void push(E e) {
        list.add(e);
    }
    

    public void pushMore(E e, ArrayList<E> al){
        int index = al.indexOf(e);
        ArrayList<E> tempList = new ArrayList<>();
        for(int i =index;i<al.size();i++){
            E value = al.get(i);
            tempList.add(value);
        }
        list.addAll(tempList);

        for(int i = al.size()-1; i>=index; i--){
            E value = al.get(i);
            al.remove(value);
        }
    }
    
    public E pop() {
        E o = list.get(getSize()-1);
        list.remove(getSize()-1);
        return o;
    }

    public void popMore(E e) {
        int index = list.indexOf(e);
        for(int i=list.size()-1;i>=index;i--){
            list.remove(i);
        }
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}


class Freecell extends OrderStack{
    //Four piles
    private OrderStack<String> pileC = new OrderStack<>();
    private OrderStack<String> pileD = new OrderStack<>();
    private OrderStack<String> pileH = new OrderStack<>();
    private OrderStack<String> pileS = new OrderStack<>();

    //9 Columns
    private ArrayList<String> column1 = new ArrayList<>(List.of("cK","cQ","cJ","cX","c9","c8","c7","c6","c5","c4","c3","c2","cA"));
    private ArrayList<String> column2 = new ArrayList<>(List.of("d3","d2","dA"));
    private ArrayList<String> column3 = new ArrayList<>(List.of("dA","d2","d3"));
    private ArrayList<String> column4 = new ArrayList<>();
    private ArrayList<String> column5 = new ArrayList<>();
    private ArrayList<String> column6 = new ArrayList<>();
    private ArrayList<String> column7 = new ArrayList<>();
    private ArrayList<String> column8 = new ArrayList<>();
    private ArrayList<String> column9 = new ArrayList<>();

    private boolean pileStatus = false;
    private boolean columnStatus = false;
    private String first;
    private String element;
    private String last;

    Scanner input = new Scanner (System.in);

    public void getUserInput(){
        System.out.print("Command > ");
        first = input.next();
        element = input.next();
        last = input.next();
    }
    
    public boolean stop(){
        if(first.equals("x")){
            return true;
        }
        return false;
    }
    

    public boolean checkPile(){
        String str0 = element.substring(0,1); // element index 0 
        String str1 = element.substring(1);   // element index 1

        if(str1.equals("A")){
            if(pileC.getSize()== 0 & str0.equals("c") && last.equals("c")){
                return pileStatus = true;
            }else if (pileD.getSize()== 0 & str0.equals("d") && last.equals("d")){
                return pileStatus = true;
            }else if (pileH.getSize()== 0 & str0.equals("h") && last.equals("h")){
                return pileStatus = true;
            }else if (pileS.getSize()== 0 & str0.equals("s") && last.equals("s")){
                return pileStatus = true;
            }
        
        }
        
        if(!"A".equals(element.substring(0,1))){
            //If list2 got element inside, get the latest element and compare with the element we want to add and respective pile,
            //If the moveCard exactly one bigger than the latest element, add it into the respective pile
            //new code for testing purpose
            String strC;
            String strD;
            String strH;
            String strS;

            if(last.equals("c")){
                if(pileC.getSize() == 0){
                    return pileStatus = false;
                }
                strC = pileC.peek().substring(1);
                if (str1.equals("2") && strC.equals("A") && str0.equals("c")){
                    return pileStatus = true;
                }else if(str1.equals("X") && strC.equals("9")&& str0.equals("c")){
                    return pileStatus = true;
                }else if(str1.equals("J") && strC.equals("X")&& str0.equals("c")){
                    return pileStatus = true;
                }else if (str1.equals("Q") && strC.equals("J")&& str0.equals("c")){
                    return pileStatus = true;
                }else if (str1.equals("K") && strC.equals("Q")&& str0.equals("c")){
                    return pileStatus = true;
                }else if (str1.compareTo(strC) == 1 && str0.equals("c")){
                    return pileStatus = true;
                }
            }else if(last.equals("d")){
                if(pileD.getSize() == 0){
                    return pileStatus = false;
                }
                strD = pileD.peek().substring(1); 
                if (str1.equals("2") && strD.equals("A") && str0.equals("d")){
                    return pileStatus = true;
                }else if(str1.equals("X") && strD.equals("9")&& str0.equals("d")){
                    return pileStatus = true;
                }else if(str1.equals("J") && strD.equals("X")&& str0.equals("d")){
                    return pileStatus = true;
                }else if (str1.equals("Q") && strD.equals("J")&& str0.equals("d")){
                    return pileStatus = true;
                }else if (str1.equals("K") && strD.equals("Q")&& str0.equals("d")){
                    return pileStatus = true;
                }else if (str1.compareTo(strD) == 1 && str0.equals("d")){
                    return pileStatus = true;
                }
            }else if(last.equals("h")){
                if(pileH.getSize() == 0){
                    return pileStatus = false;
                }
                strH = pileH.peek().substring(1);
                if (str1.equals("2") && strH.equals("A") && str0.equals(pileH.peek().substring(0))){
                    return pileStatus = true;
                }else if(str1.equals("X") && strH.equals("9")&& str0.equals(pileH.peek().substring(0))){
                    return pileStatus = true;
                }else if(str1.equals("J") && strH.equals("X")&& str0.equals(pileH.peek().substring(0))){
                    return pileStatus = true;
                }else if (str1.equals("Q") && strH.equals("J")&& str0.equals(pileH.peek().substring(0))){
                    return pileStatus = true;
                }else if (str1.equals("K") && strH.equals("Q")&& str0.equals(pileH.peek().substring(0))){
                    return pileStatus = true;
                }else if (str1.compareTo(strH) == 1 && str0.equals(pileH.peek().substring(0))){
                    return pileStatus = true;
                }
            }else if(last.equals("s")){
                if(pileS.getSize() == 0){
                    return pileStatus = false;
                }
                strS = pileS.peek().substring(1);
                if (str1.equals("2") && strS.equals("A") && str0.equals(pileS.peek().substring(0))){
                    return pileStatus = true;
                }else if(str1.equals("X") && strS.equals("9")&& str0.equals(pileS.peek().substring(0))){
                    return pileStatus = true;
                }else if(str1.equals("J") && strS.equals("X")&& str0.equals(pileS.peek().substring(0))){
                    return pileStatus = true;
                }else if (str1.equals("Q") && strS.equals("J")&& str0.equals(pileS.peek().substring(0))){
                    return pileStatus = true;
                }else if (str1.equals("K") && strS.equals("Q")&& str0.equals(pileS.peek().substring(0))){
                    return pileStatus = true;
                }else if (str1.compareTo(strS) == 1 && str0.equals(pileS.peek().substring(0))){
                    return pileStatus = true;
                }
            }
        }
        return false;
    }

    public void MovePile(){
        //Column 1
        if(first.equals("1") && last.equals("c")){
            if(checkPile()){
                pileC.pushMore(element,column1);
            }
        }else if(first.equals("1") && last.equals("d")){
            if(checkPile()){
                pileD.pushMore(element,column1);
            }
        }else if(first.equals("1") && last.equals("h")){
            if(checkPile()){
                pileH.pushMore(element,column1);
            }
        }else if(first.equals("1") && last.equals("s")){
            if(checkPile()){
                pileS.pushMore(element,column1);
            }
        //Column 2
        }else if(first.equals("2") && last.equals("c")){
            if(checkPile()){
                pileC.pushMore(element,column2);
            }
        }else if(first.equals("2") && last.equals("d")){
            if(checkPile()){
                pileD.pushMore(element,column2);
            }
        }else if(first.equals("2") && last.equals("h")){
            if(checkPile()){
                pileH.pushMore(element,column2);
            }
        }else if(first.equals("2") && last.equals("s")){
            if(checkPile()){
                pileS.pushMore(element,column2);
            }
        //Column 3
        }else if(first.equals("3") && last.equals("c")){
            if(checkPile()){
                pileC.pushMore(element,column3);
            }
        }else if(first.equals("3") && last.equals("d")){
            if(checkPile()){
                pileD.pushMore(element,column3);
            }
        }else if(first.equals("3") && last.equals("h")){
            if(checkPile()){
                pileH.pushMore(element,column3);
            }
        }else if(first.equals("3") && last.equals("s")){
            if(checkPile()){
                pileS.pushMore(element,column3);
            }
        //Column 4
        }else if(first.equals("4") && last.equals("c")){
            if(checkPile()){
                pileC.pushMore(element,column4);
            }
        }else if(first.equals("4") && last.equals("d")){
            if(checkPile()){
                pileD.pushMore(element,column4);
            }
        }else if(first.equals("4") && last.equals("h")){
            if(checkPile()){
                pileH.pushMore(element,column4);
            }
        }else if(first.equals("4") && last.equals("s")){
            if(checkPile()){
                pileS.pushMore(element,column4);
            }
        //Column 5
        }else if(first.equals("5") && last.equals("c")){
            if(checkPile()){
                pileC.pushMore(element,column5);
            }
        }else if(first.equals("5") && last.equals("d")){
            if(checkPile()){
                pileD.pushMore(element,column5);
            }
        }else if(first.equals("5") && last.equals("h")){
            if(checkPile()){
                pileH.pushMore(element,column5);
            }
        }else if(first.equals("5") && last.equals("s")){
            if(checkPile()){
                pileS.pushMore(element,column5);
            }
        //Column 6
        }else if(first.equals("6") && last.equals("c")){
            if(checkPile()){
                pileC.pushMore(element,column6);
            }
        }else if(first.equals("6") && last.equals("d")){
            if(checkPile()){
                pileD.pushMore(element,column6);
            }
        }else if(first.equals("6") && last.equals("h")){
            if(checkPile()){
                pileH.pushMore(element,column6);
            }
        }else if(first.equals("6") && last.equals("s")){
            if(checkPile()){
                pileS.pushMore(element,column6);
            }
        //Column 7
        }else if(first.equals("7") && last.equals("c")){
            if(checkPile()){
                pileC.pushMore(element,column7);
            }
        }else if(first.equals("7") && last.equals("d")){
            if(checkPile()){
                pileD.pushMore(element,column7);
            }
        }else if(first.equals("7") && last.equals("h")){
            if(checkPile()){
                pileH.pushMore(element,column7);
            }
        }else if(first.equals("7") && last.equals("s")){
            if(checkPile()){
                pileS.pushMore(element,column7);
            }
        //Column 8
        }else if(first.equals("8") && last.equals("c")){
            if(checkPile()){
                pileC.pushMore(element,column8);
            }
        }else if(first.equals("8") && last.equals("d")){
            if(checkPile()){
                pileD.pushMore(element,column8);
            }
        }else if(first.equals("8") && last.equals("h")){
            if(checkPile()){
                pileH.pushMore(element,column8);
            }
        }else if(first.equals("8") && last.equals("s")){
            if(checkPile()){
                pileS.pushMore(element,column8);
            }
        //Column 9
        }else if(first.equals("9") && last.equals("c")){
            if(checkPile()){
                pileC.pushMore(element,column9);
            }
        }else if(first.equals("9") && last.equals("d")){
            if(checkPile()){
                pileD.pushMore(element,column9);
            }
        }else if(first.equals("9") && last.equals("h")){
            if(checkPile()){
                pileH.pushMore(element,column9);
            }
        }else if(first.equals("9") && last.equals("s")){
            if(checkPile()){
                pileS.pushMore(element,column9);
            }
        }
    }

    public void checkColumn(ArrayList<String> firstList, String element, ArrayList<String> secondList){
        int index = firstList.indexOf(element);
        String ele0 = element.substring(0,1); // element index 0
        String ele1 = element.substring(1); // element index 1
        

        if(secondList.size() == 0){
            if(last.equals("c") && ele0.equals("c") && ele1.equals("A")){
                columnStatus = true;
            }else if(last.equals("d") && ele0.equals("d") && ele1.equals("A")){
                columnStatus = true;
            }else if(last.equals("h") && ele0.equals("h") && ele1.equals("A")){
                columnStatus = true;
            }else if(last.equals("s") && ele0.equals("s") && ele1.equals("A")){
                columnStatus = true;
            }else if (!(last.equals("c") || last.equals("d")|| last.equals("h")|| last.equals("s"))){
                columnStatus = true;
            }
        }else{
            String lastEle = secondList.get(secondList.size()-1); 
            String strLastEle = lastEle.substring(1); //item in target column
            if(ele1.equals("A") && strLastEle.equals("2")){
                columnStatus = true;
            }else if(ele1.equals("9") && strLastEle.equals("X")){
                columnStatus = true;
            }else if(ele1.equals("X") && strLastEle.equals("J")){
                columnStatus = true;
            }else if(ele1.equals("J") && strLastEle.equals("Q")){
                columnStatus = true;
            }else if (ele1.equals("Q") && strLastEle.equals("K")){
                columnStatus = true;
            }else if (strLastEle.compareTo(ele1) == 1){
                columnStatus = true;
            }

        }
        
        for(int i = index; i < firstList.size()-1; i++){
            String firstInList = String.valueOf(firstList.get(i));
            String secondInList = String.valueOf(firstList.get(i+1));
            String firstInListBack = firstInList.substring(1);
            String secondInListBack = secondInList.substring(1);
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
            }else if (firstInListBack.compareTo(secondInListBack) == 1){
                columnStatus = false;
                break; 
            }else if (firstInListBack.compareTo(secondInListBack) < 0){
                columnStatus = false;
                break;
            }else if (firstInListBack.compareTo(secondInListBack) > 1){
                columnStatus = false;
                break;
            }
        }
    }

    public void moveColoumn(ArrayList<String> list1, String string, ArrayList<String> list2){
        if(columnStatus){
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
        columnStatus = false;
    }

    public void MakeSelection(){
        //Column1
        if(first.equals("1") && last.equals("2")){
            checkColumn(column1,element,column2);
            moveColoumn(column1,element,column2);
        }else if (first.equals("1") && last.equals("3")){
            checkColumn(column1,element,column3);
            moveColoumn(column1,element,column3);
        }else if (first.equals("1") && last.equals("4")){
            checkColumn(column1,element,column4);
            moveColoumn(column1,element,column4);
        }else if (first.equals("1") && last.equals("5")){
            checkColumn(column1,element,column5);
            moveColoumn(column1,element,column5);
        }else if (first.equals("1") && last.equals("6")){
            checkColumn(column1,element,column6);
            moveColoumn(column1,element,column6);
        }else if (first.equals("1") && last.equals("7")){
            checkColumn(column1,element,column7);
            moveColoumn(column1,element,column7);
        }else if (first.equals("1") && last.equals("8")){
            checkColumn(column1,element,column8);
            moveColoumn(column1,element,column8);
        }else if (first.equals("1") && last.equals("9")){
            checkColumn(column1,element,column9);
            moveColoumn(column1,element,column9);
        //Column2
        }else if (first.equals("2") && last.equals("1")){
            checkColumn(column2,element,column1);
            moveColoumn(column2,element,column1);
        }else if (first.equals("2") && last.equals("3")){
            checkColumn(column2,element,column3);
            moveColoumn(column2,element,column3);
        }else if (first.equals("2") && last.equals("4")){
            checkColumn(column2,element,column4);
            moveColoumn(column2,element,column4);
        }else if (first.equals("2") && last.equals("5")){
            checkColumn(column2,element,column5);
            moveColoumn(column2,element,column5);
        }else if (first.equals("2") && last.equals("6")){
            checkColumn(column2,element,column6);
            moveColoumn(column2,element,column6);
        }else if (first.equals("2") && last.equals("7")){
            checkColumn(column2,element,column7);
            moveColoumn(column2,element,column7);
        }else if (first.equals("2") && last.equals("8")){
            checkColumn(column2,element,column8);
            moveColoumn(column2,element,column8);
        }else if (first.equals("2") && last.equals("9")){
            checkColumn(column2,element,column9);
            moveColoumn(column2,element,column9);
        //Column3
        }else if (first.equals("3") && last.equals("1")){
            checkColumn(column3,element,column1);
            moveColoumn(column3,element,column1);
        }else if(first.equals("3") && last.equals("2")){
            checkColumn(column3,element,column2);
            moveColoumn(column3,element,column2);
        }else if (first.equals("3") && last.equals("4")){
            checkColumn(column3,element,column4);
            moveColoumn(column3,element,column4);
        }else if (first.equals("3") && last.equals("5")){
            checkColumn(column3,element,column5);
            moveColoumn(column3,element,column5);
        }else if (first.equals("3") && last.equals("6")){
            checkColumn(column3,element,column6);
            moveColoumn(column3,element,column6);
        }else if (first.equals("3") && last.equals("7")){
            checkColumn(column3,element,column7);
            moveColoumn(column3,element,column7);
        }else if (first.equals("3") && last.equals("8")){
            checkColumn(column3,element,column8);
            moveColoumn(column3,element,column8);
        }else if (first.equals("3") && last.equals("9")){
            checkColumn(column3,element,column9);
            moveColoumn(column3,element,column9);
        //Column4
        }else if (first.equals("4") && last.equals("1")){
            checkColumn(column4,element,column1);
            moveColoumn(column4,element,column1);
        }else if (first.equals("4") && last.equals("2")){
            checkColumn(column4,element,column2);
            moveColoumn(column4,element,column2);
        }else if(first.equals("4") && last.equals("3")){
            checkColumn(column4,element,column3);
            moveColoumn(column4,element,column3);
        }else if (first.equals("4") && last.equals("5")){
            checkColumn(column4,element,column5);
            moveColoumn(column4,element,column5);
        }else if (first.equals("4") && last.equals("6")){
            checkColumn(column4,element,column6);
            moveColoumn(column4,element,column6);
        }else if (first.equals("4") && last.equals("7")){
            checkColumn(column4,element,column7);
            moveColoumn(column4,element,column7);
        }else if (first.equals("4") && last.equals("8")){
            checkColumn(column4,element,column8);
            moveColoumn(column4,element,column8);
        }else if (first.equals("4") && last.equals("9")){
            checkColumn(column4,element,column9);
            moveColoumn(column4,element,column9);
        //Column5
        }else if (first.equals("5") && last.equals("1")){
            checkColumn(column5,element,column1);
            moveColoumn(column5,element,column1);
        }else if (first.equals("5") && last.equals("2")){
            checkColumn(column5,element,column2);
            moveColoumn(column5,element,column2);
        }else if (first.equals("5") && last.equals("3")){
            checkColumn(column5,element,column3);
            moveColoumn(column5,element,column3);
        }else if(first.equals("5") && last.equals("4")){
            checkColumn(column5,element,column4);
            moveColoumn(column5,element,column4);
        }else if (first.equals("5") && last.equals("6")){
            checkColumn(column5,element,column6);
            moveColoumn(column5,element,column6);
        }else if (first.equals("5") && last.equals("7")){
            checkColumn(column5,element,column7);
            moveColoumn(column5,element,column7);
        }else if (first.equals("5") && last.equals("8")){
            checkColumn(column5,element,column8);
            moveColoumn(column5,element,column8);
        }else if (first.equals("5") && last.equals("9")){
            checkColumn(column5,element,column9);
            moveColoumn(column5,element,column9);
        //Column6
        }else if (first.equals("6") && last.equals("1")){
            checkColumn(column6,element,column1);
            moveColoumn(column6,element,column1);
        }else if (first.equals("6") && last.equals("2")){
            checkColumn(column6,element,column2);
            moveColoumn(column6,element,column2);
        }else if (first.equals("6") && last.equals("3")){
            checkColumn(column6,element,column3);
            moveColoumn(column6,element,column3);
        }else if (first.equals("6") && last.equals("4")){
            checkColumn(column6,element,column4);
            moveColoumn(column6,element,column4);
        }else if(first.equals("6") && last.equals("5")){
            checkColumn(column6,element,column5);
            moveColoumn(column6,element,column5);
        }else if (first.equals("6") && last.equals("7")){
            checkColumn(column6,element,column7);
            moveColoumn(column6,element,column7);
        }else if (first.equals("6") && last.equals("8")){
            checkColumn(column6,element,column8);
            moveColoumn(column6,element,column8);
        }else if (first.equals("6") && last.equals("9")){
            checkColumn(column6,element,column9);
            moveColoumn(column6,element,column9);
        //Column7
        }else if (first.equals("7") && last.equals("1")){
            checkColumn(column7,element,column1);
            moveColoumn(column7,element,column1);
        }else if (first.equals("7") && last.equals("2")){
            checkColumn(column7,element,column2);
            moveColoumn(column7,element,column2);
        }else if (first.equals("7") && last.equals("3")){
            checkColumn(column7,element,column3);
            moveColoumn(column7,element,column3);
        }else if (first.equals("7") && last.equals("4")){
            checkColumn(column7,element,column4);
            moveColoumn(column7,element,column4);
        }else if(first.equals("7") && last.equals("5")){
            checkColumn(column7,element,column5);
            moveColoumn(column7,element,column5);
        }else if (first.equals("7") && last.equals("6")){
            checkColumn(column7,element,column6);
            moveColoumn(column7,element,column6);
        }else if (first.equals("7") && last.equals("8")){
            checkColumn(column7,element,column8);
            moveColoumn(column7,element,column8);
        }else if (first.equals("7") && last.equals("9")){
            checkColumn(column7,element,column9);
            moveColoumn(column7,element,column9);
        //Column8
        }else if (first.equals("8") && last.equals("1")){
            checkColumn(column8,element,column1);
            moveColoumn(column8,element,column1);
        }else if (first.equals("8") && last.equals("2")){
            checkColumn(column8,element,column2);
            moveColoumn(column8,element,column2);
        }else if (first.equals("8") && last.equals("3")){
            checkColumn(column8,element,column3);
            moveColoumn(column8,element,column3);
        }else if (first.equals("8") && last.equals("4")){
            checkColumn(column8,element,column4);
            moveColoumn(column8,element,column4);
        }else if(first.equals("8") && last.equals("5")){
            checkColumn(column8,element,column5);
            moveColoumn(column8,element,column5);
        }else if (first.equals("8") && last.equals("6")){
            checkColumn(column8,element,column6);
            moveColoumn(column8,element,column6);
        }else if (first.equals("8") && last.equals("7")){
            checkColumn(column8,element,column7);
            moveColoumn(column8,element,column7);
        }else if (first.equals("8") && last.equals("9")){
            checkColumn(column8,element,column9);
            moveColoumn(column8,element,column9);
        //Column9
        }else if (first.equals("9") && last.equals("1")){
            checkColumn(column9,element,column1);
            moveColoumn(column9,element,column1);
        }else if (first.equals("9") && last.equals("2")){
            checkColumn(column9,element,column2);
            moveColoumn(column9,element,column2);
        }else if (first.equals("9") && last.equals("3")){
            checkColumn(column9,element,column3);
            moveColoumn(column9,element,column3);
        }else if (first.equals("9") && last.equals("4")){
            checkColumn(column9,element,column4);
            moveColoumn(column9,element,column4);
        }else if(first.equals("9") && last.equals("5")){
            checkColumn(column9,element,column5);
            moveColoumn(column9,element,column5);
        }else if (first.equals("9") && last.equals("6")){
            checkColumn(column9,element,column6);
            moveColoumn(column9,element,column6);
        }else if (first.equals("9") && last.equals("7")){
            checkColumn(column9,element,column7);
            moveColoumn(column9,element,column7);
        }else if (first.equals("9") && last.equals("8")){
            checkColumn(column9,element,column8);
            moveColoumn(column9,element,column8);
        }
    } 

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

class TestFreecell{
    public static void main(String[] args){
        Freecell freecell = new Freecell();
        do{
            System.out.println("-----------------------");
            freecell.printAll();
            freecell.getUserInput();
            freecell.MovePile();
            freecell.MakeSelection();
        }while(!freecell.stop());
    }
}


