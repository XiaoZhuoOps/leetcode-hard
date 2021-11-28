package basic.trackBack;

    /*res = []
    def trackBack
        if 满足条件
            res.add(路径)
            return

        for 选择 in 选择列表
            路径.add(选择)
            trackBack
            路径.remove(选择)
        */

import java.util.List;

public class trackBack1079 {
    int sum;
    /*public int numTilePossibilities(String tiles) {
        dfs();
    }
*/
    public void dfs(String tiles, List<Character> path, int[] flag){
        if(path.size() > 0){
            sum++;
            return;
        }
        for(int i = 0; i < tiles.length() && flag[i] == 0 ; i++){
            path.add(tiles.charAt(i));
            flag[i] = 1;
            dfs(tiles,path,flag);
            path.remove(tiles.charAt(i));
            flag[i] = 0;
        }
    }
}
