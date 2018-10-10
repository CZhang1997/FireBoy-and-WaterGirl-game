package cxz173430;

//Name -		Churong Zhang, Smit Shah
//Date -		05/24/2015
//Period -		3rd Period
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ArrayList;
/**
* Manages the levels and builds all the elements of the level using images and data files
*/
public class Grass
{
	
	private LinkedList<int[][]> lvl;
	private Image grass;
	private Image back;
	private int [][] grassOn;
	public final static int SIZE = 30;
	private Image lava, water, poison, rGem, bGem, comp, wall;
	private FireBoy boy;
	private WaterGirl girl;
	private Boulder stone;
	private int score;
	private int lvlNum;
	/**
	* Makes a default Grass object which uses the data files and the 
	* images are pre-selected for different types of objects
	*/
	public Grass()throws FileNotFoundException
	{
		score = 0;
		
		
		
		
		lvl = new LinkedList<int[][]>();
		boy = new FireBoy();
		girl = new WaterGirl();
		stone = new Boulder();
		changeStage("lvl1.txt");
		grassOn = lvl.get(0);
		lvlNum = 0;
//		
//		for(int d = 0; d < lvl.size(); d++)
//		{
//			for(int a = 0; a< lvl.get(d).length; a++)
//		{
//			for(int b = 0; b < lvl.get(d)[a].length; b++)
//			{
//				System.out.print (lvl.get(d)[a][b]);
//	
//			}
//			System.out.println ();
//		}
//		System.out.println ();
//		}

		try
		{
			URL url = getClass().getResource("tile_grass_1.jpg");
			URL url2 = getClass().getResource("Frosting_Forest_background.png");
			grass = ImageIO.read(url);
			back = ImageIO.read(url2);
			URL url3 = getClass().getResource("Lava.jpg");
			lava = ImageIO.read(url3);
			URL url4 = getClass().getResource("Water.jpg");
			water = ImageIO.read(url4);
			URL url5 = getClass().getResource("green.png");
			poison = ImageIO.read(url5);
			URL url6 = getClass().getResource("redgem.png");
			rGem = ImageIO.read(url6);
			URL url7 = getClass().getResource("bluegem.png");
			bGem = ImageIO.read(url7);
			URL url8 = getClass().getResource("url.jpg");
			comp = ImageIO.read(url8);
			URL url9 = getClass().getResource("wall.jpg");
			wall = ImageIO.read(url9);

		}
		catch(Exception e)
		{
	
			JOptionPane.showMessageDialog(null,"Image was not found !");
		}
	}
	/**
	* Used to change the position
	* @param x the x location
	* @param y the y location
	* @param value the amount of change the position
	*/
	public void changePostion(int x, int y, int value)
	{
		grassOn[y/SIZE+1][x/SIZE+1] = value;
		grassOn[y/SIZE][x/SIZE] = value;
		grassOn[y/SIZE-1][x/SIZE+1] = value;

	}
	/**
	* Changes the level that the Stage object displays 
	* @param file the new layout of the level
	*/
	public void changeStage(String file) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File(file));
		int x = 0;
		int lvlNum = in.nextInt();
		in.nextLine();
		int [] [] temp = new int[20][26];
		for(int c = 0; c < lvlNum; c++)
		{
			
			for(int b = 0; b< 19; b++)
			{
				String line = in.nextLine();
				String[] lin = line.split(" ");
				
				for(int a = 0; a < lin.length; a++)
				{
					temp[x][a] = Integer.parseInt(lin[a]);

				}

				x++;
			}
			
			lvl.add(temp);
			temp = new int[20][26];
			x= 0;
		}
	}
	/**
	* Sets the level to a new level
	* @param a the new level
	*/
	public void setLvl(int a)
	{
			
			grassOn = lvl.get(lvl.indexOf(grassOn)+1 + a);
			boy.setPos(0,400);
			girl.setPos(710,400);
		
	}
	/**
	* Returns what level the current level being displayed is
	*/
	public int getLvlNum()
	{
		return lvl.indexOf(grassOn)+1;
	}
	/**
	* Adds to the score using the amount given
	* @param a the amount being added
	*/
	public void changeScore(int a)
	{
		score +=a;
	}
	/**
	 * Draws/Updates the contents of the graphics window
	 * @param window the graphics window
	 */
	public void draw(Graphics window) 
	{
		window.drawImage(back,0,0,800,600,null);
		
		for(int a = 0; a < grassOn.length; a++)
		{
			for(int b = 0; b < grassOn[a].length; b++)
			{
				if(grassOn[a][b] == -2)
				{
					stone.setPos(b*SIZE, a*SIZE);
					grassOn[a][b] = 0;
//					window.drawImage(stone, b*SIZE, a*SIZE, SIZE,SIZE,null);
		
				}
				else if (grassOn[a][b] == 1 || grassOn[a][b] == -1)
				{
					window.drawImage(grass, b*SIZE, a*SIZE, SIZE,SIZE,null);
				}
//				else if (grassOn[a][b] == 2)
//				{
////					boy.setPos(b*SIZE, a*SIZE-SIZE);
////					boy = new FireBoy(a*(800/grassOn.length),b*(600/grassOn[1].length),2);
////					boy = new FireBoy();
//				}
				else if (grassOn[a][b] == 2 || grassOn[a][b] == 3)
				{
//					girl.setPos(b*SIZE-SIZE, a*SIZE-SIZE);
//					girl = new WaterGirl(a*(800/grassOn.length),b*(600/grassOn[1].length),2);
//					girl = new WaterGirl();
					window.drawImage(comp, b*SIZE, a*SIZE, SIZE,SIZE,null);
				}
				else if (grassOn[a][b] == 4)
				{
					window.drawImage(lava, b*SIZE, a*SIZE, SIZE,SIZE,null);
				}
				else if (grassOn[a][b] == 12 || grassOn[a][b] ==13 || grassOn[a][b] == -11)
				{
					window.drawImage(wall, b*SIZE, a*SIZE, SIZE,SIZE,null);
				}
				else if (grassOn[a][b] == 5)
				{
					window.drawImage(water, b*SIZE, a*SIZE, SIZE,SIZE,null);
				}
				else if (grassOn[a][b] == 6)
				{
					window.drawImage(poison, b*SIZE, a*SIZE, SIZE,SIZE,null);
				}
				else if (grassOn[a][b] == 7)
				{
					window.drawImage(rGem, b*SIZE, a*SIZE, SIZE,SIZE,null);
				}
				else if (grassOn[a][b] == 8)
				{
					window.drawImage(bGem, b*SIZE, a*SIZE, SIZE,SIZE,null);
				}
				else //if ()
				{
//					window.drawImage(water, b*SIZE, a*SIZE, SIZE,SIZE,null);
				}
			window.drawString("Total Score: " + score, 600,35);
			}
			
		}
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * left side of the head of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getHeadLeft(MovingThing o)
	{
		int x = o.getX() / SIZE;
		int y = o.getY() / SIZE;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * right side of the head of the given MovingThing
	 * @param o the MovingThing to look around	 
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getHeadRight(MovingThing o)
	{
		int x = (o.getX() + o.getWidth())/ SIZE;
		int y = o.getY() / SIZE;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * left center of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getCenterLeft(MovingThing o)
	{
		int x = o.getX() / SIZE;
		int y = (o.getY() + o.getHeight() /2) / SIZE;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * center of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getCenter(MovingThing o)
	{
		int x = (o.getX() + o.getWidth()/2)/ SIZE;
		int y = (o.getY() + o.getHeight()/2 ) / SIZE;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * center right of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getCenterRight(MovingThing o)
	{
		int x = (o.getX() + o.getWidth())/ SIZE;
		int y = (o.getY() + o.getHeight()/2 ) / SIZE;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * bottom left of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getBottomLeft(MovingThing o)
	{
		int x = o.getX() / SIZE;
		int y = (o.getY() + o.getHeight()) / SIZE;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * bottom right of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getBottomRight(MovingThing o)
	{
		int x = (o.getX() + o.getWidth())/ SIZE;
		int y = (o.getY() + o.getHeight()) / SIZE ;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * bottom middle(2/5) of  of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getBottomMidOne(MovingThing o)
	{
		int x = (o.getX() + (2 * o.getWidth()/ 5))/ SIZE;
		int y = (o.getY() + o.getHeight()) / SIZE ;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * bottom middle(3/5) of  of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getBottomMidTwo(MovingThing o)
	{
		int x = (o.getX() + (o.getWidth() - ((2 * o.getWidth())/5)))/ SIZE;
		int y = (o.getY() + o.getHeight()) / SIZE ;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * bottom middle(2/7) of  of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getBottomMidThree(MovingThing o)
	{
		int x = (o.getX() + (2 * o.getWidth()/ 7))/ SIZE;
		int y = (o.getY() + o.getHeight()) / SIZE ;
		return grassOn[y][x];
	}
	/**
	 * Hit Detection Method, returns the integer that is in the 
	 * bottom middle(5/7) of  of the given MovingThing
	 * @param o the MovingThing to look around
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getBottomMidFour(MovingThing o)
	{
		int x = (o.getX() + (o.getWidth() - ((2 * o.getWidth())/7)))/ SIZE;
		int y = (o.getY() + o.getHeight()) / SIZE ;
		return grassOn[y][x];
	}
	/**
	 * Checks if the block that the MovingThing is standing on is a computer or 
	 * not and changing the map appropriately 
	 * @param o the MovingThing to look around
	 */
	public void comp(MovingThing o)
	{
//		int x = (o.getX() + (2 * o.getWidth()/ 5))/ SIZE;
//		int y = (o.getY() + o.getHeight()) / SIZE ;
//		if(grassOn[y][x] == 2)
//		{
//			for(int r = 0; r < grassOn.length; r++)
//				for(int c = 0; c < grassOn[r].length;c++)
//				{
//					if(grassOn[r][c] == 12)
//						grassOn[r][c] = 0;
//				}
//			grassOn[y][x] = 0;
//		}	
//		if(grassOn[y][x] == 3)
//		{
//			for(int r = 0; r < grassOn.length; r++)
//				for(int c = 0; c < grassOn[r].length;c++)
//				{
//					if(grassOn[r][c] == 13)
//						grassOn[r][c] = 0;
//				}
//			grassOn[y][x] = 0;
//		}
		int x = (o.getX() + (2 * o.getWidth()/ 5))/ SIZE;
		int y = (o.getY() + o.getHeight()) / SIZE ;
		if(grassOn[y][x] == 2)
		{
			grassOn[y][x] = 0;
			boolean more = false;
			for(int r = 0; r < grassOn.length; r++)
				for(int c = 0; c < grassOn[r].length;c++)
				{
					if(grassOn[r][c] == 2)
						more = true;
				}
			if(!more)
			for(int r = 0; r < grassOn.length; r++)
				for(int c = 0; c < grassOn[r].length;c++)
				{
					if(grassOn[r][c] == 12)
						grassOn[r][c] = 0;
				}
			
		}	
		if(grassOn[y][x] == 3)
		{
//			for(int r = 0; r < grassOn.length; r++)
//				for(int c = 0; c < grassOn[r].length;c++)
//				{
//					if(grassOn[r][c] == 13)
//						grassOn[r][c] = 0;
//				}
//			grassOn[y][x] = 0;
			grassOn[y][x] = 0;
			boolean more = false;
			for(int r = 0; r < grassOn.length; r++)
				for(int c = 0; c < grassOn[r].length;c++)
				{
					if(grassOn[r][c] == 3)
						more = true;
				}
			if(!more)
			for(int r = 0; r < grassOn.length; r++)
				for(int c = 0; c < grassOn[r].length;c++)
				{
					if(grassOn[r][c] == 13)
						grassOn[r][c] = 0;
				}
		}
		
	}
	/**
	 * Checks to see if the hidden switch has been pressed by the boulder or not
	 * @param o the MovingThing that is on the hiddenSwitch
	 */
	public void hiddenSwitch(MovingThing o)
	{
		int x = (o.getX() + o.getWidth()) / SIZE; int y = (o.getY()+ o.getHeight()) / SIZE;
//		System.out.println (y + " " + x);
		if(y >= 0 && x >= 0)
//		System.out.println (grassOn[y][x]);
			if(grassOn[y][x] == -1)
			{
				for(int r = 0; r < grassOn.length; r++)
					for(int c = 0; c < grassOn[r].length;c++)
					{
						if(grassOn[r][c] == -11)
							grassOn[r][c] = 0;
					}
	//			grassOn[y -1][x] = 0;
			}
//		y = y + 2;
//		x = x - 1;
//		if(y >= 0 && x >= 0)
//		System.out.println (grassOn[y][x]);
//		System.out.println (y + " " + x);
	}
	/**
	 * Checks whether there is grass or not
	 * @param o the MovingThing to look around
	 * @return whether there is grass
	 */
	public boolean isThereGrass(MovingThing o)
	{
		int x1 = (int)Math.ceil(o.getX() / SIZE);
		int x2 = (int)Math.ceil((o.getX() + SIZE) / SIZE);
		int head = (int)Math.ceil(o.getY() / SIZE );
		int foot = (int)Math.ceil((o.getY() + SIZE) / SIZE);
//		return  grassOn[x2][foot] == 1;
		return grassOn[head][x1] == 1 || grassOn[foot][x2] == 1; 
	} 
	/**
	 * Gets the score of the game
	 * @return the number that is there, which represents what object/image is in that position
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 * Removes the given gem
	 * @param whichGem which gem to look at
	 */
	public void gem(int whichGem)
	{
		for(int r = 0; r < grassOn.length; r++)
			for(int c = 0; c < grassOn[r].length;c++)
			{
				if(grassOn[r][c] == whichGem)
					grassOn[r][c] = 0;
			}
	}
	/**
	 * Gets the FireBoy
	 * @return the FireBoy
	 */
	public FireBoy getFireBoy()
	{
		return boy;
	}
	/**
	 * Gets the WaterGirl
	 * @return the WaterGirl
	 */
	public WaterGirl getWaterGirl()
	{
		return girl;
	}
	/**
	 * Gets the Boulder
	 * @return the Boulder
	 */
	public Boulder getBoulder()
	{
		return stone;
	}
}


