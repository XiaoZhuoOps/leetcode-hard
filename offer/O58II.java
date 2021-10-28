package offer;

/* 
    思路
    伪代码 
    实现
*/
public class O58II {
    public String reverseLeftWords(String s, int n) {
        String sub1 = s.substring(n,s.length()-1); 
        String sub2 = s.substring(0, n);
        return sub1+sub2;
    }
}
