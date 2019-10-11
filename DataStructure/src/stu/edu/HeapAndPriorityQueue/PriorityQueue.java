package stu.edu.HeapAndPriorityQueue;

import java.util.Random;

/**
 * 优先级队列
 * 以最大堆作为存储结构
 * 优先级高的元素在堆顶，优先级低的元素在堆底
 * @param <T>
 */
public class PriorityQueue<T extends Comparable<T>> {
    private MaxHeap<T> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    public int getSize(){
        return maxHeap.getSize();
    }

    //往优先级队列中添加元素
    public boolean add(T elem) {
        try{
            maxHeap.add(elem);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //从优先级队列中删除元素
    public T remove() {
        return maxHeap.remove();
    }

    //测试
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Random random = new Random();
        for(int i=0; i<10; i++) {
            queue.add(random.nextInt(50));
        }
        int num = queue.getSize();
        for(int i=0; i<num; i++) {
            System.out.print(queue.remove() + " ");
        }
    }
}
