/*
*
*                   懒汉模式
*
* 懒汉模式比饿汉模式效率要高
* 懒汉模式很大可能是"实例用不到",此时就省略了实例化的开销
*
*
* 懒汉模式 线程不安全
* 对于懒汉模式来说 当多个线程同时调用getInstance时
* 先读取instance的内容并判断是否为null
* 再如果instance如果是null 再new实例
* 最后返回实例的地址
* 因为线程之间是并发进行的可能几个线程同时判断instance时为null
* 然后就同时new Singleton 此时就已经不是单例模式了而同时出现多个实例
* 逻辑错误 线程也就不安全
* */
public class Test2 {
    static class Singleton {
        private Singleton() { }
        //类加载的时候,没有立刻实例化
        private static Singleton instance = null;

        //第一次调用getInstance的时候,才真的实例化
        //如果要是代码一整场都没有调用getInstance此时实例化的过程就被省略掉了
        //"延时加载"
        public static Singleton getInstance() {
                if (instance == null) {
                    instance = new Singleton();
                }
            return instance;
        }
    }
}
