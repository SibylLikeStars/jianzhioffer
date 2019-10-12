package topic_learning.a_javabasis.genericity;

/**
 * 泛型
 */
public class Holder<T> {
    public Holder(){
    }
    private T t;
    public Holder(T t){
        this.t=t;
    }
    public T getT(){
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    //写个泛型方法
    // <E> 是泛型方法的标志
    public <E> void printInfo(E e){
        System.out.println(e);
    }
    public <T> int getHashCode(T t){
        return t.hashCode();
    }
}
