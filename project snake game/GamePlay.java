import java.awt.Color;
import javax.swing.JFrame;



public class GamePlay extends JFrame {

  
    

    public static void main(String[] args) {
			 
	
		
                      
                JFrame obj = new GamePlay();
				Game game =new Game();
				
				
			    obj.setBounds(10,10,905,710); 
				obj.setBackground(Color.DARK_GRAY); 
				
				obj.setTitle("SNAKE GAME BY <KAWSAR> & <SHAMIM>"); 
				
				obj.setResizable(false);
                obj.setVisible(true);
	             obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 obj.add(game);
			   
            }
       
    
}
