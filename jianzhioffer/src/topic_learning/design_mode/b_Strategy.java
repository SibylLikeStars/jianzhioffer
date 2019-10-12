package topic_learning.design_mode;


abstract class StrategyRoot{
    public abstract void algorithm();
}

class Method1 extends StrategyRoot{
    @Override
    public void algorithm() {
        System.out.println("方法1");
    }
}

class Method2 extends StrategyRoot{
    @Override
    public void algorithm() {
        System.out.println("方法2");
    }
}

class Context{
    StrategyRoot strategy;
     Context(StrategyRoot s){
        this.strategy=s;
    }
     void carryout(){
        strategy.algorithm();
    }
}

public class b_Strategy {
    public static void main(String[] args){
        Context context=new Context(new Method1());
        context.carryout();
        Context context2=new Context(new Method2());
        context2.carryout();
    }
}
