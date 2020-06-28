import java.io.*;
import java.util.*;
class TheMaximumNumber {

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        int [] power2 = new int[31];
        power2[0] = 1;
        for (int pos = 1; pos < 31; pos++) {
            power2[pos] = 2*power2[pos-1];
        }
        while (t-- > 0) {
            long setBitCnt[][] = new long[31][2];
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);
            int[] bitCount = new int[31];
            inp = buffer.readLine().split(" ");
            long temp = 0;
            for (int pos = 0; pos < n; pos++) {
                temp = Long.parseLong(inp[pos]);
                for (int power = 0; power < 31; power++) {
                    if ((temp&(1<<power)) != 0) {
                        bitCount[power]++;
                    }
                }
            }
            for (int power = 0; power < 31; power++) {
                setBitCnt[power][0] = power;
                setBitCnt[power][1] = (long) bitCount[power] * power2[power];
            }
            Arrays.sort(setBitCnt, new Comparator<long[]>() {
                @Override
                public int compare(long[] arr1, long[] arr2) {
                    if (arr1[1] > arr2[1])return 1;
                    else if (arr1[1]==arr2[1])
                    {
                        if (arr1[0] < arr2[0])return 1;
                        else return -1;
                    }
                    else
                        return -1;
                }
            });
            long val = 0;
            for (int pos = 30; pos >= 31-k; pos--) {
                val += power2[(int)setBitCnt[pos][0]];
            }
            sb.append(val+"\n");
        }
        System.out.println(sb);
    }
}
