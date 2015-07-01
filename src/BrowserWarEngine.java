/**
 * BrowserWarEngine
 * 
 * @author Lyndon Kondratczyk
 * 
 * 4/28/14
 * 
 * This java class contains all the methods and functions required to define the gameplay of BrowserWar
 * (which are the same as Reversi/Othello)
 **/

import javax.swing.JOptionPane;

public class BrowserWarEngine extends BrowserWarData{ 
  
  /**
   * Takes the current player and outputs the opposite player
   * 
   * @param String playerColor The current player's color
   * 
   * @return String The color of the player opposite the current player
   */
  public static String oppositePlayer(String playerColor){
    if(playerColor.equals("black")){
      return "white";
    }
    else{
      return "black";
    }
  }
  
  
  /**
   * Initializes the game board with the standard starting conditions
   * 
   * @param String[][] square The current game board
   * @param String playerColor The color of the current player
   */
  public static void initializeBoard(String[][] square, String playerColor){
    playerColor = "black";
    for (int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        square[i][j] = "clear";
      }
    }    
    square[2][3] = "open";
    square[3][2] = "open";
    square[4][5] = "open";
    square[5][4] = "open";    
    square[3][4] = "black";
    square[4][3] = "black";    
    square[3][3] = "white";
    square[4][4] = "white";
  }
  
  
  /**
   * Takes in a location and outputs whether or not there is a potential score in the upward direction
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The current state of the gameboard
   * @param String playerColor The color of the current player
   * 
   * @return Boolean Returns true if there is a potential score in the upward direction.
   */  
  public static Boolean analyzeN(int userVInput, int userHInput, String[][] square, String playerColor){
    Boolean flag = false;
    if(userVInput > 1){
      if(square[userVInput - 1][userHInput].equals(oppositePlayer(playerColor))){
        for(int i = (userVInput - 1); (i > (-1)); i--){
          if(square[i][userHInput].equals(playerColor)){
            flag = true;
            i = (-1);
          }
          else if(square[i][userHInput].equals("open")){
            i = (-1);
          }
          else if(square[i][userHInput].equals("clear")){
            i = (-1);
          }
        }
      }
    } 
    return flag;
  }
  
  
  /**
   * Takes in a location and outputs whether or not there is a potential score in the uper right direction
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The current state fo the game board
   * @param String playerColor The color of the current player
   * 
   * @return Boolean Returns true if there is a potential score in the upper right direction.
   */  
  public static Boolean analyzeNE(int userVInput, int userHInput, String[][] square, String playerColor){
    Boolean flag = false;
    if((userVInput > 1) && (userHInput < 6)){      
      if(square[userVInput - 1][userHInput + 1].equals(oppositePlayer(playerColor))){        
        for(int i = 1;i > 0; i++){          
          if(((userVInput - i) < 0) || ((userHInput + i) > 7)){
            i = (-1);
          }
          else if(square[userVInput - i][userHInput + i].equals(playerColor)){
            flag = true;
            i = (-1);
          }          
          else if(square[userVInput - i][userHInput + i].equals("clear")){
            i = (-1);
          }          
          else if(square[userVInput - i][userHInput + i].equals("open")){
            i = (-1);
          }
        }
      }
    }
    return flag;
  }
  
  
  /**
   * Takes in a location and outputs whether or not there is a potential score in the right direction
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   * 
   * @return Boolean Returns true if there is a potential score in the right direction.
   */  
  public static Boolean analyzeE(int userVInput, int userHInput, String[][] square, String playerColor){
    Boolean flag = false;
    if(userHInput < 6){
      if(square[userVInput][userHInput + 1].equals(oppositePlayer(playerColor))){
        for(int i = (userHInput + 1); (i < 8); i++){
          if(square[userVInput][i].equals(playerColor)){
            flag = true;
            i = 8;
          }
          else if(square[userVInput][i].equals("open")){
            i = 8;
          }
          else if(square[userVInput][i].equals("clear")){
            i = 8;
          }
        }
      }
    }
    return flag;
  }
  
  
  /**
   * Takes in a location and outputs whether or not there is a potential score in the lower right direction
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   * 
   * @return Boolean Returns true if there is a potential score in the lower right direction.
   */  
  public static Boolean analyzeSE(int userVInput, int userHInput, String[][] square, String playerColor){
    Boolean flag = false;
    if((userHInput < 6) && (userVInput < 6)){      
      if(square[userVInput + 1][userHInput + 1].equals(oppositePlayer(playerColor))){        
        for(int i = 1;i > 0; i++){          
          if(((userVInput + i) > 7) || ((userHInput + i) > 7)){
            i = (-1);
          }
          else if(square[userVInput + i][userHInput + i].equals(playerColor)){
            flag = true;
            i = (-1);
          }
          else if(square[userVInput + i][userHInput + i].equals("clear")){
            i = (-1);
          }
          else if(square[userVInput + i][userHInput + i].equals("open")){
            i = (-1);
          }
        }
      }
    }
    return flag;
  }
  
  
  /**
   * Takes in a location and outputs whether or not there is a potential score in the downward direction
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   * 
   * @return Boolean Returns true if there is a potential score in the downward direction.
   */   
  public static Boolean analyzeS(int userVInput, int userHInput, String[][] square, String playerColor){
    Boolean flag = false;
    if(userVInput < 6){
      if(square[userVInput + 1][userHInput].equals(oppositePlayer(playerColor))){
        for(int i = (userVInput + 1); (i < 8); i++){
          if(square[i][userHInput].equals(playerColor)){
            flag = true;
            i = 8;
          }
          else if(square[i][userHInput].equals("open")){
            i = 8;
          }
          else if(square[i][userHInput].equals("clear")){
            i = 8;
          }
        }
      }
    } 
    return flag;
  }
  
  
  /**
   * Takes in a location and outputs whether or not there is a potential score in the lower left direction
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   * 
   * @return Boolean Returns true if there is a potential score in the lower left direction.
   */ 
  public static Boolean analyzeSW(int userVInput, int userHInput, String[][] square, String playerColor){
    Boolean flag = false;
    if((userHInput > 1) && (userVInput < 6)){
      if(square[userVInput + 1][userHInput - 1].equals(oppositePlayer(playerColor))){
        for(int i = 1;i > 0; i++){
          if(((userVInput + i) > 7) || ((userHInput - i) < 0)){
            i = (-1);
          }
          else if(square[userVInput + i][userHInput - i].equals(playerColor)){
            flag = true;
            i = (-1);
          }
          else if(square[userVInput + i][userHInput - i].equals("clear")){
            i = (-1);
          }
          else if(square[userVInput + i][userHInput - i].equals("open")){
            i = (-1);
          }
        }
      }
    }
    return flag;
  }
  
  
  /**
   * Takes in a location and outputs whether or not there is a potential score in the left direction
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   * 
   * @return Boolean Returns true if there is a potential score in the left direction.
   */  
  public static Boolean analyzeW(int userVInput, int userHInput, String[][] square, String playerColor){
    Boolean flag = false;
    if(userHInput > 1){
      if(square[userVInput][userHInput - 1].equals(oppositePlayer(playerColor))){
        for(int i = (userHInput - 1); (i > (-1)); i--){
          if(square[userVInput][i].equals(playerColor)){
            flag = true;
            i = (-1);
          }
          else if(square[userVInput][i].equals("open")){
            i = (-1);
          }
          else if(square[userVInput][i].equals("clear")){
            i = (-1);
          }
        }
      }
    }
    return flag;
  }
  
  /**
   * Takes in a location and outputs whether or not there is a potential score in the upper left direction
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   * 
   * @return Boolean Returns true if there is a potential score in the upper left direction.
   */ 
  public static Boolean analyzeNW(int userVInput, int userHInput, String[][] square, String playerColor){
    Boolean flag = false;
    if((userHInput > 1) && (userVInput > 1)){
      if(square[userVInput - 1][userHInput - 1].equals(oppositePlayer(playerColor))){
        for(int i = 1;i > 0; i++){
          if(((userVInput - i) < 0) || ((userHInput - i) < 0)){
            i = (-1);
          }
          else if(square[userVInput - i][userHInput - i].equals(playerColor)){
            flag = true;
            i = (-1);
          }
          else if(square[userVInput - i][userHInput - i].equals("clear")){
            i = (-1);
          }
          else if(square[userVInput - i][userHInput - i].equals("open")){
            i = (-1);
          }
        }
      }
    }
    return flag;
  }
  
  /**
   * Takes in the current game board, searches for new open squares and converts them.
   * 
   * @param String[][] square The current game board
   * @param String playerColor
   */
  public static void analyzeActives(String[][] square, String playerColor){
    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        if((square[y][x].equals("open")) || (square[y][x].equals("clear"))){
          if((analyzeN(y, x, square, playerColor)) || (analyzeNE(y, x, square, playerColor)) ||
             (analyzeE(y, x, square, playerColor)) || (analyzeSE(y, x, square, playerColor)) ||
             (analyzeS(y, x, square, playerColor)) || (analyzeSW(y, x, square, playerColor)) ||
             (analyzeW(y, x, square, playerColor)) || (analyzeNW(y, x, square, playerColor))){
            square[y][x] = "open";
          }
          else{
            square[y][x] = "clear";
          }
        }
      }
    }
  }
  
  
  /**
   * Takes in a location and player color and flips all opposite colors in the upward direction
   * until encountering the same color
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @paramString  playerColor The color of the current player
   */  
  public static void flipN(int userVInput, int userHInput, String[][] square, String playerColor){
    for(int i = (userVInput - 1); (i > (-1)); i--){
      if(square[i][userHInput].equals(playerColor)){
        i = (-1);
      }
      else{
        square[i][userHInput] = playerColor;
      }
    }
  }
  
  
  /**
   * Takes in a location and player color and flips all opposite colors in the upper right direction
   * until encountering the same color
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   */  
  public static void flipNE(int userVInput, int userHInput, String[][] square, String playerColor){
    for(int i = 1; i > 0; i++){
      if(square[userVInput - i][userHInput + i].equals(oppositePlayer(playerColor))){
        square[userVInput - i][userHInput + i] = playerColor;
      }
      else{
        i = (-1);
      }
    }
  }
  
  
  /**
   * Takes in a location and player color and flips all opposite colors in the right direction
   * until encountering the same color
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   */  
  public static void flipE(int userVInput, int userHInput, String[][] square, String playerColor){
    for(int i = (userHInput + 1); (i < 8); i++){
      if(square[userVInput][i].equals(playerColor)){
        i = 8;
      }
      else{
        square[userVInput][i] = playerColor;
      }
    }
  }
  
  
  /**
   * Takes in a location and player color and flips all opposite colors in the lower right direction
   * until encountering the same color
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   */  
  public static void flipSE(int userVInput, int userHInput, String[][] square, String playerColor){
    for(int i = 1; i > 0; i++){
      if(square[userVInput + i][userHInput + i].equals(oppositePlayer(playerColor))){
        square[userVInput + i][userHInput + i] = playerColor;
      }
      else{
        i = (-1);
      }
    }
  }
  
  
  /**
   * Takes in a location and player color and flips all opposite colors in the downward direction
   * until encountering the same color
   * 
   * @param String userVInput The number of the row of the user's input after being translated to the respective index
   * @param String userHInput The letter of the column of the user's input after being translated to the respective index
   * @param playerColor The color of the current player
   */   
  public static void flipS(int userVInput, int userHInput, String[][] square, String playerColor){
    for(int i = (userVInput + 1); (i < 8); i++){
      if(square[i][userHInput].equals(playerColor)){
        i = 8;
      }
      else{
        square[i][userHInput] = playerColor;
      }
    }
  }
  
  
  /**
   * Takes in a location and player color and flips all opposite colors in the lower left direction
   * until encountering the same color
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   */ 
  public static void flipSW(int userVInput, int userHInput, String[][] square, String playerColor){
    for(int i = 1; i > 0; i++){
      if(square[userVInput + i][userHInput - i].equals(oppositePlayer(playerColor))){
        square[userVInput + i][userHInput - i] = playerColor;
      }
      else{
        i = (-1);
      }
    }
  }
  
  
  /**
   * Takes in a location and player color and flips all opposite colors in the left direction
   * until encountering the same color
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   */  
  public static void flipW(int userVInput, int userHInput, String[][] square, String playerColor){
    for(int i = (userHInput - 1); (i > (-1)); i--){
      if(square[userVInput][i].equals(playerColor)){
        i = (-1);
      }
      else{
        square[userVInput][i] = playerColor;
      }
    }
  }
  
  
  /**
   * Takes in a location and player color and flips all opposite colors in the upper left direction
   * until encountering the same color
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   */ 
  public static void flipNW(int userVInput, int userHInput, String[][] square, String playerColor){
    for(int i = 1; i > 0; i++){
      if(square[userVInput - i][userHInput - i].equals(oppositePlayer(playerColor))){
        square[userVInput - i][userHInput - i] = playerColor;
      }
      else{
        i = (-1);
      }
    }
  }
  
  /**
   * This is the module responsible for checking where the user has scored and flipping the appropriate tiles
   * 
   * @param int userVInput The number of the row of the user's input after being translated to the respective index
   * @param int userHInput The letter of the column of the user's input after being translated to the respective index
   * @param String[][] square The state of the current gameboard
   * @param String playerColor The color of the current player
   */
  public static void flipScore(int userVInput, int userHInput, String[][] square, String playerColor){
    square[userVInput][userHInput] = playerColor;
    if(analyzeN(userVInput, userHInput, square, playerColor)){
      flipN(userVInput, userHInput, square, playerColor);
    }
    if(analyzeNE(userVInput, userHInput, square, playerColor)){
      flipNE(userVInput, userHInput, square, playerColor);
    }
    if(analyzeE(userVInput, userHInput, square, playerColor)){
      flipE(userVInput, userHInput, square, playerColor);
    }
    if(analyzeSE(userVInput, userHInput, square, playerColor)){
      flipSE(userVInput, userHInput, square, playerColor);
    }
    if(analyzeS(userVInput, userHInput, square, playerColor)){
      flipS(userVInput, userHInput, square, playerColor);
    }
    if(analyzeSW(userVInput, userHInput, square, playerColor)){
      flipSW(userVInput, userHInput, square, playerColor);
    }
    if(analyzeW(userVInput, userHInput, square, playerColor)){
      flipW(userVInput, userHInput, square, playerColor);
    }
    if(analyzeNW(userVInput, userHInput, square, playerColor)){
      flipNW(userVInput, userHInput, square, playerColor);
    }
  }
  
  
  /**
   * Takes in the game board and occupation and returns the count of that type of occupation
   * 
   * @param String[][] square The current game board
   * @param String color The occupation of a game board location
   * 
   * @return int The number of the occurrence of the type of occupation
   */
  public static int updateScore(String[][] square, String color){
    int count = 0;
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        if(square[i][j].equals(color)){
          count = count + 1;
        }
      }
    }
    return count;
  }
  
  /**
   * Prints an announcement of the winner at the end of the game
   * 
   * @param int blackScore The score for player black
   * @param int whiteScore The score for player white
   * @param int openScore The number of available moves
   */
  public static void winnerAnnouncer(int blackScore, int whiteScore, int openScore){
    if(!(openScore > 0)){
      
      if(whiteScore > blackScore){
        JOptionPane.showMessageDialog(null, "PLAYER 2 WINS!!!");
      }
      else if(blackScore > whiteScore){
        JOptionPane.showMessageDialog(null,  "PLAYER 1 WINS!!!");
      }
      else{
        JOptionPane.showMessageDialog(null,  "TIE GAME!!!");
      }
    }
  }
}
