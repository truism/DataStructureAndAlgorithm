package stu.edu.LinkedList;

public class DoubleLinkedList<K,V> {

    private class Node<K,V>{
        K key;
        V value;
        Node next;
        Node before;

        public Node() {
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node(K key, V value, Node next, Node before) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.before = before;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        head = new Node();
        tail = null;
        head.next = tail;
        size = 0;
    }

    //头部添加节点
    public void addFirst(K key, V value) {
        if(containsKey(key)) {
            throw new IllegalStateException("Key is exist");
        }
        Node newNode = new Node(key, value);
        newNode.next = head.next;
        newNode.before = head;
        if(head.next != null){
            head.next.before = newNode;
        }
        head.next = newNode;
        size ++;
        if(size == 1){
            tail = newNode;
        }
    }

    //尾部添加节点
    public void addLast(K key, V value) {
        Node newNode = new Node(key, value);
        newNode.before = tail.before;
        newNode.before.next = newNode;
        tail = newNode;
        size ++;
    }

    //删除尾部节点
    public V removeLast() {
        if(tail == null){
            throw new IllegalStateException("DoubleLinkedList is empty.");
        }
        V value = (V) tail.value;
        Node node = tail.before;
        tail = node;
        tail.next = null;
        size--;
        return value;
    }

    //删除指定节点
    public V removeNode(K key) {
        V value;
        if(!containsKey(key)){
            throw new IllegalArgumentException("Element doesn't exist.");
        }
        Node target = findNode(key);
        value = (V)target.value;
        if(target != null){
            Node before = target.before;
            before.next = target.next;
            target.before = null;  //切断target节点与before节点的联系
            target.next.before = before;
            target.next = null;  //切断target节点与next节点的联系
        }
        return value;
    }

    //查询节点的值
    public V find(K key) {
        Node cur = head.next;
        while(cur != null){
            if(cur.key.equals(key)){
                return (V)cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    //查询指定的节点,可能返回null
    public Node findNode(K key) {
        Node cur = head.next;
        while(cur != null){
            if(key.equals(cur.key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //修改节点
    public void setValue(K key, V value) {
        if(containsKey(key)) {
            throw new IllegalArgumentException("Key doesn't exist");
        }
        Node cur = head.next;
        while(cur != null) {
            if(cur.key.equals(key)){
                cur.value = value;
            }
            cur = cur.next;
        }
    }

    //判断key是否存在
    public boolean containsKey(K key){
        Node cur = head.next;
        while(cur != null) {
            if(cur.key.equals(key)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //获取双向链表中元素的个数
    public Integer getSize(){
        return size;
    }

    /**
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head.next;
        while(cur != null){
            sb.append(cur.value + " ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer,Integer> list = new DoubleLinkedList<>();
        for(int i=0;i<10;i++){
            list.addFirst(i,i);
        }
        System.out.println(list);  // 9 8 7 6 5 4 3 2 1 0
        list.removeLast();
        list.removeLast();
        System.out.println(list);  // 9 8 7 6 5 4 3 2
    }

}
