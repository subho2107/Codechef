
import java.io.*;
import java.util.*;

class HiringWorkers {
    public static List<List<Integer>> makeProperSize(List<List<Integer>>facts, int k){
        if (facts.get(0).size() <= k)
            return facts;
        List<List<Integer>>lists = new ArrayList<>();
        for (List<Integer> list : facts) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    ArrayList<Integer>temp = new ArrayList<>(list);
                    int val = temp.get(i)* temp.get(j);
                    temp.remove(j);temp.remove(i);
                    temp.add(val);
                    lists.add(temp);
                }
            }
        }
        return makeProperSize(lists, k);
    }
    public static List<Integer> primeFactors(int n)
    {
        List<Integer>factors = new ArrayList<>();
        while (n%2==0)
        {
            if (factors.size() == 0)
            factors.add(2);
            else
                factors.set(0, factors.get(0)*2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                if (factors.size() == 0||factors.get(factors.size()-1)%i!=0)
                factors.add(i);
                else
                    factors.set(factors.size()-1, factors.get(factors.size()-1)*i);
                n /= i;
            }
        }
        if (n > 2)
            factors.add(n);
        return factors;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int k = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            List<Integer>facts = primeFactors(x);
            int minSum = Integer.MAX_VALUE;
//            System.out.println(facts.toString());
            if (facts.size() > k)
            {
                List<List<Integer>> temp = new ArrayList<>();
                temp.add(facts);
                temp = makeProperSize(temp, k);
                for (List<Integer> list : temp) {
//                    System.out.println("hi "+list.toString());
                    int sum = 0;
                    for (Integer integer : list) {
                        sum += integer;
                    }
                    minSum = Math.min(minSum, sum);
                }
            }
            else {
                minSum = 0;
                for (Integer fact : facts) {
                    minSum += fact;
                }
                minSum += k- facts.size();
            }
            sb.append(minSum+"\n");
        }
        System.out.println(sb);
    }
}
