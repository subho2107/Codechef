import java.io.*;
import java.util.*;

public class GameOnAStrip {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            ArrayList<Integer>groups = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                if (arr[pos]==1)continue;
                int cnt = 0;
                for (; pos < n && arr[pos]==0; pos++)
                    cnt++;
                groups.add(cnt);
            }
            groups.sort(Collections.reverseOrder());
            if (groups.size()==0){
                sb.append("No\n");
            }
            else if (groups.size()==1){
                int group = groups.get(0);
                if (group%2==0)
                    sb.append("No\n");
                else {
                    sb.append("Yes\n");
                }
            }
            else {
                int a = groups.get(0), b = groups.get(1);
                if (a/2<b){
                    int spaceA = a%2==0?(a/2):(a/2+1);
                    int spaceB = b;
                    if (spaceA>spaceB)
                        sb.append("Yes\n");
                    else
                        sb.append("No\n");

                }
                else {
                    if (a%2==0)
                        sb.append("No\n");
                    else {
                        sb.append("Yes\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
