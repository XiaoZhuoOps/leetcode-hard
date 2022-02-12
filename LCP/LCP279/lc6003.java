package LCP.LCP279;

class Bitset {
    boolean[] set;
    int trueNum;
    int falseNum;
    boolean flip;
    int size;
    public Bitset(int size) {
        set = new boolean[size];
        trueNum = 0;
        falseNum = size;
        this.size = size;
    }

    public void fix(int idx) {
        if (flip) unfix0(idx);
        else fix0(idx);
    }

    void fix0(int idx) {
        if (!set[idx]) {
            set[idx] = true;
            trueNum++;
            falseNum--;
        }
    }

    public void unfix(int idx) {
        if (flip) fix0(idx);
        else unfix0(idx);
    }

    void unfix0(int idx) {
        if (set[idx]){
            set[idx] = false;
            trueNum--;
            falseNum++;
        }
    }

    public void flip() {
        flip = !flip;
    }

    public boolean all() {
        return ((flip)?falseNum:trueNum) == size;
    }

    public boolean one() {
        return ((flip)?falseNum:trueNum) > 0;
    }

    public int count() {
        return (flip) ? falseNum:trueNum;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < set.length; i++) {
            if (!flip){
                sb.append((set[i]) ? 1 : 0);
            } else {
                sb.append((set[i]) ? 0 : 1);
            }
        }
        return sb.toString();
    }
}
