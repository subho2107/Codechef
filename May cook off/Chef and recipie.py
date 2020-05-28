import collections

t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    check = True
    hashFreq = collections.defaultdict(int)
    hashFreq[arr[0]] += 1
    hashAppearance = {arr[0]:1}
    for pos in range(1, n):
        hashFreq[arr[pos]] += 1
        if arr[pos] == arr[pos-1] or arr[pos] not in hashAppearance:
            hashAppearance[arr[pos]] = None
        else:
            check = False
            break
    # print(hashAppearance)
    # print(hashFreq)
    if not  check:
        print("NO")
        continue
    else:
        check = True
        hashAppearance = {}
        for num in hashFreq:
            freq = hashFreq[num]
            if freq not in hashAppearance:
                hashAppearance[freq] = None
                continue
            else:
                check = False
                break
        if check:
            print("YES")
        else:
            print("NO")