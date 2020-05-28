import math
t = int(input())
for _ in range(t):
    x, y, l, r = map(int, input().rstrip().split())
    temp = x
    x = max(x, y)

    y = min(y, temp)
    lenOfR = int(math.log2(r))+1
    pos = lenOfR-1

    hashMap = {}
    dupR = r
    hashMap[(r & x) * (r & y)] = r
    maxPro = float("-inf")
    val = 0
    while pos >= 0:
        eitherOne = ((x >> pos) & 1) | ((y >> pos) & 1)
        if (r>>pos)&1:
            temp = val + (1 << pos)-1
            tempPro = (temp & x) * (temp & y)
            temp2 = r - (1 << pos)
            tempPro2 = (temp2 & x) * (temp2 & y)
            # if tempPro >= maxPro and (not(pos > 0 and (1<<pos)-1 < l) or (not eitherOne and r-(1<<pos)>=l)):
            if  temp >= l and (not (tempPro2 < maxPro and tempPro2 == 0)):
                r -= 1<<pos
                hashMap[(r & x) * (r & y)] = r
                if (r & x) * (r & y) > maxPro:
                    maxPro = (r & x) * (r & y)
                print(r, (r & x) * (r & y))
            else:
                val += 1<<pos
        else:
            temp = r + (1<<pos)
            tempPro = (temp & x) * (temp & y)
            if  temp <= dupR:
                r += 1<<pos
                hashMap[(r & x) * (r & y)] = r
                if (r & x) * (r & y) > maxPro:
                    maxPro = (r & x) * (r & y)
                val += 1<<pos

        pos-=1
    result = hashMap[max(hashMap.keys())]
    print(result)