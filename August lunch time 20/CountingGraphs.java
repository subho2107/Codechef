import java.io.*;
import java.util.*;

public class CountingGraphs {
    static int mod = (int) 1e9 + 7;

    public static long inverse(long num) {
        return pow(num, mod - 2);
    }

    public static long pow(long num, long power) {
        if (power == 0) return 1;
        long res = pow(num, power / 2) % mod;
        res = (res % mod * res % mod) % mod;
        if (power % 2 == 0)
            return res % mod;
        else
            return (res % mod * num % mod) % mod;
    }

    public static long ncr(long n, long r) {
        if (n < r) return 0;
        if (n == r || r == 0) return 1;
        long numerator = 1, denominator = 1;
        for (long num = n; num > n - r; num--) {
            numerator = (numerator % mod * num % mod) % mod;
        }
        for (long num = r; num > 1; num--) {
            denominator = (denominator % mod * num % mod) % mod;
        }
        return (numerator % mod * inverse(denominator) % mod) % mod;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            long[] freq = new long[n];
            for (int pos = 0; pos < n - 1; pos++) {
                int num = Integer.parseInt(inp[pos]);
                freq[num - 1]++;
            }
            long ans = 1;
            long totalPlaces = 0;
            for (int pos = 0; pos < n; pos++) {
                if (freq[pos] == 0) continue;
                totalPlaces += (freq[pos] * (freq[pos] - 1)) / 2;
            }
            for (int pos = 1; pos < n; pos++) {
                if (freq[pos] == 0) continue;
                ans *= pow(freq[pos - 1], freq[pos]);
                ans %= mod;
            }
            ans = (ans % mod * ncr(totalPlaces, m - n + 1)%mod)%mod;
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
