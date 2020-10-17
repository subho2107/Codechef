import java.io.*;
import java.util.*;

class MonkeyPower {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int [] largestFromRight = new int[n];
            int maxFromRight = arr[n-1], pos = n-1;
            for (int i = n-1; i >= 0; i--) {
                if (arr[i] > maxFromRight){
                    maxFromRight = arr[i];
                    pos = i;
                }
                largestFromRight[i] = pos;
            }
            int maxX = 0;
//            System.out.println(Arrays.toString(largestFromRight));
            for (int i = 0; i < n; i++) {
                int cnt = 1;
                while (i < n-1 && largestFromRight[i] == largestFromRight[i + 1]){
                    i++;
                    cnt++;
                }
                maxX = Math.max(maxX, cnt);
            }
//            System.out.println(maxX);
            long fact = 1;
            int mod = (int)1e9+7;
            while (maxX != 0){
                fact = ((fact%mod)*(maxX%mod))%mod;
                maxX--;
            }
            sb.append(fact+"\n");
        }
        System.out.println(sb);
    }
}
