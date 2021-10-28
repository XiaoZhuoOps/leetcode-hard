package offer;

public class O16 {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        double temp = x, res = 1.0;
        for(int i=n; i>0; i>>=1){
            if((i&1) == 1){
                res = res*temp;
            }
            temp*=temp;
        }
        return res;
    }
}
