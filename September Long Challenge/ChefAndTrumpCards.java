import java.io.*;
import java.util.*;

class ChefAndTrumpCards {
    public static long getInverse(long num, int mod){
        return moduloPow(num, mod-2, mod);
    }
    public static long getVal(long freq){//this method gives nC(n/2)
        long ans = 1;
        int mod = (int)1e9+7;
        for (long num = freq; num > freq/2 ; num--) {
            ans*=num;
            ans%=mod;
        }
        long fact = 1;
        for (long num = 1; num <= freq/2; num++) {
            fact*=num;
            fact%=mod;
        }
        fact = getInverse(fact, mod);
        ans = ((ans%mod)*(fact%mod))%mod;
        return ans;
    }
    public static long moduloPow(long num, int pow, int mod){
        if (pow == 0)return 1;
        long res = moduloPow(num, pow/2, mod)%mod;
        res = ((res%mod)*(res%mod))%mod;
        if (pow % 2 == 0)
            return res;
        else
            return ((res%mod)*(num%mod))%mod;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            HashMap<Integer, Integer>freq = new HashMap<>();
            int maxNum = -1, mod = (int)1e9+7;
            for (int pos = 0; pos < n; pos++) {
                int num = Integer.parseInt(inp[pos]);
                freq.put(num, freq.getOrDefault(num, 0) + 1);
                maxNum = Math.max(maxNum, num);
            }
            long ans;
            if (freq.get(maxNum)%2 == 1)
                ans = moduloPow(2, n, mod)%mod;
            else {
                long temp =( (getVal(freq.get(maxNum)) % mod)*(moduloPow(2, n-freq.get(maxNum), mod)%mod))%mod;//number of ways max valued card can be equally divided
                ans = (moduloPow(2, n, mod) % mod - temp%mod + mod) % mod;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
