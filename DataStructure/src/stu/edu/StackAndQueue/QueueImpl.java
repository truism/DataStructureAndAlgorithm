package stu.edu.StackAndQueue;

public class QueueImpl<E> implements Queue<E> {
    private class Node {
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

    private Node head; //链表头结点
    private Node rail; //链表尾结点
    private int size;

    public QueueImpl() {
        head = new Node();
        rail = head;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    //入队时元素加到队尾
    @Override
    public void enQueue(E e) {
        rail.next = new Node(e,null);
        rail = rail.next;
        size++;
    }

    //出队时删除队首元素
    @Override
    public E deQueue() {
        if(size == 0){
            throw new IllegalStateException("List is empty.");
        }
        E temp = head.next.data;

        head.next = head.next.next;
        size --;
        return temp;
    }

    //获得队首元素
    @Override
    public E peek() {
        if(size == 0){
            throw new IllegalStateException("List is empty.");
        }
        return head.next.data;
    }

    /**
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head.next;
        sb.append("head ");
        while(cur != null){
            sb.append(cur.data+" ");
            cur = cur.next;
        }
        sb.append("rail");
        return sb.toString();
    }


    public static void main(String[] args) {
        QueueImpl<Integer> queue = new QueueImpl<>();
        for(int i=0; i<5; i++){
            queue.enQueue(i);
        }
        System.out.println(queue);
        queue.deQueue();
        System.out.println(queue);
    }
}
