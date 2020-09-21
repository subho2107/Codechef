import java.io.*;
import java.util.*;

public class BulbsAndWires {
    public static int getCost(String s, int k){
        if (k < 0 )
            return (int)1e7;
        ArrayList<Integer>zeroes = new ArrayList<>();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1'){
                if (cnt > 0)
                    zeroes.add(cnt);
                cnt = 0;
            }
            else cnt++;
        }
        Collections.sort(zeroes);
        while (k > 1 && zeroes.size() > 0){
            zeroes.remove(zeroes.size()-1);
            k-=2;
        }
        int ans = 0;
        for (int val : zeroes) {
            ans+=val;
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
            String s = buffer.readLine();
            int cntFirst = 0, cntLast = 0;
            for (int pos = 0; pos < s.length() && s.charAt(pos)!='1'; pos++) {
                cntFirst++;
            }
            for (int pos = s.length()-1; pos >= 0 && s.charAt(pos)!='1' ; pos--) {
                cntLast++;
            }
            int one = 0;
            for (char c : s.toCharArray()) {
                if (c == '1')
                    one++;
            }
            if (one == n || one == 0){
                sb.append("0\n");
                continue;
            }
            s = s.substring(s.indexOf('1'), s.lastIndexOf('1')+1);
            int val = Math.min(getCost(s, k)+cntFirst+cntLast, Math.min(getCost(s, k-1)+cntFirst, Math.min(getCost(s, k-1)+cntLast, getCost(s, k-2))));
            sb.append(val+"\n");

        }
        System.out.println(sb);
    }
}
