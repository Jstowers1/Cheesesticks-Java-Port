import java.util.Arrays;
class Player{
  String[] cards = new String[5];
  Object[] carObj = new Object[5];
  int playerNum;
  boolean ai;
  int score = 0;
  boolean emptHand;

  //Constructs the player object
  public Player(String[] array,int playerNumber, boolean aiCheck){
    cards = array;
    carObj = array;
    playerNum = playerNumber;
    ai = aiCheck;
    emptHand = false;
  }

public void setScore(int newScore){
  score = newScore;
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
public boolean getHand(){
  return emptHand;
}
public int getScore(){
  return score;
}
public int getPlayerNum(){
  return playerNum;
}
//Gets the playerScore
public static String scoreBoard(Player playing){
  return (playing.getPlayerNum()+" "+playing.getScore());
}


//Pass values to ask and remove cards when a player asks for cards
public static String cardAsk(Player pAsk, Player pDraw, String wantCard){
  int count = 0;
  String result = new String("No valid move!");
  for(int emCheck = 0; emCheck < pDraw.cards.length; emCheck++){
    if(pDraw.cards[emCheck].equals(wantCard)){
      count++;
    }
  }
  if(count > 0){
    if(pAsk.getAI() == false){
      if(count > 1){
        result =  ("Congratulations! You got "+count+" cards of "+wantCard+" from player "+pDraw.playerNum+"!");
      }else if(count == 1){
        result = ("Congratulations! You got "+count+" card of "+wantCard+" from player "+pDraw.playerNum+"!");
      }
  }
    for(int adding = 0; adding < count; adding++){
      pAsk.cards = Functions.addArray(pAsk.cards, wantCard, true);
      pDraw.cards = Functions.addArray(pDraw.cards, wantCard, false);
      }
  }
  if(count == 0){
    if(pAsk.getAI() == false){
      result = ("Player "+pDraw.playerNum+" did not have any of your requested cards.");
    }
    if(Functions.Global.deck.length != 0){
      pAsk.cards = Functions.addArray(pAsk.cards, Functions.Global.deck[0],true);
      Functions.Global.deck = Functions.addArray(Functions.Global.deck, Functions.Global.deck[0],false);
    }else{
      if(pAsk.getAI() == false){
        result = ("Sorry!! The deck is out of cards!");
      }
    }
  }
  return result;
}

//Check to see if there is 4 of a kind in the deck
public static void cheeseCheck(Player player){
    int count = 0;
    String winningCard = "";
    for(int checkPlayIndex = 0; checkPlayIndex < player.cards.length && count != 4; checkPlayIndex++){
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
      if(count == 4){
        if(player.getAI() == false){
          System.out.println("That was a valid cheesestick!");
        }
        player.score++;
        for(int i = 0; i < 4; i++){
          player.cards = Functions.addArray(player.cards, winningCard, false);
        }
      }
    } 
  }
//Updates the array that deterimines wether or not the game ends
public Boolean updateHand(Player playing){
  if(playing.cards.length == 0){
    playing.emptHand = true;
    return playing.getHand();
  }else if(playing.cards.length != 0){
    playing.emptHand = false;
    return playing.getHand();
  }
  return true;
}
}