import java.io.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class PointOfImpact {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]), x = Integer.parseInt(inp[2]), y = Integer.parseInt(inp[3]);
            if (x == y)
                sb.append(n).append(" ").append(n);
            else {
                int[][] coordinates = new int[4][2];
                int diff = Math.min(n - x, n - y);
                x += diff;
                y += diff;
                coordinates[0][0] = x;
                coordinates[0][1] = y;
                if (x == n && y != 0) {
                    diff = Math.min(x, n-y);
                    x -= diff;
                    y += diff;
                } else {
                    diff = Math.min(n - x, y);
                    x += diff;
                    y -= diff;
                }
                coordinates[1][0] = x;
                coordinates[1][1] = y;
                diff = Math.min(x, y);
                x -= diff;
                y -= diff;
                coordinates[2][0] = x;
                coordinates[2][1] = y;
                if (x == 0 && y != 0) {
                    diff = Math.min(n - x, y);
                    x += diff;
                    y -= diff;
                }
                else {
                    diff = Math.min(x, n-y);
                    x -= diff;
                    y += diff;
                }
                coordinates[3][0] = x;
                coordinates[3][1] = y;
//                for (int[] coordinate : coordinates) {
//                    System.out.print(Arrays.toString(coordinate) + " ");
//                }
//                System.out.println();
                if (k <= 4){
                    x = -1;
                    y = -1;
                    for (int i = 0; i < k; i++) {
                        int tempX = coordinates[i][0], tempY = coordinates[i][1];
                        if ((tempX == 0 && tempY == 0)||(tempX == n && tempY == 0)||(tempX == 0 && tempY == n)||(tempX == n && tempY == n)){
                            x = tempX; y = tempY;
                        }
                    }
                    if (x == -1)
                        sb.append(coordinates[k-1][0]).append(" ").append(coordinates[k-1][1]);
                    else
                        sb.append(x).append(" ").append(y);
                }
                else {
                    x = -1;
                    y = -1;
                    for (int i = 0; i < 4; i++) {
                        int tempX = coordinates[i][0], tempY = coordinates[i][1];
                        if ((tempX == 0 && tempY == 0)||(tempX == n && tempY == 0)||(tempX == 0 && tempY == n)||(tempX == n && tempY == n)){
                            x = tempX; y = tempY;
                        }
                    }
                    if (x == -1)
                        sb.append(coordinates[(k-1)%4][0]).append(" ").append(coordinates[(k-1)%4][1]);
                    else
                        sb.append(x).append(" ").append(y);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
