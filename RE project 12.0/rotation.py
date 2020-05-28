import bisect

t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    if arr == sorted(arr):
        print(1)
    hash = {}
    for num in arr:
        if num not in arr:
            hash[num] = None
    nums = hash.keys()
    cnt = 1
    dup = arr[:]
    for num in nums:
        pos = bisect.bisect(dup, num)-1
        if pos >= 0 and pos <= len(arr)-1:
            dup = dup[pos+1:]
        else:
            dup = arr[:]
            cnt += 1
    print(cnt)
