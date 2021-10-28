package LCP.D25;

/**
 * step1
 *      不是9的最高位对应的数 -> 9
 *      首位>1 -> 1
 *      首位=1
 *          下一位=0
 *              下一位
 *                  ...
 *                      下一位>0 -> 0
*
 * step2
 *      转换成字符串 字符数组
 *      借用内部函数 replace
 * step3
 *      check
 *      111
 */
public class C1432 {
    public int maxDiff(int num) {
        /*char[] nums = str.toCharArray(); //['9',,,]
        //max
        int len = nums.length;
        int a = -1, b = -1, max = 0, min = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] ok || nums[i] - '0' == a){
                a = nums[i] - '0';
                max += Math.pow(10, len-i);
            }
        }
        max *= (9-a);
        //min
        for (int i = 0; i < len; i++) {
            if(nums[i] ok || nums[i] - '0' == b){
                b = nums[i] - '0';
                min += Math.pow(10, len-i);
            }
        }
        min *= (1 or 0)?(b):(b-1);
        return max + min;*/
        //cast to String
        String str = num + "";
        char a = '9', b = '0';
        int len = str.length();
        //
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) != '9'){
                a = str.charAt(i);
                break;
            }
        }
        //
        for (int i = 1; i < len; i++) {
            if(str.charAt(i) != '0'){
                b = str.charAt(i);
                break;
            }
        }
        String max = str.replace(a, '9');
        String min = str;
        if(str.charAt(0) != '1') {
            b = str.charAt(0);
            min = str.replace(b, '1');
            //首位 = 1 ok
        }else if(b != '1'){
            //首位 1 -> 0
            min = str.replace(b, '0');
        }
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}
