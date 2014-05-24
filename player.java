public class Player
{
    private int baseBudget;
    private int tieBudget;
    private int lastBase;
    private int lastTie;
    private int wins;
  
    public Player(int b, int t) //Player method, initializes variables
    {
      baseBudget = b;
      tieBudget = t;
      lastBase = 0;
      lastTie = 0;
      wins = 0;
    }
    
    public void playRound(int base, int tie) //playRound method, adjusts budget and assigns lastBase and lastTie values
    {
      if (base>baseBudget)
      {
        base = baseBudget;
      }
      if (tie>tieBudget)
      {
        tie = tieBudget;
      }
      
      baseBudget = baseBudget - base;
      tieBudget = tieBudget - tie;
      
      this.lastBase = base;
      this.lastTie = tie;
    }
    
    public boolean canStillPlay() //method checks if budgets are above zero
    {
        if ((tieBudget) > 0)
       {
         return true;
       }
          
       if ((baseBudget) > 0)
        {
          return true;
        }
       else
       {
         return false; 
       }
    }
    
    public int compare(Player p) //compares player value choices, sees who chose the higher number
    {
      if (lastBase>p.lastBase)
      {
        return 1;
      }
      else if (p.lastBase>lastBase)
      {
        return -1;
      }
      else if (p.lastBase == lastBase)
      {
        if (lastTie>p.lastTie)
        {
          return 1;
        }
        else if (p.lastTie>lastTie)
        {
          return -1;
        }
        else
        {
          return 0;
        }
      }
      else
      {
        return 0;
      } 
    }
    
    public void win() //adds wins to player
    {
        wins = wins + 1;
    }
    
    public int getWins() //getter method for wins
    {
      return wins;
    }
    
    public String toString() //toString method for Player object
    {
        return "Base Budget: " + baseBudget + " Tie Budget: " + tieBudget + " Game number: " + lastBase + " Tie Number: " + lastTie + " Total Wins: " + wins;
    }
  
}
