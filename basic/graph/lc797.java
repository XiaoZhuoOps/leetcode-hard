package basic.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * error ans =[[],[]] stack == null add()方法传递的参数是一个地址，直接传stack想等于传地址，因为最后stack是null，所以最后的ans立面也是[][]
 * 因为给stack创建一个副本，把副本的地质穿进去 这样stack改变也不会改变副本的内容
 */
public class lc797 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> stack = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0);
        return ans;
    }
    
    void dfs(int[][] graph, int V){

        stack.add(V);
        if(V+1 == graph.length) {
            //ans.add(stack)
            ans.add(new ArrayList<>(stack));
        }
        else{
            for(int W : graph[V]) {
                dfs(graph, W);
            }
        }
        stack.remove(stack.size()-1);
    }

    void print(List<Integer> list){
        for(Integer i:list){
            System.out.print(i);
        }
        System.out.print("---");
    }
}