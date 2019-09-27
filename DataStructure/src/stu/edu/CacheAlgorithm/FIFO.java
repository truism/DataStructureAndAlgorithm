package stu.edu.CacheAlgorithm;

import stu.edu.LinkedList.DoubleLinkedList;

import java.util.HashMap;

/**
 * 缓存置换策略，先进先出原则
 */
public class FIFO<K,V> {
    //缓存池
    private DoubleLinkedList<K,V> cache;
    //缓存池容量
    private Integer capacity;
    //模拟数据库
    private HashMap<K,V> map;

    //初始容量为10
    public FIFO() {
        this(10);
    }
    //自定义缓存池容量
    public FIFO(Integer capacity) {
        this.cache = new DoubleLinkedList();
        this.capacity = capacity;
        map = new HashMap<>();
    }

    //从缓存中查找元素
    public V get(K key) {
        V value = cache.find(key);
        /*
        * 缓存池中没有，假设数据库或内存中存在
        * 更新缓存
        */
        if(value == null) {
            //缓存已满，删除最先进入缓存的元素
            if(cache.getSize() == capacity) {
                cache.removeLast();
                cache.addFirst(key,map.get(key));
            }else { //缓存池未满
                cache.addFirst(key, map.get(key));
            }
            value = map.get(key);
        }

        return value;
    }

}
