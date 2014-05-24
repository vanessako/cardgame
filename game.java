import java.util.*;
public class Game 
{
    // needed to get input from the player
    static Scanner sc = new Scanner(System.in);

    // game specific values
    static final int baseBudget = 10;   
    static final int tieBudget = 3;
    static final int baseMax = 3;
    static final int tieMax = 1;
  
    public static void main (String args[])
    {
      // p1 and p2 will play against each other
      Player p1 = new Player(baseBudget, tieBudget);
      Player p2 = new Player(baseBudget, tieBudget);
      int base, tie; // numbers played in this round
      int playResult;
      Random r = new Random(); // for the computer-generated player
      
      System.out.println("Welcome: you have a base budget of " + baseBudget +
                         " and a tie budget of " + tieBudget);
      
      while (p1.canStillPlay() || p2.canStillPlay())
      {
              
        System.out.println("Indicate your base number between 0 and " + baseMax);
        base = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Indicate your tie number between 0 and " + tieMax);
        tie = sc.nextInt();
        sc.nextLine();
        
        if ((base < 0  || base > baseMax ||
             tie < 0 || tie > tieMax))
        {
          System.out.println("Wrong input");
        }
        else
        {
          // play for the user
          p1.playRound(base, tie);
          
          // now play for the computer
          base = r.nextInt(baseMax+1);
          tie = r.nextInt(tieMax+1);
          p2.playRound(base, tie);
          
          System.out.println("You: " + p1.toString());
          System.out.println("Computer: " + p2.toString());
          
          // check the win
          playResult = p1.compare(p2);
          if (playResult == 1)
          {
            p1.win();
            System.out.println("You won this round");
          }
          else if (playResult == -1)
          {
            p2.win();
            System.out.println("You lose this round");
          }
          else
          {
            System.out.println("It's a tie");
          }
        }
      }
      
      System.out.println("Game over");
      System.out.println("Your wins: " + p1.getWins());
      System.out.println("Your opponent's wins: " + p2.getWins());
      
      if (p1.getWins() > p2.getWins())
        System.out.println("You are the winner");
      else if (p1.getWins() < p2.getWins())
        System.out.println("You are the loser");
      else
        System.out.println("It's a tied game");
    }
}

      
    
  
