import java.io.*;
import java.util.*;

class ChefAndWeddingArrangements {
    public static void solve(int n, int k, int[]arr)throws Exception{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer>partitionPoints = new ArrayList<>();
        int tables = 0;
        Set<Integer>set = new HashSet<>();
        for (int pos = 0; pos < n; pos++) {
            if (set.add(arr[pos]))continue;
            set.clear();
            set.add(arr[pos]);
            tables++;
            partitionPoints.add(pos);
        }
        if (set.size()!=0)tables++;
        long cost = tables*k;
//            if (k==1){
//                sb.append(cost+"\n");
//                continue;
//            }
        long original = cost;
        HashMap<Integer, Integer>twoTable = new HashMap<>();
        HashMap<Integer, Integer>oneTable = new HashMap<>();
        for (int partn = partitionPoints.size(); partn >= 1 ; partn--) {
            twoTable .clear();
            int posToRemove = 0;
            int disputes = Integer.MAX_VALUE, prevDisp = 0;
            int presLen = partitionPoints.size();
            for (int i = 0; i < partitionPoints.get(0); i++) {
                twoTable.put(arr[i], twoTable.getOrDefault(arr[i], 0)+1);
                if (twoTable.get(arr[i])==2)
                    prevDisp+=2;
                else if (twoTable.get(arr[i])>2)
                    prevDisp++;
            }
            for (int pos = 0; pos < presLen; pos++) {
                oneTable.clear();
                int start = partitionPoints.get(pos);
                int end = pos==(presLen-1)?(n-1):(partitionPoints.get(pos+1)-1), tempDisp = 0, currDisp = 0;
                for (int i = start; i <= end; i++) {
                    twoTable.put(arr[i], twoTable.getOrDefault(arr[i], 0)+1);
                    if (twoTable.get(arr[i])==2)
                        tempDisp+=2;
                    else if (twoTable.get(arr[i])>2)
                        tempDisp++;
                    oneTable.put(arr[i], oneTable.getOrDefault(arr[i], 0)+1);
                    if (oneTable.get(arr[i])==2)
                        currDisp+=2;
                    if (oneTable.get(arr[i])>2)
                        currDisp++;
                }
//                    tempDisp+=dispFam.size();
                if (disputes>prevDisp+tempDisp){
//                        System.out.println(disputes+" "+(prevDisp+tempDisp));
                    disputes = prevDisp+tempDisp;
                    posToRemove = pos;
                }
                prevDisp = currDisp;
                twoTable.clear();
                twoTable = new HashMap<>(oneTable);
            }
            partitionPoints.remove(posToRemove);
            disputes = 0;
            oneTable.clear();
            int len = partitionPoints.size();
            for (int i = 0; i < (len==0?n:partitionPoints.get(0)); i++) {
                oneTable.put(arr[i], oneTable.getOrDefault(arr[i], 0)+1);
                int tempFreq = oneTable.get(arr[i]);
                if (tempFreq==2)
                    disputes+=2;
                else if (tempFreq>2)
                    disputes++;
            }
            for (int i = 0; i < len; i++) {
                oneTable.clear();
                for (int j = partitionPoints.get(i); j < ((i==len-1)?n:partitionPoints.get(i+1)); j++) {
                    oneTable.put(arr[j], oneTable.getOrDefault(arr[j], 0)+1);
                    int tempFreq = oneTable.get(arr[j]);
                    if (tempFreq==2)
                        disputes+=2;
                    else if (tempFreq>2)
                        disputes++;
                }
            }
            cost = Math.min(cost, partn*k+disputes);
//                System.out.println(partitionPoints.toString());
//                System.out.println(partn+" "+disputes+" "+cost);
//                System.out.println(cost+" "+partn);
        }
        System.out.println(Math.min(original, cost)+"\n");
    }
    public static int getCnt(int[]arr, boolean[]partitions){
        int cnt = 0;
        int n = arr.length;
        HashMap<Integer, Integer>freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (partitions[i])
                freq.clear();
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
            if (freq.get(arr[i])==2)
                cnt+=2;
            else if (freq.get(arr[i])>2)
                cnt++;
        }
        return cnt;
    }
    public static void main(String[] args)throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            int tables = 0;
            Set<Integer>set = new HashSet<>();
            for (int pos = 0; pos < n; pos++) {
                if (set.add(arr[pos]))continue;
                set.clear();
                set.add(arr[pos]);
                tables++;
            }
            if (set.size()!=0)tables++;
            long cost = tables*k;
            if (k==1)
            {
                sb.append(cost+"\n");
                continue;
            }
            boolean[] partitions = new boolean[n];
            partitions[0] = true;
            if (n>500){
                solve(n, k, arr);
                continue;
            }
            for (int table = 1; table <= n; table++) {
                if (table==1){
                    cost = Math.min(cost, k*table+getCnt(arr, partitions));
                    continue;
                }
                int tempDisp = Integer.MAX_VALUE;
                int posToAdd = 0;
                for (int partnPos = 0; partnPos < n; partnPos++) {
                    if (partitions[partnPos])continue;
                    partitions[partnPos] = true;
                    int currDisp = getCnt(arr, partitions);
                    if (currDisp<tempDisp){
                        tempDisp = currDisp;
                        posToAdd = partnPos;
                    }
                    partitions[partnPos] = false;
                }
                partitions[posToAdd] = true;
                cost = Math.min(cost, k*table+tempDisp);
            }
            sb.append(cost+"\n");
        }
        System.out.println(sb);
    }
}