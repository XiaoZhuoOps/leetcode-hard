package LCP.LCP264;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lcp2049 {
    public int countHighestScoreNodes(int[] parents) {
        int max = -1, num = 0;
        int[] parentss = Arrays.copyOf(parents, parents.length);
        for (int i = 0; i < parents.length; i++) {
            int prod = product(parents, i);
            if (prod == max) {
                num++;
            } else if (prod > max) {
                max = prod;
                num = 1;
            }
            parents = parentss;
        }
        return max;
    }

    int product(int[] parents, int k) {
        for (int i = 0; i < parents.length; i++) {
            if (i == k) {
                parents[i] = -2;
            }
            if (parents[i] == k) {
                parents[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -2) continue;
            int j = i;
            while (parents[j] != -1) {
                j = parents[j];
            }
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        int prod = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            prod *= entry.getValue();
        }
        System.out.println(prod);
        return prod;
    }
}


