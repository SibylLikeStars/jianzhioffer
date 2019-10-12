package topic_learning.concurrent;

class ThreadLocalTest implements Runnable{
    static ThreadLocal<String> str=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    @Override
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName()+":"+str.get());
            Thread.sleep(10);
        }catch (Exception e){
            System.out.println(Thread.currentThread().getName()+":"+"执行结束");
        }
    }
}


public class TryThreadLocal {
    public static void main(String[] args){
        Thread t1=new Thread(new ThreadLocalTest());
        Thread t2=new Thread(new ThreadLocalTest());
        t1.start();
        t2.start();
    }
}
