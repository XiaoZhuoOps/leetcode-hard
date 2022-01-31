package algo.hashMap;

import java.util.*;

public class C1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //构建map{id:{1,2...}}
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] record : logs){
            int id = record[0];
            int min = record[1];
            if(!map.containsKey(id)){
                HashSet<Integer> set = new HashSet<>();
                set.add(min);
                map.put(id, set);
            }else {
                map.get(id).add(min);
            }
        }

        //统计id对应的mins
        int[] res = new int[k];
        for(int r:res) r = 0;
        for(Map.Entry<Integer, Set<Integer>> set : map.entrySet()){
            int mins = set.getValue().size();
            res[mins-1]++;
        }
        //res
        return res;
    }
}
