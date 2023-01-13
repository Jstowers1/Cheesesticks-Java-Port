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
      pAsk.cards = Functions.addArrayStr(pAsk.cards, wantCard, true);
      pDraw.cards = Functions.addArrayStr(pDraw.cards, wantCard, false);
      }
  }
  if(count == 0){
    if(pAsk.getAI() == false){
      System.out.printf("Player %s did not have any of your requested cards.\n", pDraw.playerNum);
    }
    pAsk.cards = Functions.addArrayStr(pAsk.cards, Arrays.toString(Functions.Global.deck).substring(1,2),true);
    Functions.Global.deck = Functions.addArray(Functions.Global.deck, Arrays.toString(Functions.Global.deck).substring(1,2),false);
  }
}

//Check to see if there is 4 of a kind in the deck
public static void cheeseCheck(Player checkPlay){
    int count = 0;
    String[] player = new String[5];
    player = checkPlay.cards;
    System.out.println(Arrays.toString((player)));
    String play = new String("");
    String set = new String("");
    for(int i = 0; i < player.length; i++){
      count = 0;
      int i2 = 0;
      while(i2 < 13){
        play = player[i];
        set = Functions.Global.oneSet[i2];
        if(play.equals(set)){
          for(int i4 = 0; i4 < player.length; i4++){
            if(player[i4].equals(set)){
              count++;
            }
          }
        }
        if(count == 4){
          if(checkPlay.getAI() == false){
            System.out.println("Congratulations! You had 4 of a kind, and your score has been increased.");
          }
          checkPlay.score ++;
        }
        i2++;
      }
      
    }
    if(checkPlay.getAI() == false){
      System.out.println("You do not have a valid Cheesestick.");
    }
  }
}