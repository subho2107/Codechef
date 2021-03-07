import java.io.*;
import java.util.*;

class TeamName {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] funnyWords = buffer.readLine().split(" ");
            HashMap<String, HashSet<Character>> startingChar = new HashMap<>();
            for (String funnyWord : funnyWords) {
                if (!startingChar.containsKey(funnyWord.substring(1)))
                    startingChar.put(funnyWord.substring(1), new HashSet<>());
                startingChar.get(funnyWord.substring(1)).add(funnyWord.charAt(0));
            }
            ArrayList<String>arrayList = new ArrayList<>(startingChar.keySet());
            int ans = 0;
            for (int i = 0; i < arrayList.size(); i++){
                String a = arrayList.get(i);
                HashSet<Character>tempA = startingChar.get(a);
                for (int j = i+1; j < arrayList.size();j++) {
                    String b = arrayList.get(j);
                    HashSet<Character>tempB = startingChar.get(b);
                    if (a.equals(b))continue;
                    for (char k = 'a'; k <= 'z'; k++) {
                        for (char l = (char) (k+1); l <= 'z'; l++) {
                            if (tempA.contains(k)&&tempB.contains(l) && !tempA.contains(l) && !tempB.contains(k))
                                ans+=2;
                            else if (tempA.contains(l)&&tempB.contains(k) && !tempA.contains(k) && !tempB.contains(l))
                                ans += 2;
                        }
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
