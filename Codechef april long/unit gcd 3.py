
# def giveGCD(a, b):
#     while (a != b):
#         if (a > b):
#             a = a - b
#         else:
#             b = b - a
#     return a
# def isCoPrime(num, num2):
#     gcd = giveGCD(num, num2)
#     if gcd == 1:
#         return True
#     else:
#         return False

def minDaysCount(n):
    tot = n // 2
    if tot == 0:
        print(1)
        print(n, end = " ")
        for page in range(1, n+1):
            print(page, end = " ")
        print("")
    else:
        print(tot)
        num = 1
        perLine = n // tot
        arr = []
        for day in range(tot-1):
            cnt = 0
            tempArr = [str(perLine)]
            # print(perLine, end = " ")
            while cnt < perLine:
                tempArr.append(str(num))
                cnt+=1
                num+=1
            arr.append(tempArr)
        rest = n - num + 1
        # print(rest, end=" ")
        tempArr = [str(rest)]
        for page in range(num, n+1):
            # print(page, end = " ")
            tempArr.append(str(page))
        arr.append(tempArr)
        for ar in arr:
            print(' '.join(ar))




t = int(input())
for _ in range(t):
    n = int(input())
    minDaysCount(n)