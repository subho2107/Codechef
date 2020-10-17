import java.io.*;
import java.util.*;

public class FIZZAAndMAGICIAN {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                inp = buffer.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(inp[j]);
                }
            }
            String path = buffer.readLine();
            inp = buffer.readLine().split(" ");
            int matrixCost = Integer.parseInt(inp[0]), stringCost = Integer.parseInt(inp[1]);
            long cost = 0;
            for (int i = 0; i < m; i++) {
                int row = 0, col = i;
                int ones = 0, zeroes = 0;
                while (row < n && col >= 0) {
                    if (matrix[row][col] == 1)
                        ones++;
                    else
                        zeroes++;
                    row++;
                    col--;
                }
                int pres = Character.getNumericValue(path.charAt(i));
                long tempCost;
                if (pres == 0)
                    tempCost = Math.min(ones * matrixCost, zeroes * matrixCost + stringCost);
                else
                    tempCost = Math.min(zeroes * matrixCost, ones * matrixCost + stringCost);
                cost += tempCost;
            }
            for (int i = 1; i < n; i++) {
                int row = i, col = m-1, ones = 0, zeroes = 0;
                while (row < n && col >= 0){
                    if (matrix[row][col] == 1)
                        ones++;
                    else
                        zeroes++;
                    row++;col--;
                }
                int pres = Character.getNumericValue(path.charAt(m+i-1));
                long tempCost;
                if (pres == 0)
                    tempCost = Math.min(ones * matrixCost, zeroes * matrixCost + stringCost);
                else
                    tempCost = Math.min(zeroes * matrixCost, ones * matrixCost + stringCost);
                cost += tempCost;
            }
            sb.append(cost+"\n");
        }
        System.out.println(sb);
    }
}
