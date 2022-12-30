"""
1 数据结构题 - 范围问题 - 差分数组或者线段树
1 问题1 数据量很大，存储和遍历，线性表肯定不行
1   - 思路1 额外数据结构
1   - 思路2 省略不必要的存储 - 链表 - 查询插入慢 - TreeMap
2 差分数组基本逻辑图
3 SortedDict api 不熟悉
4 -
"""
from sortedcontainers import SortedDict
class MyCalendarThree:

    def __init__(self):
        self.sd = SortedDict()

    def book(self, startTime: int, endTime: int) -> int:
        self.sd[startTime] = self.sd.setdefault(startTime, 0) + 1
        self.sd[endTime] = self.sd.setdefault(endTime, 0) - 1
        ans = k = 0
        for v in self.sd.values():
            k += v
            ans = max(ans, k)
        return ans


# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(startTime,endTime)