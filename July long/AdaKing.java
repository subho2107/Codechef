import java.io.*;
import java.util.*;

public class AdaKing {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(buffer.readLine());
            for (int rowPos = 0; rowPos < 8; rowPos++) {
                for (int colPos = 0; colPos < 8; colPos++) {
                    if (rowPos == 0 && colPos == 0) {
                        sb.append("");
                        k--;
                    } else if (k != 0) {
                        sb.append(".");
                        k--;
                    } else
                        sb.append("X");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
