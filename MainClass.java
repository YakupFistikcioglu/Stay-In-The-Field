
import java.util.Locale;
import javax.swing.JFrame;

public class MainClass {
    public static void main(String args[]){
        
    //  creation of the game window
        JFrame gameWindow = new JFrame() ; 
        
    //  game window proporties
        gameWindow.setTitle("Battle Area") ; 
        gameWindow.setSize(1305 , 750);
        gameWindow.setLocation(0,0);
        gameWindow.setResizable(false) ;
    //  add to gameArea
        GameArea gameArea = new GameArea() ;
        gameArea.setCharacterHealt(100)  ; 
        
        gameWindow.add(gameArea) ; 
        gameWindow.setVisible(true) ; 
        gameWindow.setDefaultCloseOperation(gameWindow.EXIT_ON_CLOSE);
    }
}