package ms;

import java.util.*;

class Solution {
    long mod = 1000000007;
    Map<Integer, TreeSet<Node>> visited = new HashMap<>();

    public int solution(int[] X, int[] Y) {
        TreeMap<Node, Integer> treeMap = new TreeMap<>();
        int n = Y.length;
        for (int i = 0; i < n; i++) {
            Node node = new Node(X[i], Y[i]);
            Node ext = treeMap.floorKey(node);
            if (ext != null && ext.compareTo(node) == 0) {
                treeMap.put(node, treeMap.get(ext) + 1);
            } else {
                treeMap.put(node, 1);
            }
        }
        List<Node> nodes = new ArrayList<>();
        while (!treeMap.isEmpty()) {
            Map.Entry<Node, Integer> entry = treeMap.pollFirstEntry();
            for (int i = 0; i < entry.getValue(); i++) {
                nodes.add(new Node(entry.getKey().numerator, entry.getKey().denominator));
            }
        }
        return (int) f(0, nodes.size(), nodes, new Node(1, 1));
    }

    public long f(int idx, int n, List<Node> nodes, Node curNode) {
        if (visited.containsKey(idx)) {
            Node ext = visited.get(idx).floor(curNode);
            if (ext != null && ext.compareTo(curNode) == 0) return ext.count;
        }
        if (idx == n) return 0;
        if (curNode.compareTo(nodes.get(idx)) < 0) {
            return 0;
        } else if (curNode.compareTo(nodes.get(idx)) == 0) {
            long tmp = (f(idx + 1, n, nodes, curNode) % mod + 1) % mod;
            TreeSet<Node> set = visited.getOrDefault(idx, new TreeSet<>());
            Node node = new Node(curNode.numerator, curNode.denominator);
            node.count = tmp;
            visited.put(idx, set);
            return tmp;
        }
        long tmp = 0;
        long newnumerator = curNode.numerator * nodes.get(idx).denominator - curNode.denominator * nodes.get(idx).numerator;
        long newdenominator = curNode.numerator * nodes.get(idx).denominator;
        tmp = (f(idx + 1, n, nodes, new Node(newnumerator, newdenominator)) % mod + tmp) % mod;
        tmp = (f(idx + 1, n, nodes, curNode) % mod + tmp) % mod;
        TreeSet<Node> set = visited.getOrDefault(idx, new TreeSet<>());
        Node node = new Node(curNode.numerator, curNode.denominator);
        node.count = tmp;
        visited.put(idx, set);
        return tmp;
    }

    //    Numerator and denominator
    class Node implements Comparable<Node> {

        long numerator;
        long denominator;
        long count;

        public Node(long numerator, long denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            if (denominator != 1) {
                long g = 0;
                if (numerator <= denominator) {
                    g = gcd(denominator, numerator);
                } else {
                    g = gcd(numerator, denominator);
                }
                this.numerator /= g;
                this.denominator /= g;
            }
            ;
        }

        long gcd(long a, long b) {
            return (b == 0) ? a : gcd(b, a % b);
        }

        @Override
        public int compareTo(Node node) {
            return (int) (numerator * node.denominator - denominator * node.numerator);
        }
    }
}
