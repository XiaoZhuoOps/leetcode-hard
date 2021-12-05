package basic.unionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lc2092{
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        UnionFind uf = new UnionFind(parents);
        uf.unite(firstPerson, 0);
        int time = 0;
        for (int i = 0; i < meetings.length;) {
            time = meetings[i][2];
            int last = i;
            while (i < meetings.length && time == meetings[i][2]) {
                uf.unite(meetings[i][0], meetings[i][1]);
                i++;
            }
            for (int j = last; j < i; j++) {
                int a = meetings[j][0], b = meetings[j][1];
                if (!uf.connected(a,0)) parents[a] = a;
                if (!uf.connected(b,0)) parents[b] = b;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < parents.length; i++) {
            if (uf.connected(i, 0)) ans.add(i);
        }
        return ans;
    }
}

class UnionFind{
    int[] parents;
    public UnionFind(int[] parents) {
        this.parents = parents;
    }
    void unite(int p, int q) {
        int pp = find(p);
        int qq = find(q);
        if (pp == 0) {
            parents[qq] = pp;
        } else {
            parents[pp] = qq;
        }
    }
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    int find(int p) {
        while (parents[p] != p) {
            p = parents[p];
        }
        return p;
    }
}
