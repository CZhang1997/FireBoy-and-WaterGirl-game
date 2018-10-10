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
import java.io.FileNotFoundException;
/**
* Represents a moving boulder that can be drawn in a graphics
* window.
*/
public class Boulder extends MovingThing
{
//	private int speed;
	private Image image;

	/**
	 * Constructs a boulder with a location of (10,10), a width
	 * height and speed of 10
	 */
	public Boulder()
	{
		this(740,10,30,30,1);
		//speed = 10;
		setSpeed(1);
	}




	/**
	 * Constructs a boulder at a specified location with a specified
	 * speed, width and height.
	 * @param x the x location
	 * @param y the y location
	 * @param w the width
	 * @param h the height
	 * @param s the speed
	 */
	public Boulder(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		setSpeed(s);
		try
		{
			URL url = getClass().getResource("stone.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
			JOptionPane.showMessageDialog(null,"Image was not found!");
		}
	}

	
		
	/**
	 * Adjusts the x and y of the boulder based on a specified direction, and the speed at which the
	 * boulder is moving. boulders can move LEFT, RIGHT, UP or DOWN
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
			setY(getY()- getSpeed());
		if(direction.equalsIgnoreCase("DOWN"))
			setY(getY()+ getSpeed());
	}

	/**
	 * Draws a boulder in a specified Graphics window
	 * @param window the Graphics window
	 */
	public void draw(Graphics window)
	{
		if(getX()<780)
 		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	/**
	 * Returns a string version of the boulder
	 * @return a string version of the boulder
	 */
	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
