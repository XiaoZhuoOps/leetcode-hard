package basic.DS.List.SlidingWindow;

import java.util.HashMap;

public class SW3 {
    public int lengthOfLongestSubstring(String s){
        int len = s.length(), ans = 0, left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while(right<len){
            Character ch = s.charAt(right);
            if(window.containsKey(ch)){
                int l = window.get(ch);
                for(int i = left; i<=l; i++){
                    window.remove(s.charAt(i));
                }
                left = l+1;
            }
            window.put(ch,right);
            right++;
            ans = Math.max(ans,window.size());
        }
        return ans;
    }
}
