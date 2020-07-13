import java.io.*;
import java.util.*;
class ChefAndDragonDens {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]);
        inp = buffer.readLine().split(" ");
        int[] heights = new int[n];
        for (int pos = 0; pos < n; pos++) {
            heights[pos] = Integer.parseInt(inp[pos]);
        }
        long[] tastes = new long[n];
        inp = buffer.readLine().split(" ");
        for (int pos = 0; pos < n; pos++) {
            tastes[pos] = Integer.parseInt(inp[pos]);
        }
        if (q <= 1000)
        {
            for (int query = 0; query < q; query++) {
//            System.out.println(query);
                inp = buffer.readLine().split(" ");
//            System.out.println(Arrays.toString(inp));
                int queryType = Integer.parseInt(inp[0]);
                if (queryType == 1)
                    tastes[Integer.parseInt(inp[1]) - 1] = Integer.parseInt(inp[2]);
                else {
                    int start = Integer.parseInt(inp[1]) - 1, end = Integer.parseInt(inp[2]) - 1;
                    if (start == end) {
                        sb.append(tastes[start]).append("\n");
                        continue;
                    }
                    boolean check = true;
                    for (int pos = Math.min(start, end) + 1; pos < Math.max(start, end); pos++) {
                        if (heights[pos] >= heights[start]) {
                            check = false;
                            break;
                        }
                    }
                    if (!check || heights[end] >= heights[start]) {
//
                        sb.append("-1\n");
                    } else {
                        long taste = tastes[start] + tastes[end];
                        int prevHeight = heights[end];
                        if (start < end) {
                            for (int pos = end - 1; pos > start; pos--) {
                                if (heights[pos] > prevHeight) {
                                    taste += tastes[pos];
                                    prevHeight = heights[pos];
                                }
                            }
                        } else {
                            for (int pos = end + 1; pos < start; pos++) {
                                if (heights[pos] > prevHeight) {
                                    taste += tastes[pos];
                                    prevHeight = heights[pos];
                                }
                            }
                        }
                        sb.append(taste).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
