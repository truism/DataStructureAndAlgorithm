package stu.edu.LinkedList;

import java.util.Random;

public class LinkedList<T> {

    private class Node{
        private T data;
        private Node next;

        public Node(){
            this(null,null);
        }

        public Node(T data){
            this(data,null);
        }

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }

        public String toString(){
            return data.toString();
        }
    }

    private Node dumyHead;
    private int size;

    /**
     * 带有头结点的链表
     */
    public LinkedList(){
        this.dumyHead = new Node();
    }

    public int getSize(){
        return this.size;
    }

    /**
     * 查找指定元素在链表中的位置
     * @param elem
     * @return
     */
    public int findElement(T elem){
        Node cur = dumyHead.next;
        for(int i=0;i<size;i++){
            if(elem.equals(cur.data)){
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void add(T elem,int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException(index + "do not correct.");
        }
        Node prev = dumyHead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        prev.next = new Node(elem, prev.next);
        size++;
    }

    public void addFirst(T elem){
        add(elem,0);
    }

    public void addLast(T elem){
        add(elem, size);
    }

    public void remove(T elem){
        Node prev = dumyHead;
        int index = findElement(elem);
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        T e = prev.next.data;
        prev.next = prev.next.next;
        size--;
    }

    public T removeFirst(){
        if(size==0){
            throw new RuntimeException("LinkedList is empty.");
        }
        T e = dumyHead.next.data;
        dumyHead.next = dumyHead.next.next;
        size--;
        return e;
    }

    public T removeLast(){
        if(size==0){
            throw new RuntimeException("LinkedList is empty.");
        }
        Node cur = dumyHead.next;
        while (cur.next!=null){
            cur = cur.next;
        }
        T e = cur.data;
        cur = null;
        size--;
        return e;
    }


    public void set(T elem,int index){

        if(index<0 || index>=size){
            throw new IllegalArgumentException(index + "do not correct.");
        }

        Node cur = dumyHead.next;
        for(int i=0;i<index;i++){
            cur.data = elem;
        }
    }

    public T get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException(index + "do not correct.");
        }
        Node cur = dumyHead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.data;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node cur = dumyHead.next;
        for(int i=0;i<size;i++){
            if(i==size-1){
                sb.append(cur.data);
                break;
            }
            sb.append(cur.data+" => ");
            cur = cur.next;

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<20;i++){
            list.addFirst(random.nextInt(100));
        }
        list.addLast(100);
        System.out.println(list.toString());
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list.toString());
    }

}
