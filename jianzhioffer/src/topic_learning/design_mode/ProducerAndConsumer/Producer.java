package topic_learning.design_mode.ProducerAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName : Producer
 * @Description : TODO
 * @Date : 2019/1/17 10:23
 */
public class Producer implements Runnable {
    private volatile boolean isRunning=true;
    private BlockingQueue<PCDdata> queue;
    private static AtomicInteger count=new AtomicInteger();
    private static final int SLEEPTIME=1000; //休眠时间，1s

    public Producer(BlockingQueue<PCDdata> q){
        this.queue=q;
    }
    public void run(){
        PCDdata data ;
        Random r =new Random();

        System.out.println("start producer id = "+Thread.currentThread().getId());
        try{
            while(isRunning){
                Thread.sleep(r.nextInt(SLEEPTIME)); //获取一个伪随机，在0(包括)和指定值(不包括)之中随机生成一个数
                data=new PCDdata(count.incrementAndGet());//构造任务数据
                System.out.println(data+" is put into queue");  //应该就是自动调用了toString
                if (!queue.offer(data,2, TimeUnit.SECONDS)){ //将任务装入缓冲区
                    System.out.println("failed to put data : "+data);
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt(); //将当前线程中断
        }
    }
    public void stop(){
        isRunning=false;
    }
}
