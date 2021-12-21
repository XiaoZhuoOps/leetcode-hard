package LCP.LCP272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc5959 {
}

class Solution {
    public int kIncreasing(int[] arr, int k) {
        int len = arr.length, res = 0;
        boolean[] vis = new boolean[len];
        int i = 0, temp = 0; //[0,len-1-k]
        while (i <= len-1-k) {
            temp = i;
            if (!vis[i]){
                List<Integer> list = new ArrayList<>();
                while (i <= len-1-k) {
                    list.add(arr[i]);
                    vis[i] = true;
                    i = i+k;
                }
                list.add(arr[i]);
                res += (list.size() - lengthOfLIS(list));
            }
            i = temp + 1;
        }

        return res;
    }
    int longestAddSeq(List<Integer> nums) {
        int[] dp = new int[nums.size()];
        int res = 0;
        Arrays.fill(dp,1);
        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(nums.get(j) <= nums.get(i)) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public int lengthOfLIS(List<Integer> nums) {
        int len = 1, n = nums.size();
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums.get(0);
        for (int i = 1; i < n; ++i) {
            if (nums.get(i) >= d[len]) {
                d[++len] = nums.get(i);
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums.get(i)) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums.get(i);
            }
        }
        return len;
    }
}