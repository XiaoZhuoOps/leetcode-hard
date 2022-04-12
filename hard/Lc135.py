"""
2022年4月7日
1 递增递减序列
2 O(N)
3 30min
"""
class Lc164:
    def candy(self, ratings: List[int]) -> int:
        i, lr, ans = 1, len(ratings), 1
        candys = [1 for i in range(lr)]
        while i < lr:
            if ratings[i-1] < ratings[i]:
                candys[i] = candys[i-1]+1
                ans += candys[i]
                i += 1
            elif ratings[i-1] == ratings[i]:
                candys[i] = 1
                ans += candys[i]
                i += 1
            else:
                m = 0
                while i < lr and ratings[i-1] > ratings[i]:
                    i += 1
                    m += 1
                if candys[i-m-1] <= m:
                    ans += (m+1-candys[i-m-1])
                ans += m*(m+1)//2
        return ans