ch = 'a'
ch2 = 'z'
def five(s):
    cnt = 0
    for i in range(ord(ch), ord(ch2)+1):
        for j in range(ord(ch), ord(ch2) + 1):
            for k in range(ord(ch), ord(ch2) + 1):
                for l in range(ord(ch), ord(ch2) + 1):
                    for m in range(ord(ch), ord(ch2) + 1):
                        cnt += 1
                        if chr(i)+chr(j)+chr(k)+chr(l)+chr(m) == s:
                            return cnt
def four(s):
    cnt = 0
    for i in range(ord(ch), ord(ch2) + 1):
        for j in range(ord(ch), ord(ch2) + 1):
            for k in range(ord(ch), ord(ch2) + 1):
                for l in range(ord(ch), ord(ch2) + 1):
                    cnt += 1
                    if chr(i) + chr(j) + chr(k) + chr(l) == s:
                            return cnt
def three(s):
    cnt = 0
    for i in range(ord(ch), ord(ch2) + 1):
        for j in range(ord(ch), ord(ch2) + 1):
            for k in range(ord(ch), ord(ch2) + 1):
                cnt += 1
                if chr(i) + chr(j) + chr(k) == s:
                    return cnt
def two(s):
    cnt = 0
    for i in range(ord(ch), ord(ch2) + 1):
        for j in range(ord(ch), ord(ch2) + 1):
            cnt += 1
            if chr(i) + chr(j)  == s:
                return cnt
def one(s):
    cnt = 0
    for i in range(ord(ch), ord(ch2) + 1):
        cnt += 1
        if chr(i)== s:
            return cnt
mod = 998244353
t = int(input())
for _ in range(t):
    s = input()
    if len(s) == 1:
        print(one(s))
    elif len(s) == 2:
        print(two(s))
    elif len(s) == 3:
        print(three(s))
    elif len(s) ==4:
        print(four(s))
    elif len(s) == 5:
        print(five(s))
