import java.io.*;
import java.util.*;

class DoctorChef {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            long x = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            for (int pos = 0; pos < n; pos++)
                arr[pos] = Integer.parseInt(inp[pos]);
            Arrays.sort(arr);
            if (x >= arr[arr.length - 1])
                sb.append(arr.length + "\n");
            else {
                long minNoOfDays = 0;
                int startingPos = 0;
                for (int pos = 0; pos < n; pos++) {
                    if (arr[pos] >= x) {
                        startingPos = pos;
                        break;
                    }
                }
//                if (startingPos>0 && arr[startingPos]<=arr[startingPos-1]*2)
//                {
//                    if(arr[startingPos-1]>x)
//                    {
////                        minNoOfDays++;
////                        x = arr[startingPos-1];
//                        startingPos--;
//
//                    }
//
//                }
                long extra = startingPos - 1;
                for (int pos = startingPos; pos < n; pos++) {
                    int power = 0;
                    while (x < arr[pos]) {
                        x *= 2;
                        power++;
                    }
                    minNoOfDays += 1 + power;
                    x = 2 * arr[pos];
                }
                minNoOfDays += extra + 1;
                long minNoOfDays2 = Integer.MAX_VALUE;
                if (startingPos > 0) {
                    startingPos--;
                    //                x = arr[startingPos];
                    minNoOfDays2 = 0;
                    long extra2 = startingPos - 1;
                    for (int pos = startingPos; pos < n; pos++) {
                        int power = 0;
                        while (x < arr[pos]) {
                            x *= 2;
                            power++;
                        }
                        minNoOfDays2 += 1 + power;
                        x = 2 * arr[pos];
                    }
                    minNoOfDays2 += extra2 + 1;
                }
                sb.append(Math.min(minNoOfDays, minNoOfDays2) + "\n");
            }
        }
        System.out.println(sb);
    }
}
