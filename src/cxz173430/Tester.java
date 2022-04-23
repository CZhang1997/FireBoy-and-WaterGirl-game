package cxz173430;

//Name -		Churong Zhang, Smit Shah
//Date -		05/24/2015
//Period -		3rd Period
import javax.swing.JFrame;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
/**
* This is the game window, it is a JFrame and all levels are eventually displayed in the same one
*/
public class Tester extends JFrame implements WindowListener, ActionListener
{
	private static final int WIDTH = 780;
	private static final int HEIGHT = 630;
	private ImageIcon img, icon;
	private Ranking rank;
//	private String name;
	private Stage theGame;
//	private static String playerName;
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem save, show;
	
	/**
	 * Constructs a Level JFrame
	 * @param playerName the name of the player
	 */
	public Tester() throws FileNotFoundException, IOException
	{	
		super("Fireboy and Watergirl");
	//	this.playerName = playerName;
		addWindowListener(this);
		ImageIcon img = new ImageIcon(getClass().getResource("fireboy_station.png"));
		setIconImage(img.getImage());
		setSize(WIDTH,HEIGHT);
		rank = new Ranking();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);	
		save = new JMenuItem("Save_Score");
		show = new JMenuItem("Show_Ranking");
	
		save.addActionListener(this);

		show.addActionListener(this);
	
		menu = new JMenu("Score_Options");
		menu.add(save);
		menu.add(show);
	
		menuBar.add(menu);
		
	//	name = playerName;
		theGame = new Stage();
		((Component)theGame).setFocusable(true);
		
		getContentPane().add(theGame);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	/**
	 *	To ask the user if he or she really want to close the program
	 * @param e the WindowEvent
	 */
	public void windowClosing(WindowEvent e)
	{
		
		try
		{
			rank.save();
		}
		catch(IOException en){
//			System.out.println ("asfa");
		
		}

	}
	
	/** 
	 * Do-nothing methods that are part of the WindowListener Interface
	 * @param e the windowEveent
	 */
	public void windowDeactivated(WindowEvent e){}
		/** 
	 * Do-nothing methods that are part of the WindowListener Interface
	 * @param e the windowEveent
	 */
	public void windowDeiconified(WindowEvent e){}
		/** 
	 * Do-nothing methods that are part of the WindowListener Interface
	 * @param e the windowEveent
	 */
	public void windowIconified(WindowEvent e){}
		/** 
	 * Do-nothing methods that are part of the WindowListener Interface
	 * @param e the windowEveent
	 */
	public void windowOpened(WindowEvent e){}
		/** 
	 * Do-nothing methods that are part of the WindowListener Interface
	 * @param e the windowEveent
	 */
	public void windowClosed(WindowEvent e){
		}
	/**
	 *  Do-nothing methods that are part of the MouseListener Interface
	 * @param the MouseEvent e
	 */
	public void mouseClicked(MouseEvent e){}
	/**
	 *  Do-nothing methods that are part of the MouseListener Interface
	 * @param the MouseEvent e
	 */
	public void mousePressed(MouseEvent e){}
	/** 
	 * Do-nothing methods that are part of the WindowListener Interface
	 * @param e the windowEveent
	 */
	public void windowActivated(WindowEvent e){}
	/** 
	 * Manages the scoring tab in the game
	 * @param e the ActionEvent
	 */
	public void actionPerformed(ActionEvent e)
	 {
	 	String menuName = e.getActionCommand();
	 	try
	 	{
	 		if(menuName.equals("Save_Score"))
	  	 	{
	  	 		String name = JOptionPane.showInputDialog(null, "Enter your name: ");
				rank.add(theGame.getScore(), name);
	  	 	}
	  	 	else if(menuName.equals("Show_Ranking"))
	  	 	{
	  	 		JFrame j = new JFrame("Ranking!");
	  	 		j.setSize(500,200);
	  	 		JTextArea a = new JTextArea();
	  	 		JScrollPane s = new JScrollPane(a);
	  	 		a.setLineWrap(true);
				a.setFont(new Font("Courier",Font.BOLD,15));
			 	a.setEditable(false);
			 	a.setBorder(BorderFactory.createLineBorder(Color.blue));	
				a.setWrapStyleWord(true);
				a.setText(rank.toString());
//				j.add(a);
				j.add(s);
//				j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				j.setVisible(true);
				
	  	 	}
	 	}
	 	catch(IOException en)
	 	{
	 		
	 	}
	 	
	 }
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		Tester t = new Tester();
	}
}