import java.io.*;
import java.util.*;

class UnusualQueries {
    static int[] next;

    static void fillNext(int[] a, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (s.size() > 0) {
                int cur = s.peek();
                if (a[cur] < a[i]) {
                    next[cur] = i;
                    s.pop();
                } else
                    break;
            }
            s.push(i);
        }
        while (s.size() > 0) {
            int cur = s.peek();
            next[cur] = -1;
            s.pop();
        }
    }

    static void fillCnt(int[] fwdCnt, int[] tillCurrCnt) {
        Arrays.fill(fwdCnt, 1);
        int n = next.length;
        for (int pos = n - 1; pos >= 0; pos--) {
            int nextGreater = next[pos];
            if (nextGreater == -1)
                continue;
            fwdCnt[pos] = fwdCnt[nextGreater] + 1;
        }
        Arrays.fill(tillCurrCnt, 1);
        for (int i = 0; i < n; i++) {
            if (next[i] == -1)
                continue;
            tillCurrCnt[next[i]] = Math.max(tillCurrCnt[next[i]], tillCurrCnt[i] + 1);
        }
    }

    static int recursivelySearchMaxElement(int[] arr, int[] segmentTree, int rangeStart, int rangeEnd, int l, int r, int currNode) {
        if (l <= rangeStart && r >= rangeEnd)
            return segmentTree[currNode];
        if (l > rangeEnd || r < rangeStart)
            return -1;
        int mid = rangeStart + (rangeEnd - rangeStart) / 2;
        int left = recursivelySearchMaxElement(arr, segmentTree, rangeStart, mid, l, r, currNode * 2 + 1);
        int right = recursivelySearchMaxElement(arr, segmentTree, mid + 1, rangeEnd, l, r, currNode * 2 + 2);
        if (left == -1)
            return right;
        else if (right == -1)
            return left;
        if (arr[left] > arr[right])
            return left;
        else
            return right;
    }

    static int getMaxInRange(int[] arr, int[] segmentTree, int l, int r, int n) {
        return recursivelySearchMaxElement(arr, segmentTree, 0, n - 1, l, r, 0);
    }

    static int builtSegmentTreeRecursively(int[] arr, int[] segTreeArr, int rangeStart, int rangeEnd, int currNode) {
        if (rangeStart == rangeEnd) {
            segTreeArr[currNode] = rangeEnd;
        } else {
            int mid = rangeStart + (rangeEnd - rangeStart) / 2;
            int left = builtSegmentTreeRecursively(arr, segTreeArr, rangeStart, mid, (2 * currNode) + 1);
            int right = builtSegmentTreeRecursively(arr, segTreeArr, mid + 1, rangeEnd, (2 * currNode) + 2);
            segTreeArr[currNode] = arr[left] > arr[right] ? left : right;
        }
        return segTreeArr[currNode];
    }

    static int[] constructSegmentTree(int[] arr) {
        int n = arr.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int sizeOfSegmentTreeArr = 2 * (1 << height) - 1;
        int[] segmentTreeArr = new int[sizeOfSegmentTreeArr];
        builtSegmentTreeRecursively(arr, segmentTreeArr, 0, n - 1, 0);
        return segmentTreeArr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]), s = Integer.parseInt(inp[2]);
        int[] heights = new int[n];
        inp = buffer.readLine().split(" ");
        for (int i = 0; i < n; i++)
            heights[i] = Integer.parseInt(inp[i]);
        int previousAns = 0;
        next = new int[n];
        fillNext(heights, n);
        int[] fwdCnt = new int[n], tillCurrCnt = new int[n];
        fillCnt(fwdCnt, tillCurrCnt);
        int[] segmentTreeHeights = constructSegmentTree(heights);
        int[] segmentTreeTillCurr = constructSegmentTree(tillCurrCnt);
        int[] segmentTreeNextGreater = constructSegmentTree(fwdCnt);
        for (int i = 0; i < q; i++) {
            inp = buffer.readLine().split(" ");
            int L = Integer.parseInt(inp[0]), R = Integer.parseInt(inp[1]);
            L = (L + s * previousAns - 1) % n;
            R = (R + s * previousAns - 1) % n;
            if (L > R)
                L = L ^ R ^ (R = L);
            int maxValPos = getMaxInRange(heights, segmentTreeHeights, L, R, n);
            int l = getMaxInRange(fwdCnt, segmentTreeNextGreater, L, maxValPos, n);
            int ans1 = fwdCnt[l] - fwdCnt[maxValPos] + 1;
            int ans2=0;
            if (maxValPos+1<=R)
            ans2 = tillCurrCnt[getMaxInRange(tillCurrCnt, segmentTreeTillCurr, maxValPos + 1, R, n)];
            previousAns = Math.max(ans1, ans2);
            sb.append(previousAns).append("\n");
        }
        System.out.println(sb);
    }
}