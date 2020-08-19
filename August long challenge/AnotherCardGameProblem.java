import java.io.*;
import java.util.*;

public class AnotherCardGameProblem {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int chef = Integer.parseInt(inp[0]), rick = Integer.parseInt(inp[1]);
            int digChef = chef/9, digRick = rick/9  ;
            digChef += chef%9==0?0:1;
            digRick+=rick%9==0?0:1;
            if (digChef<digRick)
                sb.append("0 "+digChef+"\n");
            else
                sb.append("1 "+digRick+"\n");

        }
        System.out.println(sb);
    }
}
