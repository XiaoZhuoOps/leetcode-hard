import java.util.*;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
//public class Main {
//    private static String colors;
//    private static List<Integer>[] tree;
//    private static int ans = 0;
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = in.nextInt();
//
//        colors = in.next().toString();
//        tree = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            tree[i] = new ArrayList<Integer>();
//        }
//        while (in.hasNext()) { // 注意 while 处理多个 case
//            int u = in.nextInt();
//            int v = in.nextInt();
//            tree[u-1].add(v-1);
//            tree[v-1].add(u-1);
//        }
//        new Main().dfs(0, -1, (colors.charAt(0) == 'R') ? 1 : -1);
//        System.out.println(ans);
//    }
//    void dfs(int root, int par, int diff) {
//        ans += Math.abs(diff);
//        for (int ch : tree[root]) {
//            if (ch == par) {
//                continue;
//            }
//            if (colors.charAt(ch) == 'R') {
//                dfs(ch, root, diff+1);
//            } else {
//                dfs(ch, root, diff-1);
//            }
//        }
//    }
//}



public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int m = in.nextInt();
            if (m == 1) {
                String name = in.next().toString();
                int n = in.nextInt();
                List<String> stocks = new ArrayList<String>();
                for (int j = 0; j < n; j++) {
                    String stock = in.next().toString();
                    stocks.add(stock);
                    if (!map2.containsKey(stock)) {
                        map2.put(stock, new ArrayList<String>());
                    }
                    map2.get(stock).add(name);
                }
                map1.put(name, stocks);
            } else {
                String name = in.next().toString();
                if (!map1.containsKey(name)) {
                    System.out.println("error");
                }
                else {
                    int ans = 0;
                    for (String stock : map1.get(name)) {
                        List<String> persons = map2.get(stock);
                        for (String p: persons) {
                            if (p.equals(name)) {
                                continue;
                            }
                            for (String stock2 : map1.get(p)) {
                                if (!map1.get(name).contains(stock2)) {
                                    ans += 1;
                                }
                            }
                        }
                    }
                    System.out.println(ans);
                }
            }
        }
    }
}
