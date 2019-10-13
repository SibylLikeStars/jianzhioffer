package basic_algorithm;

/**
 * 给初始啤酒数，3空瓶换1瓶酒，7空瓶换1瓶酒，问一共可以喝多少瓶
 */
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

    //方法2
    static int sum=0;
    static int lastBottle=0;
    static int lastCover=0;
    public static int getBeerCount(int x) {
        getBeerCount1(x);
        return sum;
    }
    public static void getBeerCount1(int x) {
        sum+=x;
        int curBottle=lastBottle+x;
        int curCover=lastCover+x;
        int echangeBotle=0;
        echangeBotle=curBottle/3;
        lastBottle=curBottle%3;
        echangeBotle+=curCover/7;  //本轮总共可以换多少瓶
        lastCover=curCover%7;
        if (lastBottle+echangeBotle>=3 || lastCover+echangeBotle>=7) {
            getBeerCount1(echangeBotle);
        }else{
            sum+=echangeBotle;
        }
    }

}
