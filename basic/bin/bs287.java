package basic.bin;


public class bs287 {
    /**
     *
     * @param nums
     * @return
     * 二分查找框架
     * int bs(int[] nums, int tar){
     *     int left = 0, right = nums.length;
     *     while(left<right){
     *         int mid = (right-left)/2;
     *         if(nums[mid] == tar){
     *         ...
     *         }else if(nums[mid]<tar){
     *         ...
     *         }else if(nums[mid]>tar){
     *         ...
     *         }
     *     }
     *     return ...;
     * }
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length; //n+1
        int l = 0, r = n-1, ans = -1; //n
        //二分搜索的目标数组是[1,2,3..]
        while(l<=r){
            int mid = (l+r)/2;
            //计算cnt
            int cnt = 0;
            for(int i = 0;i<n;i++){
                if(nums[i]<=mid)
                    cnt++;
            }
            if(cnt<=mid) l=mid+1;
            else{
                //r=mid 可能会导致无限循环
                r = mid-1;
                //寻找cnt>mid的左边界
                ans = mid;
            }
        }
        return ans;
    }
}
