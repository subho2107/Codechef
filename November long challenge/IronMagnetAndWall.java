import java.io.*;
import java.util.*;

class IronMagnetAndWall {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            char[] arr = buffer.readLine().toCharArray();
            int[] prefixSheets = new int[n], suffixSheets = new int[n];
            int[] prefixIronAtPos = new int[n], suffixIronAtPos = new int[n];
            int sheets = 0, pos = -1;
            for (int i = 0; i < n; i++) {
                prefixSheets[i] = sheets;
                prefixIronAtPos[i] = pos;
                if (arr[i] == ':')
                    sheets++;
                else if (arr[i] == 'I')
                    pos = i;
                else if (arr[i] == 'X')
                    pos = -1;
            }
            pos = -1;
            sheets = 0;
            for (int i = n - 1; i >= 0; i--) {
                suffixIronAtPos[i] = pos;
                suffixSheets[i] = sheets;
                if (arr[i] == ':')
                    sheets++;
                else if (arr[i] == 'I')
                    pos = i;
                else if (arr[i] == 'X')
                    pos = -1;
            }
            HashSet<Integer> iron = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (arr[i] != 'M')
                    continue;
                int j = prefixIronAtPos[i];
                boolean check = false;
                pos = -1;
                while (j != -1) {
                    int power = k + 1 - Math.abs(i - j) - Math.abs(prefixSheets[i] - prefixSheets[j]);
                    if (power > 0) {
                        if(!iron.contains(j)) {
                            check = true;
                            pos = j;
                        }
                    }
                    else
                        break;
                    j = prefixIronAtPos[j];
                }
                if (check) {
                    iron.add(pos);
                    continue;
                }
                j = suffixIronAtPos[i];
                while (j != -1) {
                    int power = k + 1 - Math.abs(i - j) - Math.abs(suffixSheets[i] - suffixSheets[j]);
                    if (power > 0) {
                        if(iron.add(j))
                            break;
                    }
                    else
                        break;
                    j = suffixIronAtPos[j];
                }
            }
            sb.append(iron.size() + "\n");
        }
        System.out.println(sb);
    }
}
