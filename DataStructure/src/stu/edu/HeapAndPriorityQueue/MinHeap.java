package stu.edu.HeapAndPriorityQueue;

import java.util.Random;

/**
 * 最小堆
 * 堆顶元素比左右子树的元素都小
 */
public class MinHeap<E extends Comparable> {

    private Array<E> data;

    public MinHeap() {
        data = new Array();
    }

    public int getSize() {
        return data.getSize();
    }

    //父节点
    private int parent(int index) {
        if(index <= 0){
            throw new IllegalArgumentException(index + "doesn't have parent node.");
        }
        return (index - 1)/2;
    }

    //左孩子节点
    private int leftChild(int index) {
        return index*2 + 1;
    }

    //右孩子节点
    private int rightChild(int index) {
        return index*2 + 2;
    }

    //往堆中添加元素
    public void add(E elem) {
        data.addLast(elem);
        shiftUp(data.getSize()-1);
    }
    //上浮操作
    private void shiftUp(int index) {
        while(index > 0) {
            int parent = parent(index);
            if(data.get(index).compareTo(data.get(parent)) < 0) {  //子元素小于父元素
                data.swap(index,parent);
                index = parent;
            }else{
                break;
            }
        }
    }

    //删除堆顶元素
    public E remove() {
        if(!data.isEmpty()){
            E res = data.get(0);
            //交换堆顶与堆底元素,然后让堆顶元素下沉
            data.swap(0,data.getSize()-1);
            data.removeLast();
            shiftDown(0);
            return res;
        }else {
            throw new IllegalStateException("MinHeap is empty.");
        }
    }
    //下沉操作
    private void shiftDown(int index) {
        while(leftChild(index) < data.getSize()) {
            int j = leftChild(index);
            //有右孩子且右孩子不左孩子小
            if((j+1) < data.getSize() && data.get(j+1).compareTo(data.get(j))<0) {
                j = j+1;
            }
            //测试data.get(j)是左右孩子中最小的
            data.swap(j,index);
            index = j;
        }
    }


    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();
        Random random = new Random();
        for(int i=0;i<10;i++){
            minHeap.add(random.nextInt(50));
        }
        for(int i=0;i<10;i++){
            System.out.print(minHeap.remove()+" ");
        }
        System.out.println();
    }
}
