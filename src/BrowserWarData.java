/**
 * BrowserWarData
 * 
 * @author Lyndon Kondratczyk
 * 
 * 4/28/14
 * 
 * This java class constructs the data used to run BrowserWar. It contains all the
 * accessors and mutators for this data.
 **/



public class BrowserWarData{
  private String playerColor;  
  private String square[][];
  public BrowserWarData(){
    playerColor = "black";  
    square = new String[8][8];
  }
  
  /**
   * This retrieves the color of the current player
   * 
   * @return String The player color
   **/
  public String getPlayerColor(){
    return this.playerColor;
  }
  
  /**
   * This retrieves the square 2D matrix which stores the states of the board spaces
   * 
   * @return String[][] The 2d state matrix
   **/
  public String[][] getSquare(){
    return this.square;
  }
  
  /**
   * This sets the player color
   * 
   * @param String player The player color to be set
   **/
  public void setPlayerColor(String player){
    this.playerColor = player;
  }
  
  /**
   * This sets the game baord spaces' states
   * 
   * @param String[][] input A 2D array of states to set the game board to
   **/
  public void setSquare(String[][] input){
    this.square = input;
  }
}
