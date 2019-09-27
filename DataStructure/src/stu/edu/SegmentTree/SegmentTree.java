package stu.edu.SegmentTree;

/**
 * 对于某个动态变化的区间进行求和、求最大值、求最小值等操作很简便，时间复杂度为log(n)
 * 其思想其实还是以空间换时间
 * @param <E>
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;  //数据的线段树表示，其空间大小为data的4倍
    private Merger<E> merger;

    /**
     * 构造函数，其中merger代表对区间的操作
     * @param arr
     * @param merger
     */
    public SegmentTree(E[] arr, Merger<E> merger) {

        this.merger = merger;
        data = (E[])new Object[arr.length];
        tree = (E[])new Object[data.length*4];

        for(int i=0; i<arr.length; i++){
            data[i] = arr[i];
        }

        buildTree(0,0,data.length-1);
    }

    public SegmentTree() {}

    /**
     * 在treeIndex的位置创建l到r的线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildTree(int treeIndex, int l, int r){
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int mid = l + (r-l)/2;

        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        buildTree(leftChild, l, mid);
        buildTree(rightChild, mid+1, r);

        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
    }

    /**
     * 左孩子
     * @param treeIndex
     * @return
     */
    private int leftChild(int treeIndex) {
        return treeIndex*2 + 1;
    }

    /**
     * 右孩子
     * @param treeIndex
     * @return
     */
    private int rightChild(int treeIndex) {
        return treeIndex*2 + 2;
    }

    /**
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i=0; i<tree.length; i++){
            sb.append(tree[i] + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 查询区间l到r经操作后的数据
     * @param l
     * @param r
     * @return
     */
    public E query(int l, int r) {
        if(l<0 || r>=data.length || r<l) {
            throw  new IllegalArgumentException("Params isn't correct");
        }
        return query(0,0, data.length-1, l, r);
    }

    //查询以treeIndex为根从l到r线段树上queryL到queryR区间的数据
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if(l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r-l)/2;

        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        if(queryL > mid) {
            return query(rightChild, mid+1, r, queryL, queryR);
        }else if(queryR <= mid) {
            return query(leftChild, l, mid, queryL, queryR);
        }

        E leftResult = query(leftChild, l, mid, queryL, mid);
        E rightResult = query(rightChild, mid+1, r, mid+1, queryR);
        return merger.merge(leftResult,rightResult);
    }

    /**
     * 更新数组某位置的值
     * @param index
     * @param e
     */
    public void update(int index, E e) {
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException(index + "is not correct.");
        }
        data[index] = e;
        update(0, 0, data.length-1, index, e);
    }

    //更新以treeIndex为根节点的线段树，从l到r区间中节点为index的值
    private void update(int treeIndex, int l, int r, int index, E e){
        if(l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l)/2;

        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        if(index >= mid+1) { //待更新的节点在mid 到 r之间
            update(rightChild, mid+1, r, index, e);
        }else{
            update(leftChild, l, mid, index, e);
        }

        //此时左孩子树或右孩子树已被更新，需备同步到以treeIndex为根节点的树上
        tree[treeIndex] = merger.merge(tree[leftChild],tree[rightChild]);
    }



}
