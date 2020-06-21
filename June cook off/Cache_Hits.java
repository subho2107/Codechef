import java.io.*;
import java.util.*;

class Cache_Hits {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), m = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            int [] query = new int[m];
            for (int pos = 0; pos < m; pos++) {
                query[pos] = Integer.parseInt(inp[pos]);
            }
            int cnt = 0;
            int cStart = 0, cEnd = 0;
            for (int index : query) {
                if (cStart==0&&cEnd==0)
                {
                    cStart = (index/b)*b;
                    cEnd = cStart+b-1;
                    cnt++;
                }
                else
                {
                    if (index >= cStart && index <= cEnd)
                    {
                        continue;
                    }
                    else
                    {
                        cStart = (index/b)*b;
                        cEnd = cStart+b-1;
                        cnt++;
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
