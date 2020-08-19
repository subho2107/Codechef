import java.io.*;
import java.util.*;

public class ChefWarsReturnOfTheJedi {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int health = Integer.parseInt(inp[0]), power = Integer.parseInt(inp[1]);
            while(health!=0 && power!=0){
                health -= power;
                power /= 2;
            }
            if (health<=0)
                sb.append("1\n");
            else
                sb.append("0\n");
        }
        System.out.println(sb);
    }
}
