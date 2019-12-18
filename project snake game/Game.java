import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.Font;
import java.util.Random;



public class Game extends JPanel implements KeyListener,ActionListener 
{
private int [] snakexlength = new int[300];
private int [] snakeylength = new int[300];

private int moves =0;


private boolean left = false;
private boolean right =false;
private boolean up =false;
private boolean down =false;
	


private ImageIcon titleImage;
private ImageIcon rightmouth;
private ImageIcon leftmouth;
private ImageIcon downmouth;
private ImageIcon upmouth;
private ImageIcon snakeimage;
private ImageIcon enemyimage;

private Timer timer;
private int delay =100;
private int score =0;


private int [] enemyxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500};

private int [] enemyypos={75,100,125,150,175,200,250,275,300,325,350,375,400,425,450,475};


private int lengthofsnake =1;

private Random random=new Random();

private int xpos = random.nextInt (20);
private int ypos=  random.nextInt (16);

public Game()
{
	


addKeyListener (this);
setFocusable (true);
timer =new Timer(delay,this);

timer.start();

}


public void paint (Graphics g) 
{
	if (moves==0) 
	{
		
		snakexlength[0]=100;
		snakeylength[0]=100;
	}
	
	
	g.setColor(Color.BLACK);
	g.drawRect(24,10,851,51);
	
	g.setColor(Color.WHITE);
	g.fillRect(25,11,850,50);
	
	
	
	
  
	g.setColor(Color.WHITE);
	g.drawRect(24,74,851,577);
	
	g.setColor(Color.BLACK);
	g.fillRect(25,75,850,575);
	
	
	
	
	
	g.setColor(Color.DARK_GRAY);
	g.setFont(new Font("Arial Black  ",Font.BOLD,30));
	g.drawString("Scores:->"+score, 600,45);
	
	
	
	
	g.setColor(Color.DARK_GRAY);
	g.setFont(new Font("Arial Black  ",Font.BOLD,30));
	g.drawString("Length:->"+lengthofsnake, 75,45);
	
	
	
	rightmouth =new ImageIcon("rightmouth.png");
	rightmouth.paintIcon(this,g, snakexlength[0],snakeylength[0]);
	
	
	
for( int a=0; a<lengthofsnake; a++)
{
		if(a==0 && right)
		{
			rightmouth =new ImageIcon("rightmouth.png");
	rightmouth.paintIcon(this,g, snakexlength[a],snakeylength[a]);
		}
		
		if(a==0 && left)
		{
			leftmouth =new ImageIcon("leftmouth.png");
	leftmouth.paintIcon(this,g, snakexlength[a],snakeylength[a]);
		}
		if(a==0 && up)
		{
			upmouth =new ImageIcon("upmouth.png");
	upmouth.paintIcon(this,g, snakexlength[a],snakeylength[a]);
		
		}
		if (a==0 &&  down)
		{
			downmouth =new ImageIcon("downmouth.png");
	downmouth.paintIcon(this,g, snakexlength[a],snakeylength[a]);
		}
			if (a!=0)
			{
	snakeimage =new ImageIcon("snakeimage.png");
	snakeimage.paintIcon(this,g, snakexlength[a],snakeylength[a]);
			}
			
			
			
}

enemyimage =new ImageIcon("enemy.png") ;
enemyimage.paintIcon(this, g, enemyxpos[xpos],enemyypos[ypos]);


        





if((enemyxpos[xpos] ==snakexlength[0] && enemyypos[ypos] == snakeylength[0]))
	
	{
		score++;
		lengthofsnake++;
		xpos = random.nextInt(20);
		ypos = random.nextInt (16);
	}
	


	for(int b=1;b<lengthofsnake;b++)
	{
		if((snakexlength[b]== snakexlength[0] && snakeylength[b]==snakeylength[0]))
	
	{
		right=false;
		left=false;
		up=false;
		down=false;
		
		g.setColor(Color.RED);
		g.setFont(new Font("arial",Font.BOLD, 60));
		g.drawString("GAME OVER",285,300);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD, 35));
		g.drawString("PRESSS>> ENTER <<TO RESTART",200,400);
		
		

	}
	
	}
		

	
}



