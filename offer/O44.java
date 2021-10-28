package offer;
/**
 * 先确定第n个数位于哪个区间，在确定是第几个数的第几位
 * s起点 k位数 i j 第i个数后的前j位
 */
public class O44 {
    public int findNthDigit(int n) {
        int s = 0, k = 1;
        while(s+calc1(k)<=n) {
            s+=calc1(k);
            k++;
        }
        int i = (n-s)/k;
        int j = n-s-i*k;
        int t = calc2(k) + i;
        return calc3(t,j,k);
    }

    int calc1(int k){
        //计算k位的数一共有多少位
        int res = (int) (k*9*Math.pow(10,k-1));
        return (k==1)?(res+1):res;
    }

    int calc2(int k){
        //计算k位数的起始数
        return (k==1)?0: (int) (Math.pow(10, k - 1));
    }

    int calc3(int t, int j, int k){
        //计算是数字t的第j位
        int l = k-j-1;
        for (int i = 0; i < l; i++) {
            t/=10;
        }
        return t%10;
    }

    public static void main(String[] args) {
        long res1 = new O44().findNthDigit(10000000);
        System.out.println(res1);
    }
}

