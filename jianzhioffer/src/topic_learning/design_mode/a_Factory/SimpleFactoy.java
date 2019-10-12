package topic_learning.design_mode.a_Factory;
abstract class Fruit{
    abstract void eat();
}

class Apple extends Fruit{
    @Override
    void eat() {
        System.out.println("apple");
    }
}

class Banana extends Fruit{
    @Override
    void eat() {
        System.out.println("Banana");
    }
}

class FruitFac{
    static Fruit makeFruit(String name) {
        Fruit f=null;
        switch (name){
            case "apple":f=new Apple();;break;
            case"banana":f=new Banana();break;
            default:break;
        }
        return f;
    }

}

public class SimpleFactoy {
    public static void main(String[] args){
        Fruit f=FruitFac.makeFruit("apple");
        f.eat();
    }
}
