package offer;

class O46 {
    int ans = 0;
    public int translateNum(int num) {
        int k = 1;
        while(k<=num/10){
            k*=10;
        }
        dfs(num,k);
        return ans;
    }

    void dfs(int num, int k){
        while(num<k){
            k/=10;
        }
        if(k == 1 || k == 0){
            ans++;
            return;
        }
        int a = num/k;
        if(0<a&&a<26) dfs(num%k,k);
        k/=10;
        int b = num/k;
        if(0<b&&b<26) dfs(num%k,k);
    }
}