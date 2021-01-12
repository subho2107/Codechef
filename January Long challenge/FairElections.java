import java.io.*;
import java.util.*;

class FairElections {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int[] arr = new int[n], arr2 = new int[m];
            long votes = 0, votes2 = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                votes += arr[i];
            }
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inp[i]);
                votes2 += arr2[i];
            }
            if (votes > votes2) {
                sb.append(0 + "\n");
                continue;
            }
            Arrays.sort(arr);
            Arrays.sort(arr2);
            int moves = 0;
            for (int i = 0, j = m - 1; i < n && j >= 0 && votes <= votes2; i++, j--) {
                votes -= arr[i];
                votes2 += arr[i];
                votes += arr2[j];
                votes2 -= arr2[j];
                moves++;
            }
            if (votes > votes2)
                sb.append(moves).append("\n");
            else
                sb.append("-1\n");
        }
        System.out.println(sb);
    }
}
