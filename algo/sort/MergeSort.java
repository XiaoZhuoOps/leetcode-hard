package algo.sort;

import java.util.Arrays;

public class MergeSort {
    void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        //1、sort
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        //2、merge
        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        i = left;
        k = 0;
        while (i <= right) {
            nums[i++] = temp[k++];
        }
    }
}
