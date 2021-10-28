package interview;

/**
 *  1思路：按位统计后验证
 *      a(主要元素)->b(对应的位值出现的次数最多)
 *      再遍历整个数组 验证是否满足 b->a
 *  2伪代码：统计次数 构造res
 *  3实现：
 */
public class I1710 {
    public int majorityElement(int[] nums) {
        //init
        int res = 0;
        //statics
        for(int i = 0; i < 32; i++){
            int a = 0, b = 0;
            for (int num:nums){
                if(((num>>i)&1) == 1) a++;
                else b++;
            }
            if(a == b) return -1;
            int bit = (a>b)?1:0;
            res+=bit<<i;
        }
        //check
        int n = 0;
        for(int num:nums){
            if(num == res) n++;
        }
        return (n>nums.length/2)?res:-1;
    }
}
