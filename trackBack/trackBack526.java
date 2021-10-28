package trackBack;

import java.util.Stack;
// error:EmptyStack path.isEmpty() vs path == null vs path.Empty()
// error syntax 值传递和引用传递 
// error result
// optimize 
public class trackBack526{
    //Tree Structure DPS
    //path、select=[1-N]-path
    int res = 0;
    private Stack<Integer> path = new Stack<>();
    public int countArrangement(int N) {
        dfs(N);
        return res;
    }
    private void dfs(int N){
        // case: path = null
        if(!path.isEmpty()){
            if(!isOk(path.size(), path.peek())) return;
            else if(path.size() == N) res++;
            // if (isOk(path.size(), path.peek()))
            //     res++;
            // else
            //     return; // not OK, return to last layer's next node
        }
    
        for (int i = 1; i <= N; i++) {
            //pre traverse
            if (path.contains(i))
                continue;
            path.push(i);
            //dfs(N,path) means decide if the node of i is OK and travel all childNodes of path.peek() 
            //also means find all OK nodes in the subTree
            dfs(N);
            //post traverse
            path.pop();
        }
        //
    }
    private boolean isOk(int index, Integer num){
        return index%num == 0 || num%index == 0;
    }
}
