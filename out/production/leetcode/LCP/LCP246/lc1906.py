def minDifference(nums, queries):
    # 前缀和
    n = len(nums)
    pre = [[0 for _ in range(100)] for _ in range(n+1)]
    for i, num in enumerate(nums):
        pre[i+1][:] = pre[i][:]
        pre[i+1][num-1] += 1
    # 计算
    res = list()
    for left, right in queries:
        last = 0
        dis = float('inf')
        for i in range(1, 101):
            if pre[right+1][i-1] != pre[left][i-1]:
                if last != 0:
                    dis = min(dis, i-last)
                last = i
        if dis == float('inf'):
            res.append(-1)
        else:
            res.append(dis)
    return res


print(minDifference([1, 3, 4, 8], [[0, 1], [1, 2], [2, 3], [0, 3]]))
