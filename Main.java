import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

class Main {
  //testing123
  public static void clear(){
    System.out.print("\033[H\033[2J");
      System.out.flush();
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to Cheesesticks!");
    Functions.Global.deck = Functions.shufle();
    //Get the proper number of other bots
    //REPLACE THIS REMOVE THE COMMENTS PLEASSSEEEE
    int playerCount = 3;
    
    System.out.println("How many bots do you want to play with? Answer 2 - 7.");
    playerCount = scan.nextInt();
    while(!(playerCount >= 2 && playerCount <= 7)){
      System.out.println("Enter a proper value. 2-7 bots?");
      playerCount = scan.nextInt();
    }
    
    Object[][] playCards = new Object[7][1];
    playCards = Functions.playerDeck(playerCount);
    String[] oneCards = new String[5];
    String[] twoCards = new String[5];
    String[] threeCards = new String[5];
    String[] fourCards = new String[5];
    String[] fiveCards = new String[5];
    String[] sixCards = new String[5];
    String[] sevenCards = new String[5];

    oneCards = Functions.deckToString(playCards, 1);
    twoCards = Functions.deckToString(playCards, 2);
    threeCards = Functions.deckToString(playCards, 3);
    fourCards = Functions.deckToString(playCards, 4);
    fiveCards = Functions.deckToString(playCards, 5);
    sixCards = Functions.deckToString(playCards, 6);
    sevenCards = Functions.deckToString(playCards, 7);

    Player p1 = new Player(oneCards, 1, false);
    Player p2 = new Player(twoCards, 2, true);
    Player p3 = new Player(threeCards, 3, true);
    Player p4 = new Player(fourCards, 4, true);
    Player p5 = new Player(fiveCards, 5, true);
    Player p6 = new Player(sixCards, 6, true);
    Player p7 = new Player(sevenCards, 7, true);

    Player[] players = new Player[]{p1,p2,p3,p4,p5,p6,p7};
    int[] scoreboard = new int[]{p1.getScore(),p2.getScore(),p3.getScore(),p4.getScore(),p5.getScore(),p6.getScore(),p7.getScore()};
    String desire = new String("");
    int pAsk = 0;
    clear();
    //Game Loop
    while(true){
      
      for(int playerTurn = 0; playerTurn < playerCount; playerTurn++){
        scoreboard[playerTurn] = players[playerTurn].getScore();
        if(players[playerTurn].getAI() == false){
          System.out.println("Here is the current score:");
          for(int scoreCheck = 0; scoreCheck < playerCount; scoreCheck++){
            System.out.printf("Player %s's score: %s\n", players[scoreCheck].playerNum, players[scoreCheck].getScore());
          }
          System.out.println("");
          System.out.printf("Here are your cards: %s\n",p1.getCards());
          System.out.println(p2.getCards());
          System.out.println("You can do two things, check for a Cheesestick, or ask for a card.\nPlease type either \"Cheesestick\" or \"Ask\".");
          String move = new String("");

          //FALSE - CHEESECHECK
          //TRUE - ASK
          Boolean moveCheck = false;
          Boolean moveConfirm = false;
          move = scan.next();
          move = move.toUpperCase();
          while(moveCheck == false){
            if(move.equals("CHEESESTICK") || move.equals("ASK")){
              moveConfirm = true;
              if(move.equals("CHEESESTICK")){
                moveCheck = false;
              }
              if(move.equals("ASK")){
                moveCheck = true;
              }
              break;
            }else{
              System.out.println("Please enter a valid move.\nYour options are either \"Cheesestick\" or \"Ask\".");
              move = scan.next();
              move = move.toUpperCase();
            }
          }

          //Code for asking cards
          if(moveConfirm == true){
            System.out.println("What player would you like to ask? Please enter a number from 2 to "+playerCount+".");
            pAsk = scan.nextInt();
            while(pAsk == 1 || pAsk>playerCount){
              if(!(pAsk!=1) || !(pAsk<playerCount)){
                System.out.println("Enter a valid player. 2-"+playerCount+"!");
                pAsk = scan.nextInt();
              }
            }
            System.out.println("What card would you like to request from "+pAsk+"?\nHere are the cards you can ask for:"+Functions.getSet());
            desire = scan.next();
            desire = desire.toUpperCase();
            boolean cardCheck = false;
            while(cardCheck == false){
              int cardIndex = 0;
              while(cardIndex < Functions.Global.oneSet.length){
                if(Functions.Global.oneSet[cardIndex].equals(desire)){
                  cardCheck = true;
                }
                cardIndex++;
                if(desire.equals("A")){
                  cardCheck = true;
                }
                if(cardIndex == 12 && cardCheck == false){
                  System.out.println("That was not a valid card. The deck to choose from is: "+Functions.getSet());
                  desire = scan.next();
                  desire = desire.toUpperCase();
                }
              }
            }
            Player.cardAsk(p1, players[pAsk-1], desire);
          }else{ //Work on this line of code specifically, cheesestick move isn't working properly!
            Player.cheeseCheck(p1);
          }

          }



        if(players[playerTurn].getAI() == true){
          System.out.println("AI Turn...");
        }
      }
    }
    //scan.close();
  }
}
