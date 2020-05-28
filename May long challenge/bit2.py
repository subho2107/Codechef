import random
import time


def my():
    if (startOfSecondPart < len(binaryY) and startOfSecondPart < len(binaryX)) or (len(binaryX) == len(binaryY)):
        # print(firstPart)
        return firstPart
    else:
        res = firstPart
        pos = startOfSecondPart
        bigger = binaryX if len(binaryX) > len(binaryY) else binaryY

        while pos < len(bigger):
            temp = res + (int(bigger[pos])*int(pow(2, pos)))
            if temp > r:
                break
            res = temp
            pos += 1
        # print(res)
        return res
def test():
    z = 0
    maxPro = float("-inf")
    for num in range(l, r+1):
        pro = (x&num)*(y&num)
        if pro > maxPro:
            maxPro  = pro
            z = num
    return z
def toBinary(num):
    binary = ""
    while num > 0:
        binary += str(num%2)
        num //= 2
    return binary
def getFirst(num, num2, r):
    res = 0
    small = num2 if len(num2) < len(num) else num
    big = num if len(num) > len(num2) else num2
    pos = 0
    while pos < len(small):
        if small[pos] == '1' or big[pos] == '1':
            if res + int(pow(2,pos)) > r:
                return (pos, res)
            res += int(pow(2,pos))
        pos += 1
    return (pos, res)

t = int(input())
for _ in range(t):
    # x, y = random.randrange(1,50), random.randrange(1,50)
    # l = random.randrange(1,50)
    # r = random.randrange(l+1, 100)
    # print(x, y, l, r)
    x, y, l, r = map(int, input().rstrip().split())

    binaryX = toBinary(x)
    binaryY = toBinary(y)
    # print(binaryY, binaryX)
    startOfSecondPart, firstPart = getFirst(binaryX, binaryY, r)
    # print(firstPart)
    # print("l", l)
    # nb = my()
    l = my()
    # print("l", l,nb)
    ans1 = test()
    # ans2 = test()
    # if ans1 == ans2:
    #     print("ok", ans1)
    # else:
    #     print("no", ans1, ans2)
    #     print((x&ans1)*(y&ans1))
    #     print((x&ans2)*(y&ans2))
    #     break
    print(time.time())
    print(ans1)
    print(time.time())