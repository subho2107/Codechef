import java.io.*;
import java.util.*;

public class BinaryConcatenation {
    static long[] pow2 = new long[31];
    public static void main(String[] args) throws Exception {
        pow2[0] = 1;
        for (int pos = 1; pos < pow2.length; pos++) {
            pow2[pos] = pow2[pos - 1] * 2;
        }
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bu.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(bu.readLine());
            String[] inp = bu.readLine().split(" ");
            ArrayList[] arr = new ArrayList[31];
            for (int pos = 0; pos < arr.length; pos++) {
                arr[pos] = new ArrayList<Long>();
            }
            for (int pos = 0; pos < n; pos++) {
                long num = Integer.parseInt(inp[pos]);
                arr[(int) (Math.log(num)/Math.log(2))].add(num);
            }
            for (int pos = 0; pos < 31; pos++) {
                Collections.sort(arr[pos]);
            }
            long maxVal = 0;
            for (int pos = 0; pos < 31; pos++) {
                for (int pos2 = 0; pos2 < 31; pos2++) {
                    boolean check = pos==pos2 && arr[pos].size() < 2;
                    boolean check2 = arr[pos].size() == 0 || arr[pos2].size()==0;
                    if (check||check2)continue;
                    long valA = pow2[pos2+1]-1, valB = pow2[pos+1]-1;
                    long val1 = (long) arr[pos].get(arr[pos].size()-1), val2 = (long) arr[pos2].get(0);
                    maxVal = Math.max(maxVal, valA*val1-valB*val2);
                }
            }
            sb.append(maxVal+"\n");
        }
        System.out.print(sb);
    }
}
