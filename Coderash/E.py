import math
def truncate(f, n):
    return math.floor(f * 10 ** n) / 10 ** n
t = int(input())
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    totalLevels = 0
    if n&1:
        totalLevels = (n-1)//2+1
    else:
        totalLevels = n//2
    time = 0
    start = 1
    for level in range(totalLevels):
        time += k/(2*start + 1)
        start = n+1
        change = 0
        if n&1:
            change = (n-1)//2+1
        else:
            change = n//2
        n += change
    print(time)
    print(truncate(time, 6))