import java.io.*;
import java.util.*;

public class PositiveAND {
    public static boolean isPowerOfTwo(long n){
        int power = (int) (Math.log(n)/Math.log(2));
        if (Math.pow(2, power) == n)
            return true;
        else
            return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] arr = new int[n];
            if (n!=1 && isPowerOfTwo(n))
                sb.append("-1\n");
            else{
                if (n==1)
                    sb.append(1+"\n");
                else {
                    arr[0] = 2;arr[1] = 3;arr[2] = 1;
                    for (int i = 4; i <= n; i++) {
                        arr[i-1] = i;
                    }
                    for (int i = 4; i <= n; i++) {
                        if (isPowerOfTwo(i) && i != n)
                            arr[i-1] = arr[i]^arr[i-1]^(arr[i] = arr[i-1]);
                    }
                    for (int i = 0; i < n; i++) {
                        sb.append(arr[i]+" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
