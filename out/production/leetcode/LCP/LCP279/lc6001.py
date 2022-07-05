def smallestNumber(self, num):
    numList = list(str(abs(num)))
    if num == 0:
        return 0
    elif num > 0:
        numList.sort()
        for i in range(len(numList)):
            if numList[i] != '0':
                pop = numList.pop(i)
                numList.insert(0, pop)
                break
    else:
        numList.sort(reverse=True)
    res = "".join(numList)
    if num > 0:
        return int(res)
    else:
        return -1*int(res)
