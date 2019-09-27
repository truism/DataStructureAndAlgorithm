package stu.edu.SetAndMap;

import stu.edu.LinkedList.LinkedList;

public class LinkedListSet<T> implements Set<T> {

    private LinkedList<T> linkedListSet;

    @Override
    public int getSize() {
        return linkedListSet.getSize();
    }

    @Override
    public boolean contains(T elem) {

        return linkedListSet.findElement(elem) != -1;
    }

    @Override
    public void add(T elem) {
        linkedListSet.addFirst(elem); //时间复杂度为O(1)
    }

    @Override
    public boolean remove(T elem) {
        if(linkedListSet.findElement(elem) == -1) {
            return false;
        }
        linkedListSet.remove(elem);
        return true;
    }

    @Override
    public void set(T oldElem, T newElem) {
        int index = linkedListSet.findElement(oldElem);
        linkedListSet.set(newElem, index);
    }


}
