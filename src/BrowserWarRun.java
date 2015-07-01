/**
 * BrowserWarRun
 * 
 * @author Lyndon Kondratczyk
 * 
 * 4/28/14
 * 
 * This java class is the top level module of BrowserWar. It instantiates the 
 * graphics from the BrowserWarGraphics class
 **/

import javax.swing.JApplet;
import javax.swing.*;
import javax.swing.border.*;

public class BrowserWarRun {
  public static void main(String[] args){
    BrowserWarGraphics game =  new BrowserWarGraphics(); 
    JFrame gui = new JFrame("Browser War");
    gui.add(game.getGui());
    gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    gui.setLocationByPlatform(true);
    gui.pack();
    gui.setMinimumSize(gui.getSize());
    gui.setVisible(true);
    gui.setResizable(false);  
  }
}