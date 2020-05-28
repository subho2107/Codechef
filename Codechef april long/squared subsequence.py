def checkSquareDiff(num):
    if abs(num % 4) == 2:
        return True
    else:
        return False

def getNumberOfSubs(arr):
    posArr = []
    for pos in range(0, len(arr)):
        if checkSquareDiff(arr[pos]):
            posArr.append(["critical",pos])
        elif arr[pos] % 4 == 0:
            posArr.append(["even",pos])
    length = len(arr)
    totalContigSubs = (length * (length + 1)) // 2
    if posArr == []:
        return totalContigSubs
    if posArr[0][0] != "even" :
        posArr = [["",-1]] + posArr
    if posArr[-1][0] != "even":
        posArr += [["", length]]
    for pos in range(1, len(posArr)-1):
        catg = posArr[pos][0]
        posPres = posArr[pos][1]
        posPrev = posArr[pos-1][1]
        posNext = posArr[pos+1][1]
        if catg == "critical":
            prev = posPres-posPrev - 1
            post = posNext - posPres - 1
            totalContigSubs -=  (prev + 1 )*(post+1)
        # if prev > 0 and post > 0:
        #     totalContigSubs -= 1


    return totalContigSubs


dictOfSquares = dict()
t = int(input())
for _ in range(t):
    a = int(input())
    arr = list(map(int , input().rstrip().split()))
    print(getNumberOfSubs(arr))