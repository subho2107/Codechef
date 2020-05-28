# Python 3 implmentation to find the
# Number of factors of very
# large number N modulo M
from math import sqrt

mod = 1000000007


# Function for modular
# multiplication
def mult(a, b):
    return ((a % mod) * (b % mod)) % mod


# Funcion to find the number
# of factors of large Number N
def calculate_factors(n):
    cnt = 0
    ans = 1

    # Count the number of times
    # 2 divides the number N
    while (n % 2 == 0):
        cnt += 1
        n = n // 2

    # Condition to check
    # if 2 divides it
    if (cnt):
        ans = mult(ans, (cnt + 1))

    # Check for all the possible
    # numbers that can divide it
    for i in range(3, int(sqrt(n)), 2):
        cnt = 0

        # Loop to check the number
        # of times prime number
        # i divides it
        while (n % i == 0):
            cnt += 1
            n = n // i

        # Condition to check if
        # prime number i divides it
        if (cnt):
            ans = mult(ans, (cnt + 1))

        # Condition to check if N
    # at the end is a prime number.
    if (n > 2):
        ans = mult(ans, 2)
    print(mod)
    return ans % mod


# Driver Code
if __name__ == '__main__':
    n = 19374857

    print(calculate_factors(n))

# This code is contributed by Surendra_Gangwar
