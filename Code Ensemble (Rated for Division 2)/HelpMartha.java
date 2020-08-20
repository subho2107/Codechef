import java.io.*;
import java.util.*;

public class HelpMartha {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String directions = buffer.readLine();
            int originX, originY;
            String[] inp = buffer.readLine().split(" ");
            originX = Integer.parseInt(inp[0]);
            originY = Integer.parseInt(inp[1]);
            int queryNo = Integer.parseInt(buffer.readLine());
            HashMap<Character, Integer> frequency = new HashMap<>();
            frequency.put('R', 0);
            frequency.put('L', 0);
            frequency.put('U', 0);
            frequency.put('D', 0);
            for (char ch : directions.toCharArray())
                frequency.put(ch, frequency.get(ch) + 1);
            for (int pos = 0; pos < queryNo; pos++) {
                inp = buffer.readLine().split(" ");
                int queryX = Integer.parseInt(inp[0]), queryY = Integer.parseInt(inp[1]);
                int diffX = Math.abs(queryX - originX), diffY = Math.abs(queryY - originY);
                boolean check = true;
                if (queryX > originX && frequency.get('R') < diffX)
                    check = false;
                if (queryX < originX && frequency.get('L') < diffX)
                    check = false;
                if (queryY > originY && frequency.get('U') < diffY)
                    check = false;
                if (queryY < originY && frequency.get('D') < diffY)
                    check = false;
                if (check)
                    sb.append("YES ").append(diffX + diffY);
                else
                    sb.append("NO");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
