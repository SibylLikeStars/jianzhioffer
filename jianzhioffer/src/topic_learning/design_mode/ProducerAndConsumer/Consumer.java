package topic_learning.design_mode.ProducerAndConsumer;

import java.text.MessageFormat;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName : Consumer
 * @Description : 消费者
 * @Date : 2019/1/17 10:43
 */
public class Consumer implements Runnable{
    private BlockingQueue<PCDdata> queue;
    private static final int SLEEPTIME=1000;
    public Consumer(BlockingQueue<PCDdata> q){
        this.queue=q;
    }
    public void run(){
        System.out.println("start consumer id = "+Thread.currentThread().getId());
        try{
        while(true){
            PCDdata data=queue.take();
            if (null!=data){
                int re=data.getIntData()*data.getIntData();  // 处理任务：平方计算
                System.out.println(MessageFormat.format("{0}*{1}={2}",data.getIntData(),data.getIntData(),re));
                Thread.sleep(SLEEPTIME);
            }

        }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }



}
