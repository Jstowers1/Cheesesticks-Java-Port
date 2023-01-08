import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

class Main {
  @Override
  public String toString() {
    return "The string representation";
  }

  //Master Deck, do not touch!
  public static class Global {
    public static Object[] deck = new Object[] {"2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","A","A","A","A"};
    public static String[] oneSet = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
  }
  
  //Add/Subtract to a list
  //FALSE IS TO SUBTRACT
  //TRUE IS TO ADD
  public static Object[] Deck(){
    return Global.deck;
  }

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
    Object[][] botCards = new Object[botCount][1];
    for(int i = 0; i<botCount;i++){
      Object[][] botCard = new Object[][]{{i+1, cardDivide()}};
      botCards[i] = botCard;
    }
    return botCards;
  }
  
  //Splits the Chew-Dee array into a string, fit for the player and use
  public static String deckToString(Object[][] playerCards, int playerNum){
    String playerDeck = Arrays.deepToString(playerCards);
    playerDeck = playerDeck.substring(1, playerDeck.length()-1);
    System.out.println(playerDeck);
    for(int i = 0; i < (playerNum)*3; i++){
      playerDeck = playerDeck.substring(playerDeck.indexOf("[")+1,playerDeck.length());
    }
    playerDeck = playerDeck.substring(0,playerDeck.indexOf("]"));
    System.out.println(playerDeck);
    return playerDeck;
  }

  //Check to see if there is 4 of a kind in the deck
  public static boolean cheeseCheck(Object[][] playerDe, int playerNum){
    int count = 0;
    playerNum--;
    Object[] x23 = new Object[]{"4","4","4","4","5","6","7"};
    Object[][] playerDec = new Object[][]{{1, x23}};
    String playerDeck = new String(deckToString(playerDec, playerNum));
    for(int i = 0; i < playerDeck.length();i++){
      count = 0;
      for(int i2 = 0; i2 < Global.oneSet.length;i2++){
        if((playerDeck.equals(Global.oneSet[i2]))){
          count++;
          System.out.println(count);
        }
        if(count%4 == 0 && count>0){
          System.out.println(count);
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to Cheesesticks!");
    Global.deck = shufle();
    //Get the proper number of other bots
    int playerCount = 1;
    System.out.println("How many bots do you want to play with? Answer 2 - 7.");
    playerCount = scan.nextInt();
    while(!(playerCount >= 2 && playerCount <= 7)){
      System.out.println("Enter a proper value. 2-7 bots?");
      playerCount = scan.nextInt();
    }
    Object[][] playCards = new Object[playerCount][1];
    //Use two-dimensional arrays to hold information for players
    //D1 - Player Number
    //D2 - Deck for each player 
    //Maybe turn this into an array of objects? Would make sense in the end 
    //11/6 signoff
    playCards = playerDeck(playerCount);

    String oneCards = new String(deckToString(playCards, 1));
    System.out.printf("Here are your cards: %s\n", oneCards);
   
    /*
    boolean cheesestick = cheeseCheck(playCards, 1);
    if (cheesestick){
      System.out.println("CHEESE DETECTED");
    }else{
      System.out.println("no cheese :(");
    }
    */
    scan.close();
  }
}