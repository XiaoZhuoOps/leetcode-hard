package bit;

/*
    1思路 两两比较 记录最大的不含公共字母的字符串对的长度的乘积
    2伪代码
        for i
            for j
                if(len1*len2 < maxLen) continue
                if(noCommon(i,j)) update maxLen
        比较是否包含公共字母
            转换成位图做与运算 结果=0 说明两个字符串没有相同字符
            abc&dc -> 0111 & 1100 != 0
    3实现
 */
public class B318 {
    public int maxProduct(String[] words) {
        //hash
        int[] hashTable = new int[words.length];
        for(int j = 0; j < words.length; j++){
            int hash = 0;
            for(int i = 0; i < words[j].length(); i++){
                hash |= (1 << (words[j].charAt(i) - 'a'));
            }
            hashTable[j] = hash;
        }
        //traver
        int maxLen = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                int len = words[i].length()*words[j].length();
                if(len <= maxLen) continue;
                if((hashTable[i] & hashTable[j]) == 0){
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }
}
