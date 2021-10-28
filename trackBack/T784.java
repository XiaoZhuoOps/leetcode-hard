package trackBack;

import java.util.ArrayList;
import java.util.List;
/*
    1思路 组合->回溯
    2伪代码
    3实现
 */
public class T784 {
    List<String> res;
    public List<String> letterCasePermutation(String S) {
        res =  new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) < '0' || S.charAt(i) > '9'){
                temp.add(i);
            }
        }
        char[] cur = S.toCharArray();
        tb(S, cur, temp, 0);
        return res;
    }

    void tb(String s, char[] cur, List<Integer> temp, int p){
        //base
        res.add(new String(cur));
        //recur
        for(int i = p; i < temp.size(); i++){
            //convert
            char ch = cur[temp.get(i)];
            cur[temp.get(i)] = convert(ch);
            tb(s, cur, temp, i+1);
            //re convert
            cur[temp.get(i)] = ch;
        }
    }

    char convert(char c){
        return (c<97)?((char)(c+32)):((char)(c-32));
    }
}
