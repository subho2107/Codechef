import java.io.*;
import java.util.*;

class ChefinaAndSwaps {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp= buffer.readLine().split(" ");
            int [] a = new int[n], b = new int[n];
            Map<Integer, Integer>totalFreq = new HashMap<>();
            Map <Integer, Integer> aMap = new HashMap<>();
            Map <Integer, Integer> bMap = new HashMap<>();
            for (int pos = 0; pos < n; pos++) {
                a[pos] = Integer.parseInt(inp[pos]);
                totalFreq.put(a[pos], totalFreq.getOrDefault(a[pos], 0)+1);
                aMap.put(a[pos], aMap.getOrDefault(a[pos], 0)+1);
            }
            inp = buffer.readLine().split(" ");
            for (int pos = 0; pos < n; pos++) {
                b[pos] = Integer.parseInt(inp[pos]);
                totalFreq.put(b[pos], totalFreq.getOrDefault(b[pos], 0)+1);
                bMap.put(b[pos], bMap.getOrDefault(b[pos], 0)+1);
            }
            boolean notPossible = false;
            for (int freq :
                    totalFreq.values()) {
                if (freq % 2 == 1)
                {
                    notPossible = true;
                    break;
                }
            }
            if (areEqual(a, b))
            {
                sb.append("0\n");
            }
            else if (notPossible)
                sb.append("-1\n");
            else
            {
                ArrayList<Integer>aList = new ArrayList<>(), bList = new ArrayList<>();
                for (int freq : aMap.keySet()) {
                    if (aMap.get(freq) <= (totalFreq.get(freq) / 2)) continue;
                    int diff = -(totalFreq.get(freq)/2) + aMap.get(freq);
                    for (int pos = 0; pos < diff; pos++) {
                        aList.add(freq);
                    }
                }
                for (int freq : bMap.keySet()) {
                    if (bMap.get(freq) <= (totalFreq.get(freq) / 2)) continue;
                    int diff = -(totalFreq.get(freq)/2) + bMap.get(freq);
                    for (int pos = 0; pos < diff; pos++) {
                        bList.add(freq);
                    }
                }
                Collections.sort(aList);Collections.sort(bList);
                long cost = 0;
                int minNum = Collections.min(totalFreq.keySet());
                if ((!aMap.containsKey(minNum)||!bMap.containsKey(minNum)) ||(!aMap.get(minNum).equals(bMap.get(minNum))))
                {
                    if (!aMap.containsKey(minNum)||(bMap.containsKey(minNum)&&aMap.get(minNum)<bMap.get(minNum)))
                    {
                        while (bList.get(0)!=minNum)
                        {
                            cost += minNum;
                            bList.remove(0);
                            aList.remove(aList.size()-1);

                        }
                    }
                    else
                    {
                        while (aList.get(0)!=minNum)
                        {
                            cost += minNum;
                            aList.remove(0);
                            bList.remove(bList.size()-1);

                        }
                    }
                }
                while (aList.size()!=0)
                {
                    if (aList.get(0)<bList.get(0))
                    {
                        cost += Math.min(2*minNum, aList.remove(0));
                        bList.remove(bList.size()-1);
                    }
                    else
                    {
                        cost += Math.min(2*minNum, bList.remove(0));
                        aList.remove(aList.size()-1);
                    }
                }
                sb.append(cost+"\n");

            }
        }
        System.out.println(sb);
    }
    private static boolean areEqual(int [] a, int [] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (int pos = 0; pos < a.length; pos++) {
            if (a[pos]!=b[pos])return false;
        }
        return true;
    }
}
