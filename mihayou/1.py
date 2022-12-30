#coding=utf-8
import sys 
#str = input()
#print(str)
"""
1 
2 sum "18" 3 9 = 12 add(sum) sum+2
2 add("19")  
3 -
4
"""
class solution:
    def f(astr, bstr):
        lastSum = ""
        n = len(astr)
        
        def increment(lastSum):
            if lastSum == "":
                return "1"
            num = int(lastSum[-1])
            if num == 9:
                return increment(lastSum[:-1])+str(0)
            return lastSum[:-1]+str(num+1)
            
        for i in range(n):
            a, b = int(astr[i]), int(bstr[i])
            sum = a+b
            if sum >= 10:
                lastSum = increment(lastSum)+str(sum%10)
            else:
                lastSum += str(sum)
        print(lastSum)
        
        
a = "9000000000000356456456"
b = "2999999999999946575676"
solution.f(a, b)
print(int(a) + int(b))


#coding=utf-8
import sys 
#str = input()
#print(str)
"""
1 hash
2 [3 5 1 2]
2 [1 2 3 4]
2 [1 2 3 5]
2 []
2 -
3 -
4 
"""
class solution:
    def f(nums):
#         nums = [3,5,1,2]
        n = len(nums)
        for i in range(n):
            a = abs(nums[i])
            if 1 <= a <= n:
                nums[a-1] = -1*nums[a-1]
                
        for i in range(n):
            if nums[i] > 0:
                print(i+1)
                return
    def f2(nums):
        def qs(nums, l, r):
            if l >= r:
                if nums[l] == l+1:
                    return l+2
                else:
                    return l+1
            mid = nums[l]
            i, j = l, r
            while i < j:
                while i < j and mid <= nums[j]:
                    j -= 1
                nums[i] = nums[j]
                while i < j and nums[i] <= mid:
                    i += 1
                nums[j] = nums[i]
            nums[i] = mid
            if nums[i] > i+1:
                return qs(nums, l, i)
            else:
                return qs(nums, i+1, r)
        print(qs(nums, 0, len(nums)-1))
print(solution.f2([2,3,1]))



class solution:
    def f(n):
        ans = 0
        a = n
        while a > 0:
            ans += a
            a //= 2
        return ans

