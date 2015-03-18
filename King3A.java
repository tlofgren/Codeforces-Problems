/**Tyler Lofgren
 * http://codeforces.com/problemset/problem/3/A
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class King3A
{
	static final int A_ASCII = Integer.valueOf('a') - 1;
	static final int ZERO_ASCII = Integer.valueOf('0');

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String src = br.readLine();
		String dest = br.readLine();
		int x1 = Integer.valueOf(src.charAt(0) - A_ASCII);
		int y1 = Integer.valueOf(src.charAt(1) - ZERO_ASCII);
		int x2 = Integer.valueOf(dest.charAt(0) - A_ASCII);
		int y2 = Integer.valueOf(dest.charAt(1) - ZERO_ASCII);
		StringBuilder sb = new StringBuilder("\n");
		int moves = 0;
		while (x1 != x2 || y1 != y2)
		{
			if (y2 > y1)			//move up
			{
				y1++;				//U
				moves++;
				if (x2 > x1)		//RU
				{
					x1++;
					sb.append("RU\n");
				}
				else if (x2 < x1)	//LU
				{
					x1--;
					sb.append("LU\n");
				}
				else
				{
					sb.append("U\n");
				}
			}
			else if (y2 < y1)		//move down
			{
				y1--;				//D
				moves++;
				if (x2 > x1)		//RD
				{
					x1++;
					sb.append("RD\n");
				}
				else if (x2 < x1)	//LD
				{
					x1--;
					sb.append("LD\n");
				}
				else
					sb.append("D\n");
			}
			else					//same y coordinate
			{
				if (x2 > x1)		//R
				{
					x1++;
					moves++;
					sb.append("R\n");
				}
				else if (x2 < x1)	//L
				{
					x1--;
					moves++;
					sb.append("L\n");
				}
			}
		}
		sb.insert(0, moves);
		System.out.println(sb.toString());
	}
}
