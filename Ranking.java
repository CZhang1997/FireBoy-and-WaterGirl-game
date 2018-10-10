package cxz173430;
//Name -		Churong Zhang, Smit Shah
//Date -		05/24/2015
//Period -		3rd Period 

import java.util.*;
import java.io.*;
import javax.swing.*;
/** 
* Used for saving and loading high scores of the game
*/
public class Ranking
{
	private Map<Integer, ArrayList<String>> rank;
	private File f;
	
	/** 
	 * Makes a default Ranking class that is able to save and load
	 */
	public Ranking()throws IOException
	{
		rank = new TreeMap<Integer, ArrayList<String>>();
		f = new File("ranking.dat");
		load();

	}
	/**
	 * Adds a score to the TreeMap
	 * @param score the score to add 
	 * @param name the name of the player
	 */
	public void add(int score, String name)throws IOException
	{
		if(rank == null)
		{
			rank = new TreeMap<Integer, ArrayList<String>>();
			System.out.println (1);
		}
		if(rank.containsKey(score))
		{
			rank.get(score).add(name);
		}
		else
		{
			ArrayList<String> names = new ArrayList<String>();
			names.add(name);
			rank.put(score, names);
		}
		
	}
	/**
	 * Saves the TreeMap of scores into a file
	 * @param fileName the name of the file to save to
	 */
	public void save()throws IOException
	{
			
			try
	    	{
	    		PrintWriter out = new PrintWriter(f);
	    		if(!rank.isEmpty())
					for(int i : rank.keySet())
					{
						out.println(i);
						for(int a = 0; a < rank.get(i).size(); a++)
						{
							out.println(rank.get(i).get(a));
						}
			    
					}
				out.close();

	    	}
	    	catch(IOException exception)
	    	{
	    		System.out.println("File problem - could not save");
	    	}
		
  
	}
	/**
	 * Loads data from a file into a TreeMap of scores
	 * @param file the File name to load from
	 */
	private void load()throws IOException
	{
		Scanner in = new Scanner(f);
		int a = 0;
		ArrayList<String> names = null;
		while(in.hasNextLine())
		{
			
			if(in.hasNextInt())
			{
				if(names != null)
				{
					rank.put(a, names);
				}
				a = in.nextInt();
				in.nextLine();
				names = new ArrayList<String>();
			}
			else
			{
				String name = in.nextLine();
				names.add(name);
			}
			
		}
		rank.put(a,names);

		in.close();
	}
	/**
	 * Gives a string representation of the TreeSet
	 * @return the string representation 
	 */
	public String toString()
	{
		String s = "";
		if(!rank.isEmpty())
		for(int i : rank.keySet())
		{			
			for(int a = 0; a < rank.get(i).size(); a++)
			{
				s = i + "\t\t" + rank.get(i).get(a) + "\n" + s;
			}
			
		}
		return "SCORE\t\tPLAYERS\n" + s;
	}
}
	