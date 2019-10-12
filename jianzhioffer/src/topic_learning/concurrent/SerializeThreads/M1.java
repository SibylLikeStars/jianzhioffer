package topic_learning.concurrent.SerializeThreads;

/**
 * 让线程顺序执行的方法
 */
public class M1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("A"));
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");});
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C");});
        t1.start();
//        t1.join();
        t3.start();
//        t3.join();
        t2.start();
        //输出：A C B
    }
}
