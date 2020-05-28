import random
t = int(input())
for _ in range(t):
    n, k = map(int , input().rstrip().split())
    arr = list(map(int , input().rstrip().split()))
    sortedArr = sorted(arr)
    time = 0

    result = []

    length = len(arr)
    posLast = length
    pos1, pos2, pos3 = 0, posLast-2, posLast-1
    while pos1 < length-1 and sortedArr != arr:
        temp = [pos1+1, pos2+1, pos3+1]
        result.append(temp)
        v1 = arr[pos1]
        v2 = arr[pos2]
        v3 = arr[pos3]
        arr[pos1] = v3
        arr[pos2] = v1
        arr[pos3] = v2
        pos1+=1
        print(arr)
        while arr[posLast-1] == posLast:
            posLast -= 1
        pos2, pos3 = posLast - 2, posLast - 1
        time += 1
    if arr == sortedArr:
        print(time)
        for arr in result:
            for num in arr:
                print(num, end=" ")
            print("")
    else:
        print(-1)
