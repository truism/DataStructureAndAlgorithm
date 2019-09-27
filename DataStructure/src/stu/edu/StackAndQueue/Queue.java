package stu.edu.StackAndQueue;

public interface Queue<E> {
    boolean isEmpty();
    int size();
    void enQueue(E e); //入队
    E deQueue();  //出队
    E peek(); //获得队首元素
}
