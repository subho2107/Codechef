def goodPrefix(string, minRemove, maxAppear):
    dictOfLetters ={}
    for i in string:
        if i not in dictOfLetters:
            dictOfLetters[i] = 1
        elif dictOfLetters[i] + 1 > maxAppear:
            if minRemove != 0:
                minRemove -= 1
            else:
                break
        else:
            dictOfLetters[i] += 1
    return sum(dictOfLetters.values())

t = int(input())
for _ in range(t):
    string = input()
    arr = list(map(int, input().rstrip().split()))
    print(goodPrefix(string, arr[0], arr[1]))
        
