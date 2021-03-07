import java.io.*;
import java.util.*;

public class PrimeGame {
    static final int MAX_SIZE = 1000001;
    static ArrayList<Boolean> isprime = new ArrayList<>(MAX_SIZE);
    static ArrayList<Integer> prime = new ArrayList<>();
    static ArrayList<Integer> SPF = new ArrayList<>(MAX_SIZE);

    static void manipulated_seive() {
        isprime.set(0, false);
        isprime.set(1, false);
        for (int i = 2; i < PrimeGame.MAX_SIZE; i++) {
            if (isprime.get(i)) {
                prime.add(i);
                SPF.set(i, i);
            }
            for (int j = 0;
                 j < prime.size() &&
                         i * prime.get(j) < PrimeGame.MAX_SIZE && prime.get(j) <= SPF.get(i);
                 j++) {
                isprime.set(i * prime.get(j), false);
                SPF.set(i * prime.get(j), prime.get(j));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < MAX_SIZE; i++){
            isprime.add(true);
            SPF.add(2);
        }
        manipulated_seive();
        int cnt = 0;
        int [] primesLessThanN = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; ++i) {
            if (isprime.get(i))
                cnt++;
            primesLessThanN[i] = cnt;
        }
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
            if (primesLessThanN[x] <= y)
                sb.append("Chef\n");
            else
                sb.append("Divyam\n");
        }
        System.out.println(sb);
    }
}
