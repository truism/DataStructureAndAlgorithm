package stu.edu.DynamicArray;


/**
 * 动态数组
 */
public class DynamicArray<T> {

    private T elements[];
    private int size;

    /**
     * 空参构造函数,默认初始容量为10
     */
    public DynamicArray(){
        this.size = 0;
        this.elements = (T[])new Object[10];
    }

    /**
     * 自定义初始容量
     * 避免后期动态改变容量，提高性能
     * @param capacity
     */
    public DynamicArray(int capacity){
        this.size = 0;
        elements = (T[])new Object[capacity];
    }

    /**
     * 返回数组元素个数
     * @return
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 数组末尾添加元素
     * @param element
     */
    public void addLast(T element){
        add(element, size);
    }

    /**
     * 添加元素
     * @param element
     * @param index
     */
    public void add(T element,int index){
        if(index<0 || index>elements.length){
            throw new IllegalArgumentException(index + "do not correct.");
        }
        if(size==elements.length){
            resize(2*size);
        }
        for(int i=size;i>index;i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除一个元素
     */
    public void delete(T element){
        int index = findElement(element);
        for(int i=index;i<size;i++){
            elements[i] = elements[i+1];
        }
        elements[size--] = null;
    }

    /**
     * 修改指定索引处的元素
     * @param element
     * @param index
     */
    public void set(T element,int index){
        if(index<0 || index>elements.length){
            throw new IllegalArgumentException(index + "do not correct.");
        }
        elements[index] = element;
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public T get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException(index + "do not correct.");
        }
        return elements[index];
    }


    /**
     * 查找元素的索引
     * @param element
     * @return
     */
    public int findElement(T element){
        for(int i=0;i<size;i++){
            if(element.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }


    /**
     * 动态扩容函数
     * @param newCapacity
     */
    private void resize(int newCapacity){
        T tempArray[] = (T[])new Object[newCapacity];
        for(int i=0;i<size;i++){
            tempArray[i] = elements[i];
        }
        elements = tempArray;
    }
}
