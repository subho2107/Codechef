import java.io.*;
import java.util.*;

class MagicalCandyStore {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            boolean check = false;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                if (arr[i] == 1)
                    check = true;
            }
            int noOfQuery = Integer.parseInt(buffer.readLine());
            long[] prefixArr = new long[n];
            long[] lastRoundVals = new long[n];
            long chefCandies = 0;
            int MOD = (int) (1e9 + 7);
            for (int i = 0, chef = 1; i < n; i++) {
                long presentCandies = arr[i];
                long dup = presentCandies;
                //if current is not last turn
                if (presentCandies > 1) {
                    if (arr[0] == 1) {
                        if (i != 0 ) {
                            if (presentCandies % 2 == 1)
                                presentCandies--;
                        }
                    } else if (arr[n - 1] == 1) {
                        if (i != n - 1 && presentCandies % 2 == 1)
                            presentCandies--;
                    } else if (check) {
                        if (i == n - 1) {
                            if (presentCandies % 2 == 0)
                                presentCandies--;
                        } else if (i + 1 <= n - 1 && arr[i + 1] == 1) {
                            if (presentCandies % 2 == 0)
                                presentCandies--;
                        } else if (presentCandies % 2 == 1) {
                            presentCandies--;
                        }
                    } else {
                        if (i == n - 1 && presentCandies % 2 == 0)
                            presentCandies--;
                        else if (i != n - 1 && presentCandies % 2 == 1)
                            presentCandies--;
                    }
                }
                presentCandies %= MOD;
                if (chef == 0) {
                    prefixArr[i] = prefixArr[i - 1];
                } else {
                    if (i == 0)
                        prefixArr[i] = presentCandies;
                    else
                        prefixArr[i] = (prefixArr[i - 1] % MOD + presentCandies % MOD) % MOD;
                    presentCandies %= MOD;
                    chefCandies += presentCandies;
                    chefCandies %= MOD;
                }
                if (presentCandies % 2 == 1)
                    chef ^= 1;
                //if current is last turn
                presentCandies = dup;
                if (n == 1)
                    lastRoundVals[0] = arr[0];
                else if (arr[0] == 1) {
                    if (i == 0) {
                        lastRoundVals[i] = 0;
                    } else {
                        lastRoundVals[i] = 1;
                    }
                } else if (arr[n - 1] == 1) {
                    if (i == 0)
                        lastRoundVals[i] = presentCandies;
                    else
                        lastRoundVals[i] = (presentCandies % MOD + prefixArr[i - 1] % MOD) % MOD;

                } else if (check) {
                    if (i + 1 <= n - 1 && arr[i + 1] == 1) {
                        if (i == 0)
                            lastRoundVals[i] = presentCandies;
                        else
                            lastRoundVals[i] = (presentCandies % MOD + prefixArr[i - 1] % MOD) % MOD;
                    } else if (arr[i] == 1) {
                        if (i == 1) {
                            lastRoundVals[i] = arr[i - 1];
                        }
                        else {
                            lastRoundVals[i] = (prefixArr[i - 2] % MOD + arr[i - 1] % MOD) % MOD;
                        }//problem(hopefully solved)
                        if (arr[i-1] % 2 == 0)
                            lastRoundVals[i]++;
                        lastRoundVals[i] %= MOD;
                    }
                    else{
                        if (i == 0)
                            lastRoundVals[i] = arr[0];
                        else
                            lastRoundVals[i] = (presentCandies % MOD + prefixArr[i - 1] % MOD) % MOD;
                    }
                } else {
                    if (i == 0)
                        lastRoundVals[i] = presentCandies;
                    else
                        lastRoundVals[i] = (prefixArr[i - 1] % MOD + presentCandies % MOD) % MOD;
                }
                lastRoundVals[i] %= MOD;
                if (i == n - 1)
                    chef ^= 1;
            }
            for (int query = 0; query < noOfQuery; query++) {
                long R = Long.parseLong(buffer.readLine());
                long times = (R / n) % MOD;
                int rem = (int) (R % n);
                long currCandies;
                if (rem == 0) {
                    currCandies = ((times - 1) % MOD * chefCandies % MOD) % MOD;
                    currCandies = (currCandies%MOD+lastRoundVals[n-1]%MOD)%MOD;
                } else {
                    currCandies = (times % MOD * chefCandies % MOD) % MOD;
                    currCandies = (currCandies%MOD+lastRoundVals[rem-1]%MOD)%MOD;
                    if (arr[0] == 1 && times == 0 && rem == 1)
                        currCandies++;
                }
                sb.append(currCandies).append("\n");
            }
        }
        System.out.println(sb);
    }
}
