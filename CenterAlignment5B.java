/**Tyler Lofgren
 * http://codeforces.com/problemset/problem/5/B
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CenterAlignment5B
{
	public static final char FRAME = '*';
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<String> lines = new ArrayList<String>();
		while (sc.hasNextLine())
			lines.add(sc.nextLine());
		int[] lengths = new int[lines.size()];
		int i;
		for (i = 0; i < lines.size(); i++)
			lengths[i] = lines.get(i).length();
		int longest = findLargest(lengths);
		StringBuilder sb = new StringBuilder((longest + 2) * lines.size());
		char[] stars = new char[longest + 2];
		for (i = 0; i < stars.length; i++)
			stars[i] = FRAME;
		char[] spaces = new char[longest];
		for (i = 0; i < spaces.length; i++)
			spaces[i] = ' ';
		sb.append(stars);
		boolean closerToLeft = true;
		for (i = 0; i < lines.size(); i++)
		{
			sb.append('\n');
			sb.append(FRAME);
			int numSpaces = longest - lengths[i];
			if (numSpaces % 2 == 0)
			{
				sb.append(spaces, 0, numSpaces / 2);
				sb.append(lines.get(i));
				sb.append(spaces, 0, numSpaces / 2);
			}
			else
			{
				if (closerToLeft)
				{
					sb.append(spaces, 0, numSpaces / 2);
					sb.append(lines.get(i));
					sb.append(spaces, 0, numSpaces / 2 + 1);
					
				}
				else
				{
					sb.append(spaces, 0, numSpaces / 2 + 1);
					sb.append(lines.get(i));
					sb.append(spaces, 0, numSpaces / 2);
				}
				closerToLeft = !closerToLeft;
			}
			sb.append(FRAME);
		}
		sb.append('\n');
		sb.append(stars);
		
		System.out.println(sb.toString());
		sc.close();
	}
	
	public static int findLargest(int[] aList)
	{
		int largest = 0;
		for (int x : aList)
			largest = Math.max(largest, x);
		return largest;
	}
}
