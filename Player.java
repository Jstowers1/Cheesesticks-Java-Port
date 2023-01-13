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
      System.out.printf("Congratulations! You got %s cards of %s from %s!\n"count, wantCard, pDraw);)
    }
    for(int adding = 0; adding < count; adding++){
      pAsk.cards = Functions.addArrayStr(pAsk.cards, wantCard, true);
      pDraw.cards = Functions.addArrayStr(pDraw.cards, wantCard, false);
    }
  }
  
}
}