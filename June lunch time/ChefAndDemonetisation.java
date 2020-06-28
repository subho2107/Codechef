import java.io.*;
import java.util.*;

public class ChefAndDemonetisation {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int s = Integer.parseInt(inp[0]), n = Integer.parseInt(inp[1]);
            if (n >= s)
            {
                if (s%2==0||s==1)
                {
                    sb.append("1\n");
                }
                else
                {
                    sb.append("2\n");
                }
            }
            else
            {
                int cnt = 0;
                cnt += s/n;
                s %=n;
                if(s==0)
                {
                    sb.append(cnt+"\n");
                }
                else
                {
                    if (s%2==0 || s == 1)
                    {
                        sb.append((cnt+1)+"\n");
                    }
                    else
                    {
                        sb.append((cnt+2)+"\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
