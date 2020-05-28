t = int(input())
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    arr = list(map(int, input().rstrip().split()))
    check = False
    for pos in range(0, n):
        if pos == n-1:
            if arr[n-2] | arr[0] == k:
                check = True
                break
        if arr[pos-1] | arr[pos+1] == k:
            check = True
            break
    if check:
        