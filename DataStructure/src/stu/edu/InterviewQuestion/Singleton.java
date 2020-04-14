package stu.edu.InterviewQuestion;

/**
 * @author Admin
 * 单例类：饿汉式和懒汉式
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    // 私有化构造器
    private Singleton(){};

    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 懒汉式，需要的时候才去创建单例类
 */
class Singleton2 {

    private Singleton2() {};

    private static class Singleton2Loader {
        private static Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return Singleton2Loader.instance;
    }

}