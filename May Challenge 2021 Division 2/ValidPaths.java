import java.io.*;
import java.util.*;

class ValidPaths {
    static int MOD = (int) (1e9+7);
    static ArrayList<Integer>adj[];
    static long [] vals;
    static  long ans;
    public static void dfs(int vertex, int parent){
        vals[vertex] = 1;
        for (int neighbour : adj[vertex]) {
            if (neighbour == parent)
                continue;
            dfs(neighbour, vertex);
            ans += (vals[vertex]%MOD*vals[neighbour]%MOD)%MOD;
            vals[vertex]+=2*vals[neighbour];
            vals[vertex] %= MOD;
            ans %= MOD;
        }
        ans++;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            adj = new ArrayList[n];
            ans = 0;
            vals = new long[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                String [] inp = buffer.readLine().split(" ");
                int u = Integer.parseInt(inp[0])-1, v = Integer.parseInt(inp[1])-1;
                adj[u].add(v);
                adj[v].add(u);
            }
            dfs(0, -1);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
