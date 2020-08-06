import math
def addZeroes(year):
    year = str(year)
    length = len(year)
    if length == 4:
        return year
    else:
        for i in range(4 - length):
            year = "0" + year
        return year
def getDay(day, month, year):
    year = addZeroes(year)
    E = int(year[0:2])
    D = int(year[1:])
    m = month - 2
    if month == 1 or month == 2:
        D -= 1
        m = 10 + month
    k = day
    f = k + math.floor((13 * m - 1) / 5) + D + math.floor(D / 4) + math.floor(E / 4) - 2 * E
    rem = 0
    if f % 7 >= 0:
        rem = f % 7
    else:
        div = rem // 7
        div += 1
        rem = (div * 7) + f
    #switcher = {0:"Sunday", 1:"Monday", 2:"Tuesday", 3:"Wednesday", 4:"Thursday", 5:"Friday", 6:"Saturday"}
    #dayOfWeek = switcher.get(rem, "No such case")
    #return dayOfWeek
    return rem #just for ease of returning the number rather than the string
def leap(year):
    flag = False
    if year % 400 == 0:
        flag = True
    elif year % 100 != 0 and year % 4 == 0:
        flag = True
    return flag
def getMonthEnd(month, year):
    #daysEnding30 = ["September", "April", "June", "November"]
    #daysEnding30 = [9, 4, 6, 11]
    if leap(year):
        return 29
    else:
        return 28
        
def challengeIntersect(month, year):
    #check = False
    #calculation of date of long contest
    firstDay = getDay(1, month, year)
    diffFromFriday = 5 - firstDay
    if firstDay == 6:
        diffFromFriday = firstDay
    longContestStart = 1 + diffFromFriday
    longContestEnd = longContestStart + 10
    #calculation of date of cook off
    lastDayDate = getMonthEnd(month, year)
    lastDay = getDay(lastDayDate,month, year)
    cookOffDay = lastDayDate - lastDay - 7
    if longContestEnd > cookOffDay:
        return True
    else:
        return False
    #return check
def getNoOfMonths(monthStart, yearStart, monthEnd, yearEnd):
    countOfMonths = 0
    for year in range(yearStart, yearEnd+1):
        if (year == yearStart and monthStart <= 2) or (year == yearEnd and monthEnd >= 2) or (year != yearStart and year != yearEnd):
            #print(month)
            if challengeIntersect(2, year):
                countOfMonths += 1
                #print(year)
    print(countOfMonths)

t = int(input())
for _ in range(t):
    monthYear1 = input().split()
    monthYear2= input().split()
    month1 = int(monthYear1[0])
    year1 = int(monthYear1[1])
    month2 = int(monthYear2[0])
    year2 = int(monthYear2[1])
    getNoOfMonths(month1, year1, month2, year2)

