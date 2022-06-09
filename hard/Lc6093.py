# 调用 addText ，deleteText ，cursorLeft 和 cursorRight 的 总 次数不超过 2 * 104 次。
# 双向链表
# O(N)
# 
# 
class Node:
    def __init__(self, ch, pre, succ):
        self.ch = ch
        self.pre = pre
        self.succ = succ

class TextEditor:

    def __init__(self):
        self.cur = self.dumpy = Node('-',None,None)

    def addText(self, text: str) -> None:
        for s in text:
            newNode = Node(s, self.cur, self.cur.succ)
            if self.cur.succ != None: self.cur.succ.pre = newNode
            self.cur.succ = newNode
            self.cur = newNode

    def deleteText(self, k: int) -> int:
        for i in range(k):
            if self.cur == self.dumpy:
                return i
            if self.cur.pre != None: self.cur.pre.succ = self.cur.succ
            if self.cur.succ != None: self.cur.succ.pre = self.cur.pre
            self.cur = self.cur.pre
        return k

    def cursorLeft(self, k: int) -> str:
        for i in range(k):
            if self.cur == self.dumpy:
                break
            self.cur = self.cur.pre
        return self.f()

    def cursorRight(self, k: int) -> str:
        for i in range(k):
            if self.cur.succ == None:
                break
            self.cur = self.cur.succ
        return self.f()
        
    def f(self) -> str:
        ans = ""
        cur = self.cur
        for i in range(10):
            if cur == self.dumpy:
                break
            ans = cur.ch + ans
            cur = cur.pre
        return ans

# 调用 addText ，deleteText ，cursorLeft 和 cursorRight 的 总 次数不超过 2 * 104 次。
# 对顶栈
# O(N)
# 
# 
class TextEditor:
    def __init__(self):
        self.ls = []
        self.rs = []

    def append(self, arr : List[int], num) -> None:
        arr.append(num)

    def pop(self, arr : List[int]) -> int:
        return arr.pop(-1)

    def addText(self, text: str) -> None:
        for s in text:
            self.append(self.ls, s)

    def deleteText(self, k: int) -> int:
        for i in range(k):
            if len(self.ls) == 0:
                return i
            self.pop(self.ls)
        return k

    def cursorLeft(self, k: int) -> str:
        for i in range(k):
            if len(self.ls) == 0:
                break
            self.append(self.rs, self.pop(self.ls))
        size = len(self.ls)
        return "".join(self.ls[size-min(10, size):size])

    def cursorRight(self, k: int) -> str:
        for i in range(k):
            if len(self.rs) == 0:
                break
            self.append(self.ls, self.pop(self.rs))
        size = len(self.ls)
        return "".join(self.ls[size-min(10, size):size])

# Your TextEditor object will be instantiated and called as such:
# obj = TextEditor()
# obj.addText(text)
# param_2 = obj.deleteText(k)
# param_3 = obj.cursorLeft(k)
# param_4 = obj.cursorRight(k)