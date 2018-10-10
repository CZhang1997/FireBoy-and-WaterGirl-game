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

/**
* Represents a moving girl that can be drawn in a graphics
* window.
*/
public class WaterGirl extends MovingThing
{
//	private int speed;
	private Image image;

	/**
	 * Constructs a Watergirl with a location of (0,400), a width
	 * height of 50 and speed of 1
	 */
	public WaterGirl()
	{
		this(700, 400,50,50,1);
		//speed = 10;
	
	}

	/**
	 * Constructs a girl at a specified location with a specified
	 * speed, width and height.
	 * @param x the x location
	 * @param y the y location
	 * @param w the width
	 * @param h the height
	 * @param s the speed
	 */
	public WaterGirl(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		setSpeed(s);
		try
		{
			URL url = getClass().getResource("watergirl.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
			JOptionPane.showMessageDialog(null,"Image was not found !");
		}
	}

	
		
	/**
	 * Adjusts the x and y of the girl based on a specified direction, and the speed at which the
	 * girl is moving. girls can move LEFT, RIGHT, UP or DOWN
	 * @param direction the direction in which to move
	 */
	public void move(String direction)
	{
		//add code here
		if(direction.equalsIgnoreCase("LEFT"))
			setX(getX()- getSpeed());
		if(direction.equalsIgnoreCase("RIGHT"))
			setX(getX()+ getSpeed());
		if(direction.equalsIgnoreCase("UP"))
		{
			setY(getY()- getSpeed());	
		}
		if(direction.equalsIgnoreCase("DOWN"))
			setY(getY()+ getSpeed());
	}

	/**
	 * Draws a girl in a specified Graphics window
	 * @param window the Graphics window
	 */
	public void draw(Graphics window)
	{
 		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	/**
	 * Returns a string version of the girl
	 * @return a string version of the girl
	 */
	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
