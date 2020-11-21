import java.io.*;
import java.util.*;

class AdaAndDishes {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            if (n == 1) {
                sb.append(arr[0]).append("\n");
                continue;
            }
            Arrays.sort(arr);
            int time = arr[n-1];
            if (n == 2) {
                sb.append(time).append("\n");
                continue;
            }
            int rest = arr[n - 1] - arr[n - 2];
            arr[n - 3] -= rest;
            int extra = Math.max(0, arr[n - 3]);
            if (n == 3)
                sb.append(time+extra).append("\n");
            else {
                if (arr[1] < 0) {
                    arr[0] += arr[1];
                    if (arr[0] > 0)
                        time += arr[0];
                }
                else if (arr[1] == 0){
                    time += arr[0];
                }
                else {
                    time += Math.max(arr[0], arr[1]);
                }
                sb.append(time+"\n");

            }

        }
        System.out.println(sb);
    }
}
