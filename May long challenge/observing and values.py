a = int(input())
b = int(input())
for num in range(0, 10*max(a, b)):
    print("num = ",num,"a&num = ", a&num,"b&num=",b&num, (a&num)*(b&num))
'''
92 23 0 184->127
77 21 0 154->127
51 23 0 102->63
# 2 13 0 26->15
9 31 0 62->31
'''
