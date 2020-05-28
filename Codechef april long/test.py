posArr = ["neglect","odd","odd","even","even","odd","neglect","odd","even","odd","odd","neglect"]
res = []
length = 0
neglectEncountered = False
encounteredPos = 0
temp = []
temp2 = []
for pos in range(len(posArr)):
    catg = posArr[pos]
    if catg == "odd":
        length += 1
        temp2.append(catg)
    elif (catg == "even" or catg == "neglect") and neglectEncountered:
        res.append([encounteredPos, length])
        length = 0
        neglectEncountered = False
        encounteredPos = 0
        temp.append(temp2)
        temp2 = []
        if catg == "neglect":
            length = 1
            neglectEncountered = True
            encounteredPos =length
            temp2.append(catg)

    elif catg == "neglect" :
        length += 1
        neglectEncountered = True
        encounteredPos = length
        temp2.append(catg)
        # if pos == len(posArr)-1:
        #     temp.append(temp2)
        #     res.append([encounteredPos, length])

    elif catg == "even" and not neglectEncountered:
        length = 0
        temp2 = []
    if neglectEncountered and pos == len(posArr) - 1 and (catg == "odd" or catg == "neglect"):
        temp.append(temp2)
        res.append([encounteredPos, length])
length = len(posArr)
totalContigSubs = (length*(length+1))//2
print(totalContigSubs)
for negArr in res:
    totalContigSubs -= (negArr[1]-negArr[0]+1)*negArr[0]
print(totalContigSubs)
print(temp)
print(res)

# tempArr = []
# for pos in range(len(posArr)):
#     catg = posArr[pos]
#     if catg == "odd" or catg == "neglect":
#         tempArr.append(catg)
#         if tempArr[0] == "neglect" and tempArr[-1] == "neglect":
#             tempPos = pos + 1
#             while posArr[tempPos] == "odd":
