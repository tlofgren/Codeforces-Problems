/**Tyler Lofgren
 * http://codeforces.com/problemset/problem/2/A
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Winner2A
{
	private class Entry<K, V>	//borrowed from http://www.vogella.com/tutorials/JavaDatastructures/article.html#map
	{
		  private final K key;
		  private V value;

		  public Entry(K key, V value)
		  {
		    this.key = key;
		    this.value = value;
		  }

		  public K getKey()
		  {
		    return key;
		  }

		  public V getValue()
		  {
		    return value;
		  }

		  public void setValue(V value)
		  {
		    this.value = value;
		  }
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Winner2A w = new Winner2A();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Entry<String,Integer>> map = new ArrayList<Winner2A.Entry<String,Integer>>();
		int maxScore = 0;
		int T = Integer.parseInt(br.readLine());
		int[] scores = new int[T];
		String[] names = new String[T];
		for (int t = 0; t < T; t++)
		{
			String[] line = br.readLine().split(" ");
			String s = line[0];
			names[t] = s;
			int sc = Integer.parseInt(line[1]);
			int loc = -1;
			for (int i = 0; i < map.size(); i++)	//find index of key
			{	
				if (s.equals(map.get(i).getKey().toString()))
					loc = i;
			}
			
			if (loc < 0)	//doesn't exist yet
			{
				Entry<String,Integer> e = w.new Entry<String,Integer>(line[0],sc);
				map.add(e);
				scores[t] = sc;
			}
			else
			{
				Entry<String, Integer> e = map.get(loc);
				e.setValue(e.getValue() + sc);
				scores[t] = e.getValue();
			}
		}
		
		for (int i = 0; i < map.size(); i++)	//find max score
		{
			Entry<String,Integer> e = map.get(i);
			if (e.getValue() > maxScore)
			{
				maxScore = e.getValue();
			}
		}
		
		for (int i = 0; i < T; i++)
		{
			int val = -1;
			for (int j = 0; j < map.size(); j++)	//get value for current name
			{
				Entry<String,Integer> curr = map.get(j);
				if (curr.getKey().equals(names[i]))
				{
					val = curr.getValue();
					break;
				}
			}
			
			if (scores[i] >= maxScore && val == maxScore)
			{
				System.out.println(names[i]);
				break;
			}
		}
	}
}
