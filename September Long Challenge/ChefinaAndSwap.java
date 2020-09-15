import java.io.*;
import java.util.*;

class ChefinaAndSwap {
    public static long calc(long num){
        return num*(num-1)/2;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(buffer.readLine());
            long totSum = (n*(n+1))/2;
            if (totSum % 2 == 1) {
                sb.append("0\n");
                continue;
            }
            long x = (long) ((Math.sqrt(4*totSum+1)-1)/2.0);
            long sum = x*(x+1)/2;
            long res = n-x;
            if (sum == totSum/2){
                res+=calc(x)+calc(n-x);
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
