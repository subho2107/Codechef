import math
# import random
def method1(bits):
    val = (1 << bits) - 1
    product = (x & val) * (y & val)
    ans = (1 << (bits - 1))
    bits -= 1
    # print((x&ans)*(y&ans))
    hashMap = {}
    while (x & (ans - 1)) * (y & (ans - 1)) < product and bits != 0:
        if (x & (ans - 1)) * (y & (ans - 1)) not in hashMap:
            hashMap[(x & (ans - 1)) * (y & (ans - 1))] = ans-1
        # print((x & ans) * (y & ans))
        bits -= 1
        temp = 1 << bits
        # if (x & ((ans+temp) - 1)) * (y & ((ans+temp) - 1)) == (x & (ans - 1)) * (y & (ans - 1)):
        #     break
        if ans + temp < r:
            ans += temp
    # print((x & ans) * (y & ans))
    if (x & (ans - 1)) * (y & (ans - 1)) not in hashMap:
        hashMap[(x & (ans - 1)) * (y & (ans - 1))] = ans - 1
    if ans == val:
        return val
    else:
        return hashMap[(x & (ans - 1)) * (y & (ans - 1))]
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
        z2 = method1(bits+1)
        result = z2
        a =(x & (z1 - 1)) * (y & (z1 - 1))
        b = (x & (z2 - 1)) * (y & (z2 - 1))
        print(z1, z2,a,b)
        if  a > b:
            result = z1
        elif a == b:
            result = z1 if z1 < z2 else z2
        print(result)

