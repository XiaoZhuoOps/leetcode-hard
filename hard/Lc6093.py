# 调用 addText ，deleteText ，cursorLeft 和 cursorRight 的 总 次数不超过 2 * 104 次。
# 双向链表
# O(N)
# 
# 
from _typeshed import Self


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

# Your TextEditor object will be instantiated and called as such:
# obj = TextEditor()
# obj.addText(text)
# param_2 = obj.deleteText(k)
# param_3 = obj.cursorLeft(k)
# param_4 = obj.cursorRight(k)