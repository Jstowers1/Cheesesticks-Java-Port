import java.util.ArrayList;
import java.util.*;
class Main {
  //Master Deck, do not touch!
  static String[] deck = new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","A","A","A","A"};
  //Add/Subtract to a list
  //FALSE IS TO SUBTRACT
  //TRUE IS TO ADD
  public static String[] addArray(String[] arr, String value, boolean addCheck){
    ArrayList<String> arrList = new ArrayList<String>();
    for(int i = 0; i < arr.length;i++){
      arrList.add(arr[i]);
    }
    if(addCheck == true){
      arrList.add(value);
    }else{
      arrList.remove(value);
    }
    //Convert Arraylist to Array 
    String[] newArr = new String[arrList.size()];
    newArr = arrList.toArray(newArr);
    return(newArr);
  }
  
  //Generate a random number of any range
  public static int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
}

  //Shuffle a deck of cards
  public static String[] shufle(String[] deck){
    int randomNumber;
    String[] newDeck = new String[52];
    int i = 0;
    while(i <= deck.length*75){
      randomNumber = getRandomNumber(0,deck.length-1);
      newDeck[i] = deck[randomNumber];
      deck = addArray(deck, deck[randomNumber],false);
      i++;
    }
    return newDeck;
  }
  
  //Divides a deck into a list of 7
  public static String[] cardDivide(String[] deck){
    String[] newArr = new String[7];
    for(int i = 0; i < 7; i++){
      newArr[i] = deck[i];
      deck = addArray(deck, deck[i],false);
    }
    return newArr;
  }
  
  public static void main(String[] args) {
    deck = shufle(deck);
    Player one = new Player(cardDivide(deck), 1, false);
    System.out.println(one);
  }
}