import java.io.*;
import java.util.*;

public class IncreasingDecreasing {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            Integer [] arr = new Integer[n];
            boolean check = true, checkfreq = false;
            int maxVal = Integer.MIN_VALUE;
            HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                if (freq.containsKey(arr[pos]))
                    freq.put(arr[pos], freq.get(arr[pos])+1);
                else
                    freq.put(arr[pos], 1);
                if (freq.get(arr[pos]) > 2)
                {
                    check = false;
                    break;
                }
                else if (freq.get(arr[pos]) > 1)
                    checkfreq = true;
                maxVal = Math.max(maxVal, arr[pos]);
            }
            if (freq.get(maxVal) > 1 || !check)
            {
                sb.append("NO\n");
            }
            else
            {
                sb.append("YES\n");
                if (!checkfreq)
                {
                    Arrays.sort(arr);
                    for (int pos = 0; pos < n; pos++) {
                        sb.append(arr[pos]+" ");
                    }
                    sb.append("\n");
                }
                else
                {
                    ArrayList<Integer>unique = new ArrayList<Integer>();
                    for (int num :
                            freq.keySet()) {
                        unique.add(num);
                    }
                    Collections.sort(unique);
                    for (int num :
                            unique) {
                        sb.append(num + " ");
                    }
                    for (int pos = unique.size()-1; pos >= 0; pos--) {
                        int num = unique.get(pos);
                        if (freq.get(num)>1)
                            sb.append(num+" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
