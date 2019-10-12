package basic_algorithm.packagePro;

import java.util.Scanner;

public class PackageDemo {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String[] arr=in.nextLine().trim().split(",");
        int n=arr.length; //个数
        int [] nums=new int[n+1]; //相当于value数组，它的体积数组取值都是1
        nums[0]=0;
        int sum=0;
        for (int i=1;i<n;i++){
            nums[i]=Integer.parseInt(arr[i-1]);
            sum+=nums[i];
        }
        int halfsum=sum/2;
        if (halfsum*2!=sum){
            System.out.println(false);
            return;
        }
         int [][] memo=new int[2][halfsum+1];
           for (int i=1;i<=n;i++){
               for (int j=1;j<=halfsum;j++){
                   memo[i%2][j]=Math.max(memo[(i-1)%2][j],memo[(i-1)%2][j-1]+nums[i]);
               }
           }
        if (memo[n%2][halfsum]>0)
            System.out.println(true);
        else
            System.out.println(false);
    }

}
