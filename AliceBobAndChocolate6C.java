/**Tyler Lofgren
 * http://codeforces.com/problemset/problem/6/C
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AliceBobAndChocolate6C
{
	public static void main(String[] args) throws IOException
	{
		//get input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] tokens = br.readLine().trim().split("\\s+");
		int[] times = new int[tokens.length];
		for (int i = 0; i < times.length; i++)
			times[i] = Integer.parseInt(tokens[i]);
		
		//calculate
		int a = 0;					//bars Alice has eaten
		int b = 0;					//bars Bob has eaten
		int i = 0;					//index of last bar A ate
		int j = times.length - 1;		//index of last bar B ate
		int sumA = 0;				//sum of times for A
		int sumB = 0;				//sum of times for B
		while (i <= j)
		{
			if (sumB >= sumA)		//a faster
			{
				a++;
				sumA += times[i++];
			}
			else					//b faster
			{
				b++;
				sumB += times[j--];
			}
		}
		
		//print results
		System.out.println(a + " " + b);
		
		br.close();
	}
}
