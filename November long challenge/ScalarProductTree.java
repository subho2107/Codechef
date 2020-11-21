import java.io.*;
import java.util.*;
//part of code taken from https://www.geeksforgeeks.org/find-the-path-from-root-to-the-given-nodes-of-a-tree-for-multiple-queries/
class ScalarProductTree {
    static class Pair<T, V> {
        T first;
        V second;
        Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    static int sz;
    static ArrayList<Integer>[] tree;
    static boolean[] vis;
    static int [] parents;
    static long [] squaresPrefix;
    static long[] weight;
    static final long MOD = Long.parseLong("4294967296");
    static void addEdge(int a, int b) {
        tree[a].add(b);
        tree[b].add(a);
    }
    static void bfs(int node) {
        Queue<Pair<Integer, Integer>> qu = new LinkedList<>();
        qu.add(new Pair<>(node, -1));
        vis[node] = true;
        squaresPrefix[0] = (weight[0]%MOD*weight[0]%MOD)%MOD;
        squaresPrefix[0] %= MOD;
        while (!qu.isEmpty()) {
            Pair<Integer, Integer> p = qu.poll();
            vis[p.first] = true;
            for (int child : tree[p.first]) {
                if (!vis[child]) {
                    qu.add(new Pair<>(child, p.first));
                    parents[child] = p.first;
                    squaresPrefix[child] = (weight[child]%MOD*weight[child]%MOD)%MOD;
                    squaresPrefix[child] += squaresPrefix[p.first]%MOD;
                    squaresPrefix[child] %= MOD;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]);
        sz = n;
        tree = new ArrayList[sz];
        vis = new boolean[sz];
        parents = new int[sz];
        squaresPrefix = new long[sz];
        weight = new long[sz];
        inp = buffer.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(inp[i]);
        }
        for (int i = 0; i < sz; i++) {
            tree[i] = new ArrayList<>();
            vis[i] = false;
        }
        for (int i = 0; i < n - 1; i++) {
            inp = buffer.readLine().split(" ");
            int u = Integer.parseInt(inp[0]) - 1, v = Integer.parseInt(inp[1]) - 1;
            addEdge(u, v);
        }
        bfs(0);
        HashMap<Integer, HashMap<Integer, Long>>prevQueryResults = new HashMap<>();
        for (int i = 0; i < q; i++) {
            inp = buffer.readLine().split(" ");
            int u = Integer.parseInt(inp[0]) - 1, v = Integer.parseInt(inp[1]) - 1;
            long sum = 0;
            int orgU = u, orgV = v, less, greater;
            while (v != u){
                less = Math.min(u, v);
                greater = Math.max(u, v);
                if (prevQueryResults.containsKey(less) && prevQueryResults.get(less).containsKey(greater))
                    break;
                sum += (weight[u]%MOD*weight[v]%MOD)%MOD;
                sum %= MOD;
                u = parents[u];
                v = parents[v];
            }
            if (u == v)
                sum += squaresPrefix[u]%MOD;
            else {
                sum += prevQueryResults.get(Math.min(u, v)).get(Math.max(u, v))%MOD;
                sum %= MOD;
            }
            less = Math.min(orgU, orgV);
            greater = Math.max(orgU, orgV);
            if (!prevQueryResults.containsKey(less))
                prevQueryResults.put(less, new HashMap<>());
            prevQueryResults.get(less).put(greater, sum);
            sum %= MOD;
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}
