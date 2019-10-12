package topic_learning.design_mode.ProducerAndConsumer;

/**
 * @ClassName : PCDdata
 * @Description : 任务：生产者和消费者之间共享的数据模型
 * @Date : 2019/1/17 10:25
 */
public final class PCDdata {
    private final int intData;
    public PCDdata(int data){
        this.intData=data;
    }
    public PCDdata(String data){
        this.intData=Integer.valueOf(data);
    }
    public int getIntData(){
        return this.intData;
    }

    @Override
    public String toString() {
        return "PCDdata{" +
                "intData=" + intData +
                '}';
    }
}
