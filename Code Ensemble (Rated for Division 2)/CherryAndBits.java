import java.io.*;
import java.util.*;

public class CherryAndBits {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
        int [][] matrix = new int[n][m];
        long [][] pref = new long[n+1][m+1];
        for (int pos = 0; pos < n; pos++) {
            char[]chars = buffer.readLine().toCharArray();
            for (int pos2 = 0; pos2 < m; pos2++) {
                matrix[pos][pos2] = Character.getNumericValue(chars[pos2]);
            }
        }
        int query = Integer.parseInt(buffer.readLine());
        for (int pos = 0; pos < query; pos++) {
            inp = buffer.readLine().split(" ");
            int x1 = Integer.parseInt(inp[0])-1, y1 = Integer.parseInt(inp[1])-1, x2 = Integer.parseInt(inp[2])-1, y2 = Integer.parseInt(inp[3])-1;
            pref[x1][y1]++;
            pref[x2+1][y1]--;
            pref[x1][y2+1]--;
            pref[x2+1][y2+1]++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pref[j][i] += pref[j-1][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                pref[i][j] += pref[i][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pref[i][j]%2==1)
                    matrix[i][j]^=1;
                sb.append(matrix[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
