package basic.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs743 {
    // 典型的bfs问题->
    // bfs框架->伪代码->
    // 实现 
    // Queue<Integer> q = new LinkedList<>();
    // int num = 0, res = 0;q.add(K);while(!q.isEmpty()){
    //         Integer front = q.poll();
    //         num++;
    //         for(Integer adj:adjs){
    //             res += Time(front,adj);
    //             q.add(adj);
    //         }
    //     }return(num<N)?-1:res;
    // error result: cost of path != total cost
    // run of time: [[1,2,1],[2,1,3]] 2 2 缺少visited[] 死循环
    // error result: [[1,2,1],[2,3,2],[1,3,4]] 3 1 没有考虑要求的是最短可以遍历所有节点的时间
    // error result
    // 树是单向无跨边的图
    // class Node{
    //     int seq;
    //     int time; //time of path to this node
    //     Node(int seq, int time){
    //         this.seq = seq;
    //         this.time = time;
    //     }
    // }
    //
    int maxTime = 0;

    public int networkDelayTime(int[][] times, int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        // 用hashmap存储 是否被访问过 以及最短时间
        // boolean[] visited = new boolean[N+1];
        HashMap<Integer, Integer> visited = new HashMap<>();
        q.add(K);
        visited.put(K, 0);
        while(!q.isEmpty()){
            Integer front = q.poll();
            for(int[] time:times){
                if(time[0] == front){
                    //已经访问过的节点 
                    if(visited.get(time[1]) != null) {
                        // 比较和更新时间 
                        if(visited.get(front) + time[2] < visited.get(time[1])){
                                visited.put(time[1],visited.get(front) + time[2]);
                                q.add(time[1]); // Node(1,3)
                        }
                        continue;
                    };
                    //未访问过的节点
                    q.add(time[1]); //Node(1,3)
                    visited.put(time[1], visited.get(front) + time[2]);
                }
            }
        }
        //遍历 找到时间最大值
        visited.forEach((a,b)->{
            // lambda 相当于 在创建一个内部类 并生成一个对象
            if(b > maxTime) maxTime = b;
        });
        return (visited.size() < N)?-1:maxTime;
    }
}
