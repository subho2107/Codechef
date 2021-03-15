import java.io.*;
import java.util.*;

public class InterestingXOR {
    public static boolean increase(int a , int C){
        int b = a^C;
        long pro = (long) a *b;
        a++;
        b = a^C;
        return (long) a *b > pro;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] pow2 = new int[31];
        pow2[0] = 1;
        for (int i = 1; i < 31; i++) {
            pow2[i] = pow2[i-1]*2;
        }
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int C = Integer.parseInt(buffer.readLine());
            int d = (int) Math.ceil(Math.log(C)/Math.log(2));
            if (Math.log(C)%Math.log(2) == 0)
                d++;
            int low = 0, high = pow2[d]-1;
            long ans = 0;
            while (low <= high){
                int mid = (low+high)/2;
                if (increase(mid, C))
                    low = mid+1;
                else
                    high = mid-1;
                ans = Math.max(ans, (long) mid *(mid^C));
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
