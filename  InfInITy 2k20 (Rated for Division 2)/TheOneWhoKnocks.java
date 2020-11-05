import java.io.*;
import java.util.*;

class TheOneWhoKnocks {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp =buffer.readLine().split(" ");
            int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
            int diff = y - x;
            if (diff == 0)
                sb.append(0+"\n");
            else if (diff > 0){
                if (diff % 2 == 1)
                    sb.append(1);
                else {
                    diff/=2;
                    if (diff % 2 == 1)
                    sb.append(2);
                    else
                        sb.append(3);
                }
                sb.append("\n");
            }
            else {
                diff = Math.abs(diff);
                if (diff%2 == 0)
                    sb.append(1+"\n");
                else
                    sb.append(2+"\n");
            }
        }
        System.out.println(sb);
    }
}
