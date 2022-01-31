package algo.sort;

//插入排序
public class InsertSort {

    void insertSort(int[] a){
        int len = a.length, l = 0, r = 0, mid = 0;
        for (int i = 0; i < len; i++) {
            //从[0- i-1]中大于a[i]的最小元素j; 或小于等于a[i]的最大元素+1
            r = i;
            while(l<r){
                mid = (l+r)/2;
                if(a[mid] <= a[i]){
                    //找到满足条件的最右侧元素+1
                    l = mid+1;
                }else if(a[mid] > a[i]) {
                    r = mid;
                }
                int temp = a[i];
                //交换剩余元素[l-j-1]
                for(int j = i-1; j>=l; j--){
                    a[j+1] = a[j];
                }
                a[l] = temp;
            }
        }
    }
}
