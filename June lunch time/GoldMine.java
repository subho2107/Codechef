import java.io.*;
import java.util.*;

public class GoldMine {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int noOfMines = Integer.parseInt(buffer.readLine());
            int [] G = new int[noOfMines];
            int [] A = new int[noOfMines];
            int [] B = new int[noOfMines];
            for (int pos = 0; pos < noOfMines; pos++) {
                String [] inp = buffer.readLine().split(" ");
                G[pos] = Integer.parseInt(inp[0]);
                A[pos] = Integer.parseInt(inp[1]);
                B[pos] = Integer.parseInt(inp[2]);
            }
            double forChef = 0, forChefu = 0;
            for (int pos = 0; pos < noOfMines; pos++) {
                double deno = A[pos]+B[pos];
                forChef += G[pos]*(B[pos]/deno);
                forChefu += G[pos]*(A[pos]/deno);
            }
            sb.append(forChef+" "+forChefu+"\n");
        }
        System.out.println(sb);
    }
}
