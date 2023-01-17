import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Functions {
  //Testing 123
  //Master Deck, do not touch!
  public static class Global {
    public static String[] deck = new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","A","A","A","A"};
    public static String[] oneSet = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    public static String[] filler = new String[]{"7","7","7","7","7","7","7"};
  }
  public static String getSet() {
    return Arrays.toString(Global.oneSet);
  }

  //Add/Subtract to a list(AND RETURN TO A STRING)
  //FALSE IS TO SUBTRACT
  //TRUE IS TO ADD
  public static String[] addArray(String[] arr, String value, boolean addCheck){
    String[] strings = Arrays.stream(arr).toArray(String[]::new);
    ArrayList<String> arrList = new ArrayList<String>();
    for(int i = 0; i < arr.length;i++){
      arrList.add(strings[i]);
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
  public static String[] shufle(){
    int randomNumber;
    String[] newDeck = new String[52];
    int i = 0;
    while(i < Global.deck.length*75){
      randomNumber = getRandomNumber(0,Global.deck.length-1);
      newDeck[i] = Global.deck[randomNumber];
      Global.deck = addArray(Global.deck, Global.deck[randomNumber].toString(),false);
      i++;
    }
    return newDeck;
  }
  
  //Divides a deck into a list of 7
  public static String[] cardDivide(int botCount, int playerNum){
    String[] newArr = new String[7];
    if(playerNum <= botCount){
      for(int i = 0; i < 7; i++){
        newArr[i] = Global.deck[0];
        Global.deck = addArray(Global.deck, Global.deck[0].toString(),false);
      }
    }
    return newArr;
  }
}
