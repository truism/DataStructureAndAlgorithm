package stu.edu.StackAndQueue;

public interface Stack<E> {

    void push(E e); //入栈
    E pop();        //出栈
    E peek();       //查询栈顶元素
    int getSize();     //栈中元素个数
    boolean isEmpty();  //判空
    int search(Object e); //查询元素e离栈顶的位置
}
