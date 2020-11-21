import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class RestoreSequence {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            HashSet<Integer>[] graph = new HashSet[n];
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new HashSet<>();
            }
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                graph[num - 1].add(i);
                arr[i] = num;
            }
            int [] b = new int[n];
            Arrays.fill(b, -1);
            for (int i = n - 1, j = 2; i >= 0 ; i--, j++) {
                if (b[i] != -1)continue;
                int key = arr[i] - 1;
                for (int pos : graph[key]) {
                    b[pos] = j;
                }
            }
            for (int num : b) {
                sb.append(num +" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