private void move()
{
	timer.start ();
	 
if (right)
{
	
		for(int r = lengthofsnake; r >= 0; r--)
			
			{ 
			snakeylength[r+1]=snakeylength[r];
			}
			
			for(int r = lengthofsnake; r >= 0; r--)
			
			{
				if(r==0)
				{
					snakexlength[r]=snakexlength [r]+25;
				}
				else
				{
					snakexlength[r] =snakexlength [r-1];
					
				}
				if(snakexlength [r] > 850)
				{
					snakexlength [r]=25;
					
				}
				
			}
	        repaint ();
}


if (left)
{
	
	for (int r=lengthofsnake ; r >= 0; r--)
		
		{
			snakeylength[r+1]=snakeylength[r];
		}
		
			for(int r = lengthofsnake; r >= 0; r--)
			{
				
				
				if(r==0)
				{
					snakexlength[r]=snakexlength[r]-25;
				}
				else
				{
					snakexlength[r] =snakexlength [r-1];
					
				}
				if(snakexlength [r] <25)
				{
					snakexlength [r]=850;
				}
				
			}
			repaint ();
}

	


if (up)
{
	
	for (int r=lengthofsnake ; r >= 0; r--)
		
		{
			snakexlength[r+1]=snakexlength[r];
		}
	
			
			for(int r = lengthofsnake; r >= 0; r--)
			{
				if(r==0)
				{
					snakeylength[r]=snakeylength [r]-25;
				}
				else
				{
					snakeylength[r] =snakeylength [r-1];
					
				}
				if(snakeylength [r] < 75)
				{
					snakeylength [r]=625;
				}
				
			}
			repaint ();
}


if (down)
{
	
	for (int r = lengthofsnake ; r >= 0; r--)
		
		{
			snakexlength[r+1]=snakexlength[r];
		}
		for(int r = lengthofsnake; r >= 0; r--)
			
			{
				if(r==0)
				{
					snakeylength[r]=snakeylength [r]+25;
				}
				else
				{
					snakeylength[r] =snakeylength [r-1];
					
				}
			if(snakeylength [r] > 625)
				{
					snakeylength [r]=75;
				}
				
			}
			repaint ();
}

}


	
 public void actionPerformed(ActionEvent e)
 {  
 
 
 move();

		
 }	 


 public void keyTyped(KeyEvent e)
{

	
}

public void keyPressed(KeyEvent e)
{
	
if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	
	{
		moves ++;
		right=true;
		if(!left)
		{
			right=true;
		}
		else
		{
			left=true;
			right=false;
		}
		
		up=false;
		down=false;
	}
if(e.getKeyCode () == KeyEvent.VK_LEFT)
	
	{
		moves ++;
		left=true;
		if(!right)
		{
			left=true;;
		}
		else
		{
			right=true;
			left=false;
		}
	
		
		up=false;
		down=false;
	}
	if(e.getKeyCode () == KeyEvent.VK_UP)
	
	{
		moves ++;
		up=true;
		if(!down)
		{
			up=true;;
		}
		else
		{
			down=true;
			up=false;
		}
		
		left=false;
		right=false;
	}
	if(e.getKeyCode () == KeyEvent.VK_DOWN)
	
	{
		moves ++;
		down=true;
		if(!up)
		{
			down=true;;
		}
		else{
			up=true;
			down=false;
			
		}
		
		left=false;
		right=false;
	}
	
	if(e.getKeyCode() == KeyEvent.VK_ENTER)
	{
		moves=0;
		score=0;
		lengthofsnake=1;
		repaint();
	
	}
	
	
}
 
 

 public void keyReleased(KeyEvent e)
 {
	 
 }

}
