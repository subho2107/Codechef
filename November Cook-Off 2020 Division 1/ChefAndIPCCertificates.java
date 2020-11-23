import java.io.*;
import java.util.*;

class ChefAndIPCCertificates {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split( " ");
        int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            inp = buffer.readLine().split(" ");
            int [] times = new int[k];
            long sum = 0;
            for (int j = 0; j < k; j++) {
                times[j] = Integer.parseInt(inp[j]);
                sum += times[j];
            }
            int q = Integer.parseInt(inp[k]);
            if (q <= 10 && sum >= m)
                cnt++;
        }
        System.out.println(cnt);
    }
}
