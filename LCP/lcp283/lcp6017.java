package LCP.lcp283;

import java.util.Arrays;


public class lcp6017 {
    public long minimalKSum(int[] nums, int k) {
        //[1,4,25,10,25]
        long sum = 0, count = 0;
        Arrays.sort(nums);
        int i = 0, last = 0;
        for (; i < nums.length; i++) {
            if (count + count(last, nums[i]) <= k) {
                sum += sum(last, nums[i]);
                count += count(last, nums[i]);
                last = nums[i];
            } else {
                break;
            }
        }
        sum += sum(last, (int) (k-count+last+1));
        return sum;
    }
    long sum(int s, int e) {
        long count = count(s,e);
        if (count < 1) return 0;
        return count*(s+e)/2;
    }
    long count(int s, int e) {
        return Math.max(e-s-1, 0);
    }
}
