package basic_algorithm.packagePro;


/**
 * 完全背包问题
 */
public class Package_all {
    static int [] volume=new int[]{0,5,7};
    static int [] values=new int[]{0,5,8};

    //方法1：递归法求解
    private static int getRes(int i,int capacity){
        int maxValue=0;
        if (i==0|| capacity==0) {
            return maxValue;
        }else if (volume[i]>capacity){
            maxValue=getRes(i-1,capacity);
        }else{
            for (int m=0;m*volume[i]<=capacity;m++){
                int tempValue=getRes(i-1,capacity-m*volume[i])+values[i]*m;
                if (tempValue>maxValue){
                    maxValue=tempValue;
                }
            }
        }
        return maxValue;
    }

    // 方法2：动态规划法求解
    static Integer  [][] arr=new Integer [3][11];
    private static int getRes2(int i,int capacity){
        if (arr[i][capacity]!=null)
            return arr[i][capacity];
        int result=0;
        if (i==0||capacity==0){
            return result;
        }else if (volume[i]>capacity){
            result=getRes2(i-1,capacity);
        }else{
            for (int m=0;m*volume[i]<=capacity;m++){
                int tempValue=getRes2(i-1,capacity-m*volume[i])+m*values[i];
                if (tempValue>result){
                    result=tempValue;
                }
            }
            arr[i][capacity]=result;
        }
        return result;
    }

    //方法3：动态规划，自下而上，填充数组（但此时，要把数组中的第一个0去掉）
    static int [][] arr2=new int[3][11];
    public static int getRes3(int i,int capacity){
        for (int m=0;m<i;m++){
            for (int n=0;n<=capacity;n++){
                for (int k=0;k*volume[m]<=n;k++){
                        arr2[m+1][n]=Math.max(arr2[m+1][n],arr2[m][n-k*volume[m]]+k*values[m]);
                    }
            }
        }
        return arr2[i][capacity];
    }


    public static void main(String[] args){
        System.out.println(getRes3(2,10));
    }
}
