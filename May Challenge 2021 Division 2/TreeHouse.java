import java.io.*;
import java.util.*;

class TreeHouse {
    static ArrayList<Integer>[]edges;
    public static long generateKeys(int vertex, int parent){
        ArrayList<Long>temp = new ArrayList<>();
        for (int neighbour : edges[vertex]) {
            if (neighbour == parent)
                continue;
            temp.add(generateKeys(neighbour, vertex));
        }
        temp.sort(Collections.reverseOrder());
        int i = 1;
        long val = 1;
        for (long num : temp) {
            val += num *i++;
        }
        return val;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            edges = new ArrayList[n];
            for (int i = 0; i < n; i++)
                edges[i] = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                inp = buffer.readLine().split(" ");
                int u = Integer.parseInt(inp[0])-1, v = Integer.parseInt(inp[1])-1;
                edges[u].add(v);
                edges[v].add(u);
            }

            int MOD = (int) (1e9+7);
            long ans = (generateKeys(0, -1)%MOD*x%MOD)%MOD;
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
