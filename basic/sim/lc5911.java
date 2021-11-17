package basic.sim;

class Robot {

    int l;
    int w, h;
    int dir;
    int[] pos;
    int mod;
    String[] dirs = new String[]{"East","North","West","South"};

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        this.pos = new int[]{0,0};
        this.l = 0;
        this.dir = 0;
        this.mod = 2*(w+h)-4;
    }

    public void move(int num) {
        l = (l+num)%mod;
        if (l<=w-1) {

        }
    }

    public int[] getPos() {

    }

    public String getDir() {

    }
}
