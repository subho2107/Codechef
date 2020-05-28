import math
# import random
def method1(bits):
    val = (1 << bits) - 1
    product = (x & val) * (y & val)
    ans = (1 << (bits - 1))
    bits -= 1
    while (x & (ans - 1)) * (y & (ans - 1)) < product and bits != 0:
        bits -= 1
        temp = 1 << bits
        ans += temp
    if ans == val:
        return val
    else:
        return ans-1
t = int(input())
for _ in range(t):
    x,y,l,r = map(int, input().rstrip().split())
    if r == 0:
        print(r)
    elif l == r:
        print(r)
    else:
        bits = int(math.log2(r))
        z1 = method1(bits)
        print(z1)

