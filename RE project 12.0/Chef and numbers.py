import random
t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    # arr = []
    # for pos in range(random.randrange(1,10)):
    #     arr.append(random.randrange(1,3))
    hashtypes = {}
    for num in arr:
        if num not in hashtypes:
            hashtypes[num] = None
    # print(arr)
    # print(hashtypes)
    for type in hashtypes:
        cnt = 0
        pos = 0
        while pos < len(arr):
            num = arr[pos]
            if num == type:
                cnt += 1
                pos += 2
            else:
                pos+=1
        hashtypes[type] = cnt
        # if cnt > maxCnt:
        #     maxCnt = cnt
            # maxType = type
    # print(hashtypes)
    maxCnt = max(hashtypes.values())
    minKey = 99999
    for type in hashtypes:
        if hashtypes[type] == maxCnt and type < minKey:
            minKey = type
    print(minKey)