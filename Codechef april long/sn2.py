lim = int(pow(10,7))
factors = [0]*(lim+1)
X = 0
K = 0
mod = 1000000007

from math import sqrt

def mult(a, b):
    return ((a % mod) * (b % mod)) % mod
def calculate_factors(n):
    cnt = 0
    ans = 1
    while (n % 2 == 0):
        cnt += 1
        n = n // 2


    if (cnt):
        ans = mult(ans, (cnt + 1))
    for i in range(3, int(sqrt(n)), 2):
        cnt = 0

        while (n % i == 0):
            cnt += 1
            n = n // i

        if (cnt):
            ans = mult(ans, (cnt + 1))

    if (n > 2):
        ans = mult(ans, 2)
    return ans % mod

def calculateFactors():
    # generatePrimeFactors()
    primeFactCnt = calculate_factors(X)
    if primeFactCnt >= K:
        return True
    else:
        return False

t = int(input())
for _ in range(t):
    arr = list(map(int, input().rstrip().split()))
    X = arr[0]
    K = arr[1]
    if calculateFactors():
        print(1)
    else:
        print(0)