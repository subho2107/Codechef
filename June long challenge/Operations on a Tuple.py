import os
import sys
from io import BytesIO, IOBase
import math
import random


def inputIntArray():
    return list(map(int, input().rstrip().split()))


def inputArray():
    return input().rstrip().split()


def inputVars():
    return map(int, input().rstrip().split())


def inputNum():
    return int(input())


def removeDuplicates(begin, end):
    duplicates = []
    for pos in range(3):
        if begin[pos] != end[pos]:
            duplicates.append(pos)
    dup, dup2 = [], []
    for pos in duplicates:
        dup.append(begin[pos])
        dup2.append(end[pos])
    return (dup[:],  dup2[:])
def getCntByAdd(begin, end):
    for pos in range(0,len(begin)):
        cnt = 0
        diff = end[pos]-begin[pos]
        for pos2 in range(pos+1, len(end)):
            if diff == end[pos2]-begin[pos2]:
                cnt += 1
        if cnt == 1:
            if len(begin) == 3:
                return 2
            else:
                return 1
        elif cnt == 2:
            return 1  # Only possible for length 3
    return -1
def getCntByMult(begin, end):
    for pos in range(0,len(begin)):
        cnt = 0
        if begin[pos] == 0:
            continue
        if end[pos]%begin[pos] != 0:
            continue
        diff = end[pos]//begin[pos]
        for pos2 in range(pos+1, len(end)):
            if begin[pos2] == 0 or end[pos2]%begin[pos2]!=0:
                continue
            if diff == (end[pos2]//begin[pos2]):
                cnt += 1
        if cnt == 1:
            if len(begin) == 3:
                return 2
            else:
                return 1
        elif cnt == 2:
            return 1#Only possible for length 3
    return -1


def getAddAdd(begin, end):
    diff0 = end[0] - begin[0]
    diff1 = end[1] - begin[1]
    diff2 = end[2] - begin[2]
    ######for 0#######
    check01 = (end[1] - (begin[1] + diff0) == diff2)
    check02 = (end[2] - (begin[2] + diff0) == diff1)
    check012 = end[1] - (begin[1] + diff0) == end[2] - (begin[2] + diff0)
    if check01 or check02 or check012:
        return 2
    ######for 1########
    check10 = (end[0] - (begin[0] + diff1) == diff2)
    check12 = (end[2] - (begin[2] + diff1) == diff0)
    check102 = end[0] - (begin[0] + diff1) == end[2] - (begin[2] + diff1)
    if check10 or check12 or check102:
        return 2
    ######for 2########
    check20 = (end[0] - (begin[0] + diff2) == diff1)
    check21 = (end[1] - (begin[1] + diff2) == diff0)
    check201 = end[0] - (begin[0] + diff2) == end[1] - (begin[1] + diff2)
    if check20 or check21 or check201:
        return 2
    return -1


def getMultMult(begin, end):
    fact0, rem0 = end[0]//begin[0] if begin[0]!=0 else '', end[0]%begin[0] if begin[0]!=0 else ''
    fact1, rem1 = end[1]//begin[1] if begin[1]!=0 else '', end[1]%begin[1] if begin[1]!=0 else ''
    fact2, rem2 = end[2]//begin[2] if begin[2]!=0 else '', end[2]%begin[2] if begin[2]!=0 else ''
    #####for 0,1; 0,2######
    if fact0 != '' and rem0 == 0:
        if fact2 != '' and rem2 == 0 and fact0*begin[1]*fact2==end[1]:
            return 2
        elif fact1 != '' and rem1 == 0 and fact0*begin[2]*fact1==end[2]:
            return 2
    ######for 1, 2##########
    if fact1 != '' and rem1 == 0:
        if fact2 != '' and rem2 == 0 and fact2*fact1*begin[0]==end[0]:
            return 2
    return -1

def getAddMult(begin, end):
    diff0 = end[0] - begin[0]
    diff1 = end[1] - begin[1]
    diff2 = end[2] - begin[2]
    fact0, rem0 = end[0] // begin[0] if begin[0] != 0 else '', end[0] % begin[0] if begin[0] != 0 else ''
    fact1, rem1 = end[1] // begin[1] if begin[1] != 0 else '', end[1] % begin[1] if begin[1] != 0 else ''
    fact2, rem2 = end[2] // begin[2] if begin[2] != 0 else '', end[2] % begin[2] if begin[2] != 0 else ''
    ###for 0####
    if fact1 != '' and rem1 == 0:
        if (begin[2] + diff0) * fact1 == end[2]:
            return 2
    if fact2 != '' and rem2 == 0:
        if (begin[1] + diff0) * fact2 == end[1]:
            return 2
    if not(begin[1]==0 or begin[2]==0) and (end[1]-diff0)%begin[1] == 0 and (end[2]-diff0)%begin[2] == 0 and (end[1]-diff0)//begin[1] == (end[2]-diff0)//begin[2]:
        return 2
    if not(begin[1]+diff0==0 or begin[2]+diff0==0) and end[1]%(begin[1]+diff0) == end[2]%(begin[2]+diff0) == 0 and end[2]//(begin[2]+diff0) == end[1]//(begin[1]+diff0):
        return 2
    ###for 1#####
    if fact0 != '' and rem0 == 0:
        if (begin[2] + diff1) * fact0 == end[2]:
            return 2
    if fact2 != '' and rem2 == 0:
        if (begin[0] + diff1) * fact2 == end[0]:
            return 2
    if not(begin[0]==0 or begin[2]==0) and(end[2]-diff1)%begin[2] == 0 and (end[0]-diff1)%begin[0] == 0 and (end[2]-diff1)//begin[2] == (end[0]-diff1)//begin[0]:
        return 2
    if not(begin[0]+diff1==0 or begin[2]+diff1==0) and end[0]%(begin[0]+diff1) == end[2]%(begin[2]+diff1) == 0 and end[0]//(begin[0]+diff1) == end[2]//(begin[2]+diff1):
        return 2
    #####for 2######
    if fact0 != '' and rem0 == 0:
        if (begin[1] + diff2) * fact0 == end[1]:
            return 2
    if fact1 != '' and rem1 == 0:
        if (begin[0] + diff2) * fact1 == end[0]:
            return 2
    if not(begin[1]==0 or begin[0]==0) and (end[1]-diff2)%begin[1] == 0 and (end[0]-diff2)%begin[0] == 0 and (end[1]-diff2)//begin[1] == (end[0]-diff2)//begin[0]:
        return 2
    if not(begin[1]+diff2==0 or begin[0]+diff2==0) and end[0]%(begin[0]+diff2) == end[1]%(begin[1]+diff2) == 0 and end[0]//(begin[0]+diff2) == end[1]//(begin[1]+diff2):
        return 2
    return -1


def getMultAdd(begin, end):
    diff0 = end[0] - begin[0]
    diff1 = end[1] - begin[1]
    diff2 = end[2] - begin[2]
    fact0, rem0 = end[0] // begin[0] if begin[0] != 0 else '', end[0] % begin[0] if begin[0] != 0 else ''
    fact1, rem1 = end[1] // begin[1] if begin[1] != 0 else '', end[1] % begin[1] if begin[1] != 0 else ''
    fact2, rem2 = end[2] // begin[2] if begin[2] != 0 else '', end[2] % begin[2] if begin[2] != 0 else ''
    ####for 0#####
    if fact0 != '' and rem0 == 0:
        if end[1] - (begin[1]*fact0) == diff2 or end[1]-(begin[1]*fact0) == end[2]-(begin[2]*fact0):
            return 2
        if end[2] - (begin[2]*fact0) == diff1:
            return 2
        if (fact0 != 0 and end[1]%fact0 == 0 and end[2]%fact0 == 0):
            if end[1]//fact0 - begin[1] == end[2]//fact0 - begin[2]:
                return 2

    ####for 1######
    if fact1 != '' and rem1 == 0:
        if end[0] - (begin[0]*fact1) == diff2 or end[0]-(begin[0]*fact1) == end[2]-(begin[2]*fact1):
            return 2
        if end[2] - (begin[2]*fact1) == diff0:
            return 2
        if (fact1 != 0 and end[0]%fact1 == 0 and end[2]%fact1 == 0):
            if end[0]//fact1 - begin[0] == end[2]//fact1 - begin[2]:
                return 2
    #####for 2######
    if fact2 != '' and rem2 == 0:
        if end[0] - (begin[0]*fact2) == diff1 or end[0] - (begin[0]*fact2) == end[1] - (begin[1]*fact2):
            return 2
        if end[1] - (begin[1]*fact2) == diff0:
            return 2
        if (fact2 != 0 and end[1]%fact2 == 0 and end[0]%fact2 == 0):
            if end[1]//fact2 - begin[1] == end[0]//fact2 - begin[0]:
                return 2
    return -1


def getThreeByThree(begin, end):
    if (begin[0]-begin[1]) != 0:
        x = (end[0]-end[1])//(begin[0]-begin[1])#solving the two equations px+y=a and qx+y=b
        if end[0] - begin[0]*x == end[1] - begin[1]*x == end[2] - begin[2]*x:
            return 2
    if end[1]-end[0] != 0:
        x = (end[0]*begin[1] - end[1]*begin[0])//(end[1]-end[0])#solving the two equations (p+x)y=a and (q+x)y=b
        if begin[0]+x != 0 and begin[1]+x != 0 and begin[2]+x != 0:
            if end[0]%(begin[0]+x) == end[1]%(begin[1]+x) == end[2]%(begin[2]+x)==0 and end[0]//(begin[0]+x) == end[1]//(begin[1]+x) == end[2]//(begin[2]+x):
                return 2
    return -1



def main():
    for _ in range(inputNum()):
        begin = inputIntArray()
        end = inputIntArray()
        # begin = []
        # end = []
        # for pos in range(3):
        #     num = random.randrange(1, 100)
        #     begin.append(num)
        #     end.append(random.randrange(1, 200))
        # print(begin, end)
        if end[0] == end[1] == end[2] == 0:
            print(1)
            continue
        if end[0] == end[1] == end[2]:
            print(2)
            continue

        begin, end = removeDuplicates(begin, end)
        if len(begin) == len(end) == 0:
            print(0)
            continue
        if len(begin) == len(end) == 1:
            print(1)
            continue

        cntByAdd = getCntByAdd(begin, end)
        cntByMult = getCntByMult(begin, end)
        if cntByAdd == 1 or cntByMult == 1:
            print(1)
            continue
        elif cntByMult == 2 or cntByAdd == 2:
            print(2)
            continue
        if len(begin) == 2:
            print(2)
        else:
            a = getAddAdd(begin, end)
            b = getMultMult(begin, end)
            c = getAddMult(begin, end)
            d = getMultAdd(begin, end)
            e = getThreeByThree(begin, end)
            if a == b == c == d == e == -1 :
                check = False
                # for num in range(-10, 10):
                #     if end[0] - begin[0] * num == end[1] - begin[1] * num == end[2] - begin[2] * num:
                #         print(2)
                #         check = True
                #         break
                if not check:
                    print(3)
            else:
                print(2)
main()

#.........................................FAST INPUT OUTPUT.......................................
BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

#....................................END OF FAST I/O............................................

# if __name__ == "__main__":
#     main()