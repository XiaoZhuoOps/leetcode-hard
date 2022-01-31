package algo.guilv;

public class lc400 {
    public int findNthDigit(int n) {
        int k = 1, num = 9, nums = 9, bit = 9, start = 1, end = 0;
        while (n > bit) {
            n -= bit;
            k++;
            num = 9 * (int)Math.pow(10,k-1);
            nums += num;
            bit = num*k;
            start = nums+1;
        }

        //n <= bit
        if (n % k == 0) {
            end = start + n/k - 1;
            return end % 10;
        } else {
            end = start + n/k;
            return (n / (int) Math.pow(10, k - n%k)) % 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}

