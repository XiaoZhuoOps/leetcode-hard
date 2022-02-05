package LCP.LCP246;

public class lc1904 {
    public int numberOfRounds(String loginTime, String logoutTime) {
        //计算标准时间
        int sh = 0, sm = 0, fh = 0, fm = 0;
        sh = Integer.parseInt(loginTime.split(":")[0]);
        sm = Integer.parseInt(loginTime.split(":")[1]);
        fh = Integer.parseInt(logoutTime.split(":")[0]);
        fm = Integer.parseInt(logoutTime.split(":")[1]);
        if (sh > fh || (sh == fh && sm > fm)) fh += 24;

        //计算游戏时间
        int[] times = new int[]{0,15,30,45};
        int i = 0, j = 0;
        for (; i < times.length; i++) {
            if (times[i] >= sm) {
                sm = times[i];
                break;
            }
        }
        if (i == times.length) {
            sm = 0;
            sh++;
        }
        int temp = 0;
        for (; j < times.length; j++) {
            if (times[j] <= fm) temp = times[j];
        }
        fm = temp;

        //计算时间差
        int res = (fh-sh)*4 + (fm-sm)/15;
        return Math.max(res, 0);
    }
}
