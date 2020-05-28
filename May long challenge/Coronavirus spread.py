t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    bestCase = float("inf")
    worstCase = float("-inf")
    for pos in range(len(arr)):
        back = pos
        affected = 1
        while back >= 1 and arr[back] - arr[back-1] <= 2:
            affected += 1
            back -= 1
        forward = pos
        while forward <= n-2 and arr[forward+1] - arr[forward] <= 2 :
            affected += 1
            forward += 1
        bestCase = min(bestCase, affected)
        worstCase = max(worstCase, affected)
    print(bestCase, worstCase)

