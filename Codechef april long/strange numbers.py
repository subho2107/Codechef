lim = int(pow(10,6))
factors = [0]*(lim+1)
X = 0
K = 0
def generatePrimeFactors():
    factors[1] = 1
    for num in range(2, lim):
        factors[num] = num

    for num in range(4, lim, 2):
        factors[num] = 2

    i = 3
    while i*i < lim:
        if factors[i] == i:
            j = i*i
            while j < lim:
                if factors[j] == j:
                    factors[j] = i
                j += i
        i += 1
    # print(factors[0:10])
def countfactors(n):
    if n == 1:
        return 0
    noOfFactors = 1
    noOfPrimeFactors = 0
    cnt = 1
    dup = factors[n]
    j = n//factors[n]
    while j > 1:
        if dup == factors[j]:
            cnt += 1
        else:
            noOfPrimeFactors+=1
            dup = factors[j]
            noOfFactors*=cnt+1
            cnt = 1

        j = j // factors[j]
    noOfFactors *= cnt + 1
    noOfPrimeFactors += 1
    return noOfPrimeFactors


def calculateFactors():
    generatePrimeFactors()
    primeFactCnt = countfactors(X)
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