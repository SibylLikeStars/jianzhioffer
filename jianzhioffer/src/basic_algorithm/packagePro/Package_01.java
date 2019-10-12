package basic_algorithm.packagePro;

/**
 * 0-1背包问题
 */
public class Package_01 {
    /**
     * 方法1：分治法（迭代法）
     * 注意：价值数组和体积数组，要增一列。存在重复计算的问题
     * @param i:当前下标
     * @param c：剩余容量
     * @return ：此时能装下的物品的最大价值
     */
    static int [] values=new int[]{0,2,4,3,7};
    static int [] volume=new int[]{0,2,3,5,5};

    private static int getBestValues(int i,int c){
        if (i<=0||c<=0)
            return 0;
        int result=0;
        if (c<volume[i]){
            //剩余的容量装不下该物体
            result=getBestValues(i-1,c);
        }else{
            result=Math.max(getBestValues(i-1,c),getBestValues(i-1,c-volume[i])+values[i]);
        }
        return result;
    }

    /**
     * 方法2：记忆搜索法，将中间结果记在数组中
     * @param i:当前下标
     * @param c:剩余容量
     * @return: 此时能装下的物品的最大价值
     */
    static Integer [][] interValue=new Integer[5][11];
    private static int getBestVluesByMem(int i,int c){
        if (interValue[i][c]!=null)
            return interValue[i][c];
        if (i<=0||c<=0)
            return 0;
        int result=0;
        if (c<volume[i]){
            result=getBestVluesByMem(i-1,c); //切记，这里不是直接取数组啊
        }else{
            int temp=getBestVluesByMem(i-1,c-volume[i])+values[i];
            result=Math.max(getBestVluesByMem(i-1,c),temp);
        }
        interValue[i][c]=result;
        return result;
    }

    /**
     * 方法3：动态规划，从下到上
     * @param i:当前下标
     * @param c:剩余容量
     * @return: 此时能装下的物品的最大价值
     */
    static int[][] interValues=new int[5][11];
    private static int getBestValuesByDynamic(int num,int capacity){
        for (int i=1;i<=num;i++){//注意此处，<=
            for (int j=1;j<=capacity;j++){
                interValues[i][j]=interValues[i-1][j];
                if (j>=volume[i]){
                    interValues[i][j]=Math.max(interValues[i-1][j],interValues[i-1][j-volume[i]]+values[i]);
                }
            }
        }
        return interValues[num][capacity];
    }

    /**
     * 方法4：动态规划，从下到上,两行优化
     */
    static int [][] memo=new int[2][11];
    private static int getBestValuesOpti(int num,int capacity){
        for (int i=1;i<=num;i++){
            for (int j=1;j<=capacity;j++){
                memo[i%2][j]=memo[(i-1)%2][j];
                if (j>=volume[i]){
                    memo[i%2][j]=Math.max(memo[(i-1)%2][j],memo[(i-1)%2][j-volume[i]]+values[i]);
                }
            }
        }
        return memo[num%2][capacity];
    }

    /**
     * 方法5：动态规划，从下到上,一行优化
     */
    static int [] memo2=new int[11];
    private static int getBestValuesOpti2(int num,int capacity){
        for (int i=1;i<=num;i++){
            for (int j=capacity;j>=volume[i];j--){ //这里变化了
                    memo2[j]=Math.max(memo2[j],memo2[j-volume[i]]+values[i]);
            }
        }
        return memo2[capacity];
    }


    public static void main(String[] args){
        System.out.println(getBestValuesOpti2(4,10));
    }
}
