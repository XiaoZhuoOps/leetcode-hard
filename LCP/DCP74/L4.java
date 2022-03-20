package LCP.DCP74;


import java.util.ArrayList;
import java.util.List;

/**
 *"11111"
 *         2
 *         3
 */
public class L4 {
    int min = Integer.MAX_VALUE;
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int len = floor.length();
        dfs(floor, numCarpets, carpetLen, 0, new ArrayList<>());
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

    void dfs(String floor, int numCarpets, int carpetLen, int start, List<Integer> path) {
        if (numCarpets == 0 || start >= floor.length()) {
            int left = path.get(0), val = 0;
            for (int i = 0; i < left; i++)
                if (floor.charAt(i) == '1') val++;
            for (int j = start; j < floor.length(); j++)
                if (floor.charAt(j) == '1') val++;
            min = Math.min(min, val);
            return;
        }
        for (int i = start; i < floor.length(); i++) {
            if (floor.charAt(i) == '0') continue;
            int j = Math.min(floor.length(), carpetLen + i);
            path.add(i);
            dfs(floor, numCarpets - 1, carpetLen, j, path);
            path.remove(path.size() - 1);
        }
    }
}
