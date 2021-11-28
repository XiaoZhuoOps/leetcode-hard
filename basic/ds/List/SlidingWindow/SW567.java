package basic.ds.List.SlidingWindow;

import java.util.HashMap;


/*void slidingWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...
        *//*** debug 输出的位置 ***//*
        printf("window: [%d, %d)\n", left, right);
        *//********************//*

        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
        // d 是将移出窗口的字符
        char d = s[left];
        // 左移窗口
        left++;
        // 进行窗口内数据的一系列更新
        ...
        }
        }
        }*/

public class SW567 {
    /*1.如何判断匹配是否成功？
    *   定义：valid = 匹配的字符的个数; 判断：valid=s1.length(); 更新：... 使用：
    *
    * */
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for(int i = 0;i < s1.length();i++){
            hm1.put(s1.charAt(i),hm1.getOrDefault(s1.charAt(i),0)+1);
        }
        int left = 0, right = 0;
        int valid = 0;  //匹配的字符的数目
        while(right<s2.length()){
            char c = s2.charAt(right);
            right++;
            //update window
            hm2.put(c,hm2.getOrDefault(c,0)+1);
            //update valid
            int a = hm1.getOrDefault(c,0), b = hm2.get(c);
            if(a==b) valid++;
            else if(a+1==b) valid--;
            while(right-left>=s1.length()){
                if(valid == hm1.size()) return true;
                char d = s2.charAt(left);
                left++;
                //update window
                //update valid
                a = hm1.getOrDefault(d,0);
                b = hm2.get(d);
                if(a==b) valid--;
                else if(a+1==b) valid++;
                //remove hm2[d]
                if(hm2.get(d) == 1) hm2.remove(d);
                else hm2.put(d,hm2.get(d)-1);
            }
        }
        return false;
    }
}


