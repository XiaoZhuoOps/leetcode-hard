package algo.DS.LRU;

import java.util.HashMap;

class Node{
    int k,v;
    Node next,pre;
    public Node(int k, int v){
        this.k = k;
        this.v = v;
    }
}

class DoubleList{
    //...
    Node header;
    Node tailer;
}

public class Lru {
    HashMap<Integer,Node> hm;
    DoubleList dl;
    int capacity;
    int size;

    void insert(Node node){
        Node first = dl.header.next;
        dl.header.next = node;
        first.pre = node;
        node.pre = dl.header;
        node.next = first;
    }

    void remove(Node node){
        Node pre = node.pre;
        Node succ = node.next;
        pre.next = succ;
        succ.pre = pre;
    }

    public int get(int k){
        Node node = null;
        if(hm.containsKey(k)){
            node = hm.get(k);
            remove(node);
            insert(node);
        }
        return (node == null)?-1:node.v;
    }

    public void put(int k, int v){
        if(hm.containsKey(k)){
            Node node = hm.get(k);
            node.v = v;
            remove(node);
            insert(node);
        }else {
            Node newNode = new Node(k,v);
            hm.put(k,newNode);
            insert(newNode);
            if(capacity<++size){
                Node lastNode = dl.tailer.pre;
                remove(lastNode);
                hm.remove(lastNode.k);
            }
        }
    }
}
