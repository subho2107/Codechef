import java.io.*;
import java.util.*;

public class BinaryConcatenation {
    static long [] pow2 = new long[61];
    public static long toDecimal(String a){
        long val = 0;
        for (int pos = 0; pos < a.length(); pos++) {
            char bit = a.charAt(pos);
            if (bit == '1')
                val += pow2[a.length()-pos-1];
        }
//        System.out.println(a+" "+val);
        return val;
    }
    public static long  binaryStringConcat(long a, long b){
        String aB = Long.toBinaryString(a);
        String bB = Long.toBinaryString(b);
//        System.out.println(aB+" "+bB+" ");
        String abB = aB+bB;
        String baB = bB+aB;
        long temp = toDecimal(abB);
        long temp2 = toDecimal(baB);
        return Math.max(temp, temp2)-Math.min(temp, temp2);
    }
    public static void main(String[] args) throws Exception {
        pow2[0] = 1;
        for (int pos = 1; pos < pow2.length; pos++) {
            pow2[pos] = pow2[pos-1]*2;
        }
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bu.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
//            System.out.println("Test case#"+t);
            int n = Integer.parseInt(bu.readLine());
            String [] inp = bu.readLine().split(" ");
            long [] arr = new long[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Long.parseLong(inp[pos]);
            }
            long maxVal = binaryStringConcat(arr[0], arr[1]);
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    long val = binaryStringConcat(arr[i], arr[j]);
//                    System.out.println(arr[i]+" "+arr[j]+" "+val);
                    maxVal = Math.max(maxVal, val);
                }
            }
            sb.append(maxVal+"\n");
        }
        System.out.print(sb);
    }
}
