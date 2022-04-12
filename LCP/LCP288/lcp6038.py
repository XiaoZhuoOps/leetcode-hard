class Solution:
    def minimizeResult(self, expression: str) -> str:
        strList = list(expression)
        strs = expression.split("+")
        def f1(str, i):
            if i == 0:
                return [1, int(str)]
            return [int(str[0:i]), int(str[i:])]
        def f2(str, i):
            if i == len(str)-1:
                return [int(str), 1]
            return [int(str[0:i+1]), int(str[i+1:])]
        minVal = int('inf')
        p1, p2 = 0, 0
        for i in range(len(strs[0])):
            for j in range(len(strs[1])):
                a, b = f1(strs[0], i)[0], f1(strs[0], i)[1]
                c, d = f2(strs[1], j)[0], f2(strs[1], j)[1]
                if minVal > a*(b+c)*d:
                    minVal = a*(b+c)*d
                    p1 = i
                    p2 = i+1+j+1
        strList.insert(p1, "(")
        strList.insert(p2, ")")
        return "".join(strList)

