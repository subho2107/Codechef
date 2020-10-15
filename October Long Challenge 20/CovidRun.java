import java.io.*;
import java.util.*;

public class CovidRun {
    public static int gcd(int num1, int num2){
        if (num2 == 0)
            return num1;
        return gcd(num2, num1%num2);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int cities = Integer.parseInt(inp[0]), jumps = Integer.parseInt(inp[1]), initialCity = Integer.parseInt(inp[2]),
                    finalCity = Integer.parseInt(inp[3]);
            if (initialCity == finalCity)
                sb.append("YES\n");
            else if (jumps == 0)
                sb.append("NO\n");
            else {
                if (cities % jumps == 0){
                    if (Math.abs(finalCity-initialCity)%jumps==0)
                        sb.append("YES\n");
                    else
                        sb.append("NO\n");
                }
                else{
                    jumps = gcd(cities, jumps);
                    if (Math.abs(finalCity-initialCity)%jumps==0)
                        sb.append("YES\n");
                    else
                        sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
}
