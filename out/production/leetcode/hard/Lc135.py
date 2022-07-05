"""
2022年4月7日
1 递增递减序列
2 O(N)
3 30min
"""
class Lc164:
    def candy(self, ratings: List[int]) -> int:
        # 前后比较的问题一般i都从1开始
        i, ans, ls, last = 1, 0, len(ratings), 0
        candys = [1 for i in range(lr)]
        while i < ls:
            # 递增序列
            if ratings[i] > ratings[i-1]:
                candys[i] = candys[i-1]+1
                i += 1
            # 不增不减序列
            elif ratings[i] == ratings[i-1]:
                candys[i] = 1
                i += 1
            else:
                # 递减序列
                last = i-1
                while i < ls and ratings[i] < ratings[i-1]:
                    i += 1
                # 注意此时i-1才是递减序列的末尾，递减序列的范围[last, i-1]
                # 特别的，i=ls不影响后续的逻辑
                candys[last] = max(candys[last], i-last)
                candys[i-1] = 1
                for j in range(i-2, last, -1):
                    candys[j] = candys[j+1] + 1
        for c in candys:
            ans += c
        return ans