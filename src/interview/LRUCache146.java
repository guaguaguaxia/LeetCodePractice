package interview;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/*
* 20200817  First AC
* 20200818  Second AC
* 20200819  Third AC
* */
public class LRUCache146 {

    public static void main(String[] args) {
        LRUCache146 la = new LRUCache146(5);
        la.put(1,1);
        la.put(2,2);
        la.put(3,3);
        la.put(4,4);
        la.put(5,5);
        la.put(6,6);

        la.get(1);
        la.get(6);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(la.map));
        System.out.println("---------------");
        System.out.println(gson.toJson(la.cache));

    }



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
    @Override
    public String toString(){
        return "map:" + map +"----" + "cache:" + cache;
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

