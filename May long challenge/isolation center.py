t = int(input())
for _ in range(t):
    noOfPeople, noOfQueries = map(int, input().rstrip().split())
    text = input()
    hashFreq = {}
    for ch in text:
        if ch not in hashFreq:
            hashFreq[ch] = 1
        else:
            hashFreq[ch] += 1
    for i in range(noOfQueries):
        peopleWaiting = 0
        isolationCamps = int(input())
        for type in hashFreq:
            if hashFreq[type] > isolationCamps:
                peopleWaiting +=  hashFreq[type] - isolationCamps
        print(peopleWaiting)