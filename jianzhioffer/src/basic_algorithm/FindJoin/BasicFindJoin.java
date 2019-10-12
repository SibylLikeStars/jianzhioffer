package basic_algorithm.FindJoin;

import java.util.Scanner;

/**
 * 并查集
 *
 * 测试用例：4 2 1 3 4 3
 * 一共有4个点，2条路。下面两行告诉你，1、3之间有条路，4、3之间有条路。那么整幅图就被分成了1-3-4和2两部分。
 */
public class BasicFindJoin {
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
            if (pre[i]==i){  //只有根节点的pre[i]==i
               ans++;
            }
        }
        System.out.println("连通域个数："+ans);  //计算连通的子图数
    }

    private static void join(int x,int y){
        int fx=findCompress2(x);
        int fy=findCompress2(y);
        if (fx!=fy){
            pre[x]=fy;
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>> find <<<<<<<<<<<<<<<<<<<<<<<<
    //非路径压缩的find
    private static int findOrigin(int x){
        int r=x;
        while (r!=pre[r]){
            r=pre[r];
        }
        return r;
    }

    //路径压缩的find：递归实现
    private static int findCompress1(int x){
        if(x!=pre[x]){
            pre[x]=findCompress1(pre[x]);
        }
        return pre[x];
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
