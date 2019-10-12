package topic_learning.concurrent.SerializeThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class M2 {
    public static void main(String[] args){
        Thread t5=new Thread(()->System.out.println("A"));
        Thread t6=new Thread(()->System.out.println("B"));
        Thread t7=new Thread(()->System.out.println("C"));
        ExecutorService single=new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
//        ExecutorService single = Executors.newSingleThreadExecutor();
        single.submit(t5);
        single.submit(t7);
        single.submit(t6);
    }
}
