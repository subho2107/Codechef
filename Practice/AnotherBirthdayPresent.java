import java.io.*;
import java.util.*;

class AnotherBirthdayPresent {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        String [] inp;
        while (t-- > 0) {
            inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int pos = 0; pos < n; pos++)
                arr[pos] = Integer.parseInt(inp[pos]);
            for (int pos = 0; pos < k; pos++) {
                ArrayList<Integer>elements = new ArrayList<>();
                for (int pos2 = pos; pos2 < n; pos2+=k)
                    elements.add(arr[pos2]);
                Collections.sort(elements);
                for (int pos2 = pos; pos2 < n; pos2+=k) {
                    arr[pos2] = elements.remove(0);
                }
            }
            boolean check = true;
            for (int pos = 0; pos < n-1; pos++) {
                if (arr[pos] > arr[pos+1])
                {
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.println(sb);
    }
}
