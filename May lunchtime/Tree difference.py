import os
import sys
from io import BytesIO, IOBase
import collections
def inputIntArray():return list(map(int, input().rstrip().split()))
def inputArray():return input().rstrip().split()
def inputVars():return map(int, input().rstrip().split())
def inputNum():return int(input())
sys.setrecursionlimit(100000)
def dfs(graph, depth, parent, currNode, parentNode):
    parent[currNode] = parentNode
    for nbr in graph[currNode]:
        if nbr != parentNode:
            depth[nbr] = depth[currNode]+1
            dfs(graph,depth,parent,nbr,currNode)


def getQueryResult(graphValues, depth, parent, src, dst):
    if depth[src] > depth[dst]:
        src, dst = dst, src
    values = [0]*101#Stores the numbers encountered in the path between source and destination
    while depth[dst] > depth[src]:#This loop backtracks to get to same level
        if values[graphValues[dst]] > 0: return 0#This type of check is for detecting duplicate values
        values[graphValues[dst]] += 1
        dst = parent[dst]

    while src != dst:#This is for reaching LCA
        if values[graphValues[src]] > 0 : return 0
        values[graphValues[src]] += 1
        if values[graphValues[dst]] > 0: return 0
        values[graphValues[dst]] += 1
        src, dst = parent[src], parent[dst]
    if values[graphValues[src]] > 0 : return 0#Done outside the loop so as to avoid duplicate
    values[graphValues[src]] += 1
    #Finallly now we have to count the differences and find t   he minimum absolute difference
    previousValue, ans = -1, 200
    for number in range(1,101):
        if values[number] > 0:
            if previousValue != -1:
                ans = min(ans, number-previousValue)
            previousValue = number
    return ans



def main():
    for _ in range(inputNum()):
        noOfNodes, noofQueries = inputVars()
        nodes = inputIntArray()
        graph = collections.defaultdict(list)
        for pos in range(noOfNodes-1):
            src, dst = inputVars()
            graph[src-1].append(dst-1)
            graph[dst-1].append(src-1)
        depth = [0]*noOfNodes
        parent = [0]*noOfNodes
        dfs(graph, depth, parent, 0, -1)#This is for marking all the parents of nodes and their depths
        for pos in range(noofQueries):
            src, dst = inputVars()
            print(getQueryResult(nodes, depth, parent, src-1, dst-1))


#.........................................FAST INPUT OUTPUT.......................................
BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

#....................................END OF FAST I/O............................................

if __name__ == "__main__":
    main()