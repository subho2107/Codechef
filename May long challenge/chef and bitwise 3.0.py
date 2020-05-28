import random
import math
def brute():
    z = 0
    maxPro = float("-inf")
    for num in range(l, r + 1):
        pro = (x & num) * (y & num)
        if pro > maxPro:
            maxPro = pro
            z = num
    return z

def getSecond(small, big, res = 0):
    pos = 0
    lengthOfBig = int(math.log2(big))+1
    lenOfR = int(math.log2(r))+1
    maxValOfR = (1<<lenOfR)-1
    lengthOfSmall = int(math.log2(small))+1
    dup = res
    while pos < lengthOfBig:
        value =  res + (1 << pos)
        if ((small>>pos)&1 or (big>>pos)&1) and value<=r:
            if not (pos < lengthOfSmall and  not (small>>pos)&1 and (maxValOfR-((1<<(pos+1)) - 1)+res) <= r):
                res += 1 << (pos)
        # elif (big>>pos)&1 and pos > lengthOfSmall-1 and value<=r:
        #     res += 1 << (pos)
        pos += 1
    while pos < lengthOfBig:
        value =  dup + (1 << pos)
        if ((small>>pos)&1 or (big>>pos)&1) and value<=r:
            if not (pos < lenOfR-1 and  not (small>>pos)&1 and (maxValOfR-((1<<(pos+1)) - 1)+dup) <= r):
                dup += 1 << (pos)
        pos+=1
    product1 = (x&res)*(y&res)
    product2 = (x&dup)*(y&dup)
    if product2 > product1:
        return dup
    elif product1 == product2:
        if dup < res:
            return dup
    return res

t = int(input())
for _ in range(t):
    # x, y = random.randrange(0,100), random.randrange(0,100)
    # l = 0
    # r = random.randrange(random.randrange(0,100))
    # print(x, y, l, r)
    x, y, l, r = map(int, input().rstrip().split())
    finalResult = 0
    if x == 0 or y == 0:
        finalResult = 0
    elif l == r:
        finalResult = l
    elif r == 0:
        finalResult = r
    else:
        maxPro = float("-inf")
        temp = x
        x = min(x, y)
        y = max(temp, y)

        finalResult = getSecond(x, y)
        if (finalResult&x)*(finalResult&y) == 0:
            finalResult = 0

    temp = brute()
    print(temp)
    if finalResult != temp:
        print("FAILED HERE")
        print(finalResult, (x&finalResult)*(y&finalResult))
        print(temp, (x&temp)*(y&temp))
        # break
"""
23 72 0 20
23 5 0 25

6 52 0 33 my is 31 right is 22
# 11 28 0 29 my is 29 right is 27 .kj;j;ljl;j;kj

1 86 0 5
80 46 0 9
72 90 0 7
30 11 0 1
# 30 98 0 13 ;ljj;ljjl;j
"""
'''
# 9 30 42 51
# NO
# My value is 51
# Correct value is 47


NO
My value is 11
Correct value is 54
37 42 22 99
21 34 47 62
NO
My value is 8
Correct value is 55
46 23 44 46 this is not working
NO
My value is 7
Correct value is 46
4 41 31 53 this is not working
NO
My value is 18
Correct value is 45

10111
  101
-----

'''