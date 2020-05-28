def getProfit(arr):
    n = len(arr)
    arr.sort()
    year = 1
    profit = arr[n-1]
    lim = int(pow(10,9))+7
    for pos in range(n-2, -1, -1):
        price = arr[pos]
        if price - year > 0:
           profit = (profit%lim) + price - year
        else:
            break
        year+=1
    return profit%lim

t = int(input())
for _ in range(t):
    input()
    arr = list(map(int, input().rstrip().split()))
    profit = getProfit(arr)
    print(profit)