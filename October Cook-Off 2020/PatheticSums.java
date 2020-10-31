import java.io.*;
import java.util.*;

public class PatheticSums {
    static ArrayList<Integer>[] graph;
    static int[] vals;
    public static void dfs(int vertex, int parent,  int val){
        for (int neighbor : graph[vertex]) {
            if (neighbor == parent)
                continue;
            vals[neighbor] = val;
            dfs(neighbor, vertex, val^1^2);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++)
                graph[i] = new ArrayList<>();

            vals = new int[n];
            for (int i = 0; i < n - 1; i++) {
                String[] inp = buffer.readLine().split(" ");
                int u = Integer.parseInt(inp[0]) - 1, v = Integer.parseInt(inp[1]) - 1;
                graph[u].add(v);
                graph[v].add(u);
            }
            vals[0] = 1;
            dfs(0, -1, 2);
            for (int val : vals)
                sb.append(val+" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
