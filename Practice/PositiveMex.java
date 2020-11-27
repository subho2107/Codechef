import java.io.*;
import java.util.*;

class PositiveMex {
    public static long add(long a, long b, long MOD) {
        return (a % MOD + b % MOD) % MOD;
    }

    public static long multiply(long a, long b, long MOD) {
        return (a % MOD * b % MOD) % MOD;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        int MOD = 998244353;
        int[] pow2 = new int[100001];
        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++)
            pow2[i] = (pow2[i - 1] % MOD * 2 % MOD) % MOD;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            long ans = pow2[n - freq.getOrDefault(1, 0)];
            int i = 1;
            long prevSubsets = 1, cntTillCurr = 0;
            while (freq.get(i)!=null){
                int curr = freq.get(i), next = freq.getOrDefault(i+1, 0);
                prevSubsets = multiply(prevSubsets, pow2[curr]-1, MOD);
                long restNums = n - (curr + next + cntTillCurr);
                ans = add(ans, multiply(i+1, multiply(prevSubsets, pow2[(int) restNums], MOD), MOD), MOD);
                i++;
                cntTillCurr = add(cntTillCurr, curr, MOD);
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}
