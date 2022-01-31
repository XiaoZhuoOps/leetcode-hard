package algo.treeArray;

public class lc307 {

}
class NumArray {
    int[] arr; // 1->n
    public NumArray(int[] nums) {
        this.arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.arr[i] = nums[i];
        }
        for (int i = 1; i <= nums.length; i++) {
            if (i + lowBit(i) <= nums.length) {
                this.arr[i+lowBit(i)-1] += this.arr[i-1];
            }
        }
    }
    public void update(int index, int val) {
        int diff = val - sumRange(index,index);
        while (index+1 <= this.arr.length) {
            this.arr[index] += diff;
            index = index + lowBit(index+1);
        }
    }
    public int sumRange(int left, int right) {
        return preSum(right) - preSum(left-1);
    }
    int preSum(int end) {
        int sum = 0;
        while (1 <= end+1) {
            sum += this.arr[end];
            end = end - lowBit(end+1);
        }
        return sum;
    }
    int lowBit(int idx) {
        return idx & (-idx);
    }
}
