package stu.edu.SegmentTree;

public class SegmentTreeTest {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,4,-1,3,7,8};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr,(a,b) -> a+b);
        //查询
        Integer result = segmentTree.query(1,3);
        System.out.println(result);
        System.out.println(segmentTree);

        segmentTree.update(1,10);
        System.out.println(segmentTree.query(1,3));

        System.out.println(segmentTree);  //打印线段树
    }
}
