import com.sun.source.doctree.IndexTree;

import java.io.*;
import java.util.*;

class MATRIXMIN {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            HashSet<Integer> used = new HashSet<>();
            int maxMoves = 0;
            for (int i = 0; i < n; i++) {
                int moves = 0;
                int pos = i;
                if (used.add(pos)) {
                    while (pos < n - 1) {
                        used.add(pos);
                        if (pos + 1 < n && arr[pos + 1] == arr[pos]) {
                            pos++;
                            moves++;
                        } else if (pos + 2 < n && arr[pos + 2] == arr[pos]) {
                            pos += 2;
                            moves++;
                        } else
                            break;
                    }
                    maxMoves = Math.max(moves, maxMoves);
                }
            }
            sb.append(maxMoves + "\n");
        }
        System.out.println(sb);
    }
}
