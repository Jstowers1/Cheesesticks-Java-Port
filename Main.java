import java.util.ArrayList;
import java.util.*;
class Main {
  //Add/Subtract to a list
  //FALSE IS TO SUBTRACT
  //TRUE IS TO ADD
  public static String[] addArray(String[] arr, String value, boolean addCheck){
    ArrayList<String> arrList = new ArrayList<String>();
    for(int i = 0; i < arr.length;i++){
      arrList.add(arr[i]);
    }
    System.out.println(value);
    if(addCheck == true){
      arrList.add(value);
    }else{
      arrList.remove(value);
    }
    //Convert Arraylist to Array 
    System.out.println(arrList+" HELLO THIS IS ALSIT");
    String[] newArr = new String[arrList.size()];
    System.out.println(java.util.Arrays.toString(newArr));
    newArr = arrList.toArray(newArr);
    return(newArr);
  }
  
  //Generate a random number of any range
  public static int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
}

  //Shuffle a deck of cards
  public static void shufle(String[] deck){
    int randomNumber;
    String[] newDeck = new String[52];
    System.out.println(deck.length);
    int i = 0;
    while(i <= deck.length*75){
      randomNumber = getRandomNumber(0,deck.length-1);
      newDeck[i] = deck[randomNumber];
      deck = addArray(deck, deck[randomNumber],false);
      System.out.println("ITERATION!"+ i);
      System.out.println(deck.length);
      i++;
    }
  }
  
  //Divides a deck into a list of 7
  public static void cardDivide(String[] deck){
    
  }
  
  public static void main(String[] args) {
    //Master Deck, do not touch!
    String[] deck = new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","A","A","A","A"};
    shufle(deck);
    
    String[] array = new String[] {"1","2", "3", "4"};
    Player one = new Player(array, 1, false);
    System.out.println(one);
  }
}