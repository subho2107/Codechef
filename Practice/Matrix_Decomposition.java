import java.io.*;
import java.util.*;

public class Matrix_Decomposition {
    static long MOD = 1000000007;
    public static long modularExponentiation(long number, long power)
    {
        if(power==0)return 1;
        long pow = modularExponentiation(number, power/2)%MOD;
        long square = (pow*pow)%MOD;
        if(power%2==0)return square;
        else return (square*number)%MOD;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[]inp = buffer.readLine().split(" ");
            long length = Long.parseLong(inp[0]);
            long A = Long.parseLong(inp[1]);
            long result = A;
            long prevProduct = A;
            long noOfTerms = length;
            for (int pos = 3; pos <= 1+(noOfTerms-1)*2; pos+=2) {
                long temp = ((modularExponentiation(prevProduct, pos)%MOD)*(modularExponentiation(A, pos)))%MOD;
                result=((result%MOD)+(temp%MOD))%MOD;
                prevProduct = ((prevProduct%MOD)*(temp%MOD))%MOD;
            }
            sb.append(result%MOD+"\n");
        }
        System.out.println(sb);
    }
}
