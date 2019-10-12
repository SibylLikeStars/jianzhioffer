package topic_learning.a_javabasis.annotation;

/**
 * @ClassName : Apple
 * @Description : TODO
 * @Date : 2019/9/2 21:41
 */
public class Apple {
    @FruitName()
    private String name;

    @FruitColor
    private String color;
    public Apple() {
    }

    public Apple(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public void displayName(){
        System.out.println("水果的名字是："+this.name);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
