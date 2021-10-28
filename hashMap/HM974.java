package hashMap;

import java.util.HashMap;

public class HM974 {
    //解法1 暴力遍历 复杂度 O(n^2)
    public int subarraysDivByK(int[] A, int K) {
        int ans = 0, sum = 0, len = A.length;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                sum += A[j]; //j is right of internal
                if(sum%K == 0) ans++;
            }
            sum = 0; 
        }
        return ans;
    }

    // 解法2 前缀和+暴力遍历 本质不变 preSum[i]记录了解法1中每一次i的遍历结果 用空间换时间 复杂度 O(n^2)
    public int subarraysDivByK2(int[] A, int K) {
        int ans = 0, len = A.length;
        int[] preSum = new int[len+1];
        for(int i = 1; i < len+1; i++){
            preSum[i] = preSum[i-1] + A[i-1];
        }
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len+1; j++) {
                //区间[i,j-1]
                if((preSum[j]-preSum[i])%K == 0)
                    ans++;
            }
        }
        return ans;
    }

    //解法3 数学规律+hashMap 复杂度 O(N)
    public int subarraysDivByK3(int[] A, int K) {
        int ans = 0, len = A.length, psk;
        int[] preSum = new int[len + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();

        // (preSum[j]-preSum[i])%K == 0 等价于 psk = preSum[j]%K == preSum[i]%K
        for (int i = 1; i < len + 1; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
            psk = preSum[i]%K;
            hm.put(psk, hm.getOrDefault(psk, 0)+1); //记录每个psk出现的次数
        }
        for(Integer k:hm.keySet()){
            //计算可以组成多少个区间 Cn2
            len =  hm.getOrDefault(k, 0);
            for(int i = 0; i <len; i++){ //hashmap每个桶里的是链表或者红黑树 hm.get(k)=null
                for(int j = i+1; j<len; j++)
                ans++;
            }
        }
        return ans;
    }

    // 解法4 数学规律+数组 复杂度 O(N) 解法3在计算Cn2的时候有重复遍历 可以和计算preSum写在一起
    public int subarraysDivByK4(int[] A, int K) {
        int ans = 0, len = A.length, psk;
        int[] preSum = new int[len + 1];
        int[] map = new int[K];
        // (preSum[j]-preSum[i])%K == 0 等价于 psk = preSum[j]%K == preSum[i]%K
        map[0]++; 
        for (int i = 1; i < len + 1; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
            psk = (preSum[i] % K + K)%K; //考虑取模后为负数的情况
            ans+=map[psk];
            map[psk]++; 
        }
        return ans;
    }

}
