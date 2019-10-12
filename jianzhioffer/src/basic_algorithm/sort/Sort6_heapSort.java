package basic_algorithm.sort;

/**
 * 6、堆排序
 * 最好：O(NlogN)
 * 最坏：O(NlogN)
 * 平均：O(NlogN)
 * 辅助：O(1)
 * 不稳定
 */
public class Sort6_heapSort {
    public void heapSort(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            //建大顶堆，把最大的值放在栈顶，[0]的位置
            maxHeapify(arrays, arrays.length - i);
            //将[0]和最后一个交换，交换
            int temp = arrays[0];
            arrays[0] = arrays[(arrays.length - 1) - i];
            arrays[(arrays.length - 1) - i] = temp;
        }
    }

    //从尾部开始建堆
    public static void maxHeapify(int[] arrays, int size) {
        for (int i = size - 1; i >= 0; i--) {
            heapify(arrays, i, size);
        }

    }
    //一次建堆
    public static void heapify(int[] arrays, int currentRootNode, int size) {
        if (currentRootNode < size) {
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;
            int max = currentRootNode;
            if (left < size) {
                if (arrays[max] < arrays[left]) {
                    max = left;
                }
            }
            if (right < size) {
                if (arrays[max] < arrays[right]) {
                    max = right;
                }
            }
            if (max != currentRootNode) {
                int temp = arrays[max];
                arrays[max] = arrays[currentRootNode];
                arrays[currentRootNode] = temp;
                heapify(arrays, max, size);
            }
        }
    }
}
