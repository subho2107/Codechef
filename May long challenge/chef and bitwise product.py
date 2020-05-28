import random
def bruteForce(x,y,l,r):
    maxVal = -1
    zMax = 0
    for num in range(l, r+1):
        temp = F(x,y,num)
        if temp > maxVal:
            maxVal = temp
            zMax = num
    return zMax
class Bit:
    def setBit(self, num, pos):
        return num|(1<<pos)
    def unsetBit(self, num, pos):
        return num&(~(1<<pos))
    def getBit(self, num, pos):
        return num&(1<<pos)
def F(x, y, z):
    return (x&z)*(y&z)
t = int(input())
for _ in range(t):
    x, y, l, r = map(int, input().rstrip().split())
    bitObj = Bit()
    pos = 39
    while bitObj.getBit(l, pos) == bitObj.getBit(r, pos) and pos>0:
        pos-=1
    currMax = float("-inf")
    z = 0
    possibleValues = [l,r]
    for posForZ1 in range(pos-1, -1, -1):
        if bitObj.getBit(l, posForZ1):
            continue
        z1 = bitObj.setBit(l, posForZ1)
        for rest in range(posForZ1-1, -1, -1):
            if bitObj.getBit(x, rest) or bitObj.getBit(y, rest):#to minimize the value
                z1 = bitObj.setBit(z1, rest)
            else:
                z1 = bitObj.unsetBit(z1, rest)
        possibleValues.append(z1)
    for posForZ2 in range(pos-1, -1, -1):
        if not bitObj.getBit(r, posForZ2):
            continue
        z2 = bitObj.unsetBit(r, posForZ2)#unsetting the bit to make it less than r
        for rest in range(posForZ2-1, -1, -1):
            if bitObj.getBit(x, rest) or bitObj.getBit(y, rest):#to minimize the value
                z2 = bitObj.setBit(z2, rest)
            else:
                z2 = bitObj.unsetBit(z2, rest)
        possibleValues.append(z2)
    possibleValues.sort()
    for num in possibleValues:
        value = F(x,y, num)
        if value > currMax:
            z = num
            currMax = value
    # if z!= bruteForce(x,y,l,r):
    print(z)
        # break

#
#
