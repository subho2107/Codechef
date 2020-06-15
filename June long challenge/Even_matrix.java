import java.io.*;
public class Even_matrix
{
    public static void main(String[]args)throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++)
        {
            int n = Integer.parseInt(reader.readLine());
//            String result = "";
            int [][] arr = new int [n][n];
            int num = 1;
            for(int col = 0; col < arr.length; col++)
            {
                if(col % 2 == 0)
                {
                    for (int row = 0; row < n; row++)
                    {
                        arr[row][col] = num;
                        num++;
                    }
                }
                else
                {
                    for (int row = n-1; row >= 0; row--)
                    {
                        arr[row][col] = num;
                        num++;
                    }
                }
            }
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    System.out.print(arr[row][col] +" ");
                }
                System.out.println("");
            }
        }

    }
}