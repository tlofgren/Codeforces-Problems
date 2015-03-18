/**Tyler Lofgren
 * http://codeforces.com/problemset/problem/4/B
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BeforeExam4B
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split("\\s+");
		int d = Integer.parseInt(line[0]);
		int total = Integer.parseInt(line[1]);
		int maxHours = 0;
		int minHours = 0;
		Range[] hours = new Range[d];
		for (int i = 0; i < d; i++)
		{
			line = br.readLine().trim().split("\\s+");
			hours[i] = new Range(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			minHours += hours[i].b;
			maxHours += hours[i].e;
		}
		
		if (maxHours < total || total < minHours)	//not enough study time, or didn't spend enough time studying
		{
			System.out.println("NO");
			return;
		}
		else
			System.out.println("YES");
				
		int difference = total - minHours;
		int timePossible;
		for (int i = 0; i < d; i++)
		{
			timePossible = hours[i].e - hours[i].b;
			if (timePossible <= difference)
			{
				System.out.print(hours[i].e + " ");
				difference -= timePossible;
			}
			else
			{
				System.out.print(hours[i].b + difference + " ");
				difference = 0;
			}
		}
		System.out.println();

		br.close();
	}
	
	private static class Range
	{
		public int b;	//begin
		public int e;	//end
		Range(int x, int y)
		{
			b = x;
			e = y;
		}
	}
}
