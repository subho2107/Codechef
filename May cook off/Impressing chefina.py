import collections
t = int(input())
for _ in range(t):
    row, col = map(int, input().rstrip().split())
    arr = []
    hashMap = collections.defaultdict(int)
    for _ in range(row):
        a = input().rstrip().split()
        for num in a:
            hashMap[num] += 1
        arr.append(a)
    cntOfOdd = 0
    arrOfOdds = []
    for num in hashMap:
        if hashMap[num]%2!=0:
            cntOfOdd += 1
            arrOfOdds.append(num)
            hashMap[num] -= 1
    if (cntOfOdd >  0 and col%2 == 0) or (col%2 != 0 and cntOfOdd > row):
        print(-1)
    else:
        for rowPos in range(row):
            for colPos in range(col//2):
                if colPos != col - colPos - 1:
                    temp = ''
                    for num in hashMap:
                        if hashMap[num] != 0:
                            temp = num
                            break
                    num = temp
                    arr[rowPos][colPos] = num
                    arr[rowPos][col - colPos - 1] = num
                    hashMap[num] -= 2
        for num in hashMap:
            if hashMap[num] != 0:
                for i in range(hashMap[num]):
                    arrOfOdds.append(num)
        if col%2!=0:
            for rowPos in range(0, row):
                arr[rowPos][col // 2] = arrOfOdds[rowPos]
        for posRow in range(row):
            print(' '.join(arr[posRow]))
