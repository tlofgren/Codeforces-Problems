
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class PresidentOffice6B
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("\\s");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		String p = line[2];
		char[][] office = new char[n][m];
		TreeSet<Character> deps = new TreeSet<Character>();
		int pRow = 1;
		for (int i = 0; i < n; ++i)
		{
			String row = br.readLine();
			if (row.contains(p))
				pRow = i;
			for (int j = 0; j < m; ++j)
				office[i][j] = row.charAt(j);
		}

		

		br.close();
	}
}
