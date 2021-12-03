package basic.bin;

public class BS275 {
    /**
     *
     * @param citations
     * @return index
     * int right_bound(int[] nums, int target) {
     *     int left = 0, right = nums.length - 1;
     *     while (left <= right) {
     *         int mid = left + (right - left) / 2;
     *         if (nums[mid] < target) {
     *             left = mid + 1;
     *         } else if (nums[mid] > target) {
     *             right = mid - 1;
     *         } else if (nums[mid] == target) {
     *             // 别返回，锁定右侧边界
     *             left = mid + 1;
     *         }
     *     }
     *     // 最后要检查 right 越界的情况
     *     if (right < 0 || nums[right] != target)
     *         return -1;
     *     return right;
     * }
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = citations.length, ans = 0;
        while(left<right){
            int mid = left + (right-left)/2;
            if(citations[mid]<len-mid){
                left = mid+1;
            }
            else if(citations[mid]>=len-mid){
                ans = len - mid;
                right = mid;
            }
            //死循环和越界检查
        }
        //ans = 0: 第一种情况：没中 return 0; 第二种情况 中了 mid = 0 return len - ans;
        return ans;
    }
}
