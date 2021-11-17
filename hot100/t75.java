package hot100;

public class t75 {
    public void sortColors(int[] nums){
        int p = 0, q = nums.length-1;
        for (int i = 0; i <= q; i++) {
            switch (nums[i]) {
                case 0 -> {
                    swap(nums, p, i);
                    p++;
                }
                case 2 -> {
                    swap(nums, q, i);
                    q--;
                    i--;
                }
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
