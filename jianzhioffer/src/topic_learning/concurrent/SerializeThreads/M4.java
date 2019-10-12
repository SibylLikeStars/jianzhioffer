package topic_learning.concurrent.SerializeThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class M4 {
    private static Lock lock=new ReentrantLock();
    private static Condition condition1=lock.newCondition();
    private static Condition condition2=lock.newCondition();
    private static boolean printA=true;  //先打印A
    private static boolean printB=false; //再打印B
    public static void main(String[] args) throws InterruptedException {
        Thread t11=new Thread(() -> {
            try{
                lock.lock();
                if (!printA) {
                   condition1.await(); //如果当前printA=false，则在条件1上等待
                }
                System.out.println("A");
                printB=true;
                printA=false;
                condition2.signal(); //唤醒在condition2上等待的线程
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        Thread t12=new Thread(() -> {
            try{
                lock.lock();
                if (!printB){
                    condition2.await();
                }
                System.out.println("B");
                printA=true;
                printB=false;
                condition1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t11.start();
        t12.start();
    }

}


