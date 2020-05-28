def isRulemaintained(queue):
    presentFirst = 0
    for pos in range(len(queue)):
        if queue[pos] == 1:
            presentFirst = pos
            break
    check = "YES"
    for pos in range(presentFirst+1, len(queue)):
        if queue[pos] == 1:
            if pos - presentFirst >= 6:
                presentFirst = pos
            else:
                check = "NO"
                break

    return check
t = int(input())
for _ in range(t):
    input()
    queue = list(map(int, input().rstrip().split()))
    check = isRulemaintained(queue)
    print(check)



