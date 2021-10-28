package offer;

public class O33 {
    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, -1, postorder.length-1);
    }

    boolean dfs(int[] postorder, int L, int R){
        if(L == R || L+1 == R) return true;
        int i = L, j = R, rootVal = postorder[R]; 
        while(postorder[i+1]<rootVal){
            i++;
        }
        while(L+1<j && (postorder[j-1]>=rootVal)){
            j--;
        }
        if(i + 1 != j) return false;
        else return dfs(postorder,L,i) && dfs(postorder,i,R-1);
    }
}
