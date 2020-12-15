import java.io.*;
import java.util.*;

class HailXOR {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long [] pow2 = new long[32];
        pow2[0] = 1;
        for (int i = 1; i < 32; i++) {
            pow2[i] = (long) 2*pow2[i-1];
        }
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            long[] arr = new long[n];
            boolean megaCheck = false;
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            for (int i = 0; i < n - 1 && x > 0; i++) {
                boolean check = false;
                for (int pow = 31; pow >= 0 && x > 0 && arr[i] > 0; pow--) {
                    if ((arr[i]&pow2[pow]) == 0)continue;
                    check = false;
                    for (int j = i+1; j < n - 1; j++) {
                        if ((arr[j]&pow2[pow]) > 0){
                            arr[i]^=pow2[pow];
                            arr[j]^=pow2[pow];
                            if((arr[n-1]&pow2[pow]) == 0){
                                megaCheck = true;
                            }
                            x--;
                            check = true;
                            break;
                        }
                    }
                    if (!check){
                        arr[i] ^= pow2[pow];
                        arr[n-1] ^= pow2[pow];
                        x--;
                    }
                }
            }

            if (x % 2 == 1 && !megaCheck) {
                arr[n - 1] ^= 1;
                arr[n - 2] ^= 1;
            }

            for (long num : arr)
                sb.append(num).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
