package offer;

import java.util.Arrays;
import java.util.Comparator;

public class O1708 {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] person = new int[weight.length][2];
        for (int i = 0; i < weight.length; i++) {
            person[i][0] = height[i];
            person[i][1] = weight[i];
        }
        //按照 height正序 weight逆序 对person排序
        Arrays.sort(person, (a,b)->{
            if(a[0] < b[0]) return -1;
            else if(a[0] == b[0] && a[1] > b[1]) return -1;
            else return 1;
        });

        //构造dp[] size为序列的最长长度 dp[i]长度为i的序列的最小首元素
        int[] dp = new int[person.length];
        int size = 0;
        dp[0] = 0;

        for (int i = 0; i < person.length; i++) {
            //二分查找来更新 dp和size
            int l = 1, r = size+1;
            while(l<r){
                int mid = (l+r)/2;
                if(dp[mid] < person[i][1]){
                    l = mid + 1;
                }else if(dp[mid] > person[i][1]){
                    r = mid;
                }else{
                    //dp[mid] == p[i][1] do nothing
                    break;
                }
            }
            //l==r表示没有找到 必满足dp[l-1]<p[i][1]<dp[l]
            if(l==r) dp[l] = person[i][1];
            //if 没有找到且r没变 说明p[i][1] > dp[mid]
            if(l == r && r == size+1) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{65,70,56,75,60,68};
        int[] a2 = new int[]{100,150,90,190,95,110};
        new O1708().bestSeqAtIndex(a1,a2);
    }
}
