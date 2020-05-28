m = 10**9+9
print(m)
p = 31
cntChefStr = 0
cntChefinaStr = 0
S = ''
class Hash:
    def __init__(self, length):
        self.power = []
        self.hashString = [0 for _ in range(length)]
        self.power.append(1)
        for pos in range(length-1):
            self.power.append(self.power[-1]*p)
        hashVal = 0
        for pos in range(length):
            hashVal = (hashVal+ ((ord(S[pos])-ord('a')+1)*self.power[pos])%m)%m
            self.hashString[pos] = hashVal
    def getHash(self, pos, pos2):
        res = self.hashString[pos2]
        if pos != 0:
            res = (res - (self.hashString[pos-1]*self.power[pos2-pos+1])%m)%m
        return res

t = int(input())
answer = ''
for _ in range(t):
    S = input()
    cnt = 0
    obj = Hash(len(S))
    for pos in range(1, len(S)-2, 2):
        m1 = pos//2
        m2 = (len(S)-1-pos)//2
        if obj.getHash(0, m1) != obj.getHash(m1+1,pos):
            continue
        if obj.getHash(pos+1, pos+ m2) != obj.getHash(pos+m2+1, len(S)-1):
            continue
        cnt+=1
    answer += str(cnt)+'\n'
print(answer)


