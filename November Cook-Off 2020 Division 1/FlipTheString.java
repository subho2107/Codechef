import java.io.*;
import java.util.*;

class FlipTheString {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            char [] a = buffer.readLine().toCharArray();
            char [] b = buffer.readLine().toCharArray();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < a.length; i++) {
                treeSet.add(i);
            }
            int cnt = 0, n = a.length;
            while (treeSet.size() != 0){
                int pos = treeSet.first();
                int dup = pos;
                while (pos < n && a[pos] != b[pos]){
                    a[pos] = b[pos];
                    treeSet.remove(pos);
                    pos+=2;
                }
                if (dup != pos)
                    cnt++;
                else
                    treeSet.remove(pos);
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
