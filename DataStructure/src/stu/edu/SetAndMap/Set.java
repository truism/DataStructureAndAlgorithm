package stu.edu.SetAndMap;

public interface Set<T> {

    int getSize();

    boolean contains(T elem);

    void add(T elem);

    boolean remove(T elem);

    void set(T oldElem,T newElem);

}
