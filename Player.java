class Player{
  Object[] cards;
  int playerNum;
  boolean ai;
  public Player(Object[] array,int playerNumber, boolean aiCheck){
    cards = array;
    playerNum = playerNumber;
    ai = aiCheck;
  }

public String toString() {
	return String.format("%s, %s, %s", java.util.Arrays.toString(cards), playerNum, ai);
}
  
}