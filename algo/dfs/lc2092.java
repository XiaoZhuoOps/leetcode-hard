package algo.dfs;

import java.util.*;

public class lc2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        boolean[] knows = new boolean[n];
        //init
        knows[0] = true;
        knows[firstPerson] = true;

        int i = 0, time = 1;
        while (i < meetings.length) {
            time = meetings[i][2];
            Map<Integer, List<Integer>> map = new HashMap<>();
            while (i < meetings.length && meetings[i][2] == time) {
                graph(map, meetings, i);
                i++;
            }

            //dfs
            dfs(map, knows);
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < knows.length; j++) {
            if (knows[j]) ans.add(j);
        }
        return ans;
    }

    void dfs(Map<Integer, List<Integer>> map, boolean[] knows) {
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (!knows[entry.getKey()]) continue;
            dfs0(map, knows, entry.getKey());
        }
    }

    void dfs0(Map<Integer, List<Integer>> map, boolean[] knows, int key) {
        for (Integer neighbor : map.get(key)) {
            if (knows[neighbor]) continue;
            knows[neighbor] = true;
            dfs0(map, knows, neighbor);
        }
    }

    void graph(Map<Integer, List<Integer>> map, int[][] meeting, int i) {
        int x = meeting[i][0], y = meeting[i][1];
        if (!map.containsKey(x)) map.put(x, new ArrayList<>());
        if (!map.containsKey(y)) map.put(y, new ArrayList<>());
        map.get(x).add(y);
        map.get(y).add(x);
    }
}
