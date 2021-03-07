import java.io.*;
import java.util.*;

public class AnotherTreeWithNumberTheory {
    static int leftOut;
    static ArrayList<Integer>[] tree;
    static int lastParentWith1Child;
    static boolean [] changed;
    public static void dfs(int vertex){
        if (tree[vertex].size() == 1 && lastParentWith1Child == -1)
            lastParentWith1Child = vertex;
        else if (lastParentWith1Child != -1){
            if (tree[vertex].size() > 1) {
                tree[lastParentWith1Child].clear();
                tree[lastParentWith1Child].add(vertex);
                changed[lastParentWith1Child] = true;
                lastParentWith1Child = -1;
            }
            else if (tree[vertex].size() == 0){
                tree[lastParentWith1Child].clear();
                changed[lastParentWith1Child] = true;
                lastParentWith1Child = -1;
            }
        }
        for (int neighbour : tree[vertex]) {
            dfs(neighbour);
            if (changed[vertex])
                break;
        }
    }
    public static void dfs(int vertex, int work){
        int currSize = tree[vertex].size();
        if (currSize == 0)
            return;
        if (work % currSize != 0)
            leftOut += work;
        else
        {
            int perNeighbourWork = work/currSize;
            for (int neighbour : tree[vertex]) {
                dfs(neighbour, perNeighbourWork);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        int [] parent = new int[n];
        for (int i = 0; i < n - 1; i++) {
            parent[i+1] = Integer.parseInt(inp[i])-1;
        }
        changed = new boolean[n];
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }
        lastParentWith1Child = -1;
        dfs(0);
//        for (ArrayList<Integer> arrayList : tree) {
//            System.out.println(arrayList.toString());
//        }
        HashMap<Integer, HashMap<Integer, Integer>>queryAns = new HashMap<>();
        int q = Integer.parseInt(buffer.readLine());
        for (int i = 0; i < q; i++) {
            inp = buffer.readLine().split(" ");
            int v = Integer.parseInt(inp[0])-1, w = Integer.parseInt(inp[1]);
            if (queryAns.containsKey(v) && queryAns.get(v).containsKey(w))
                sb.append(queryAns.get(v).get(w)).append("\n");
            else {
                leftOut = 0;
                dfs(v, w);
                sb.append(leftOut).append("\n");
                if (!queryAns.containsKey(v))
                    queryAns.put(v, new HashMap<>());
                queryAns.get(v).put(w, leftOut);
            }
        }
        System.out.println(sb);
    }
}
