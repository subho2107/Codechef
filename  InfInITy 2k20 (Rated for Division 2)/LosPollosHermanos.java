import java.io.*;
import java.util.*;

class LosPollosHermanos {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        long [] pow2 = new long[100001];
        pow2[0]= 1;
        int MOD = (int) (1e9+7);
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = (pow2[i-1]%MOD*2)%MOD;
        }
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp =buffer.readLine().split(" ");
            int [][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = i;
                arr[i][1] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return -o1[1] + o2[1];
                }
            });
//            for (int[] ints : arr) {
//                System.out.println(Arrays.toString(ints));
//            }
            int [] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int pos = arr[i][0];
                //third
                int left = i;
                long tempPow = pow2[(n - 1) - i] % MOD;
                ans[pos] += (((long)left*(left-1)/2)%MOD* tempPow)%MOD;
                ans[pos]%=MOD;
                //second
                ans[pos] += ((long)left%MOD* tempPow%MOD)%MOD;
                ans[pos]%=MOD;
                //first
                ans[pos] += (tempPow - 1)%MOD;
                ans[pos]%=MOD;
            }
            for (int num : ans) {
                sb.append(num+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
