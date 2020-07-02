import java.io.*;
import java.util.*;

public class Factorial {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int num = Integer.parseInt(buffer.readLine());
            long trailingZeroes = 0;
            while(num>=1)
            {
                num /= 5;
                trailingZeroes += num;
            }
            sb.append(trailingZeroes+"\n");
        }
        System.out.println(sb);
    }
}
