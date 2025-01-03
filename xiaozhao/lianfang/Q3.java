package lianfang;


public class Q3 {
    public static void main(String[] args) {

    }

}
class Node{
    int i; //第i个应用
    Node pre;
    Node succ;
    public Node(int i) {
        this.i = i;
    }
}
class LRU{
    Node[] nodes;
    Node dumpy;
    public LRU(int n) {
        nodes = new Node[n];
        dumpy = new Node(0);
        Node last = dumpy;
        for (int i = n-1; i >= 0; i--) {
            Node node = new Node(i);
            last.pre = node;
            node.succ = last;
            last = node;
            nodes[i] = node;
        }
    }
    void use(int i) {
        Node cur = nodes[i];
        Node pre = cur.pre;
        Node succ = cur.succ;
        pre.succ =  succ;
        succ.pre = pre;

        Node head = dumpy.pre;
        dumpy.pre = cur;
        head.succ = cur;
        cur.pre = head;
        cur.succ = dumpy;
    }
    Node get() {
        return dumpy.pre;
    }
 }
