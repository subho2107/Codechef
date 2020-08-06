import java.io.*;
import java.util.*;

public class MaximumCandies {
    public static void main(String args[]) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bu.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String [] inp = bu.readLine().split(" ");
            int row = Integer.parseInt(inp[0]), col = Integer.parseInt(inp[1]), maxNum = Integer.parseInt(inp[2]), maxSum = Integer.parseInt(inp[3]);
            if(maxSum>=2*maxNum || (row==col && col==1))
            {
                sb.append(1l*row*col*maxNum+"\n");
                continue;
            }
            int [][] matrix = new int[row+1][col+1];
            matrix[1][1] = Math.min(maxNum, maxSum);
            long sum = matrix[1][1];
            for (int rowPos = 1; rowPos <= row; rowPos++) {
                for (int colPos = 1; colPos <= col ; colPos++) {
                    if (rowPos == 1 && colPos == 1)continue;
                    matrix[rowPos][colPos] = maxSum-Math.max(matrix[rowPos][colPos-1], matrix[rowPos-1][colPos]);
                    if(matrix[rowPos][colPos]>maxNum)
                        matrix[rowPos][colPos] = maxNum;
                    sum += matrix[rowPos][colPos];
                }
            }
//            for (int rowPos = 0; rowPos <= row; rowPos++) {
//                for (int colPos = 0; colPos <= col; colPos++) {
//                    sb.append(matrix[rowPos][colPos]+" ");
//                }
//                sb.append("\n");
//            }
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }
}
