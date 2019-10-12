package basic_algorithm;

public class TopK {
    //方法1：整体排序，取第k个；O(nlogn)
    //方法2：局部排序
    //方法3：小顶堆
    //方法4：快排-一个数组中的
    //方法5：二分：https://blog.csdn.net/chaiqunxing51/article/details/51143019

    public int binSort(int[] a,int[] b,int k){
        return binFindKth(a,a.length,b,b.length,k);
    }
    private int binFindKth(int[] a, int m, int[] b, int n, int k) {
        if (m>n)
            return binFindKth(b,n,a,m,k);
        if (m==0)
            return a[k-1];
        if (k==1)
            return Math.min(a[0],b[0]);
        int pa=Math.min(k/2,m);
        int pb=k-pa;
        if (a[pa-1]<b[pb-1]){
            int [] tmp=new int[m-pa];
            for (int i=pa,j=0;i<m;i++){
                tmp[j++]=a[i];
            }
            return binFindKth(tmp,m-pa,b,n,k-pa);
        }else if (a[pa-1]>b[pb-1]){
            int[] tmp=new int[n-pb];
            for (int i=pb,j=0;i<n;i++){
                tmp[j++]=b[i];
            }
            return binFindKth(a,m,tmp,n-pb,k-pb);
        }else{
            return a[pa-1];
        }
    }
}
