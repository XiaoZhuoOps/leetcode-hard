package AL4.Sort;
//递归+双指针将大于(小于等于)Mid的数字分别移动到Mid的两边
//自然语言->伪代码->代码
//抽象建模->常用算法/框架->Index、状态、选择
public class QuickSort {
   public static void QuickSorter(int[] nums,int left, int right){
       //base case
       if(!(left<right)) return;

       int i = left, j = right;
       int Mid = nums[left];

       //double pointer
       while(i<j){
           while (i<j && nums[j] >= Mid) {
               j--;
           }
           //switch
           if(i<j){
               nums[i] = nums[j];
               nums[j] = Mid;
           }
           while (i<j && nums[i] <= Mid) {
               i++;
           }
           if(i<j){
               nums[j] = nums[i];
               nums[i] = Mid;
           }
       }
       //递归方程
       QuickSorter(nums,left,i-1);
       QuickSorter(nums,i+1,right);
   }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,7,2,9,1,77};
        QuickSorter(nums,0,6);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
