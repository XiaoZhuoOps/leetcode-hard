package DoublePointer;

import java.util.LinkedList;
import java.util.Queue;

public class DoublePointer649 {
    /**
     * 正向循环遍历，每到达一个字符，就把它之后的距离最近的相反的字符消除，直到字符串中只存在一种字符
     * 队列
     * 所有的数据结构：数组 向量 链表 栈 队列 堆 树 图 哈希
     * @param senate
     * @return
     */

/*    public String predictPartyVictory(String senate) {
        int i = 0, j = 0;
        while(i!=j){
            j = next(i);
            while(i!=j){
                if(s[j]!=s[i]) s[j]失效,break
                j = next(j);
            }
            if(i!=j) i = next(i);
        }
        return s[i];
    }*/

    /**
     * 正向循环遍历，每到达一个字符，就把它之后的距离最近的相反的字符消除，直到字符串中只存在一种字符
     * 双循环队列 Q1 = [Index_q1,...]
     * 如何实现循环？
     */
    public String predictPartyVictory(String senate) {
        //构造队列
        Queue<Integer> Qr = new LinkedList<>();
        Queue<Integer> Qd = new LinkedList<>();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if(senate.charAt(i) == 'R') Qr.offer(i);
            if(senate.charAt(i) == 'D') Qd.offer(i);
        }
        //循环
        Integer r = 0,d = 0;
        while(Qd.size()>0 && Qr.size()>0){
            r = Qr.peek(); //r 队首元素的索引
            d = Qd.peek();
            if(r < d) Qr.offer(r+length);
            else Qd.offer(r+length);
            Qr.remove();
            Qd.remove();
        }
        return (Qd.size()>Qr.size())?"Dire":"Radiant";
    }
}
