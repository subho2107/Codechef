import java.io.*;
import java.util.*;

public class ChefAndCardGame {
    public static int getDigSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int chef = 0, morty = 0;
            for (int pos = 0; pos < n; pos++) {
                String[] inp = buffer.readLine().split(" ");
                int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
                int c = getDigSum(a), d = getDigSum(b);
                if (c > d)
                    chef++;
                else if (d > c)
                    morty++;
                else {
                    chef++;
                    morty++;
                }
            }
            if (chef > morty)
                sb.append("0 " + chef + "\n");
            else if (morty > chef)
                sb.append("1 " + morty + "\n");
            else
                sb.append("2 " + chef + "\n");
        }
        System.out.println(sb);
    }
}
