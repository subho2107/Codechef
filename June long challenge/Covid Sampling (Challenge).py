def inputIntArray():
    return list(map(int, input().rstrip().split()))


def inputArray():
    return input().rstrip().split()


def inputVars():
    return map(int, input().rstrip().split())


def inputNum():
    return int(input())


def main():
    for _ in range(inputNum()):
        n, p = inputVars()
        result = ''
        peopleInARow = []
        cnt2 = 0
        for row in range(n):
            print('1', row + 1, 1, row + 1, n)
            X = inputNum()
            if X == -1:
                return
            peopleInARow.append(X)
        totalPeople = sum(peopleInARow)
        for row in range(n):
            cnt = 0
            X = ''
            for col in range(n):
                if cnt < peopleInARow[row] and cnt2 < totalPeople:
                    print('1', row+1, col+1, row+1, col+1)
                    X = inputNum()
                    if X == -1:
                        return
                    if X == 1:
                        cnt += 1
                        cnt2+=1
                else:
                    X = 0
                result += str(X)+' '
            result += '\n'
        print('2')
        print(result[:-1])
        if inputNum() == -1:
            break
        else:
            continue

if __name__ == "__main__":
    main()