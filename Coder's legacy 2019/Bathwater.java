import java.io.*;
import java.util.*;

class Bathwater {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            long v1 = Integer.parseInt(inp[0]), t1 = Integer.parseInt(inp[1]), v2 = Integer.parseInt(inp[2]);
            long t2 = Integer.parseInt(inp[3]), v3 = Integer.parseInt(inp[4]), t3 = Integer.parseInt(inp[5]);
            long numer = t2-t3, deno = t3-t1;
            boolean check = numer*v3 <= (numer+deno)*v1 && deno*v3 <= (numer+deno)*v2 ;
            if (t2>=t3 && t3>=t1 && check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
