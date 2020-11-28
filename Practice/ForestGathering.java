import java.io.*;
import java.util.*;

class ForestGathering {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        long w = Long.parseLong(inp[1]), l = Long.parseLong(inp[2]), maxMonths = 0;
        long [][] heights = new long[n][2];
        long currSum = 0;
        for (int i = 0; i < n; i++) {
            inp = buffer.readLine().split(" ");
            heights[i][0] = Integer.parseInt(inp[0]);//height
            heights[i][1] = Integer.parseInt(inp[1]);//rate of growth
            if (heights[i][0] >= l && currSum < w)
                currSum += heights[i][0];
            maxMonths = (long) Math.max(maxMonths, Math.ceil(Math.max(0, w - heights[i][0])/(float)heights[i][1]));
        }
        if (currSum >= w)
            System.out.println(0);
        else
        {
            long low = 0, high = (long) 1e18;
            long ans = 0;
            while (low <= high) {
                long mid = (low + high) / 2, sum = 0;
                for (int i = 0; i < n && sum < w; i++) {
                    if (heights[i][0] + heights[i][1] * mid >= l)
                        sum += heights[i][0] + heights[i][1] * mid;;
                }
                if (sum >= w) {
                    ans = mid;
                    high = mid;
                } else
                    low = mid + 1;
            }
            System.out.println(ans);
        }
    }
}
