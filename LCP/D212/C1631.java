package LCP.D212;
/**
 * step1
 *      dfs 剪枝
 * step2
 *      last：上一个节点的高度
 *      d：当前相邻节点的差值
 *      max: 当前路径相邻差值最大值
 *      min：整个图中所有路径的最大差值的最小值
 *      mark[]：
 *      i j
 *      if d>=min return
 * step3
 *      error 超时
 *
 * step1
 */
public class C1631 {
    int[][] mark;
    int min;
    public int minimumEffortPath(int[][] heights) {
        //init
        mark = new int[heights.length][heights[0].length];
        min = Integer.MAX_VALUE;
        //dfs
        dfs(heights, 0, 0, heights[0][0], 0);
        return min;
    }

    void dfs(int[][] heights, int i, int j, int last, int max){
        //base
        if(i<0 || heights.length<=i || j<0 || heights[0].length <=j) return;
        if(mark[i][j] == -1) return;
        //剪枝
        int d = Math.abs(heights[i][j] - last);
        if(min <= d) return;
        //update
        if(max < d) max = d;
        last = heights[i][j];
        //mark
        mark[i][j] = -1;
        //dfs
        if(i + 1 != heights.length || j + 1 != heights[0].length){
            dfs(heights, i-1, j, last, max);
            dfs(heights, i+1, j, last, max);
            dfs(heights, i, j-1, last, max);
            dfs(heights, i, j+1, last, max);
        }else {
            if(max <= min) min = max;
        }
        //de mark
        mark[i][j] = 0;
    }
}
