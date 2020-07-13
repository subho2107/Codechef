import java.io.*;
import java.util.*;

public class MissingAPoint {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int[][] points = new int[4 * n - 1][2];
            String[] inp;
            for (int pos = 0; pos < 4 * n - 1; pos++) {
                inp = buffer.readLine().split(" ");
                points[pos] = new int[]{Integer.parseInt(inp[0]), Integer.parseInt(inp[1])};
            }
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {
                    if (arr1[0] > arr2[0]) return 1;
                    else if (arr1[0] == arr2[0]) {
                        if (arr1[1] > arr2[1]) return 1;
                        else return -1;
                    } else
                        return -1;
                }
            });
//            for (int[] p : points)
//                System.out.print(Arrays.toString(p)+" ");
//            System.out.println(" ");
            boolean check = false;
            int[] diag1 = {};
            for (int pos = 0; pos < points.length - 1; pos += 2) {
                if (points[pos][0] != points[pos + 1][0]) {
                    check = true;
                    diag1 = points[pos];
                    break;
                }
            }
            if (!check) diag1 = points[points.length - 1];
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {
                    if (arr1[1] > arr2[1]) return 1;
                    else if (arr1[1] == arr2[1]) {
                        if (arr1[0] > arr2[0]) return 1;
                        else return -1;
                    } else
                        return -1;
                }
            });
//            for (int[] p : points)
//                System.out.print(Arrays.toString(p)+" ");
//            System.out.println(" ");
            check = false;
            int[] diag2 = {};
            for (int pos = 0; pos < points.length - 1; pos += 2) {
                if (points[pos][1] != points[pos + 1][1]) {
                    check = true;
                    diag2 = points[pos];
                    break;
                }
            }
            if (!check) diag2 = points[points.length - 1];
            int[] pointA = {diag1[0], diag2[1]}, pointB = {diag2[0], diag1[1]};
            check = false;
//            System.out.println(Arrays.toString(diag1)+" "+Arrays.toString(diag2));
            for (int pos = 0; pos < points.length; pos++) {
                if (points[pos][0] == pointA[0] && points[pos][1] == pointA[1]) {
                    check = true;
                    break;
                }
            }
            if (check)
                sb.append(pointB[0] + " " + pointB[1] + "\n");
            else
                sb.append(pointA[0] + " " + pointA[1] + "\n");
        }
        System.out.println(sb);
    }
}
