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
def toBinary(num):
    binary = ""
    while num > 0:
        binary += str(num%2)
        num = num >> 1
    return binary[::-1]
def toDeci(num, length):
    deci = 0
    for pos in range(0, len(num)):
        deci += (1 << (length-pos-1))*int(num[pos])
    return deci


def powerOf2(num):
    return num and (not(num&(num-1)))


def getSecond(small, big, res = 0):
    diff = len(big)- len(small)
    pos = 0
    lengthOfSmall = len(small)
    while pos < lengthOfSmall:
        if small[pos] == '1' or big[pos+diff] == '1':
            res += 1 << (lengthOfSmall-pos-1)
        pos += 1
    return res
# def computeFarther2():

def computeFurther(binNum):
    possVal = 0
    length = len(binNum)
    cnt = length - 1
    for pos in range(0, length):
        tempVal = possVal + (1 << cnt)
        if int(binNum[pos]) and tempVal <= r:
            possVal += 1 << cnt
        cnt -= 1
    return possVal


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
        binaryX = toBinary(x)
        binaryY = toBinary(y)

        if len(binaryY) == len(binaryX):
            secondPart = getSecond(binaryX, binaryY)
            finalResult = secondPart
        else:
            val = toDeci(binaryY[0:len(binaryY) - len(binaryX)], len(binaryY))
            secondPart = getSecond(binaryX, binaryY, val)
            finalResult = secondPart
    if finalResult > r:
        binaryForm = toBinary(finalResult)
        maxProduct = (x&finalResult)*(y&finalResult)
        finalResult = computeFurther(binaryForm)
    temp = brute()
    print(temp)
    if finalResult != temp:
        print("FAILED HERE")
        print(finalResult, (x&finalResult)*(y&finalResult))
        print(temp, (x&temp)*(y&temp))
        # break
"""
23 72 0 20
23 5 0 >23

6 52 0 33 my is 31 right is 22
11 28 0 29 my is 29 right is 27

1 86 0 5
80 46 0 9
72 90 0 7
30 11 0 1
30 98 0 13
"""