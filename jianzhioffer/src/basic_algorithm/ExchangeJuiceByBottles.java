package basic_algorithm;

public class ExchangeJuiceByBottles {
    int getNum(int x){
        return getNumHelper(0,x,x);
    }

    private int getNumHelper(int x, int bottle, int cover) {
        if (bottle<3 && cover<7)
            return x;
        int a=bottle/3;
        int b=cover/7;
        int c=bottle%3;
        int d=cover%7;
        return getNumHelper(a+b+x,a+b+c,a+b+d);
    }
    public static void main(String[] args){
        ExchangeJuiceByBottles s=new ExchangeJuiceByBottles();
        System.out.println(s.getNum(7));
    }
}
