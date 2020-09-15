import java.io.*;
import java.util.*;

class FindXOR {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int [] powTwo = new int[21];

        powTwo[0] = 1;
        for (int pos = 1; pos < 21; pos++) {
            powTwo[pos]=2*powTwo[pos-1];
        }
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] ans = new int[20];
            int k = powTwo[20];
            int tempSum = 0;
            System.out.println("1 "+k);
            System.out.flush();
            int sum = Integer.parseInt(buffer.readLine()) - n*k;
            for (int pow = 0; pow < 19; pow++) {
                k = powTwo[pow];
                System.out.println("1 "+k);
                System.out.flush();
                int curr = Integer.parseInt(buffer.readLine());
                int currOnes = (sum - curr)/k + n;
                currOnes/=2;
                ans[pow] = (int) (currOnes%2);
                tempSum+=currOnes*(k);
            }
            ans[19] = (int)((sum - tempSum)/powTwo[19])%2;
            int ansDeci = 0;
            for (int pos = 0; pos < 20; pos++) {
                ansDeci += ans[pos]*powTwo[pos];
            }
            System.out.println("2 "+ ansDeci);
            System.out.flush();
            int verdict = Integer.parseInt(buffer.readLine());
            if (verdict == -1)break;
        }
    }
}
