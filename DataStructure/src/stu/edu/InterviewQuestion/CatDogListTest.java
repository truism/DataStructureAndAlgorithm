package stu.edu.InterviewQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 猫狗队列
 * ● 用户可以调用add方法将cat类或dog类的实例放入队列中；
 * ● 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 * ● 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
 * ● 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
 * ● 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 * ● 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 * ● 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 *
 */
public class CatDogListTest {

  public static void main(String[] args) {
    Animal dog = new Dog();
    Animal cat = new Cat();
    CatDogQueue queue = new CatDogQueue();
    queue.add(dog);
    queue.add(cat);
    Queue<Animal> animalQueue = queue.pollAll();
    while (!animalQueue.isEmpty()) {
      System.out.println(animalQueue.poll());
    }
  }

  /**
   * 猫狗队列
   */
  static class CatDogQueue {
    Queue<Animal> dogList;
    Queue<Animal> catList;
    int count;

    public CatDogQueue() {
      this.dogList = new LinkedList<>();
      this.catList = new LinkedList<>();
      this.count = 0;
    }

    public void add(Animal animal) {
      if(animal.getType().equals("Dog")) {
        animal.setCount(this.count++);
        dogList.add(animal);
      }else if(animal.getType().equals("Cat")) {
        animal.setCount(this.count++);
        catList.add(animal);
      }else {
        throw new IllegalArgumentException("Argument must animal class.");
      }
    }

    public Queue<Animal> pollAll() {
      Queue<Animal> animals = new LinkedList<>();
      while (!dogList.isEmpty() || !catList.isEmpty()) {
        if(dogList.isEmpty()) {
          animals.add(catList.poll());
          break;
        }
        if(catList.isEmpty()) {
          animals.add(dogList.poll());
          break;
        }
        if(dogList.peek().getCount() > catList.peek().getCount()) {
          animals.add(catList.poll());
        }else {
          animals.add(dogList.poll());
        }
      }
      return animals;
    }

    public Queue<Animal> pollDog() {
      return dogList;
    }

    public Queue<Animal> pollCat() {
      return catList;
    }

    public boolean isDogEmpty() {
      return dogList.isEmpty();
    }

    public boolean isCatEmpty() {
      return catList.isEmpty();
    }

    public boolean isEmpty() {
      return count == 0;
    }


  }

  /**
   * 猫狗的抽象类
   */
  static abstract class Animal {
    protected String type;
    protected int count;

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      return sb.append(type).append(":").append(count).toString();
    }
  }

  /**
   * Dog类
   */
  static class Dog extends Animal {
    public Dog() {
      this.type = "Dog";
      count = 0;
    }
  }

  /**
   * Cat类
   */
  static class Cat extends Animal {
    public Cat() {
      this.type = "Cat";
      count = 0;
    }
  }

}
