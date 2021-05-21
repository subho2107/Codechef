import java.io.*;
import java.util.*;

public class XorEquality {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long [] pow2 = new long[100001];
        pow2[0] = 1;
        int MOD = (int) (1e9+7);
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = (pow2[i-1]%MOD*2%MOD)%MOD;
        }
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            long ans = pow2[n-1];
            ans %= MOD;
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
