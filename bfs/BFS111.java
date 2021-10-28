package bfs;

/*// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
        Queue<Node> q; // 核心数据结构
        Set<Node> visited; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        while (q not empty) {
            int sz = q.size();

            *//* 将当前队列中的所有节点向四周扩散 *//*
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                *//* 划重点：这里判断是否到达终点 *//*
                if (cur is target)
                return step;
                *//* 将 cur 的相邻节点加入队列 *//*

            for (Node x : cur.adj())
                if (x not in visited) {
                q.offer(x);
                visited.add(x);
                }
            }
            *//* 划重点：更新步数在这里 *//*
            step++;
            }
            }*/

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*public class BFS111 {
    public int minDepth(TreeNode root) {

        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int count = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                if(curNode.left!=null) q.add(curNode.left);
                else if(curNode.right!=null) q.add(curNode.right);
                else return count;
            }
            count++;
        }
        return count;
    }
}*/
