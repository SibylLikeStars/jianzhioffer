package topic_learning.concurrent;

/**
 * 制造死锁
 */
public class MakeDeadLock {
    public static void main(String[] args){
        Object o1=new Object();
        Object o2=new Object();
        Object o3=new Object();
        Object o4=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    try{
                        System.out.println("t1 happy");
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2){}
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    try{
                        System.out.println("t2 happy");
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1){}
                }
            }
        });
        t1.start();
        t2.start();
    }
}
