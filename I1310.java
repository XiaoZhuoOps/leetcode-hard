/*
    1思路 联想preSum Xor[i:j] = preXor[j+1]^preXor[i]
    2伪代码
    3实现
 */
public class I1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int[] preXor = new int[arr.length+1];
        preXor[0] = 0;
        //preXor
        for(int i = 1; i < arr.length+1; i++){
            preXor[i] = preXor[i-1] ^ arr[i-1];
        }
        //traver
        for(int i = 0; i < queries.length; i++){
            res[i] = preXor[queries[i][1]+1] ^ preXor[queries[i][0]];
        }
        return res;
    }
}
