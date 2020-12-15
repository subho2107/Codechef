import java.io.*;
import java.util.*;

class Calculus {
    public static long getInverse(long num, long mod){
        return moduloPow(num, mod-2, mod);
    }
    public static long moduloPow(long num, long pow, long mod){
        if (pow == 0)return 1;
        long res = moduloPow(num, pow/2, mod)%mod;
        res = ((res%mod)*(res%mod))%mod;
        if (pow % 2 == 0)
            return res;
        else
            return ((res%mod)*(num%mod))%mod;
    }
    //values for 2 and 3 taken from https://www.wolframalpha.com/widgets/view.jsp?id=8ab70731b1553f17c11a3bbc87e0b605
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int MOD = 998244353;
        long ans = 0;
        for (int n = 1; n <= N ; n++) {
            long currAns = (1%MOD*getInverse((2L *n)-1, MOD)%MOD);
            ans = (ans+currAns%MOD)%MOD;
        }
        ans = (ans%MOD*2%MOD)%MOD;
        System.out.println(ans);
    }
}
