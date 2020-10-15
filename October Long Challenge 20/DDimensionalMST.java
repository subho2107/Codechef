import java.io.*;
import java.lang.*;
import java.util.*;

class DDimensionalMST {
    static int [] dsu, rank;
    static int getSet(int vertex){
        if (dsu[vertex] == vertex)
            return vertex;
        else
            return dsu[vertex] = getSet(dsu[vertex]);
    }
    static void union(int a, int b){
        a = getSet(a);
        b = getSet(b);
        if (a != b) {
            if (rank[a] < rank[b])
                a = a^b^(b = a);
            dsu[b] = a;
            if (rank[a] == rank[b])
                rank[a]++;
        }
    }
    static class Pair {
        int first, second;

        Pair(int x, int y) {
            first = x;
            second = y;
        }
    }
    static class Edge{
        int src, dst, weight;
        Edge(int a, int b, int c){
            src = a;
            dst = b;
            weight = c;
        }
    }
    static class ComparePair implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.first != o2.first)
                return o1.first - o2.first;
            else if (o1.second != o2.second)
                return o1.second - o2.second;
            else
                return 0;
        }
    }
    static class CompareEdges implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o2.weight - o1.weight;
        }
    }
    public static int getWeight(int [][] point, int u, int v){
        int sum = 0;
        for (int i = 0; i < point[0].length; i++) {
            sum += Math.abs(point[u][i]-point[v][i]);
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), d = Integer.parseInt(inp[1]);
        int[][] points = new int[n][d];
        for (int i = 0; i < n; i++) {
            inp = buffer.readLine().split(" ");
            for (int j = 0; j < d; j++) {
                points[i][j] = Integer.parseInt(inp[j]);
            }
        }
        ArrayList<Edge> edges = new ArrayList<>();//This contains the reduced edges
        for (int mask = 0; mask < (1 << d)/2; mask++) {
            /*ArrayList<Pair> temp = new ArrayList<>();//will store the mask sum
            The above statement is not required because we can compute max and min
            in constant amount of time rather than doing all of this time consuming task.
            */
            int maxW=-1, maxIndex =-1, minW=-1, minIndex=-1;
            /*Instead of sorting at the last which is time consuming,
            I have taken the max and min here only with O(1) Computation
            See how it works?*/
            for (int arrPos = 0; arrPos < n; arrPos++) {
                int sum = 0;
                for (int dimPos = 0; dimPos < d; dimPos++) {
                    if (((mask >> dimPos) & 1) == 1)
                        sum += points[arrPos][dimPos];
                    else
                        sum -= points[arrPos][dimPos];
                    // temp.add(new Pair(sum, arrPos)); This thing now is not required
                }
                if(maxIndex==-1 || sum>maxW){
                    maxIndex = arrPos;
                    maxW = sum;
                }
                if(minIndex==-1 || sum<minW){
                    minIndex = arrPos;
                    minW = sum;
                }
            }//for loop to iterate over all points for a specific dimention ends here
            for(int i=0;i<n;i++){
                edges.add(new Edge(i, minIndex, getWeight(points, minIndex, i)));
                edges.add(new Edge(i, maxIndex, getWeight(points, maxIndex, i)));
            }

            /*Now we don't need all of this just 1 loop above will do the trick and also
            if you want you can remove the self edge of minIndex and maxIndex doesn't matter that much.*/

            // int indexOfSmallest = Collections.min(temp, new ComparePair()).second;//index with smallest mask value
            // int indexOfLargest = Collections.max(temp, new ComparePair()).second;//index with largest mask value
            // for (int i = 0; i < n; i++) {
            //     if (i != indexOfLargest) {
            //         edges.add(new Edge(i, indexOfLargest, getWeight(points, indexOfLargest, i)));//edges in the form source destination and weight
            //         edges.add(new Edge(indexOfLargest, i, getWeight(points, indexOfLargest, i)));
            //     }
            //     if (i != indexOfSmallest) {
            //         edges.add(new Edge(i, indexOfSmallest, getWeight(points, indexOfSmallest, i)));
            //         edges.add(new Edge(indexOfSmallest, i, getWeight(points, indexOfSmallest, i)));
            //     }
            // }
        }
        edges.sort(new CompareEdges());//sorts on the basis of weight in reverse order
        dsu = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            dsu[i] = i;
        }
        long maxWeight = 0;
        for (Edge edge : edges) {
            int pointA = edge.src, pointB = edge.dst;
            if (getSet(pointA)!=getSet(pointB)) {//if cycle does not form after edge is added
                union(pointA, pointB);//then do union or add the edge under mst
                maxWeight += edge.weight;
            }
        }
        System.out.println(maxWeight);
    }

}

