t = int(input())
mod = 998244353
for _ in range(t):
    s = input()
    previous = 1
    length = len(s)
    for pos in range(len(s)):
        diff = ord(s[pos])-ord('a')
        power = pow(26,len(s)-(pos+1))%mod
        previous = (previous + power*diff)%mod
    print(int(previous))
'''
5
axbsjdkfs
dsgkasdjkaaldfhglsv
lagfzakfdlsdkgf
zzzzzzzzzzzz
anbbcc



5
axbsjdkfs
583381708
dsgkasdjkaaldfhglsv
605698703
lagfzakfdlsdkgf
689996144
zzzzzzzzzzzz
879255306
anbbcc
5958995

'''