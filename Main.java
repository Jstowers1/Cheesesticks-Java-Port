import java.util.ArrayList;
import java.util.*;
class Main {
  //Master Deck, do not touch!
  static Object[] deck = new Object[] {"2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","2","3","4","5","6","7","8","9","10","J","Q","K","A","A","A","A"};

  //Add/Subtract to a list
  //FALSE IS TO SUBTRACT
  //TRUE IS TO ADD
  public static Object[] Deck(){
    return deck;
  }
  public static Object[] addArray(Object[] arr, String value, boolean addCheck){
    String[] strings = Arrays.stream(arr).toArray(String[]::new);
    //String value = new String(valu.toString());
    ArrayList<String> arrList = new ArrayList<String>();
    System.out.println(value + "WOO VALUE!!");
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
    System.out.println(Arrays.toString(newArr)+" NEW ARRAY");
    return(newArr);
  }
  
  //Generate a random number of any range
  public static int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
}

  //Shuffle a deck of cards
  public static Object[] shufle(Object[] deck){
    int randomNumber;
    Object[] newDeck = new Object[52];
    int i = 0;
    while(i <= deck.length*75){
      randomNumber = getRandomNumber(0,deck.length-1);
      newDeck[i] = deck[randomNumber];
      deck = addArray(deck, deck[randomNumber].toString(),false);
      i++;
    }
    return newDeck;
  }
  
  //Divides a deck into a list of 7
  public static Object[] cardDivide(Object[] deck){
    Object[] newArr = new String[7];
    System.out.println(Arrays.toString(deck));
    for(int i3 = 0; i3 < 7; i3++){
      System.out.println(i3 + " INDEX OF CARDDIVIDE");
      newArr[i3] = deck[i3];
      System.out.println(deck[i3].toString() + "THIS SHOULD BE REMOVED");
      deck = addArray(deck, deck[i3].toString(),false);
    }
    return newArr;
  }

  //Produce the arrays that will be used for the bot players
  public static Object[][] botDeck(Object[] deck, int botCount){
    Object[][] botCards = new Object[botCount][1];
    Integer playerNum = (0);
    Object[] playerNumber = new Object[1];
    for(int i = 0; i<botCount;i++){
      playerNum = i;
      playerNumber[0] = playerNum.toString();
      botCards[i] = playerNumber;
      botCards[i][0] = cardDivide(deck);
    }

    return botCards;
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to Cheesesticks!");
    deck = shufle(deck);
    Player one = new Player(cardDivide(deck), 1, false);
    System.out.println(one);
    //Get the proper number of other bots
    int playerCount = 1;
    System.out.println("How many bots do you want to play with? Answer 2 - 7.");
    playerCount = scan.nextInt();
    while(!(playerCount >= 2 && playerCount <= 7)){
      System.out.println("Enter a proper value. 2-7 bots?");
      playerCount = scan.nextInt();
    }
    int botCount = playerCount-1;
    Object[][] botCards = new Object[botCount][1];
    //Use two-dimensional arrays to hold information for players
    //D1 - Player Number
    //D2 - Deck for each player 
    //Maybe turn this into an array of objects? Would make sense in the end 
    //11/6 signoff
    botCards = botDeck(deck, botCount);
    System.out.println(Arrays.deepToString(botCards));
    System.out.println(one);
    scan.close();
  }
}