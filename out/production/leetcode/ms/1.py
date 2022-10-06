"""
1 192.168.0.1 / 0 - 1(8) / 01
1 输入 G级别数据 -1 001
1 遍历
1 .. / 01 / .0. 
2 seg, cnt
3
4 为什么选这道题？bug多，无关算法、考虑各种corner case、实际工程中考虑各种bug，尽可能多的cover case，同时高性能
"""


class Solution:
    def isValid2(ipStr):
        seg, cnt = -1, 1
        for s in ipStr:
            if s == '.':
                if seg == -1 or 255 < seg:
                    return False
                cnt += 1
                seg = -1
            elif s < '0' or '9' < s:
                return False
            else:
                if seg == 0:
                    return False
                if seg == -1:
                    seg = int(s)
                else:
                    seg = 10*seg + int(s)
        return cnt == 4

    def isValid(ipStr):
        n = len(ipStr)

        def calcSeg(ipStr, s):
            seg = 0
            i = s
            while i < n and ipStr[i] != '.':
                if ipStr[i] > '9' or ipStr[i] < '0':
                    return -1
                if ipStr[i] == '0' and i+1 < n and ipStr[i+1] != '.':
                    return -1
                ## seg += ipStr[i]
                seg = seg*10 + ord(ipStr[i]) - ord('0')
                i += 1
            if seg == -1 or 255 < seg:
                return -1
            return i

        next = 0
        for i in range(4):
            next = calcSeg(ipStr, next)
            if next == -1:
                return False
            if i < 3 and next == n:
                return False
            next += 1
        return next == n


print(Solution.isValid2("1.1.1.1.1.1"))
"""
1
2
3
4
"""
"""
1 lru
2 map<k, node> 
3 -
4
"""


class Node:
    def __init__(self, key, val, prev, next):
        self.key = key
        self.val = val
        self.prev = prev
        self.next = next


class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.size = 0
        self.map = {}
        self.header = Node(0, 0, None, None)
        self.tailer = Node(0, 0, None, None)
        self.header.prev = self.tailer
        self.tailer.next = self.header

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.map:
            return -1
        node = self.map[key]
        self.put(key, node.val)
        return node.val

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.map:
            node = self.map[key]
            node.val = value
            self.removeNode(node)
            self.addFirst(key, value)
            # newNode = Node(key, value, self.header.prev, self.header)
        else:
            if self.size == self.capacity:
                self.removeLast()
                self.put(key, value)
            else:
                self.addFirst(key, value)

    def removeNode(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
        self.map.pop(node.key)
        self.size -= 1

    def removeLast(self):
        self.removeNode(self.tailer.next)

    def addFirst(self, key, value):
        newNode = Node(key, value, self.header.prev, self.header)
        self.header.prev.next = newNode
        self.header.prev = newNode
        self.map[key] = newNode
        self.size += 1
