import java.io.*;
import java.util.*;

public class ChefinaAndStrangeTree {
    static int[]pop;
    static int [] fruits;
    static int[] firstDay;
    static int currCityVisiting;
    static ArrayList<ArrayList<Integer>>graph;
    static Set<Integer>visited = new HashSet<>();
    static Set<Integer>deletedVertex = new HashSet<>();
    static int day;
    static void dfs(int vertex){
        if (!visited.add(vertex)||deletedVertex.contains(vertex))return;
        if (fruits[vertex]!=0) {
            fruits[vertex] -= Math.min(fruits[vertex], pop[currCityVisiting]);
            if (fruits[vertex] == 0)
                firstDay[vertex] = day + 1;
        }
        for (int nbr : graph.get(vertex)) {
            dfs(nbr);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        String[]inp;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            deletedVertex.clear();
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp = new ArrayList<>();
                graph.add(temp);
            }
            for (int i = 0; i < n-1; i++) {
                int cityA, cityB;
                inp = buffer.readLine().split(" ");
                cityA = Integer.parseInt(inp[0]);
                cityB = Integer.parseInt(inp[1]);
                graph.get(cityA-1).add(cityB-1);
                graph.get(cityB-1).add(cityA-1);
            }
            int [] pi = new int[n];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                pi[i] = Integer.parseInt(inp[i])-1;
            }
            inp = buffer.readLine().split(" ");
            pop = new int[n];
            for (int i = 0; i < n; i++) {
                pop[i] = Integer.parseInt(inp[i]);
            }
            inp = buffer.readLine().split(" ");
            fruits = new int[n];
            for (int i = 0; i < n; i++) {
                fruits[i] = Integer.parseInt(inp[i]);
            }
            firstDay = new int[n];
            for (int i = 0; i < n; i++) {
                currCityVisiting = pi[i];
                day = i;
                visited.clear();
                dfs(pi[i]);
                graph.get(pi[i]).clear();
                deletedVertex.add(pi[i]);
            }
            for (int i = 0; i < n; i++) {
                if (firstDay[i]==0)
                    firstDay[i] = -1;
                sb.append(firstDay[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
