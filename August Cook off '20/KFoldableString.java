import java.io.*;
import java.util.*;

public class KFoldableString {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            ArrayList<int[]>point = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                String [] inp = buffer.readLine().split(" ");
                point.add(new int[]{Integer.parseInt(inp[0]), Integer.parseInt(inp[1])});
            }
            if (n/2<3)
                sb.append(n+"\n");
            else {
                long cnt = n;
                while (n/2>=3){
                    n/=2;
                    cnt+=n;
                }
                sb.append(cnt+"\n");
            }
        }
        System.out.println(sb);
    }
}
