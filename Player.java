import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
class Player{
  //Testing 123
  String[] cards = new String[5];
  Object[] carObj = new Object[5];
  int playerNum;
  boolean ai;
  int score = 0;
  public Player(String[] array,int playerNumber, boolean aiCheck){
    cards = array;
    carObj = array;
    playerNum = playerNumber;
    ai = aiCheck;
  }

public String toString() {
	return String.format("%s, %s, %s", Arrays.deepToString(cards), playerNum, ai);
}
public String getCards(){
  return Arrays.deepToString(cards);
}
public boolean getAI(){
  return ai;
}
public int getScore(){
  return score;
}


//Pass values to ask and remove cards when a player asks for cards
public static void cardAsk(Player pAsk, Player pDraw, String wantCard){
  int count = 0;
  for(int emCheck = 0; emCheck < pDraw.cards.length; emCheck++){
    if(pDraw.cards[emCheck].equals(wantCard)){
      count++;
    }
  }
  if(count > 0){
    if(pAsk.getAI() == false){
      //WORK ON THIS
      if(count > 1){
        System.out.printf("Congratulations! You got %s cards of %s from player %s!\n",count, wantCard, pDraw.playerNum);
      }else if(count == 1){
        System.out.printf("Congratulations! You got %s card of %s from player %s!\n",count, wantCard, pDraw.playerNum);
      }
  }
    for(int adding = 0; adding < count; adding++){
      pAsk.cards = Functions.addArray(pAsk.cards, wantCard, true);
      pDraw.cards = Functions.addArray(pDraw.cards, wantCard, false);
      }
  }
  if(count == 0){
    if(pAsk.getAI() == false){
      System.out.printf("Player %s did not have any of your requested cards.\n", pDraw.playerNum);
    }
    pAsk.cards = Functions.addArray(pAsk.cards, Arrays.toString(Functions.Global.deck).substring(1,2),true);
    Functions.Global.deck = Functions.addArray(Functions.Global.deck, Arrays.toString(Functions.Global.deck).substring(1,2),false);
  }
}

//Check to see if there is 4 of a kind in the deck
public static void cheeseCheck(Player player){
    int count = 0;
    String winningCard = "";
    for(int checkPlayIndex = 0; checkPlayIndex < player.cards.length && count != 4; checkPlayIndex++){
      //Here is where I have to input the code again if i mess up too badly
      count = 0;
      for(int setIndex = 0; setIndex < Functions.Global.oneSet.length; setIndex++){
        if(player.cards[checkPlayIndex].equals(Functions.Global.oneSet[setIndex])){
          for(int finalPlayIndex = 0; finalPlayIndex <player.cards.length; finalPlayIndex++){
            if(player.cards[finalPlayIndex].equals(Functions.Global.oneSet[setIndex])){
              count++;
              winningCard = (Functions.Global.oneSet[setIndex]);
            }
          }
        }
      }
      if(player.getAI() == false && count == 4){
        System.out.println("That was a valid cheesestick!");
        player.score++;
        for(int i = 0; i < 3; i++){
          player.cards = Functions.addArray(player.cards, winningCard, false);
        }
      }
    } 
  }
}