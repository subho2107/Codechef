import java.io.*;
import java.util.*;

class BetterCallSaul {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]), odd = 0, even = 0;
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                if (num % 2 == 0)
                    even++;
                else
                    odd++;
            }
            int walter = -1;
            if(x >= 2*odd)
                walter = 0;
            else if (x >= 2*even)
                walter = (n - x)%2;
            else
                walter = x % 2;
            if (walter == 0){
                sb.append("Jesse");
            }
            else
                sb.append("Walter");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
