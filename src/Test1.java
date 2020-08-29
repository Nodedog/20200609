/*
*
*                   单例模式
*                   饿汉模式
*
*
* 饿汉模式线程安全 当多个线程同时调用getInstance,由于getInstance里只读取instance实例地址
* 相当于多个线程同时读取一个变量
* */

public class Test1 {
    //先创建 一个表示单例的类
    //我们要求Singleton 这个类只能有一个实例
    //饿汉模式的单例实现,"饿"指的是,只要类被加载,实例就会立刻创建
    static class Singleton{
        //构造方法变成私有,此时就在该类外部无法new这个类的实例
        private Singleton(){ }

        //再创建一个static的成员,表示Singleton类唯一的实例
        //static和类相关,和实例无关,类在内存中只有一份,static成员也就只有一份
        private static Singleton instance = new Singleton();

        public static Singleton getInstance(){
            return instance;
        }
    }

    public static void main(String[] args) {
        //此处的getInstance是获取该类实例的唯一方式
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
