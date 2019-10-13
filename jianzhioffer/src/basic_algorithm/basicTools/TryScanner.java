package basic_algorithm.basicTools;

import java.util.Scanner;

/**
 * Scanner的常见用法
 */
public class TryScanner {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //读取int
        int a=in.nextInt();
        String b=in.next(); //遇到 空格 or 换行符 停止
        String c=in.nextLine(); //遇到 换行符 停止

        //未知录入行数时
        while (in.hasNext()){
            int d=in.nextInt();
            int e=in.nextInt();
            System.out.println(d+e);
        }

        //已知录入行数
        int rows=in.nextInt();
        int [] arr=new int[rows];
        for (int i=0;i<rows;i++){
            arr[i]=in.nextInt();
        }

        //输入字符去格式化处理
        String[] strs = in.nextLine().replace("[", "").replace("]", "").split(",");

    }
}
