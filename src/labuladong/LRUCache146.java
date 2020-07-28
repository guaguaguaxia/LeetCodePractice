package labuladong;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;


public class LRUCache146 {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private Deque<Node> cache;
    // 最大容量
    private int cap;

    public LRUCache146(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new ArrayDeque<Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}

class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

