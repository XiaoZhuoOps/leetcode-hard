package LCP;

import java.util.*;

public class LCP1311 {
    boolean[] visited;
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        visited = new boolean[watchedVideos.size()];
        for(boolean b : visited) b = false;
        //int[] -> list<Integer>
        List<Integer> ids = new ArrayList<>();
        for(int friend : friends[id]){
            ids.add(friend);
        }
        for(int i = 0; i < level; i++){
            List<Integer> newIds = new ArrayList<>();
            for(Integer curId : ids){
                for(int fid : friends[curId]){
                    if(!visited[fid]){
                        newIds.add(fid);
                        visited[fid] = true;
                    }
                }
            }
            ids = newIds;
        }

        Map<String, Integer> map = new HashMap<>();
        for(Integer i : ids){
            for(String s : watchedVideos.get(i)){
                map.put(s, map.getOrDefault(s,0)+1);
            }
        }

        List<String> res = new ArrayList<>(map.keySet());
//        Collections.sort(res, new Comparator<String>(){
//            public int compare(String s1, String s2){
//                int num1 = map.get(s1);
//                int num2 = map.get(s2);
//                return (num1 == num2)?(s1-s2):(num1-num2);
//            }
//        });

        return res;
    }
}
