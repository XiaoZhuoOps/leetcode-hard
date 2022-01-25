package hot100;

public class lc215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        quickSort(nums, 0, len-1);
        return nums[len-k];
    }
    void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        int mid = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= mid) {
                j--;
            }
            nums[i] = nums[j];
            nums[j] = mid;
            while (i < j && nums[i] <= mid) {
                i++;
            }
            nums[j] = nums[i];
            nums[i] = mid;
        }
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, k);
    }
    int quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) return nums[left];
        int i = left, j = right;
        int mid = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= mid) {
                j--;
            }
            nums[i] = nums[j];
            nums[j] = mid;
            while (i < j && nums[i] <= mid) {
                i++;
            }
            nums[j] = nums[i];
            nums[i] = mid;
        }
        int target = nums.length-k;
        if (i == target) {
            return nums[i];
        }
        else if (i < nums.length-k) {
            return quickSort(nums, i+1, right, k);
        } else {
            return quickSort(nums, left, i-1, k);
        }
    }
}
