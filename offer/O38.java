package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * ["","","","","",""] 引用传递
 * aab -> 重复 hashset
 * 剪枝
 * 1.先排序
 * 2.在同一层的遍历中，若遇到多个相同字符，后续的结果都是相同的
 * 3.如果上一个元素与该元素相同，且没有被mark过(同一层)，剪枝
 *
 */
class O38 {
    char[] chars; 
    public String[] permutation(String s) {
        chars = s.toCharArray();
        Arrays.sort(chars);
        int[] marked = new int[chars.length];
        Arrays.fill(marked, -1);

        StringBuilder path = new StringBuilder();
        List<String> ans = new ArrayList<>();
        trackBack(marked,path,ans);
        return ans.toArray(new String[0]);
    }


    void trackBack(int[] marked, StringBuilder path, List<String> ans){
        if(path.length() == marked.length){
            //StringBuilder -> String
            ans.add(new String(path));
            return;
        }
        for(int i = 0; i < marked.length; i++){
            if(marked[i] == 1){
                continue;
            }
            if( 0<i && chars[i] == chars[i-1] && marked[i-1] == -1) continue;
            path.append(chars[i]);
            marked[i] = 1;
            trackBack(marked, path, ans);
            path.deleteCharAt(path.length()-1);
            marked[i] = -1;
        }
    }
}