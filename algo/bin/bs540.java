package algo.bin;

public class bs540 {
    // 以原数组为单调性依据，在索引数组上二分搜索
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length/2 + 1;
        int l = 1, r = n+1, mid, index = 0, ans = 0; //[1,r)
        // l从1开始，所以mid对应的是第mid个数
        while(l<r){
            mid = (l+r)/2;
            index = 2*mid-1;
            if(index == nums.length || 
                nums[index-1] != nums[index]){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        } 
        return nums[index-1];
    }
}
