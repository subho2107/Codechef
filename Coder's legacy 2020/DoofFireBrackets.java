import java.io.*;
import java.util.*;
public class DoofFireBrackets {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine();
            int q = Integer.parseInt(buffer.readLine()), n = s.length();
            Stack<Integer>brackets = new Stack<>();
            int [] arr = new int[n+1];
            arr[n] = -2;
            for (int pos = n-1; pos >= 0 ; pos--) {
                if (s.charAt(pos)==')')
                {
                    brackets.add(pos);
                    arr[pos] = arr[pos+1];
                }
                else
                {
                    if (brackets.size()!=0)
                        arr[pos] = brackets.pop();
                    else
                        arr[pos] = -2;
                }
            }
            String [] inp = buffer.readLine().split(" ");
            for (int query = 0; query < q; query++) {
                int ti = Integer.parseInt(inp[query]);
                sb.append(arr[--ti]+1).append("\n");
            }

        }
        System.out.println(sb);
    }
}
