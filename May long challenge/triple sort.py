import random
t = int(input())
for _ in range(t):
    n, k = map(int , input().rstrip().split())
    arr = list(map(int , input().rstrip().split()))
    # arr = []
    # n = random.randrange(1,10)
    # k = random.randrange(1, n+1)
    hash = {}
    # for i in range(n):
    #     num = random.randrange(1,n+1)
    #     if num not in hash:
    #         arr.append(num)
    #         hash[num] = 0
    #     else:
    #         while num in hash:
    #             num = random.randrange(1, n+1)
    #         arr.append(num)
    #         hash[num] = 0
    # print(arr)
    sortedArr = sorted(arr)
    time = 0
    startPos = 0
    pos1, pos2, pos3 = 0, 0, 0
    result = []
    while sortedArr != arr and time<=k:
        cnt = 0
        pos = 0
        while pos < len(arr):
            if cnt >= 3:
                break
            if sortedArr[pos] != arr[pos]:
                if cnt == 0:
                    pos1 = pos
                    cnt+=1
                elif cnt == 1:
                    pos2 = pos
                    cnt += 1
                else:
                    pos3 = pos
                    cnt += 1
            pos += 1
        if cnt < 3:
            break
        temp = [pos1+1, pos2+1, pos3+1]
        result.append(temp)
        v1 = arr[pos1]
        v2 = arr[pos2]
        v3 = arr[pos3]
        arr[pos1] = v3
        arr[pos2] = v1
        arr[pos3] = v2
        if arr[pos1]!=pos1+1:
            pos = pos1
        else:
            pos = pos1+1
        time += 1
        print(arr)
    if arr == sortedArr:
        print(time)
        for arr in result:
            for num in arr:
                print(num, end=" ")
            print("")
    else:
        print(-1)
