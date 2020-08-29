/*
*
*               改进的懒汉模式  线程安全
*
*1.加锁保证线程安全
*2.双重if保证效率
*3.volatile避免内存可见性引来的问题
*
* */
public class Test3 {
    static class Singleton {
        private Singleton() { }

        private volatile static Singleton instance = null;

        //synchronized public static Singleton getInstance() {
        public static Singleton getInstance() {
            //这里双重if判断当两个线程同时走到第一个if判断为null之后
            //一个线程抢到锁 另一个只能等待 当抢到锁的线程执行完之后
            //已经new了实例 所以当释放锁 另一个线程抢到锁之后这时再进行第一个if
            //判断已经不是null了 所以直接返回intance 这样就不用再进入第二个if判断
            //再判断完是否再new一个新的实例 提高了效率
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}
