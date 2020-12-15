import java.io.*;
import java.util.*;

public class EvenPairSum {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            long evenA = a/2, evenB = b/2;
            long oddA = a-evenA, oddB = b - evenB;
            long ans = evenA*evenB + oddA*oddB;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
