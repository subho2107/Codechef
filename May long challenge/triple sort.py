
def isLoop(i):
    if arr[i]!=(i+1) and i == arr[arr[i]-1]-1:
        return True
    return False
def swap(i, j, k):
    v1 = arr[i]
    v2 = arr[j]
    v3 = arr[k]
    arr[i] = v3
    hashPositions[v3] = i
    arr[j] = v1
    hashPositions[v1] = j
    arr[k] = v2
    hashPositions[v2] = k
def findLoop(i, j):
    for pos in range(i+1 , j):
        if isLoop(pos):
            return pos
    for pos in range(j+1, len(arr)):
        if isLoop(pos):
            return pos
    return -1

t = int(input())
for _ in range(t):
    n, k = map(int , input().rstrip().split())
    arr = list(map(int , input().rstrip().split()))
    # arr = list(range(1, random.randrange(100000)))
    # random.shuffle(arr)
    noOfLoops = 0

    hashPositions = {}
    for pos in range(0, len(arr)):
        if arr[pos] != pos+1 and isLoop(pos):
            noOfLoops += 1
        hashPositions[arr[pos]] = pos

    if noOfLoops % 2 != 0:
        print(-1)
    else:
        indexChosen = []
        queue = []
        pos = 0
        cnt = 0
        check = True
        while pos < len(arr) and cnt <= k:
            if arr[pos] != pos + 1:
                i1 = pos
                i2 = arr[pos] - 1
                i3 = 0
                if not isLoop(i1):
                    i3 = hashPositions[i1 + 1]
                else:
                    queue.append(pos)
                    pos+=1
                    continue
                swap(i1, i2, i3)
                cnt += 1
                indexChosen.append([i1 + 1, i2 + 1, i3 + 1])
            else:
                pos += 1

        if len(queue)!=0 and cnt < k:
            pos = 0
            while pos < len(arr) and len(queue)!= 0 and  cnt <= k:
                if arr[pos] == pos+1 and pos == queue[0]:
                    queue.pop(0)
                elif pos == queue[0]:
                    queue.pop(0)
                    i1 = pos
                    i2 = arr[pos] - 1
                    i3 = 0
                    if isLoop(i1):
                        i3 = findLoop(i1, i2)
                        tempI = i3
                        i3 = i2
                        i2 = tempI
                        if i2 == -1 or i1 == i2 or i2 == i3 or i1 == i3:
                            check = False
                            break
                    else:
                        i3 = hashPositions[i1 + 1]
                    swap(i1, i2, i3)
                    cnt += 1
                    indexChosen.append([i1 + 1, i2 + 1, i3 + 1])
                if arr[pos]!=pos+1:
                    check = False
                    break
                pos+=1
        length = len(indexChosen)
        if check and length<=(n//2) :
            print(length)
            for tempArr in indexChosen:
                temp = map(str, tempArr)
                print(' '.join(temp))
        else:
            print(-1)
