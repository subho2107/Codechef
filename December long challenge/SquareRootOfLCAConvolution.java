import java.io.*;
import java.util.*;

public class SquareRootOfLCAConvolution {
    //sequence generation taken from https://www.geeksforgeeks.org/print-all-sequences-of-given-length/
    static ArrayList<int[]>A;
    static void generateAndAddSeq(int[] arr, int n, int k, int index) {
        int i;
        if (k == 0) {
            int [] temp = new int[index];
            System.arraycopy(arr, 0, temp, 0, index);
            A.add(temp);
        }
        if (k > 0) {
            for (i = 0; i < n; ++i) {
                arr[index] = i;
                generateAndAddSeq(arr, n, k - 1, index + 1);
            }
        }
    }

    static void generateSequence(int n, int k) {
        int[] arr = new int[k];
        generateAndAddSeq(arr, n, k, 0);
    }

    public static void fillAllVs(int root, int ignore, ArrayList<ArrayList<Integer>> tree, ArrayList<Integer> Lix) {
        for (int neighbour : tree.get(root)) {
            if (neighbour == ignore)continue;
            Lix.add(neighbour);
            fillAllVs(neighbour, ignore, tree, Lix);
        }
    }

    public static boolean checkIfNotParent(int targetAncestor, int child, int[] parent) {
        int vertex = child;
        while (vertex != parent[vertex] && vertex != targetAncestor)
            vertex = parent[vertex];
        return vertex != targetAncestor;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), p = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int[] parent = new int[n];
            for (int i = 1; i < n; i++) {
                parent[i] = Integer.parseInt(inp[i - 1]) - 1;
            }
            int[] c = new int[n];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(inp[i]);
            }
            ArrayList<Integer>[][] Lix = new ArrayList[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    Lix[i][j] = new ArrayList<>();

            ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
            for (int i = 0; i < n; i++)
                tree.add(new ArrayList<>());
            for (int i = 0; i < n; i++) {
                if (parent[i] < i)
                    tree.get(parent[i]).add(i);
            }
            for (int x = 0; x < n; x++) {
                for (int i = 0; i < n; i++) {
                    if (checkIfNotParent(x, i, parent))
                        continue;
                    Lix[i][x].add(x);
                    if (i == x) {
                        fillAllVs(x, -1, tree, Lix[i][x]);
                        continue;
                    }
                    int ignoreChild = i;
                    while (parent[ignoreChild] != x)
                        ignoreChild = parent[ignoreChild];
                    fillAllVs(x, ignoreChild, tree, Lix[i][x]);
                }
            }
            A = new ArrayList<>();
            generateSequence(p, n);
            int [] validSequence = new int[n];
            int cnt = 0, MOD = 998244353;
            for (int[] sequence : A) {
                boolean check = true;
                for (int x = 0; x < n; x++) {
                    long sum = 0;
                    for (int i = 0; i < n; i++) {
                        if (checkIfNotParent(x, i, parent))continue;
                        long tempSum = 0;
                        for (int pos : Lix[i][x])
                            tempSum = ((tempSum%p) + sequence[pos]%p)%p;
                        tempSum *= sequence[i]%p;
                        tempSum %= p;
                        sum += tempSum;
                        sum %= p;
                    }
                    if (sum != c[x]){
                        check = false;
                        break;
                    }
                }
                if (check){
                    if (cnt == 0)
                    {
                        System.arraycopy(sequence, 0, validSequence, 0, n);
                    }
                    cnt++;
                    cnt %= MOD;
                }
            }
            sb.append(cnt).append("\n");
            if (cnt == 0){
                sb.append("-1\n");
                continue;
            }
            for (int num : validSequence)
                sb.append(num).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
