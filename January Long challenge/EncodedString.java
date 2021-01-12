import java.io.*;
import java.util.*;

class EncodedString {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            for (int i = 0; i < n; i+=4) {
                String temp = s.substring(i, i+4);
                char low = 'a', high = 'p', mid = ' ';
                for (char ch : temp.toCharArray()) {
                    mid = (char) ((low+high)/2);
                    if (ch == '0')
                        high = mid;
                    else
                        low = (char) (mid+1);
                }
                sb.append(low);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
