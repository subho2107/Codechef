import java.io.*;
import java.util.*;

class SubsequenceFrequencyCounting {
    static int mod = 1000000007;
    static long [] pow2 = new long[1000001];
    static final int N = 1000001;
    static long [] factorialNumInverse = new long[N + 1];
    static long []naturalNumInverse = new long[N + 1];
    static long []fact = new long[N + 1];
    static void invOfNum(int p)
    {
        naturalNumInverse[0] = naturalNumInverse[1] = 1;
        for (int i = 2; i <= N; i++)
            naturalNumInverse[i] = naturalNumInverse[p % i] * (p - p / i) % p;
    }
    static void invOFact(int p)
    {
        factorialNumInverse[0] = factorialNumInverse[1] = 1;
        for (int i = 2; i <= N; i++)
            factorialNumInverse[i] = (naturalNumInverse[i] * factorialNumInverse[i - 1]) % p;
    }
    static void fact(int p)
    {
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % p;
        }
    }
    static long ncr(int N, int R, int p)
    {
        long ans = ((fact[N] * factorialNumInverse[R])
                % p * factorialNumInverse[N - R])
                % p;
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        invOfNum(mod);
        invOFact(mod);
        fact(mod);
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            Set<Integer>set = new HashSet<>();
            int [] freq = new int[n+1];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                freq[arr[pos]]++;
                set.add(arr[pos]);
            }
            pow2[0] = 1;
            for (int i = 1; i < pow2.length; i++) {
                pow2[i] = (pow2[i-1]*2)%mod;
            }
            long[] ans = new long[n];
            if (set.size()==n)
            {
                for (int i = 0; i < n; i++) {
                    int cnt = n - arr[i];
                    ans[arr[i] - 1] = pow2[cnt];

                }
            }
            else {
                for (int i = 1; i <= n; i++) {
                    if (freq[i]==0)continue;
                    int currFreq = freq[i];
                    while (currFreq>0)
                    {
                        long cnt = 1;
                        boolean check = false;
                        for (int j = 1; j <= n; j++) {
                            if (freq[j]==0||i==j)continue;
                            long temp = 0;
                            for (int freqJ = 1; freqJ < Math.min(currFreq, freq[j]+1); freqJ++) {
                                temp += ncr(freq[j], freqJ, mod);
                            }
                            if (freq[j]>=currFreq && j > i){
                                temp += ncr(freq[j], currFreq, mod);
                            }
                            if (temp==0)continue;
                            if (!check)
                                check = true;
                            cnt*=temp;
                        }
                        if (check)cnt++;
                        cnt *= ncr(freq[i], currFreq, mod);
                        ans[i - 1] = (ans[i-1]%mod+cnt%mod)%mod;
                        currFreq--;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
