
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameArea extends JPanel implements KeyListener, ActionListener{
    
    Random randomCoordinatforOil = new Random() ; 
    Random randomAreaPosition = new Random() ; 
    
//  Character Traits
    String CharacterName = "" ; 
    int CharacterPositionX = 350 ; 
    int CharacterPositionY = 50 ;
    int CharacterWidth = 25 ; 
    int CharacterHeight = 25 ;
    int CharacterHealt = 0 ; 
    String Car1Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\car1.png";
    String Car2Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\car2.png";
    String Car3Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\car3.png";
    String Car4Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\car4.png";

//  Area Traits    
    int AreaWidth = 1250 ; 
    int AreaHeight = 900 ;
    int AreaPositionX = 50 ;
    int AreaPositionY = 0 ;
    
//  Oil Traits
    int OilPositionX = 650 ; 
    int OilPositionY = 360  ;
    int OilWidth = 48 ; 
    int OilHeight = 48 ; 
    int OilAmount = 0 ; 
    String OilLocation = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\oil.png" ; 
    
//  Trees Traits
    String Tree1Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree1.png" ;
    String Tree2Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree2.png" ;
    String Tree3Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree3.png" ;
    String Tree4Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree1.png" ;
    String Tree5Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree3.png" ;
    String Tree6Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree2.png" ;
    String Tree7Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree1.png" ;
    String Tree8Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree2.png" ;
    String Tree9Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree3.png" ;
    String Tree10Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree1.png" ;
    String Tree11Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree3.png" ;
    String Tree12Location = "C:\\Users\\yakup\\Documents\\NetBeansProjects\\Battle Area\\src\\tree2.png" ;
//  Getter-Setter Methods for CharacterName  
    public String getCharacterName() {
        return CharacterName;
    }
    public void setCharacterName(String CharacterName) {
        this.CharacterName = CharacterName;
    }

//  Getter-Setter Methods for CharacterHealt    
    public int getCharacterHealt() {
        return CharacterHealt;
    }
    public void setCharacterHealt(int CharacterHealt) {
//      Healt Check
        if(CharacterHealt < 0) {
            JOptionPane.showMessageDialog(this , "Character Health Cannot Be Negative") ; 
            System.exit(0) ; 
        }
        else {
            this.CharacterHealt = CharacterHealt ; 
        }
    }
    
//  Constructor
    public GameArea() {
        String LoginName = JOptionPane.showInputDialog(this, "Character Name") ;
        this.CharacterName = LoginName; 
//      LoginName Check
        if(LoginName == null || LoginName.length() == 0) {
            JOptionPane.showMessageDialog(this , "You Must To Enter Character Name") ; 
            System.exit(0) ; 
        } 
        
        addKeyListener(this) ;
        
        Timer timer = new Timer(100, this) ; 
        timer.start();
        
        
    }
    
//  Collapse to Area
    public void AreaCollapse() {
        int max = 10 ; 
        int min = -10 ; 
        
        AreaWidth -= 5 ; 
        AreaHeight -= 5 ;  
        
        this.AreaPositionX += randomAreaPosition.nextInt((max - min) + 1) + min ; 
        this.AreaPositionY += randomAreaPosition.nextInt((max - min) + 1) + min ; 
    }
    
//  Character Health Control
    public boolean CharacterCheck(){
        if(this.CharacterHealt > 0) {
            return true ; 
        }
        return false ; 
    }
    
//  Character - Area Control Location
    public boolean AreaControl(){
        if(new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(AreaPositionX, AreaPositionY , AreaWidth , AreaHeight)){
            return true; 
        }
        return false; 
    }
//  Trees, Rocks Control Location
    public boolean TreeRockControl(){
        if(new Rectangle        (CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(475, 250 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(850, 650 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(750, 50 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(650, 550 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(850, 150 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(250, 150 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(275, 400 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(1100, 370 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(900, 425 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(150, 650 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(50, 350 , 32 , 32)
                || new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(550, 150 , 32 , 32)){
            return true; 
        }
        return false; 
    }
    
//  Oil - Character Control Location
    public boolean Control() {
        if(new Rectangle(CharacterPositionX , CharacterPositionY , CharacterWidth , CharacterHeight).intersects(OilPositionX , OilPositionY , OilWidth , OilHeight) && OilAmount < 5){
            
//          medkit new location 
            OilPositionX = randomCoordinatforOil.nextInt(757); // GameWindowWidth - MedkitWidth 
            OilPositionY = randomCoordinatforOil.nextInt(656); // GameWindowHeight - MedkitHeigth 
            
            OilAmount++ ;
            
            return true ; 
        }
        return false ; 
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
//      Area
        g.setColor(Color.blue);
        g.fillOval(AreaPositionX, AreaPositionY, AreaWidth, AreaHeight);
        
//      Character
        if(direction == "left"){
            ImageIcon car1 = new ImageIcon(this.Car2Location) ; 
            car1.paintIcon(this, g, CharacterPositionX, CharacterPositionY);
        }
        if(direction == "right"){
            ImageIcon car2 = new ImageIcon(this.Car1Location) ; 
            car2.paintIcon(this, g, CharacterPositionX, CharacterPositionY);
        }
        if(direction == "up"){
            ImageIcon car3 = new ImageIcon(this.Car4Location) ; 
            car3.paintIcon(this, g, CharacterPositionX, CharacterPositionY);
        }
        if(direction == "down"){ 
            ImageIcon car4 = new ImageIcon(this.Car3Location) ; 
            car4.paintIcon(this, g, CharacterPositionX, CharacterPositionY);
        }
    
//      Oil
        ImageIcon medkit = new ImageIcon(this.OilLocation) ; 
        medkit.paintIcon(this, g, OilPositionX, OilPositionY);
        
//      Trees 
        ImageIcon tree1 = new ImageIcon(this.Tree1Location);
        tree1.paintIcon(this, g, 475, 250);
        ImageIcon tree2 = new ImageIcon(this.Tree2Location);
        tree2.paintIcon(this, g, 850, 650);
        ImageIcon tree3 = new ImageIcon(this.Tree3Location);
        tree3.paintIcon(this, g, 750, 50);
        ImageIcon tree4 = new ImageIcon(this.Tree4Location);
        tree4.paintIcon(this, g, 650, 550);
        ImageIcon tree5 = new ImageIcon(this.Tree5Location);
        tree5.paintIcon(this, g, 850, 150);
        ImageIcon tree6 = new ImageIcon(this.Tree6Location);
        tree6.paintIcon(this, g, 250, 150);
        ImageIcon tree7 = new ImageIcon(this.Tree1Location);
        tree7.paintIcon(this, g, 275, 400);
        ImageIcon tree8 = new ImageIcon(this.Tree2Location);
        tree8.paintIcon(this, g, 1100, 370);
        ImageIcon tree9 = new ImageIcon(this.Tree3Location);
        tree9.paintIcon(this, g, 900, 425);
        ImageIcon tree10 = new ImageIcon(this.Tree4Location);
        tree10.paintIcon(this, g, 150, 650);
        ImageIcon tree11 = new ImageIcon(this.Tree5Location);
        tree11.paintIcon(this, g, 50, 350);
        ImageIcon tree12 = new ImageIcon(this.Tree6Location);
        tree12.paintIcon(this, g, 550, 150);
        
//      Character Information

        Font n = new Font("Book Antiqua", Font.BOLD, 12);
        g.setFont(n);
        g.drawString("Character Name : "+this.CharacterName, 1100, 30);
        g.drawString("Remaining Oil : "+this.CharacterHealt, 1100, 45) ; 
        g.drawString("Jerry Can Amount : "+this.OilAmount, 1100, 60);
        g.drawString("Use Direction Keys - Use Space for Oil",500,20);
        
        repaint() ; 
        
    }

//  Focus on Window
    public boolean isFocusTraversable() {
        return true ; 
     }
    String direction ; 
//  Key Events
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT && CharacterPositionX > 0 && TreeRockControl() != true){
            this.CharacterPositionX -= this.CharacterWidth ;
            direction = "left" ; 
        } 
        else if(ke.getKeyCode() == KeyEvent.VK_RIGHT && CharacterPositionX < 1230 && TreeRockControl() != true){
            this.CharacterPositionX += this.CharacterWidth ; 
            direction = "right" ; 
        }
        else if(ke.getKeyCode() == KeyEvent.VK_UP && CharacterPositionY > 0 && TreeRockControl() != true){
            this.CharacterPositionY -= this.CharacterHeight ; 
            direction = "up" ; 
        }
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN && CharacterPositionY < 670 && TreeRockControl() != true){
            this.CharacterPositionY += this.CharacterHeight ; 
            direction = "down" ; 
        }
        else if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            if(CharacterHealt < 90 && OilAmount > 0){
                OilAmount-- ; 
                CharacterHealt += 10 ; 
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }
    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    
//  Action Listener 
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(CharacterCheck() == true){
            this.Control() ;
            if(AreaPositionX >= 0 || AreaPositionY >= 0){
                if(AreaPositionX < 0 || AreaPositionY < 30){
                    AreaPositionX += 30 ; 
                    AreaPositionY += 15 ; 
                }
                if(AreaPositionX > 750 || AreaPositionY > 650){
                    AreaPositionX -= 30 ; 
                    AreaPositionY -= 15 ;
                }
                this.AreaCollapse();
            }

            if(AreaControl() == false) {
                CharacterHealt -= 2 ; 
            }
        }
        if(CharacterCheck() == false){
            JOptionPane.showMessageDialog(this , "Dead") ; 
            System.exit(0) ; 
        }
        if(TreeRockControl() == true){
            JOptionPane.showMessageDialog(this , "Kaza Yaptin") ; 
            System.exit(0) ; 
        }
    }
  
    
}