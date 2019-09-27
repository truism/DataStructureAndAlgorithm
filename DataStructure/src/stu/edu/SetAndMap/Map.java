package stu.edu.SetAndMap;

public interface Map<K,V> {

    int getSize();

    boolean containsKey(K key);

    boolean containsValue(V value);

    void add(K key,V value);

    V remove(K key);


}
