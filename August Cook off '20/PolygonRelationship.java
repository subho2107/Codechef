import java.io.*;
import java.util.*;

public class PolygonRelationship {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            String s = buffer.readLine();
            int zero = 0, one = 0;
            for (char ch:s.toCharArray()){
                if (ch=='0')
                    zero++;
                else
                    one++;
            }
            if (zero==0||one==0)
                sb.append(s+"\n");
            else {
                int parts = n/k;
                if (one%parts!=0 || zero%parts!=0){
                    sb.append("IMPOSSIBLE\n");
                }
                else {
                    int cnt0 = zero/parts, cnt1 = one/parts;
                    String temp = "";
                    for (int pos = 0; pos < cnt0; pos++) {
                        temp+='0';
                    }
                    for (int pos = 0; pos < cnt1; pos++) {
                        temp+='1';
                    }
                    String rev= "";
                    for (char ch:temp.toCharArray())
                        rev = ch+rev;
                    for (int pos = 0; pos < parts; pos++) {
                        if (pos%2==0)
                            sb.append(temp);
                        else
                            sb.append(rev);
                    }
                    sb.append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}
