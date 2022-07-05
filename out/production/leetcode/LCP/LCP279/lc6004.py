from typing import *

def minimumTime(self, s: str) -> int:
    n = len(str)
    pre = [0 for _ in range(n + 1)]
    suff = [0 for _ in range(n + 1)]
    # suff
    for j in range(n - 1, -1, -1):
        if str[j] == '0':
            suff[j] = suff[j + 1]
        else:
            suff[j] = min(suff[j + 1] + 2, n - j)  # 特殊情况，j = n-1时，suff = 1
    # pre ans
    ans = suff[0]
    for i in range(0, n, 1):
        if s == '0':
            pre[i + 1] = pre[i]
        else:
            pre[i + 1] = min(pre[i] + 2, i + 1)
        ans = min(ans, pre[i + 1] + suff[i + 1])
    return ans

