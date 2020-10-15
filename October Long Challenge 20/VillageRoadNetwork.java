import java.io.*;
import java.util.*;

class VillageRoadNetwork {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            long x1 = Long.parseLong(inp[0]), y1 = Long.parseLong(inp[1]);
            long x2 = Long.parseLong(inp[2]), y2 = Long.parseLong(inp[3]);
            if (x1==x2 && y1 == y2){
                sb.append(0+"\n");
                continue;
            }
            HashSet<ArrayList<Long>> visited = new HashSet<>();
            HashMap<ArrayList<Long>, ArrayList<Long>> parents = new HashMap<>();
            Queue<ArrayList<Long>> queue = new LinkedList<>();
            queue.add(new ArrayList<>(Arrays.asList(x1, y1)));
            visited.add(new ArrayList<>(Arrays.asList(x1, y1)));
            while (queue.size() != 0) {
                ArrayList<Long> temp = queue.remove();
                long x = temp.get(0), y = temp.get(1);
                ArrayList<Long> east = new ArrayList<>(Arrays.asList(x + 2 * y, y));
                ArrayList<Long> west = new ArrayList<>(Arrays.asList(x - 2 * y, y));
                ArrayList<Long> north = new ArrayList<>(), south = new ArrayList<>();
                if (y + 2 * x < 0)
                    north.add(-x);
                else
                    north.add(x);
                north.add(Math.abs(y + 2 * x));
                if (y - 2 * x < 0)
                    south.add(-x);
                else
                    south.add(x);
                south.add(Math.abs(y - 2 * x));
                if (visited.add(east)) {
                    parents.put(east, temp);
                    if (!(east.get(0)>x2&&east.get(1)>y2))
                    queue.add(east);
                }
                if (visited.add(west)) {
                    parents.put(west, temp);
                    if (!(west.get(0)>x2&&west.get(1)>y2))
                    queue.add(west);
                }
                if (visited.add(north)) {
                    parents.put(north, temp);
                    if (!(north.get(0)>x2&&north.get(1)>y2))
                    queue.add(north);
                }
                if (visited.add(south)) {
                    parents.put(south, temp);
                    if (!(south.get(0)>x2&&south.get(1)>y2))
                        queue.add(south);
                }
                if (x2 == north.get(0) && y2 == north.get(1))
                    break;
                if (x2 == south.get(0) && y2 == south.get(1))
                    break;
                if (x2 == east.get(0) && y2 == east.get(1))
                    break;
                if (x2 == west.get(0) && y2 == west.get(1))
                    break;
            }
            int cnt = 0;
            ArrayList<Long> present = new ArrayList<>(Arrays.asList(x2, y2));
            while (true) {
                ArrayList<Long>temp = parents.get(present);
                cnt++;
                if (temp.get(0)==x1 && temp.get(1)==y1)
                    break;
                present = temp;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
