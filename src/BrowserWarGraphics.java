/**
 * BrowserWarGraphics
 * 
 * @author Lyndon Kondratczyk
 * 
 * 4/28/14
 * 
 * This java class sets up the graphical components to display BrowserWar. It Accesses the BrowserWarEngine algorithms
 * to manipulate the data that drives events
 **/

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class BrowserWarGraphics extends BrowserWarEngine{
  
  private final JPanel gui = new JPanel(new BorderLayout(3, 3));
  private JButton[][] loc = new JButton[8][8];
  private JPanel board;
  private final JLabel message = new JLabel("\nThe world wide web isn't big enough for the two of us");  
  private ImageIcon piece;  
  
  /**
   * This takes the matrix square and uses it to map out corresponding buttons to a grid
   * 
   * @param String[][] square The matrix of states on the game board.
   **/
  public void guiMapper(String[][] square){
    gui.removeAll();
    Insets buttonMargin = new Insets(0,0,0,0); // These statements set up the items in the menu bar
    board = new JPanel(new GridLayout(0, 8));
    board.setBorder(new LineBorder(Color.BLACK));    
    JToolBar tools = new JToolBar();
    tools.setFloatable(false);
    gui.add(tools, BorderLayout.PAGE_START);
    JButton newGame = new JButton("Restart game");
    
    newGame.addActionListener(new ActionListener() {     // Resets the game board to its initial setup
      public void actionPerformed(ActionEvent e)
      {
        setPlayerColor("black");
        initializeGui();
      }
    });
    
    tools.addSeparator(); //Other items for the menu bar
    tools.add(newGame);
    tools.addSeparator();
    tools.add(new JLabel("   Player 1 score: " + updateScore(square, "black")));    
    tools.addSeparator();
    tools.add(new JButton(playerImage(getPlayerColor()))).setPreferredSize(new Dimension(32, 32)); 
    tools.addSeparator();
    tools.add(new JLabel("Player 2 score: " + updateScore(square, "white")));   
    gui.add(board); 
    
    
    for (int i = 0; i < 8; i++) {   //this loops sets up the button graphics according to the square String[][]   
      
      for (int j = 0; j < 8; j++) {   
        
        if(square[i][j].equals("black")){
          piece = new ImageIcon("black.png");
        }
        
        else if(square[i][j].equals("white")){
          piece = new ImageIcon("white.png");
        }
        
        else if(square[i][j].equals("open")){
          piece = new ImageIcon("open.png");
        }
        
        else{
          piece = new ImageIcon("clear.png");
        }
        final int selectV = i;
        final int selectH = j;        
        loc[i][j] = new JButton(piece);
        loc[i][j].setPreferredSize(new Dimension(64, 64));
        if(square[i][j].equals("open")){
          
          loc[i][j].addActionListener(new ActionListener() { //this adds functionality to the "open" buttons         
            public void actionPerformed(ActionEvent e)
            {              
              flipScore(selectV, selectH,  getSquare(), getPlayerColor()); //these statements move the game forward             
              setPlayerColor(oppositePlayer(getPlayerColor()));              
              analyzeActives(getSquare(), getPlayerColor());              
              guiMapper(getSquare());   
              winnerAnnouncer(updateScore(getSquare(), "black"), updateScore(getSquare(), "white"), 
                              updateScore(getSquare(), "open"));  
            }
          });
        }
        
        board.add(loc[i][j]);
      }      
    }
  }
  
  
  
  /**
   * This is used to take the current player and return their coresponding Image Icon
   * 
   * @param String playerColor The color of the current player
   * 
   * @return ImageIcon In image corresponding to the current player 
   **/
  public ImageIcon playerImage(String playerColor){
    return new ImageIcon("" + playerColor + ".png");
  }
  
  
  
  /**
   * This is used to call the method that resets the game board, and the method that redraws the graphics
   **/
  public final void initializeGui() {
    // set up the main GUI
    initializeBoard(getSquare(), getPlayerColor());          
    guiMapper(getSquare());
    
  }
  
  
  /**
   * This makes sure that this class initializes the gui when instantiated
   **/
  BrowserWarGraphics() {
    initializeGui();
  }
  
  
  /**
   * An accessor for the board graphics
   * 
   * @return JComponent A panel that contains a 2D array of JButtons corresponding to the states in square[][]
   **/
  public final JComponent getBoard() {
    return board;
  }
  
  
  /**
   * An accessor for the main JPanel
   * 
   * @return JComponent The top level graphcs panel.
   **/
  public final JComponent getGui() {
    return gui;
  }
}