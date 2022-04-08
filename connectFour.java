import java.util.*; 

public class connectFour
{ 
  public static void main (String[] args)
  {
    Scanner vScan = new Scanner (System.in); 
    
    String[][] board = new String[7][6]; 
    for (int i = 0; i < 7; i++)
    {
      for (int j = 0; j < 6; j++)
        board[i][j] = " "; 
    }
    
    boolean v = false; 
    
    while (v == false) 
    {
      //Yellow Move
      printBoard(board); 
      System.out.println("Yellow: Select a column number"); 
      int yellowInput = vScan.nextInt(); 
      vScan.nextLine(); 
      System.out.println(); 
      
      boolean invalidY = columnFull(yellowInput, board); 
      if (invalidY == true) 
      {
        System.out.println ("This column is full. Please select another column"); 
        yellowInput = vScan.nextInt(); 
        vScan.nextLine(); 
        System.out.println(); 
      }
        
      if (board[yellowInput-1][5].equals(" "))
      {
        board[yellowInput-1][5] = "Y";
      }
      else 
      {
        int counterY = 0; 
        for (int i = 0; i < 5; i++)
        {
          if (!board[yellowInput-1][i+1].equals(" ") && counterY < 1)
          {
            board[yellowInput-1][i] = "Y";
            counterY++; 
          }
        } 
      }
      
      v = checkWin("Y", board); 
      if (v == true) 
      {
        printBoard(board); 
        System.out.println("Yellow Wins!"); 
      }
      else 
      {
        v = checkTie(board); 
        if (v == true)
        {
          printBoard(board); 
          System.out.println("It is a tie!"); 
        }
      }
      
      if (v == false)
      {
        printBoard(board); 
        System.out.println("Red: Select a column number"); 
        int redInput = vScan.nextInt(); 
        vScan.nextLine(); 
        System.out.println(); 
        
        boolean invalidR = columnFull(redInput, board); 
        if (invalidR == true) 
        {
          System.out.println ("This column is full. Please select another column"); 
          redInput = vScan.nextInt(); 
          vScan.nextLine(); 
          System.out.println(); 
        }
        
        if (board[redInput-1][5].equals(" "))
        {
          board[redInput-1][5] = "R";
        }
        else 
        {
          int counterR = 0;
          for (int i = 0; i < 5; i++)
          { 
            if (!board[redInput-1][i+1].equals(" ") && counterR < 1)
            {
              board[redInput-1][i] = "R";
              counterR++; 
            }
          } 
        }
        v = checkWin("R", board); 
        if (v == true) 
        {
          printBoard(board); 
          System.out.println("Red Wins!"); 
        }
        else 
        {
          v = checkTie(board); 
          if (v == true)
          {
            printBoard(board); 
            System.out.println("It is a tie!"); 
          }
        }
      }
      
    }
  }
  
  public static void printBoard (String[][] b)
  {
    System.out.println("  1   2   3   4   5   6   7"); 
    System.out.println("+---+---+---+---+---+---+---+"); 
    for (int i = 0; i < b[0].length; i++)
    {
      System.out.print("|"); 
      for (int j = 0; j < b.length; j++)
      {
        System.out.print (" " + b[j][i] + " |");
      }
      System.out.println(); 
      System.out.println("+---+---+---+---+---+---+---+"); 
    }
  }
  
  public static boolean checkWin (String p, String[][] b)
  {
    boolean victory = false; 
    
    //1) Vertical
    for (int i = 0; i < b.length; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        if (b[i][j].equals(p) && b[i][j+1].equals(p) && b[i][j+2].equals(p) && b[i][j+3].equals(p))
        {
          victory = true; 
        }
      }
    }
    
    //2) Horizontal 
    if (victory == false) 
    {
      for (int i = 0; i < 6; i++)
      {
        for (int j = 0; j < 4; j++)
        {
          if (b[j][i].equals(p) && b[j+1][i].equals(p) && b[j+2][i].equals(p) && b[j+3][i].equals(p))
          {
            victory = true; 
          }
        }
      }
    }
   //3) Upward Diagonal
    if (victory == false)
    {
      for (int i = 0; i < 4; i++)
      {
        for (int j = 3; j < 6; j++)
        {
          if (b[i][j].equals(p) && b[i+1][j-1].equals(p) && b[i+2][j-2].equals(p) && b[i+3][j-3].equals(p))
          {
            victory = true; 
          }
        }
      }
    }
    //4) Downward Diagonal
    if (victory == false)
    {
      for (int i = 0; i < 4; i++)
      {
        for (int j = 0; j < 3; j++)
        {
          if (b[i][j].equals(p) && b[i+1][j+1].equals(p) && b[i+2][j+2].equals(p) && b[i+3][j+3].equals(p))
          {
            victory = true; 
          }
        }
      }
    }
    
    return victory; 
  }
  
  public static boolean columnFull (int c, String[][] b)
  {
    int l = b[c-1].length; 
    int counter = 0; 
    for (int i = 0; i < l; i++)
    {
      if (b[c-1][i].equals(" "))
      {
        counter++; 
      }
    }
    if (counter == 0)
      return true; 
    else
      return false; 
  }
  
  public static boolean checkTie (String [][] b)
  {
    int n = b.length; 
    int counter = 0; 
    for (int i = 1; i <= n; i++)
    {
      if (columnFull(i, b) == false)
      {
        counter++; 
      }
    }
    if (counter == 0)
      return true; 
    else
      return false; 
  }
  
}
