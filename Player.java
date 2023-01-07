class Player{
  String[] cards;
  int playerNum;
  boolean ai;
  public Player(String[] array,int playerNumber, boolean aiCheck){
    cards = array;
    playerNum = playerNumber;
    ai = aiCheck;
  }

public String toString() {
	return String.format("%s, %s, %s", java.util.Arrays.toString(cards), playerNum, ai);
}
  
  
}