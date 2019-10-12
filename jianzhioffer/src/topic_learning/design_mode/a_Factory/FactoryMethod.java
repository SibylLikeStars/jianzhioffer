package topic_learning.design_mode.a_Factory;
interface FruitFacMeth{
    Fruit produce();
}

class ProApple implements FruitFacMeth{
    @Override
    public Fruit produce() {
        return new Apple();
    }
}

class ProBanana implements FruitFacMeth{
    @Override
    public Fruit produce() {
        return new Banana();
    }
}

public class FactoryMethod {
    public static void main(String[] args){
        FruitFacMeth factory=new ProApple();
        Fruit f=factory.produce();
        f.eat();

    }
}
