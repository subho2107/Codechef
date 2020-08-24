import java.io.*;
import java.util.*;

public class RedBlueTree {
    static boolean[] visited;
    static int[] parityArr;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] supposedToBeRed;
    static int[] supposedToBeBlue;
    static int[] initialColours;
    static int totalChanges;

    public static void assignParity(int vertex, int parity) {
        if (visited[vertex]) return;
        visited[vertex] = true;
        parityArr[vertex] = parity;
        //parity^1 assigns alternate parity between adjacent elements
        for (int nbr : graph.get(vertex))
            assignParity(nbr, parity ^ 1);
    }

    public static void dfs(int vertex, int parity) {
        //parity is the parity of nodes to set red(0) color
        if (visited[vertex]) return;
        visited[vertex] = true;
        if (parityArr[vertex] == parity && initialColours[vertex] == 1)
            supposedToBeRed[vertex]++;
        if (parityArr[vertex] != parity && initialColours[vertex] == 0)
            supposedToBeBlue[vertex]++;
        for (int nbr : graph.get(vertex)) {
            if (visited[nbr])continue;
            dfs(nbr, parity);
            supposedToBeBlue[vertex] += supposedToBeBlue[nbr];
            supposedToBeRed[vertex] += supposedToBeRed[nbr];
        }
        int minVal = Math.min(supposedToBeRed[vertex], supposedToBeBlue[vertex]);
        supposedToBeRed[vertex] -= minVal;
        supposedToBeBlue[vertex] -= minVal;
        totalChanges += supposedToBeBlue[vertex] + supposedToBeRed[vertex];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine().trim());
            parityArr = new int[n];
            graph = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                graph.add(new ArrayList<>());
            }
            for (int pos = 0; pos < n - 1; pos++) {
                String[] inp = buffer.readLine().trim().split(" ");
                int node1 = Integer.parseInt(inp[0]), node2 = Integer.parseInt(inp[1]);
                node1--;
                node2--;
                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }
            String parity = buffer.readLine().trim();
            visited = new boolean[n];
            assignParity(0, 0);
            supposedToBeBlue = new int[n];
            supposedToBeRed = new int[n];
            initialColours = new int[n];
            for (int pos = 0; pos < n; pos++) {
                initialColours[pos] = Character.getNumericValue(parity.charAt(pos));
            }
            int ans = Integer.MAX_VALUE;
            for (int parityToBeRed = 0; parityToBeRed < 2; parityToBeRed++) {
                Arrays.fill(visited, false);
                Arrays.fill(supposedToBeBlue, 0);
                Arrays.fill(supposedToBeRed, 0);
                totalChanges = 0;
                dfs(0, parityToBeRed);
                if (supposedToBeBlue[0] == supposedToBeRed[0])
                    ans = Math.min(ans, totalChanges);
            }
            if (ans == Integer.MAX_VALUE)
                sb.append("-1\n");
            else
                sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
