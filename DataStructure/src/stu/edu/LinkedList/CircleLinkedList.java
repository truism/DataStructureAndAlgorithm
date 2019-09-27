package stu.edu.LinkedList;

public class CircleLinkedList<E> {

    private class Node<E> {
        E data;
        Node next;

        public Node() {
            this(null,null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;  //此时需要维护一个引用指向链表的尾部结点
    private int size;

    public CircleLinkedList(){
        head = tail = new Node();
        tail.next = head;
        size = 0;
    }

    //链表头部添加结点
    public void addFirst(E e){
        Node node = new Node(e,null);
        node.next = head.next;
        head.next = node;
        size++;
        if(size == 1){
            tail = node;
        }
    }
    //链表尾部添加结点
    public void addLast(E e){
        Node node = new Node(e,null);
        tail.next = node;
        tail = node;
        tail.next = head;
        size++;
    }
    //删除头部结点
    public E removeFirst(){
        if(size == 0){
            throw new IllegalStateException("CircleLinkedList is empty");
        }
        Node rmNode = head.next;
        head.next = head.next.next;
        size--;
        E temp = (E) rmNode.data;
        return temp;
    }
    //s删除尾部结点
    public E removeLast(){
        if(size == 0){
            throw new IllegalStateException("CircleLinkedList is empty");
        }
        Node rmNode = tail;
        Node cur = head.next;
        if(cur == tail){
            head.next = head;
            tail = head;
            size--;
            return (E) rmNode.data;
        }
        //此时尾部指针需要遍历链表指向尾指针的前一个结点
        while (cur != null && cur.next != tail){
            cur = cur.next;
        }
        cur.next = head;
        size--;
        return (E) rmNode.data;
    }
    //删除指定结点
    public boolean remove(E e){
        if(!contains(e)){
            throw new IllegalArgumentException(e + "doesn't exist");
        }
        Node cur = head.next;
        Node before = head;
        while(cur != null && cur != head){
            if(cur.data.equals(e)){
                before.next = before.next.next;
                size--;
            }else{
                cur = cur.next;
                before = before.next;
            }
        }
        return true;
    }
    //判断是否包含某结点
    public boolean contains(E e){
        Node cur = head.next;
        while(cur != null && cur != head){
            if(cur.data.equals(e)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head.next;
        while(cur != null && cur != head){
            sb.append(cur.data + " ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CircleLinkedList<Integer> linkedList = new CircleLinkedList<>();
        for(int i=0;i<10;i++){
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
        linkedList.addLast(100);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
