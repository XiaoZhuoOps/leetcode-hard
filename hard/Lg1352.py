'''
P1352 没有上司的舞会
'''


def f(root, n, rs, chs):
    def dfs(i):
        nonlocal rs, chs
        a, b = 0, rs[i-1]
        for ch in chs[i-1]:
            c, d = dfs(ch)
            a += max(c, d)
            b += c
        return a, b
    a, b = dfs(root)
    return max(a, b)


n = int(input())
rs = []
for _ in range(n):
    rs.append(int(input()))
chs = [[] for _ in range(n)]
isRoot = [0 for _ in range(n)]
while True:
    line = input()
    if line == "":
        break
    l, k = line.split()
    chs[int(k)-1].append(int(l))
    isRoot[int(l)-1] = 1
for i in range(n):
    if isRoot[i] == 0:
        # print(f(i+1, n, rs, chs))
        return f(i+1, n, rs, chs)
