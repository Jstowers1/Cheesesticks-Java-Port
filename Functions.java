import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Functions {
  //Testing 123
  //Master Deck, do not touch!
  public static class Global {
    public static Object[] deck = new Object[] {"2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","A","A","A","A"};
    public static String[] oneSet = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    public static String[] filler = new String[]{"7","7","7","7","7","7","7"};
  }
  public static String getSet() {
    return Arrays.toString(Global.oneSet);
  }
  
  //Add/Subtract to a list
  //FALSE IS TO SUBTRACT
  //TRUE IS TO ADD
  public static Object[] addArray(Object[] arr, String value, boolean addCheck){
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
    Object[] newArr = new Object[arrList.size()];
    newArr = arrList.toArray(newArr);
    return(newArr);
  }

  //Add/Subtract to a list(AND RETURN TO A STRING)
  //FALSE IS TO SUBTRACT
  //TRUE IS TO ADD
  public static String[] addArrayStr(String[] arr, String value, boolean addCheck){
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
  public static Object[] shufle(){
    int randomNumber;
    Object[] newDeck = new Object[52];
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
  public static Object[] cardDivide(){
    Object[] newArr = new String[7];
    for(int i = 0; i < 7; i++){
      newArr[i] = Global.deck[0];
      Global.deck = addArray(Global.deck, Global.deck[0].toString(),false);
    }
    return newArr;
  }

  //Produce the arrays that will be used for the bot players
  public static Object[][] playerDeck(int botCount){
    Object[][] botCards = new Object[7][1];
    for(int i = 0; i<7;i++){
      if(i<= botCount){
        Object[][] botCard = new Object[][]{{i+1, cardDivide()}};
        botCards[i] = botCard;
      }else{
        Object[][] botCard = new Object[][]{{i+1, Global.filler}};
        botCards[i] = botCard;
      }
    }
    return botCards;
  }
  //Couts how many elements are in a string, important for 'deckToString'
  public static int elemCount(String playerDeck){
    char elem = ',';
    int count = 0;
    for (int i = 0; i < playerDeck.length(); i++){
      if (playerDeck.charAt(i) == elem){
        count++;
      }
    }
    return count+1;
  }

  //Splits the Chew-Dee array into a 1D string array, fit for the player and use
  public static String[] deckToString(Object[][] playerCards, int playerNum){
    //Object[][] playerCards = new Object[3][52];
    String playerDeck = Arrays.deepToString(playerCards);
    playerDeck = playerDeck.substring(1, playerDeck.length()-1);
    for(int i = 0; i < (playerNum)*3; i++){
      playerDeck = playerDeck.substring(playerDeck.indexOf("[")+1,playerDeck.length());
    }
    playerDeck = playerDeck.substring(0,playerDeck.indexOf("]"));
    String comma = new String(", ");
    playerDeck += ", ";
    comma+=playerDeck;
    playerDeck=comma;
    String[] cards = new String[elemCount(playerDeck)-2];
    int first;
    int second;
    for (int i2 = 0;i2 <= elemCount(playerDeck)*3; i2++){
      first = playerDeck.indexOf(", ");
      second = playerDeck.indexOf(", ", first+1);
      cards[i2] = playerDeck.substring(first, second);
      playerDeck = playerDeck.substring(second, playerDeck.length());
    }
    for (int i3 = 0; i3 < cards.length; i3++){
      cards[i3] = cards[i3].replaceAll(", ", "");
    }
    return cards;
  }
  

  public static Object[] toObj(String[] playerCards){
    Object[] newArr = new Object[playerCards.length];
    for(int i = 0; i < playerCards.length;i++){
      newArr[i] = playerCards[i];
    }
    return newArr;
  }


}
