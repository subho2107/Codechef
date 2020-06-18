import java.io.*;
import java.util.*;

public class Lift_Requests {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[]inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]);
            int previousFloor = 0;
            long totalFloors = 0;
            while (q-->0)
            {
                inp = buffer.readLine().split(" ");
                int source = Integer.parseInt(inp[0]), destination = Integer.parseInt(inp[1]);
                totalFloors += Math.abs(source-previousFloor) + Math.abs(source-destination);
                previousFloor = destination;
            }
            sb.append(totalFloors+"\n");
        }
        System.out.println(sb);
    }
}
