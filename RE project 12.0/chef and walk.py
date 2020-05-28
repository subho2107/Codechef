t = int(input())
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    # if n==0 and k == 1:
    #     print(0)
    #     continue
    # path = [0]
    # cnt = 0
    # pos = 0
    # check = False
    # maxDist = 1
    # mod = 1000000007
    # while True:
    #     for num in range(1, maxDist+1):
    #         path.append(num)
    #         pos += 1
    #         if num == n:
    #             cnt += 1
    #             if cnt == k:
    #                 print(pos)
    #                 check = True
    #                 break
    #     if check:
    #         break
    #     for num in range(maxDist-1, 0, -1):
    #         path.append(num)
    #         pos += 1
    #         if num == n:
    #             cnt += 1
    #             if cnt == k:
    #                 print(pos)
    #                 check = True
    #                 break
    #     if check:
    #         break
    #     path.append(0)
    #     pos+=1
    #     maxDist += 1
    #     pos = pos%mod
    firstAppear = n
    timeTilln2 = ((firstAppear+(k-2))/2)*(4+((firstAppear+(k-2) - 1)*2)) - 1
    print(timeTilln2)
    term = 1 + (firstAppear+(k-1) - 1)*2
    print(term)
    ans = timeTilln2 + (term//2 + 1)-(k-1)
    print(ans)