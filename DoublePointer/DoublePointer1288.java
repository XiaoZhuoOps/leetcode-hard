package DoublePointer;

import java.util.Arrays;

public class DoublePointer1288 {
    /**
     *
     * 删去数组中所有满足interval[i][0]<=interval[j][0] && interval[j][1]<=interval[i][1]的索引为i的元素
     * 双指针 二维数组
     * 如何不删除？
     * break内循环还是外循环？
     * java数组类型需要构造器吗？
     */
    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length, skip = 0;
        int[] skips = new int[len];
        for (int i = 0; i < len; i++) {
            if(skips[i] == -1) continue;
            for (int j = i+1; j < len; j++) {
                if(skips[j] == -1) continue;
                if(intervals[i][0] <= intervals[j][0] &&
                        intervals[i][1] >= intervals[j][1]){
                    skips[j] = -1;
                    skip++;
                }
                if(intervals[i][0] >= intervals[j][0] &&
                        intervals[i][1] <= intervals[j][1]){
                    break;
                }
            }
        }
        return len - skip;
    }

    /**
     * 先排序，后单指针
     * 按照Li升序,对于位置i处的元素,如果存在j<i,且Ri<=Rj,i被移除。
     * 如何排序？函数式编程：函数作为基本的运算单元，可以接受返回，lambda表达式或者内部类
     * 如何将双指针减少？双指针：两两比较；单指针：与反映区间数据特征的状态量比较
     * error1 解答错误
     */
    public int removeCoveredIntervals2(int[][] intervals){
        //对internals排序
        Arrays.sort(intervals, (int[] a, int[] b)->{
            return (a[0] != b[0])?(a[0] - b[0]):(b[1] - a[1]);
        });
        //单指针
        int i = 0, max = 0, len = intervals.length, skip = 0;
        while(i < len){
            if(intervals[i][1] <= max) skip++;
            else {
                max = intervals[i][1];
            }
            i++;
        }
        return len - skip;
    }
}


