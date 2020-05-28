t = int(input())
for _ in range(t):
    text = input()
    # if len(text) == 1 or len(text) == 2:
    #     print("YES")
    #     continue
    L = text[1:]+text[0]
    R = text[-1] + text[0:len(text)-1]
    if L == R:
        print("YES")
    else:
        print("NO")