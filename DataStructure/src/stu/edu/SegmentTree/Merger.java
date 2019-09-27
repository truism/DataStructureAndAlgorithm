package stu.edu.SegmentTree;

public interface Merger<E> {
    E merge(E firstElem, E secondElem);
}
