package topic_learning.a_javabasis.genericity;

/**
 * 泛型的应用之：元组，可以一次return回几种不同类型的数据
 */
 class TTuple<A, B> {
    public final A first;
    public final B second;
    public TTuple(A a,B b){
        this.first=a;
        this.second=b;
    }
}

public class Tuple<A,B,C> extends TTuple<A,B>{
    public final C third;
    public Tuple(A a, B b,C c) {
        super(a, b);
        this.third=c;
    }
}
