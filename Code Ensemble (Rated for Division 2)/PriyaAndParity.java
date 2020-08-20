import java.io.*;
import java.util.*;

public class PriyaAndParity {
    static int largestConnectedEvenGroup, largestConnectedOddGroup;
    static int [] parityOfWeights;
    static int [] weights;
    static boolean[]visited;
    static ArrayList<ArrayList<Integer>>graph;
    static int currentCnt = 0;
    public static int getParity(int num){
        int parity = 0;
        while(num!=0){
            if ((num&1)==1)
                parity++;
            num>>=1;
        }
        return parity%2;
    }
    public static void dfs(int index, int isEvenParity){
        visited[index] = true;
        for (int nbr:graph.get(index)) {
            int parity = parityOfWeights[nbr];
            if (isEvenParity==parity && !visited[nbr]) {
                currentCnt++;
                dfs(nbr, isEvenParity);
            }
        }
    }
    public static void setLargestConnectedGroup(int n) {
        visited = new boolean[n];
        for (int index = 0; index < n; index++) {
            if (visited[index])continue;
            int parity = parityOfWeights[index];
            currentCnt = 1;
            if (parity==0){
                dfs(index, 0);
                largestConnectedEvenGroup = Math.max(largestConnectedEvenGroup, currentCnt);
            }
            else {
                dfs(index, 1);
                largestConnectedOddGroup = Math.max(largestConnectedOddGroup, currentCnt);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            largestConnectedOddGroup = 0;
            largestConnectedEvenGroup = 0;
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            weights = new int[n];
            parityOfWeights = new int[n];
            for (int pos = 0; pos < n; pos++) {
                weights[pos] = Integer.parseInt(inp[pos]);
                parityOfWeights[pos] = getParity(weights[pos]);
            }
            graph = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                ArrayList<Integer>temp = new ArrayList<>();
                graph.add(temp);
            }
            for (int pos = 0; pos < m; pos++) {
                inp = buffer.readLine().split(" ");
                int ui = Integer.parseInt(inp[0]),vi = Integer.parseInt(inp[1]);
                ui--;vi--;
                graph.get(ui).add(vi);graph.get(vi).add(ui);
            }
            setLargestConnectedGroup(n);
            int query = Integer.parseInt(buffer.readLine());
            for (int pos = 0; pos < query; pos++) {
                inp = buffer.readLine().split(" ");
                int option = Integer.parseInt(inp[0]), num = Integer.parseInt(inp[1]);
                int parity = getParity(num);
                if (option==1)
                {
                    if (parity==0)
                        sb.append(largestConnectedOddGroup);
                    else
                        sb.append(largestConnectedEvenGroup);
                }
                else{
                    if (parity==0)
                        sb.append(largestConnectedEvenGroup);
                    else
                        sb.append(largestConnectedOddGroup);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
