package LCP;
/*
    思路 穷举
    伪代码
 */
public class L1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        //穷举
        int a = 0, b = 0, maxDif = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums1.length; j++){
                int dif = Math.abs(nums1[j] - nums2[j]) - Math.abs(nums1[i] - nums2[j]);
                if(maxDif < dif){
                    maxDif = dif;
                    a = i;
                    b = j;
                }
            }
        }
        nums1[b] = nums1[a];
        int res = 0;
        for(int i = 0; i < nums1.length; i++){
            res += Math.abs(nums1[i] - nums2[i]);
        }
        return res;
    }
}
