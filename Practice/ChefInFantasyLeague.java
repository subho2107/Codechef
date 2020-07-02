import java.io.*;
import java.util.*;

public class ChefInFantasyLeague {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        String [] inp;
        while (t-- > 0) {
            inp = buffer.readLine().split(" ");
            int totalPlayers = Integer.parseInt(inp[0]), pricePaid = Integer.parseInt(inp[1]);
            int [] prices = new int[totalPlayers];
            inp = buffer.readLine().split(" ");
            for (int pos = 0; pos < totalPlayers; pos++) {
                prices[pos] = Integer.parseInt(inp[pos]);
            }
            int minOfDef = 101, minOfFwd = 101;
            inp = buffer.readLine().split(" ");
            for (int pos = 0; pos < totalPlayers; pos++) {
                int temp = Integer.parseInt(inp[pos]);
                if (temp==0)
                    minOfDef = Math.min(prices[pos], minOfDef);
                else
                    minOfFwd = Math.min(minOfFwd, prices[pos]);
            }
            System.out.println(minOfDef+" "+minOfFwd);
            if (pricePaid+minOfDef+minOfFwd<=100)
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.println(sb);
    }
}
