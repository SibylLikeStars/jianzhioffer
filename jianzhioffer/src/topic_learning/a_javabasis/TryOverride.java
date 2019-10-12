package topic_learning.a_javabasis;

/**
 * 观察继承机制
 * 不能继承static方法，static方法中不能有super.和this：可以这么理解，实例不存在的时候，static还是存在的
 */
class Father{
    int x=1;
    Father(){
        System.out.println("father-constructor");
    }
    public void print(String str){
        System.out.println("Father "+str);
    }
    public void fatherUnique(){
        System.out.println("belong to father");
    }
}
class Son extends Father{
    int x=2;
    Son(){
        System.out.println("son-constructor");
    }
    @Override
    public void print(String str){
        System.out.println("Son "+str);
    }
    public void sonUnique(){
        System.out.println("belong to son");
    }
    public final String Msg(){
        return "x="+this.x;
    }
    public String Msg(String string){
        return "重载了final方法";
    }

}

public class TryOverride {
    public static void main(String [] args) {
        Father who = new Son();  //运行时类型是son，编译时类型是father。
        System.out.println(who.x); //1
        who.print("I am"); //Son I am, 不能引用father没有的方法，引用father有的方法时，如果子类有特色的实现，则输出子类的实现
        System.out.println(who.getClass());//class topic_learning.a_javabasis.Son
        ((Son) who).sonUnique(); //强制向下转型，此时就可以调用son中的特色方法，前提是，声明对象的时候，就是new son()，如果一开始就是new Father()，报ClassCastException
        System.out.println(((Son) who).Msg("ti")); //重载了final方法
    }
}


