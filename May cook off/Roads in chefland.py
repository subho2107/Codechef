t = int(input())
answer = ''
for _ in range(t):
    n = int(input())
    if not n&(n-1):
        answer += '-1\n'
        continue
    oddNumCnt = (n+1)//2
    cost = oddNumCnt-1
    currCost = 2
    while currCost < n:
        cost += ((n-currCost)//(2*currCost))*currCost + currCost
        currCost <<= 1
    answer += str(cost)+"\n"
print(answer)