
def helper(small, big):
    if small > big//10:
        temp = small
        small = big//10
        big = (temp*10)+(big%10)
    else:
        temp = small
        small = big%10
        big = (big//10)*10 + temp
    print(small+big)
def helper2(small, big):
    maxSum = small+ big
    temp = big
    temp2 = small
    big = ((big//10)*10)+(small%10)
    small = ((small//10)*10)+(temp%10)
    if big + small > maxSum:
        maxSum = big+small
    temp3 = temp
    big = ((temp//10)*10)+(temp2//10)
    small = ((temp3%10)*10)+(temp2%10)
    if big + small > maxSum:
        maxSum = big+small
    print(maxSum)

    
            
def printSum(s1, s2):
    len1 = len(str(s1))
    len2 = len(str(s2))
    if s1%10 == 0 and s2%10 == 0:
        print(s1+s2)
    elif len1 == 1 and len2 != 1:
       helper(s1, s2)
    elif len2 == 1 and len1 != 1:
       helper(s2,s1)
    else:
        if s1 < s2:
            helper2(s1, s2)
        else:
            helper2(s2, s1)
    


t = int(input())
for _ in range(t):
    arr = list(map(int, input().rstrip().split()))
    printSum(arr[0], arr[1])
    
    