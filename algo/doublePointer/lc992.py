a = [1,2,[1,2]]
b = a[:]
a[2].append(2)

import copy
import bisect
import sys

class classa:
a = [1,2,4]
a.append(2)
a.sort()
b = copy.deepcopy(a)
b.sort(key = lambda x : x, reverse = True)
print(a)
print(bisect.bisect(a, 2, 0, len(a)))
print(bisect.bisect_left(a, 2, 0, len(a)))
print(bisect.bisect_right(a, 2, 0, len(a)))
print("1,2,3,".split(','))
print("1,2,3,".strip(',').split(','))
    print(2**63-1)
    print(sys.maxsize)

{
 "content":"中文解释",
 "query":"产品名称 | 产品code | 中英文名称 | 缩略语",
 "answer":"" //
}