package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1,p2)->{
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            }
            return p2[0]-p1[0];
        });
        List<int[]> linkedList = new LinkedList<>();
        for (int[] p : people) {
            linkedList.add(p[1], p);
        }
        return linkedList.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        System.out.println("xx");
    }
}
