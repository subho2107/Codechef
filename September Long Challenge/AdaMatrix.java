import java.io.*;
import java.util.*;

public class AdaMatrix {
    public static void transpose(int[][] matrix, int size) {
        for (int pos = 0; pos < size; pos++) {
            for (int pos2 = pos + 1; pos2 < size; pos2++) {
                matrix[pos][pos2] = matrix[pos2][pos] ^ matrix[pos][pos2] ^ (matrix[pos2][pos] = matrix[pos][pos2]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp;
            int[][] matrix = new int[n][n];
            for (int pos = 0; pos < n; pos++) {
                inp = buffer.readLine().split(" ");
                for (int pos2 = 0; pos2 < n; pos2++) {
                    matrix[pos][pos2] = Integer.parseInt(inp[pos2]);
                }
            }
            int steps = 0;
            boolean check;
            for (; ; steps++) {
                int L = 1;
                check = false;
                for (; L < n && matrix[0][L] > matrix[0][L - 1]; L++) {
                    if (matrix[0][L] != L + 1) check = true;
                }
                if (!check)
                    break;
                transpose(matrix, L);
//                printMatrix(matrix);
            }
            sb.append(steps + "\n");
        }
        System.out.println(sb);
    }
}
