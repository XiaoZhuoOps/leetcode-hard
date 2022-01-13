package basic.guilv;
/**
 * 1、判断应该是一个暴力+找规律题目
 * 2、规律：可以通过反证法证明，若从某个i出发，最远只能到j，则[i,j]内的所有油站都不满足要求
 * 3、双指针，注意i和j的含义；复杂度O(n)，无优化空间
 * 4、先写一个两层循环，再往里面塞逻辑；最后注意终止条件判断，防止无限循环
 */
class lcp134 {
    //暴力解法，依次判断某个i是否满足要求
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            int oil = 0;
            while (oil + gas[j] - cost[j] >= 0) {
                oil = oil + gas[j] - cost[j];
                j = (j+1) % len;
                if (i == j) return i;
            }
        }
        return -1;
    }
    //优化解法，可以通过反证法证明：若从某个i出发，最远只能到j，则[i,j]内的所有油站都不满足要求，故i = j+1
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            int oil = 0;
            while (oil + gas[j] - cost[j] >= 0) {
                oil = oil + gas[j] - cost[j];
                j = (j+1) % len;
                if (i == j) return i;
            }
            //防止无限循环，若j < i，说明j已经绕过了一圈，即[0,len-1]内每个油站都不满足要求
            if (j < i) return -1;
            i = j;
        }
        return -1;
    }
}
