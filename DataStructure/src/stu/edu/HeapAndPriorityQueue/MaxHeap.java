package stu.edu.HeapAndPriorityQueue;

import java.util.Random;

public class MaxHeap<T extends Comparable<T>> {

    private Array<T> array;

    public MaxHeap(){
        this.array = new Array<>();
    }

    //父亲节点
    public int parent(int child){
        if(child>0)
            return (child-1)/2;
        else
            throw new IllegalStateException(child + "don't have parent node.");
    }

    //左孩子节点
    public int leftChild(int parent){
        return parent*2+1;
    }

    //右孩子节点
    public int rightChild(int parent){
        return parent*2 + 2;
    }

    /**
     * 堆中已添加的元素个数
     * @return
     */
    public int getSize(){
        return array.getSize();
    }

    /**
     * 往堆中添加元素
     * @param elem
     */
    public void add(T elem){
        //将元素添加到堆底
        array.addLast(elem);
        //进行上升操作
        shiftUp(array.getSize()-1);
    }

    /**
     * 堆中节点上升操作
     * @param index
     */
    private void shiftUp(int index){
        while(index > 0){
            int p = parent(index);
            if(array.get(p).compareTo(array.get(index))<0){ //父元素比子元素小
                array.swap(index, p);
                index = p;
            }else{
                break;
            }
        }
    }

    /**
     * 删除堆顶元素
     * @return
     */
    public T remove(){
        if(!array.isEmpty()){
            T res = array.get(0);
            array.swap(0, array.getSize()-1); //调换堆顶和堆底元素
            array.removeLast(); //删除原来堆顶元素
            shiftDown(0); //将现在堆顶元素进行下降操作
            return res;
        }else{
            throw new IllegalStateException("MaxHeap is empty.");
        }
    }

    /**
     * 下降操作
     * @param index
     */
    private void shiftDown(int index){
        while(leftChild(index) < array.getSize()){
            int j = leftChild(index);
            if(j+1 < array.getSize() && array.get(j).compareTo(array.get(j+1))<0){ //说明有右孩子,且左孩子比有右孩子小
                j++;
            }
            //array.get(j)此时是最大值
            if(array.get(index).compareTo(array.get(j))>0){ //此时元素已到达正确位置
                break;
            }
            array.swap(j,index);
            index = j;
        }
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i=0;i<10;i++){
            maxHeap.add(random.nextInt(50));
        }
        for(int i=0;i<10;i++){
            System.out.print(maxHeap.remove()+" ");
        }
        System.out.println();
    }

}
