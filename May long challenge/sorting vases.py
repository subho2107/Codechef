def swap(pos1, pos2):
    temp = arr[pos1]
    arr[pos1] = arr[pos2]
    arr[pos2] = temp
    dictOfPos[arr[pos1]] = pos1
    dictOfPos[arr[pos2]] = pos2
def initialSorting():
    for pos in range(0, len(arr)):
        if arr[pos] != pos+1:
            posReq = dictOfPos[pos+1]
            if (pos, posReq) in dictOfroboSwaps or (posReq, pos) in dictOfroboSwaps:
                swap(pos, posReq)

t = int(input())
for _ in range(t):
    n, m = map(int, input().rstrip().split())
    arr = list(map(int, input().rstrip().split()))
    dictOfroboSwaps = {}
    dictOfPos = {}
    for pos in range(0, len(arr)):
        dictOfPos[arr[pos]] = pos
    for i in range(m):
        x, y = map(int, input().rstrip().split())
        dictOfroboSwaps[(x-1, y-1)] = None
    cnt = 0
    sortedArr = [num for num in range(1, len(arr)+1)]
    if arr == sortedArr:
        print(0)
    else:
        initialSorting()
        if arr == sortedArr:
            print(0)
        else:
            for pos in range(0, len(arr)):
                if arr[pos] != pos + 1:
                    posReq = dictOfPos[pos + 1]
                    if not ((pos, posReq) in dictOfroboSwaps or (posReq, pos) in dictOfroboSwaps):
                        cnt+=1
                    swap(pos, posReq)
            print(cnt)

"""
3
3 1
2 3 1
2 3

5 10
2 4 5 1 3
1 2
1 3
1 4
1 5
2 3
2 4
2 5
3 4
3 5
4 5

4 1
3 1 4 2
1 2
"""