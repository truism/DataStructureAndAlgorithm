package stu.edu.StackAndQueue;

public class StackImpl<E> implements Stack<E> {

    private E[] data;
    private int size;

    public StackImpl() {
        this(64);  //默认栈容量为64
    }

    public StackImpl(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    @Override
    public void push(E e) {
        if(size == data.length)
            throw new IllegalStateException("Stack is full.");
        data[size++] = e;
    }

    @Override
    public E pop() {
        if(size == 0){
            throw new IllegalStateException("Stack is empty.");
        }
        E temp = data[size-1];
        data[size-1] = null;
        size--;
        return temp;
    }

    @Override
    public E peek() {
        return data[size-1];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int search(Object e) {
        for(int i=size-1; i>=0; i--){
            if(e.equals(data[i])) { //此处需注意传入的元素需重写equals方法
                return size-1-i;
            }
        }
        return -1;  //未找到
    }

    public static void main(String[] args) {
        StackImpl<Integer> stack = new StackImpl<>();
        for(int i=0; i<10; i++) {
            stack.push(i);
        }
        for(int i=stack.getSize(); i>0; i--){
            System.out.print(stack.pop() + " ");
        }
    }
}
