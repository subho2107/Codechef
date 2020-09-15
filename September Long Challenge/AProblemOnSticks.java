import java.io.*;
import java.util.*;

public class AProblemOnSticks {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            HashSet<Integer>set = new HashSet<>();
            for (int pos = 0; pos < n; pos++) {
                set.add(Integer.parseInt(inp[pos]));
            }
            sb.append(set.size()+"\n");
        }
        System.out.println(sb);
    }
}
