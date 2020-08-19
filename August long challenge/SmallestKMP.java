import java.io.*;
import java.util.*;

public class SmallestKMP {
    public static String repeat(char ch, HashMap<Character, Integer>freq){
        String rep = "";
        for (int pos = 0; pos < freq.get(ch); pos++) {
            rep += ch;
        }
        return rep;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String text = buffer.readLine(), pattern = buffer.readLine();
            HashMap<Character, Integer>freq = new HashMap<>();
            for (char ch:text.toCharArray())
                freq.put(ch, freq.getOrDefault(ch, 0)+1);
            char temp = pattern.charAt(0), temp2 = temp;
            boolean check = false;
            for (char ch:pattern.toCharArray()) {
                freq.put(ch, freq.get(ch) - 1);
                if(!check && ch != temp)
                {
                    temp2 = ch;
                    check = true;
                }
            }
            ArrayList<Character>chars = new ArrayList<>(freq.keySet());
            Collections.sort(chars);
            String front = "", back = "";
            int i = 0;
            for (;i<chars.size();i++){
                char ch = chars.get(i);
                String rep = repeat(ch, freq);
                if (ch<temp) {
                    front += rep;
                }
                else
                    break;
            }
            if (i!=chars.size()){
                String rep = repeat(chars.get(i), freq);
                if (chars.get(i)==temp){
                    if (chars.get(i)<temp2){
                        front+=rep;
                        i++;
                    }
                }
                for (; i<chars.size(); i++){
                    rep = repeat(chars.get(i), freq);
                    back+=rep;
                }
            }
            sb.append(front+pattern+back+"\n");

        }
        System.out.println(sb);
    }
}
