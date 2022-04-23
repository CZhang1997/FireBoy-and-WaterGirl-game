package cxz173430;

//Name -		Churong Zhang, Smit Shah
//Date -		05/24/2015
//Period -		3rd Period 

import java.awt.Color;
import java.awt.Graphics;

/**
* Represents a moving thing. This is an Abstract class.
*/
public abstract class MovingThing implements Moveable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int speed;

	/**
	 * Constructs a MovingThing object with specified position,
	 * width and height
	 * @param x the x location
	 * @param y the y location
	 * @param w the width
	 * @param h the height
	 */
	public MovingThing(int x, int y, int w, int h)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
	}

	/**
	 * Sets the position of a moveable object
	 * @param x the new x position
	 * @param y the new y position
	 */
	public void setPos( int x, int y)
	{
		xPos = x;
		yPos = y;
	}
	/** 
	 * Sets the x position of a moveable object
	 * @param x the new x
	 */
  public void setX( int x )
  {
  	xPos = x;
  }
  /**
   * Sets the y position of a moveable object
   * @param y the new y
   */
  public void setY( int y )
  {
  	yPos = y;
  }

	/**
	 * Gets the x position of a moveable object
	 * @return the x position
	 */
  public int getX()
  {
  	return xPos;
  }
  /**
   * Gets the y position of a moveable object
   * @return the y position
   */
  public int getY()
  {
  	return yPos;
  }

	/** 
	 * Gets the width of a moveable object
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}
	/** 
	 * Gets the height of a moveable object
	 * @return the height
	 */
	public int getHeight()
	{
		return height;
	}
	
	/** 
	 * Sets the width of a moveable object
	 * @param w the new width
	 */
	public void setWidth( int w )
	{
		width = w;
	}
	/**
	 * Sets the height of a moveable object
	 * @param h the new height
	 */
	public void setHeight( int h )
	{
		height = h;
	}
	
	/**
	 * Sets the speed of a moveable object
	 * @param s the new speed
	 */
  public void setSpeed( int s )
  {
  	speed = s;
  }
  
  /**
   * Gets the speed of a moveable object
   * @return the current speed
   */
	public int getSpeed()
	{
		return speed;
	}
	
	/**
	 * Moves a MovingThing according to a specified direction
	 * @param direction the direction in which to move
	 */
	public abstract void move(String direction);
	
	/**
	 * Draws a MovingThing in a specified Graphics window
	 * @param window the Graphics window
	 */
	public abstract void draw(Graphics window);

	/**
	 * Returns a string version of the MovingThing
	 * @return a string version of the MovingThing
	 */
	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}