package LCP.LCP284;

public class lcp6032 {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] map = new boolean[n][n];
        for (int[] d : dig) {
            map[d[0]][d[1]] = true;
        }
        int ans = 0;
        for (int[] artifact : artifacts) {
            int r1 = artifact[0], c1 = artifact[1], r2 = artifact[2], c2 = artifact[3];
            boolean flag = true;
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (!map[i][j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) ans++;
        }
        return ans;
    }
}
