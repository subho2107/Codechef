def isPrime(num):
    if num <= 1:
        return False
    if num <= 3:
        return True
    if n%2 == 0 or n%3 == 0:
        return False
    i = 5
    while i*i <= num:
        if n%i == 0 or n%(i+2) == 0:
            return False
        i += 6
    return True
t = int(input())
for _ in range(t):
    n = int(input())
    cnt = 0
    for i in range(1, n+1):
        for j in range(1, n+1):
            if isPrime((i-1)*(j-1)+1):
                cnt += 1
    print(cnt)