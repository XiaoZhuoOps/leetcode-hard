# 给你一个整数数组 nums 。请你对数组执行下述操作：

# 从 nums 中找出 任意 两个 相邻 的 非互质 数。
# 如果不存在这样的数，终止 这一过程。
# 否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
# 只要还能找出两个相邻的非互质数就继续 重复 这一过程。
# 返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。

# 生成的测试用例可以保证最终数组中的值 小于或者等于 108 。

# 两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。
# 1 2 3 
class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        def GCD(x, y):
            # return a % b != 0 ? gcd(b, a % b) : b;
            return GCD(y, x%y) if x%y != 0 else y

        def LCM(x, y):
            return x*y//GCD(x, y)

        stack = collections.deque()

        if len(nums) == 1: return nums

        for cur in nums:
            while len(stack) > 0 and GCD(stack[-1], cur) > 1:
                cur = LCM(stack.pop(), cur)
            stack.append(cur)

        return [i for i in stack]
        


class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        s = []
        for num in nums:
            s.append(num)
            while len(s) > 1:
                x, y = s[-1], s[-2]
                g = gcd(x, y)
                if g == 1: break
                s.pop()
                s[-1] *= x // g
        return s



