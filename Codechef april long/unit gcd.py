
def giveGCD(a, b):
    while (a != b):
        if (a > b):
            a = a - b
        else:
            b = b - a
    return a
def isCoPrime(num, num2):
    gcd = giveGCD(num, num2)
    if gcd == 1:
        return True
    else:
        return False

def minDaysCount(arr):
    cnt = 0
    res = []
    gcdDict = dict()
    while arr != []:
        arrCo = [arr[0]]
        first = arr[0]
        pos = 0
        arr.pop(0)
        while pos < len(arr):
            num = arr[pos]
            if isCoPrime(first, num):
                arrCo.append(num)
                arr.pop(pos)
                continue
            pos += 1
        # print(arrCo)
        pos = 1
        while pos < len(arrCo):
            pos2 = pos + 1
            while pos2 < len(arrCo):
                if not isCoPrime(arrCo[pos], arrCo[pos2]):
                    arr.append(arrCo[pos2])
                    arrCo.pop(pos2)
                    continue
                pos2+=1
            pos+=1
        # print(arrCo)
        res.append(arrCo)
        arrCo = []
        cnt += 1
    print(cnt)
    for groups in res:
        print(len(groups), end = " ")
        for i in groups:
            print(i, end = " ")
        print("")




t = int(input())
for _ in range(t):
    n = int(input())
    arr = []
    for num in range(n):
        arr.append(num+1)
    minDaysCount(arr)