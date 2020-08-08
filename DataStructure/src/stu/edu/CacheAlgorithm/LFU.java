package stu.edu.CacheAlgorithm;

import stu.edu.LinkedList.DoubleLinkedList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 最近最少使用算法（least frequency used）
 * 最近使用次数最少的元素优先从缓存中删除
 * 元素需要一个属性来记录缓存中元素被访问的次数
 */
public class LFU<K extends Comparable,V> {


    private Map<K, Node> cache;

    private int capacity;

    private Map<Integer, DoubleLinkedList<K, Node>> freqMap;

    public LFU() {
        this(100);
    }

    public LFU(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.freqMap = new HashMap<>();
    }

    /**
     * 从缓存中获取值
     * @param key
     * @return
     */
    public V get(K key) {
        Node node = cache.get(key);
        // 缓存不存在，则查找数据库更新缓存
        if(node == null) {
            V value = (V) new Object();
            Node dataNode = new Node(key, value, 0);
            put(dataNode);
            return value;
        }
        // 更新结点的缓存使用频率
        updateFreq(node);
        return node.value;
    }

    /**
     * 更新缓存
     * @param node
     * @return
     */
    private boolean put(Node node) {
        cache.put(node.key, node);
        if(cache.size() == capacity) {
            Integer freq = minFreq(freqMap);
            DoubleLinkedList<K, Node> list = freqMap.get(freq);
            // 结点频率相同则按FIFO规则删除
            list.removeLast();
            if(list.getSize() == 0 && freq != 0) {
                freqMap.remove(freq);
            }
            updateFreq(node);
        }else {
            updateFreq(node);
        }
        return true;
    }

    /**
     * 获取freqMap中频率最小的双向链表
     * @param freqMap
     * @return
     */
    private int minFreq(Map<Integer, DoubleLinkedList<K, Node>> freqMap) {
        int min = -1;
        Set<Integer> set = freqMap.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            if(min == -1) {
                min = it.next();
            }else {
                Integer freq = it.next();
                min = freq < min ? freq : min;
            }
        }
        return min;
    }

    /**
     * Update cache item frequency.
     * @param node
     */
    private void updateFreq(Node node) {
        DoubleLinkedList<K,Node> list = freqMap.get(node.freq);
        if(list != null) {
            list.removeNode(node.key);
            if(list.getSize() == 0) {
                freqMap.remove(node.freq);
            }
        }

        DoubleLinkedList<K, Node> updateList = freqMap.get(node.freq + 1);
        if(updateList == null) {
            updateList = new DoubleLinkedList<>();
        }
        updateList.addFirst(node.key, new Node(node.key, node.value, node.freq + 1));
    }

    class Node {
        /** The cache item key. */
        K key;

        /** The cache item value. */
        V value;

        /** The cache item select frequency. */
        int freq;

        public Node() {
        }

        public Node(K key, V value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

}
