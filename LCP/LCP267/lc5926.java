package LCP.LCP267;

public class lc5926 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sec = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != 0) {
                tickets[i] = tickets[i] - 1;
                sec++;
                if (i == k && tickets[i] == 0) return sec;
            }
            if (i == tickets.length - 1) i = -1;
        }
        return sec;
    }
}
