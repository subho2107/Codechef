import math


def F(x, y, z):
    return (x&z)*(y&z)

t = int(input())
for _ in range(t):
    x, y, l, r = map(int, input().rstrip().split())
    pos = int(math.log2(r))
    z1 = 0#already less than r
    z2 = 0#already greater than l
    while l>>pos&1 == r>>pos&1 and pos>=0:
        pos-=1
    z2 += 1<<pos
    currMax = float("-inf")
    for posForZ1 in range(pos-1, -1, -1):
        if not l>>posForZ1&1:
            z1 += 1>>posForZ1#setting the bit to make it grater than l
        dupZ1 = z1
        for rest in range(posForZ1-1, -1, -1):
            if l>>rest&1 or r>>rest&1:#to minimize the value
                dupZ1 += 1>>rest
        value = F(x, y, dupZ1)
        if value > currMax:
            currMax = value
    for posForZ2 in range(pos-1, -1, -1):
        dupZ2 = posForZ2
#unsetting the bit to make it less than r
        for rest in range(posForZ2-1, -1, -1):
            if l>>rest&1 or r>>rest&1:#to minimize the value
                dupZ2 += 1>>rest
        value = F(x, y, dupZ2)
        if value > currMax:
            currMax = value
    print(currMax)


