package topic_learning.concurrent.SerializeThreads;

public class M3 {
    public static void main(String[] args) throws InterruptedException {
        //方法3：通过wait和notify机制
        MyThread myThread = new MyThread();
        Thread t8 = new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.printStr("A", 0);
            }
        });
        Thread t9 = new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.printStr("B", 2);
            }
        });
        Thread t10 = new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.printStr("C", 1);
            }
        });
        t8.start();
        t9.start();
        t10.start();
    }
}

class MyThread {
    private static int flag=0;
    public synchronized void printStr(String str,int order){
        while (flag!=order){
            try{
                this.wait();//wait方法调用之前必须得获得对象的synchronized关键字
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(str);
        if (order<2)
            flag++;
        else
            flag=1;
        this.notifyAll();
    }
}