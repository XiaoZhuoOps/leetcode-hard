"""
1
2 x y 
3 
4
"""
# class Solution:
#     def f(x, y):
#         a = max(x, y) - min(x, y)
#         if a >= min(x, y):
#             return min(x, y)
#         else:
#             return 2*(min(x,y)-a)//3 + a
# n = int(input())
# arr = [0 for _ in range(n)]
# for i in range(n):
#     arr[i] = list(map(int, input().split()))
# for i in range(n):
#     print(Solution.f(arr[i][0], arr[i][1]))

"""
2 
4 [1]
"""
# class Solution:
#     def f(n, nums):
#         ls, rs = [0 for _ in range(n+1)], [0 for _ in range(n+1)]
#         ans = float('inf')
#         for k in range(1,n+1):
#             if nums[k-1] >= 0:
#                 ls[k] = ls[k-1]+1
#             else:
#                 ls[k] = ls[k-1]
#         for k in range(n-1, -1, -1):
#             if nums[k] <= 0:
#                 rs[k] = rs[k+1]+1
#             else:
#                 rs[k] = rs[k+1]
#         for k in range(n+1):
#             ans = min(ans, ls[k]+rs[k])
#         return ans

# n = int(input())
# nums = list(map(int, input().split()))
# print(Solution.f(n, nums))

"""
1 dp
1 
5
1 5 7 5 5 
10 5 5 9 10
2 count[i][0] 
3
4
# """
# import heapq
# class Solution:
#     def f(n, nums1, nums2):
#         m1, m2 = {}, {}
#         for i in range(n):
#             if nums1[i] not in m1:
#                 m1[nums1[i]] = 0
#             m1[nums1[i]] += 1

#         for i in range(n):
#             if nums2[i] not in m2:
#                 m2[nums2[i]] = 0
#             m2[nums2[i]] += 1
        
#         half = n//2 if n%2 == 0 else n//2+1
#         h = []
#         for k, v in m1.items():
#             heapq.heappush(h, (v, k))
#         ans = float('inf')
#         while h:
#             v, k = heapq.heappop(h)
#             if v >= half:
#                 return 0
#             else:
#                 if v+m2.get(k,0) >= half:
#                     ans = min(ans, half-v)
#         return -1 if ans == float('inf') else ans

# n = int(input())
# nums1 = list(map(int, input().split()))
# nums2 = list(map(int, input().split()))
# print(Solution.f(n, nums1, nums2))

# class Solution:
#     def f(n, nums):
#         map = {}
#         for i in range(1,n+1):
#             if nums[i-1] not in map:
#                 map[nums[i-1]] = []
#             map[nums[i-1]].append(i)
#         a, b = [], []
#         for k, v in map.items():
#             m = len(v)
#             p = m//2 if m%2 == 0 else m//2+1
#             a += v[:p]
#             b += v[p:]
#         a.sort()
#         b.sort()
#         astr, bstr = [], []
#         for e in a:
#             astr.append(str(e))
#         for e in b:
#             bstr.append(str(e))

#         print(" ".join(astr))
#         print(" ".join(bstr))


# line1 = list(map(int, input().split()))
# n = line1[0]
# nums = list(map(int, input().split()))
# Solution.f(n, nums)

s = str(input())
print(s+s.reverse()+"wowwow"+s+s.reverse()+"wow")