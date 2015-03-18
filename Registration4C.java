/**Tyler Lofgren
 * http://codeforces.com/problemset/problem/4/C
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Registration4C
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String first = br.readLine();
		TreeMap<String, Integer> names = new TreeMap<String, Integer>();
		names.put(first, 0);
		sb.append("OK\n");
		while (--n > 0)
		{
			String request = br.readLine();
			if (names.containsKey(request))
			{
				names.replace(request, names.get(request) + 1);
				sb.append(request + names.get(request) + "\n");
			}
			else
			{
				names.put(request, 0);
				sb.append("OK\n");
			}
		}
		System.out.print(sb.toString());
		br.close();
	}
}
