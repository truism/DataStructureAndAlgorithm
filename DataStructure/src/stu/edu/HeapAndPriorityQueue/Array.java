package stu.edu.HeapAndPriorityQueue;

public class Array<T> {

    private T[] data;
    private int size;

    public Array(){
        this.data = (T[])new Object[10];
        this.size = 0;
    }

    public Array(T[] data){
        this.data = data;
        size = data.length;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在index位置添加元素
     * @param elem
     * @param index
     */
    public void add(T elem,int index){
        if(size == data.length)
            resize(2*size);
        for(int i=size;i>index;i--){
            data[i] = data[i-1];
        }
        data[index] = elem;
        size++;
    }

    public void addLast(T elem){
        data[size++] = elem;
    }

    /**
     * 删除数组最后一位元素
     * @return
     */
    public T removeLast(){
        T temp = data[size-1];
        data[--size] = null;
        return temp;
    }

    /**
     * 获取指定位置元素
     * @param index
     * @return
     */
    public T get(int index){
        return data[index];
    }

    /**
     * 交换指定位置元素
     * @param x
     * @param y
     */
    public void swap(int x,int y){
        T temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    /**
     * 动态扩容
     * @param capacity
     */
    private void resize(int capacity){
        T[] temp = (T[])new Object[capacity];
        for(int i=0;i<size;i++){
            temp[i] = data[i];
        }
        this.data = temp;
    }

}
