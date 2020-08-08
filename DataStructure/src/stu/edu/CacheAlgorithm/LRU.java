package stu.edu.CacheAlgorithm;

import stu.edu.LinkedList.DoubleLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存置换策略的LRU算法(Least recently used)
 * 即最近最少使用算法,最近一段时间未被使用的缓存，将来被使用的概率也很小,类似于局部性原理
 * 将最近(时间)使用过的元素放置在双向链表头部，代表最近使用过的,链表尾部就代表最近最少使用的
 * 当有新元素加入缓存时且缓存已满时将最近最少使用的元素删除移到链表头部，
 * 使用双向链表实现，每次从缓存中查询元素时，如果缓存中存在，则将元素移到链表头部
 * 若缓存中不存在，则将元素存入缓存中
 *      此时若缓存已满，则将链表尾部元素删除,将元素添加到链表头部
 *      若没满，直接添加到链表头部
 */
public class LRU<K,V> {
    private DoubleLinkedList<K,V> cache;  //缓存容器
    private Integer capacity;  //缓存容量
    //代表数据库
    private HashMap<K,V> map;

    //缓存默认容量为20
    public LRU() {
        cache = new DoubleLinkedList<>();
        capacity = 20;
    }

    //自定义缓存容量
    public LRU(Integer capacity){
        cache = new DoubleLinkedList<>();
        this.capacity = capacity;
        map = new HashMap<>();
    }

    //从缓存中查询元素
    public V get(K key){
        if(cache.containsKey(key)){ //缓存中已存在
            //将元素移动到链表头部
            V value = cache.removeNode(key);
            cache.addFirst(key,value);
            return value;
        }
        //缓存中不存在
        if(cache.getSize().equals(capacity)) { //缓存已满
            cache.removeLast();  //删除最近最少使用的元素
            cache.addFirst(key, map.get(key));  //从内存或数据库查找存入缓存
        }else {  //缓存中不存在且缓存未满
            cache.addFirst(key, map.get(key));  //从内存或数据库查找存入缓存
        }
        return map.get(key);
    }

}
