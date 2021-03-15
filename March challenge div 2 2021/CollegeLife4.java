import java.io.*;
import java.util.*;

class CollegeLife4 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), e = Integer.parseInt(inp[1]), h = Integer.parseInt(inp[2]),
                    a = Integer.parseInt(inp[3]), b = Integer.parseInt(inp[4]), c = Integer.parseInt(inp[5]);
            long minCost = (long) 1e18;
            for (int z = 0; z <= n; z++) {
                int remainingPeople = n - z;
                if (z > Math.min(e, h))
                    continue;
                int chocoRemaining = h - z, eggsRemaining = e - z;
                int maxX = eggsRemaining/2, maxY = chocoRemaining/3;
                if (z + maxX + maxY < n)
                    continue;
                long cost = (long) c*z;
                if (a < b){
                    int x = Math.min(remainingPeople, maxX);
                    remainingPeople -= x;
                    cost += (long)a*x;
                    int y = Math.min(remainingPeople, maxY);
                    cost += (long) b*y;
                }
                else {
                    int y = Math.min(remainingPeople, maxY);
                    remainingPeople -= y;
                    cost += (long) y*b;
                    int x = Math.min(remainingPeople, maxX);
                    cost += (long) x*a;
                }
                minCost = Math.min(minCost, cost);
            }
            if (minCost == 1e18)
                minCost = -1;
            sb.append(minCost).append("\n");
        }
        System.out.println(sb);
    }
}
