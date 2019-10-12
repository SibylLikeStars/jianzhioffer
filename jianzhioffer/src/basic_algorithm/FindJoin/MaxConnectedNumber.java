package basic_algorithm.FindJoin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 求一维数组中连通域的数目，并找出最大的连通域的元素个数
 */
public class MaxConnectedNumber {
    static int[] pre;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();  //点的个数
        int m=in.nextInt();  //路的数目
        //初始化pre数组，假设目前每个点都是独立的，所有pre[i]=i
        pre=new int[n+1];
        for (int i=1;i<=n;i++){
            pre[i]=i;
        }

        for (int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            join(a,b);  //相连着的两个点，就可以连接起来
        }
        int ans=0;
        for (int i=1;i<=n;i++){
            findCompress2(i);  //如果要统计最大的连通子集，就要加上这个！！
            if (pre[i]==i){  //只有根节点的pre[i]==i
                ans++;
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=1;i<=n;i++){
            if (!map.containsKey(pre[i])){
                map.put(pre[i],1);
            }else{
                map.put(pre[i],map.get(pre[i])+1);
            }
        }
        int max=0;
        for (Map.Entry<Integer,Integer> kv:map.entrySet()){
            max=Math.max(max,kv.getValue());
        }

        System.out.println("连通域个数："+ans);  //计算连通的子图数
        System.out.println("最大的连通子图元素个数："+max);
    }

    private static void join(int x,int y){
        int fx=findCompress2(x);
        int fy=findCompress2(y);
        if (fx!=fy){
            pre[x]=fy;
        }
    }

    //路径压缩的find：循环实现
    private static int findCompress2(int x){
        int r=x;
        while (r!=pre[r]){
            r=pre[r];
        }
        int i=x,j;
        while (i!=r){
            j=pre[i];
            pre[i]=r;
            i=j;
        }
        return r;
    }
}
