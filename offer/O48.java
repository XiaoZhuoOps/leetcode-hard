package offer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * //
 * 维护一个不含有重复元素的滑动窗口
 * i 和 j的更新方式 map
 * 复杂度O(N)
 */
public class O48 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        //lastJ表示j对应的元素上一次出现的位置
        int i = 0, j = 0, res = 0, temp = 0, lastJ = 0;
        int[] map = new int[26];
        Arrays.fill(map,-1);

        while (j<s.length()){
            //[i,j)
            if(map[s.charAt(j) - 'a'] == -1) {
                map[s.charAt(j) - 'a'] = j;
                j++;
                temp++;
            }
            else{
                res = Math.max(res, temp);

                //在map中将[i,Lastj]的元素都置为0
                lastJ = map[s.charAt(j) - 'a'];
                for (int a = i; a <= lastJ; a++) map[s.charAt(a)-'a'] = 0;

                i = lastJ+1;
                //此时的j不包含在窗口内
                temp = j-i;
            }
        }
        //最后一个元素
        return Math.max(res, temp);
    }
}
