package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class O60 {
    public double[] dicesProbability(int n) {
        List<Double> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 1);
        hm.put(2, 1);
        hm.put(3, 1);
        hm.put(4, 1);
        hm.put(5, 1);
        hm.put(6, 1);

        for(int i = 0; i < n; i++){
            // update hm;
            HashMap<Integer, Integer> hm2 = new HashMap<>();
            for(Integer key:hm.keySet()){
                for(int j = 1; j <= 6; j++){
                    // 如果hm2中不存在k+i put(k+i,hm.get(k))
                    if(hm2.containsKey(key+j)){
                        int temp = hm2.get(key+j);
                        hm2.put(key+j,temp + hm.get(key));
                    }
                    // 否则put(k+i,hm2.get(k+i)+hm.get(k))
                    else{
                        hm2.put(key+j,hm.get(key));
                    }
                }
            }
            hm = hm2;
        }
        TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer, Integer>(
            new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
        });

        sortedMap.putAll(hm);

        for(Integer key:sortedMap.keySet()){
            double prob = sortedMap.get(key)/(Math.pow(6, n));
            ans.add(prob);
        }
        double[] anss = new double[ans.size()];
        for(int i = 0; i<ans.size();i++){
            anss[i] = ans.get(i);
        }
        return anss;
    }
}
