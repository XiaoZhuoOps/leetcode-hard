class CountIntervals:

    def __init__(self):
        self.ls = []
        self.rs = []
        self.count = 0

    def add(self, left: int, right: int) -> None:
        start = bisect.bisect_left(self.rs, left)
        end = bisect.bisect_right(self.ls, right)-1

        nl, nr = self.ls[start], self.rs[end]
        for i in range(start, end+1):
            self.count -= (self.rs[i]-self.ls[i]+1)
            self.ls.pop(start)
            self.rs.pop(start)
        
        self.ls.insert(start, nl)
        self.rs.insert(start, nr)
        self.count += (nr-nl+1)
    def count(self) -> int:
        return self.count

