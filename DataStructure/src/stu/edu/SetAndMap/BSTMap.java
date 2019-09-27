package stu.edu.SetAndMap;

import stu.edu.BinaryTree.BinaryTree;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private BinaryTree<K,V> binaryTree;

    @Override
    public int getSize() {
        return binaryTree.getSize();
    }

    @Override
    public boolean containsKey(K key) {

        return binaryTree.contains(key);
    }

    /**
     * 按二叉树的层序遍历去查找
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(V value) {
        return binaryTree.containsValue(value);
    }

    @Override
    public void add(K key, V value) {
        binaryTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return binaryTree.remove(key);
    }

}
