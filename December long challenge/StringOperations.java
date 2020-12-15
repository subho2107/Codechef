import java.io.*;
import java.util.*;

class StringOperations {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine();
            HashMap<Integer, HashMap<Integer, HashSet<Integer>>> substrings = new HashMap<>();
            int n = s.length();
            int[] prefixOneCnt = new int[n + 1];
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == '1') {
                    cnt++;
                }
                prefixOneCnt[i] = cnt;
            }
            for (int i = 0; i < s.length(); i++) {
                ArrayList<Character> temp = new ArrayList<>();
                int onesAtStart = 0, pos = -1, penUltimateOnePos = -1;
                for (int j = i; j < s.length(); j++) {
                    temp.add(s.charAt(j));
                    int currOnes = prefixOneCnt[j + 1] - prefixOneCnt[i];
                    if (s.charAt(j) == '1') {
                        if (i == j) {
                            onesAtStart++;
                            pos = 0;
                        }else {
                            if (penUltimateOnePos == -1) {
                                penUltimateOnePos = j - i;
                                pos = penUltimateOnePos;
                            }
                            else{
                                pos = getCorrectPos(onesAtStart, penUltimateOnePos, j-i);
                                onesAtStart++;
                                if (s.charAt(j) == '1' && j-i-penUltimateOnePos == 1){
                                    onesAtStart++;
                                    penUltimateOnePos = -1;
                                }else
                                    penUltimateOnePos = pos;
                            }
                        }
                    }

                    if (!substrings.containsKey(temp.size()))
                        substrings.put(temp.size(), new HashMap<>());
                    if (!substrings.get(temp.size()).containsKey(currOnes))
                        substrings.get(temp.size()).put(currOnes, new HashSet<>());
                    substrings.get(temp.size()).get(currOnes).add(pos);
//                    System.out.println(temp.toString()+" "+pos);
                }
            }
            int ans = 0;
            for (HashMap<Integer, HashSet<Integer>> value : substrings.values()) {
                for (HashSet<Integer> strings : value.values()) {
                    ans += strings.size();
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static int getCorrectPos(int firstPos, int toBeSwapped, int lastPos) {
        int pos;
        int midPos = (lastPos+firstPos)/2;
        int diff = midPos - toBeSwapped;
        if (diff >= 0)
        {
            pos = diff+midPos;
            if ((lastPos-firstPos+1) % 2 == 0)
                pos++;
        }else {
            diff *= -1;
            pos = midPos-diff;
            if ((lastPos-firstPos+1) % 2 == 0)
                pos++;
        }
        return pos;
    }
}
