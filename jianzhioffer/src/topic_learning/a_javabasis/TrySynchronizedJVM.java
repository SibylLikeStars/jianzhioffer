package topic_learning.a_javabasis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 查看Synchronized的字节码
 */
public class TrySynchronizedJVM {
    static int a=0;
    static int add0Age(){
        return ++a;
    }
    synchronized static int add1Age(){
        return ++a;
    }
    static int add2Age(){
        synchronized (String.class){
            return ++a;
        }
    }

    public static void main(String [] args){
        int b=add2Age();
        String String ="ss";
        System.out.println(b);
        final ExecutorService executors =  Executors.newCachedThreadPool();

    }
}
