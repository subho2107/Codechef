import java.io.*;
import java.util.*;

public class UpForAGame {
    static int lessThanEqualEle(int [] arr, int ele)
    {
        int lo = 0, hi = arr.length-1, ans = 0;
        while (lo <= hi)
        {
            int mid = (lo+hi)/2;
            if (arr[mid] <= ele)
            {
                ans = mid;
                lo = mid+1;
            }
            else
                hi = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] stack = new int[n];
            for (int pos = 0; pos < n; pos++) {
                stack[pos] = Integer.parseInt(inp[pos]);
            }
            inp = buffer.readLine().split(" ");
            int [] setS = new int[k];
            for (int pos = 0; pos < k; pos++) {
                setS[pos] = Integer.parseInt(inp[pos]);
            }
            int scoreChef = 0, scoreDarry = 0;

        }
        System.out.println(sb);
    }
}
