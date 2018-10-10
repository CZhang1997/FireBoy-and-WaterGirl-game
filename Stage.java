package cxz173430;

//Name -		Churong Zhang, Smit Shah
//Date -		05/24/2015
//Period -		3rd Period
import java.io.File;
import java.net.URL;


import java.awt.Image;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;
/**
* Represents a thread with a Canvas that has the game and can be controlled by the keys
*/
public class Stage extends Canvas implements KeyListener, Runnable
{
	private FireBoy boy;
	private WaterGirl girl;
	private boolean [] keys;
	private BufferedImage back;
//	private Image image;
	private boolean ima;
	private Grass grass;
	private boolean pause;
	private double boyCount;
	private boolean fly, fly2;
	private long time, time2;
	private Thread thread;
	private int girlCount;
//	private Ranking rank;
	private boolean save;
	private Boulder stone;
	
/**
* Makes a default Stage object that starts with the deafult level 1
*/
	public Stage() throws FileNotFoundException, IOException
	{
		
		save = false;
		girlCount = 0;
		keys = new boolean[10];
		thread = new Thread(this);
		grass = new Grass();
		boy = grass.getFireBoy();
		girl = grass.getWaterGirl();
		stone = grass.getBoulder();
//		thread.start();
		boyCount = 0;
		fly = false;
	//	rank = new Ranking();
		
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);
		
	}
	/**
	 * Updates the graphics window
	 * @param window the graphics window
	 */
	public void update(Graphics window)
	{
		
		paint(window);
	}
	
	/**
	 * Updates the contents of the graphics window
	 * @param window the graphics window
	 */
	public void paint(Graphics window)
	{
		Graphics2D twoDGraph = (Graphics2D)window;
//		window.drawImage("SAO (2).Jpg",0,0,1000,1000);
		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
	
		
			
	
		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		
		
		graphToBack.setColor(Color.BLUE);

		graphToBack.setColor(Color.BLACK);
	
		graphToBack.fillRect(0,0,this.getWidth(),this.getHeight());
		pause = keys[8];
		time2 = System.currentTimeMillis();
//		System.out.println (pause);
//		while(!pause){
//		try
//		{
				if(grass.getBottomMidOne(boy) == 5 || grass.getBottomMidOne(boy) == 6 || grass.getBottomMidTwo(boy) == 5 || grass.getBottomMidTwo(boy) == 6)
				{
				pause = true;
				
				thread.interrupt();
				
					
					
					
//				System.out.println ("Game Over!" + Math.random());
//				rank.add(grass.getScore(), playerName);
//				if(!save)
//				{
//					String name = JOptionPane.showInputDialog(null, "Enter your name: ");
//					rank.add(grass.getScore(), name);
//					
//					save = true;
//				}
	//			String name = JOptionPane.showInputDialog(null, "Enter your name: ");
	//			rank.add(grass.getScore(), name);
			}
			else if(grass.getBottomMidOne(girl) == 4 || grass.getBottomMidOne(girl) == 6 || grass.getBottomMidTwo(girl) == 4 || grass.getBottomMidTwo(girl) == 6)
			{
				thread.interrupt();
				pause = true;
//				if(pause)
//				System.out.println ("Game Over!" + Math.random());
//				rank.add(grass.getScore(), playerName);
				
			}
//		}
//		catch(IOException e){
//		}
		
		if(!pause)
		{
//			System.out.println (grass.getBottomLeft(boy) + " " + grass.getBottomRight(boy) + " " + grass.getBottomMidOne(boy) + " " + grass.getBottomMidTwo(boy));
//			System.out.println (grass.getCenter(boy) == 0 + " " + grass.getBottomLeft(boy) ==0 + " " + grass.getBottomMidFour(boy) == 0 + " " + grass.getBottomRight(boy) ==0 + " " + grass.getBottomMidThree(boy) == 0);
//			
			if(grass.getScore()/200 == grass.getLvlNum())
				{
					grass.setLvl(0);
				}
			grass.hiddenSwitch(stone);
			if(keys[0])
			{
				if(boy.getX() > 0 && (stone.getX() + 30 == boy.getX()) && (stone.getY() - 20 == boy.getY()))
				{
					boy.move("LEFT");
					stone.move("LEFT");
				}
				else if(boy.getX() > 0 && (grass.getCenterLeft(boy) == 0 || grass.getCenterLeft(boy) == 7|| grass.getCenterLeft(boy) ==8))
				{
					boy.move("LEFT");
				}	
			}
			if(keys[1])
			{
				if(boy.getX() < 715 && (stone.getX() - 30 == boy.getX()) && (stone.getY() - 20 == boy.getY()))
				{
					boy.move("RIGHT");
					stone.move("RIGHT");
				}
				else if(boy.getX() < 715 && (grass.getCenterRight(boy) == 0 || grass.getCenterRight(boy) == 7|| grass.getCenterRight(boy) ==8))
					boy.move("RIGHT");
			}
			if((grass.getCenter(stone) == 0) && ((grass.getBottomMidFour(stone) ==0) && (grass.getBottomMidThree(stone) ==0)))
				stone.move("DOWN");
//			if(time2 >= time + 20 && keys[2] && fly && boy.getY() > 0 && grass.getHeadLeft(boy) == 0 && grass.getHeadRight(boy) == 0)
//			System.out.println (count);
//			if(time2 >= time + 2000 && count > 1 && boy.getY() > 0 && grass.getHeadLeft(boy) == 0 && grass.getHeadRight(boy) == 0)// && grass.getBottomMidOne(boy) != 0 && grass.getBottomMidTwo(boy) != 0)// && keys[2] && fly && boy.getY() > 0 && grass.getHeadLeft(boy) == 0 && grass.getHeadRight(boy) == 0)
//			if(boyCount< 100 &&  boy.getY() > 0 && grass.getHeadLeft(boy) == 0 && grass.getHeadRight(boy) == 0)// && grass.getBottomMidOne(boy) != 0 && grass.getBottomMidTwo(boy) != 0)// && keys[2] && fly && boy.getY() > 0 && grass.getHeadLeft(boy) == 0 && grass.getHeadRight(boy) == 0)
//			{
//				boy.move("UP");
//				boyCount++;
//				
////				fly = count <90;
////				time = System.currentTimeMillis();
////				System.out.println (time);
//			}
////			else if(count != 0 && grass.getBottomMidOne(boy) != 0 || grass.getBottomMidTwo(boy) != 0 && keys[2] && boy.getY() > 0 && grass.getHeadLeft(boy) == 0 && grass.getHeadRight(boy) == 0)
//////			else if(grass.getBottomMidOne(boy) != 0 || grass.getBottomMidTwo(boy) != 0 && keys[2] && boy.getY() > 0 && grass.getHeadLeft(boy) == 0 && grass.getHeadRight(boy) == 0)
////			{
////				boy.move("UP");
////				count = 3;
////			}
//	//		else if(grass.getCenter(boy) == 0 && ((grass.getBottomLeft(boy) ==0 && grass.getBottomMidFour(boy) == 0) || (grass.getBottomRight(boy) ==0 && grass.getBottomMidThree(boy) == 0)))
//			else if(grass.getCenter(boy) == 0 && ((grass.getBottomLeft(boy) ==0 && grass.getBottomRight(boy) ==0)))// || (grass.getBottomMidThree(boy) == 0 || grass.getBottomMidFour(boy) == 0)))
//			{
////				count = 0;
////				fly = count <90;
//				boy.move("DOWN");
//			}
//			else
//				boyCount = 0;
//			System.out.println (fly);
//			if(grass.comp(boy) == 1)
//			{
//				
//			}
			grass.comp(boy);
			if((keys[3])||(boy.getY() <= 0 || grass.getHeadLeft(boy) != 0 || grass.getHeadRight(boy) != 0))
			{	
				boyCount = 100;
				fly = false;
			}
			if(fly && boy.getY() > 0 && grass.getHeadLeft(boy) == 0 && grass.getHeadRight(boy) == 0)
			{
				if(boyCount >= 100)
					fly = false;
				boy.move("UP");
				boyCount++;
			}
			else if(!fly && boyCount < 100 && keys[2] && boy.getY() > 0 && grass.getHeadLeft(boy) == 0 && grass.getHeadRight(boy) == 0)
			{
//				boy.setSpeed(2);
//				boy.move("UP2");
//				boy.move("UP");//
//				boyCount = boyCount + 1.5;
//				boyCount++;//
				fly = true;
			}
//			else if((grass.getCenter(boy) == 0) && !((grass.getBottomMidFour(boy) ==1) || (grass.getBottomMidThree(boy) ==1))) //was getbotleft and getbotright
//			else if((grass.getCenter(boy) == 0) &&!((grass.getBottomLeft(boy) ==1 && grass.getBottomMidFour(boy) == 1) || (grass.getBottomRight(boy) ==1 && grass.getBottomMidThree(boy) == 1)))
			else if((grass.getCenter(boy) == 0) && ((grass.getBottomMidFour(boy) ==0) && (grass.getBottomMidThree(boy) ==0))) //was getbotleft and getbotright
					boy.move("DOWN");
			else
				boyCount = 0;
			
			grass.comp(girl);
			if((keys[9])||(girl.getY() <= 0 || grass.getHeadLeft(girl) != 0 || grass.getHeadRight(girl) != 0))
			{	
				girlCount = 100;
				fly2 = false;
			}	
			if(fly2 && girl.getY() > 0 && grass.getHeadLeft(girl) == 0 && grass.getHeadRight(girl) == 0)
			{
				if(girlCount >= 100)
					fly2 = false;
				girl.move("UP");
				girlCount++;
			}
			else if(!fly2 && girlCount < 100 && keys[5] && girl.getY() > 0 && grass.getHeadLeft(girl) == 0 && grass.getHeadRight(girl) == 0)
			{
//				girl.setSpeed(2);
//				girl.move("UP2");
//				girl.move("UP");//
//				girlCount = girlCount + 1.5;
//				girlCount++;//
				fly2 = true;
			}
//			else if((grass.getCenter(girl) == 0) && !((grass.getBottomMidFour(girl) ==1) || (grass.getBottomMidThree(girl) ==1))) //was getbotleft and getbotright
//			else if((grass.getCenter(girl) == 0) &&!((grass.getBottomLeft(girl) ==1 && grass.getBottomMidFour(girl) == 1) || (grass.getBottomRight(girl) ==1 && grass.getBottomMidThree(girl) == 1)))
			else if((grass.getCenter(girl) == 0) && ((grass.getBottomMidFour(girl) ==0) && (grass.getBottomMidThree(girl) ==0))) //was getbotleft and getbotright
					girl.move("DOWN");
			else
				girlCount = 0;
			
			if(keys[6])
			{
				if(girl.getX() > 0 && (stone.getX() + 30 == girl.getX()) && (stone.getY() - 20 == girl.getY()))
				{
					girl.move("LEFT");
					stone.move("LEFT");
				}
				else if(girl.getX() > 0 && (grass.getCenterLeft(girl) == 0 || grass.getCenterLeft(girl) == 7|| grass.getCenterLeft(girl) ==8))
				{
					girl.move("LEFT");
				}	
			}
			if(keys[7])
			{
				if(girl.getX() < 715 && (stone.getX() - 30 == girl.getX()) && (stone.getY() - 20 == girl.getY()))
				{
					girl.move("RIGHT");
					stone.move("RIGHT");
				}
				else if(girl.getX() < 715 && (grass.getCenterRight(girl) == 0 || grass.getCenterRight(girl) == 7|| grass.getCenterRight(girl) ==8))
					girl.move("RIGHT");
			}
			
			
		}
		if(grass.getCenter(boy) == 7)
			{
//				grass.changePostion(boy.getX(),boy.getY(),0);
				grass.gem(7);
				grass.changeScore(100);
			}
			else if(grass.getCenter(boy) == 8)
			{
//				grass.changePostion(boy.getX(),boy.getY(),0);
				grass.gem(8);
				grass.changeScore(-100);
			}
		if(grass.getCenter(girl) == 7)
			{
//				grass.changePostion(girl.getX(),girl.getY(),0);
				grass.gem(7);
				grass.changeScore(-100);
			}
			else if(grass.getCenter(girl) == 8)
			{
//				grass.changePostion(girl.getX(),girl.getY(),0);
				grass.gem(8);
				grass.changeScore(100);
			}
	
		grass.draw(graphToBack);
		stone.draw(graphToBack);
		boy.draw(graphToBack);
		girl.draw(graphToBack);
		if(pause)
		{
			graphToBack.drawString("YOU LOSE!!",350,35);
		}
		twoDGraph.drawImage(back, null, 0, 0);
	}	
	
	public int getScore()
	{
		return grass.getScore();
	}
	
	
	
	/**
	 * Updates the keys array based on the key that was pressed
	 * Uses the arrow keys left, right, up and down
	 * @param e the KeyEvent representing the pressed key
	 */
	public void keyPressed(KeyEvent e)
	{
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[5] = true;
			
		
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[6] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[7] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[9] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			keys[8] = !keys[8];
		}
		if(e.getKeyCode() == KeyEvent.VK_N)
		{
			grass.setLvl(0);
		}
		if(e.getKeyCode() == KeyEvent.VK_R)
		{
			grass.setLvl(-1);
		}
		repaint();
	}

	/**
	 * Updates the keys array based on the key that was released
	 * @param e the KeyEvent representing the released key
	 */
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
				keys[2] = false;	
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[5] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[6] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[7] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[9] = false;
		}
//		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
//		{
//			keys[8] = false;
//		}
		if (e.getKeyCode() == KeyEvent.VK_H)
		{
			JOptionPane.showMessageDialog(null,"Don't go into the dark green blocks and don't mix fire and water");
		}
		repaint();
	}

	/**
	 * Needed to satisfy the KeyListener
	 * @param e not used
	 */
	public void keyTyped(KeyEvent e)
	{
	}

	/**
	 * Runs the thread in an infinite loop with a pause of 8 miliseconds between updates
	 */
 	public void run()
 	{
 		try
 		{
	   		while(!thread.interrupted())
	   		{
	   		   thread.currentThread().sleep(8);
	           repaint();
	        }
    	}
    	catch(Exception e)
    	{
    	}
	}
}