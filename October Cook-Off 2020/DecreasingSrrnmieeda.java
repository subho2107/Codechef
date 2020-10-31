import java.io.*;
import java.util.*;

public class DecreasingSrrnmieeda {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int l = Integer.parseInt(inp[0]), r = Integer.parseInt(inp[1]);
            if(r < 2*l)
                sb.append(r+"\n");
            else
                sb.append(-1+"\n");
        }
        System.out.println(sb);
    }
}
