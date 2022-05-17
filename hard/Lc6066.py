# class CountIntervals:

#     def __init__(self):
#         self.ls = []
#         self.rs = []
#         self.c = 0

#     def add(self, left: int, right: int) -> None:
#         # 满足 rs[i] >= left-1 的最小的i
#         start = bisect.bisect_left(self.rs, left-1)
#         # 满足 ls[j] <= right+1 的最大的j+1 
#         end = bisect.bisect_right(self.ls, right+1)
#         # [start, end)

#         # 需要考虑四种情况 1、全相交 2、不相交 3、左相交 4、右相交
#         for i in range(start, end):
#             self.c -= (self.rs[i]-self.ls[i]+1)
#             # 
#             left = min(left, self.ls[i])
#             right = max(right, self.rs[i])

#         self.ls[start:end] = [left]
#         self.rs[start:end] = [right]
#         self.c += (right - left +1)

#     def count(self) -> int:
#         return self.c

class CountIntervals:

    def __init__(self):
        self.ls = []
        self.rs = []
        self.c = 0

    def add(self, left: int, right: int) -> None:
        # 满足 rs[i] >= left-1 的最小的i
        # 
        start = bisect.bisect_left(self.rs, left-1)
        end = start
        while end < len(self.ls) and self.ls[end] <= right+1:
            left = min(left, self.ls[end])
            right = max(right, self.rs[end])
            self.c -= (self.rs[end]-self.ls[end]+1)
            end += 1
        # 若 sta让他
        self.ls[start:end] = [left]
        self.rs[start:end] = [right]
        self.c += (right-left+1)

    def count(self) -> int:
        return self.c
