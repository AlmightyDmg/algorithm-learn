package cn.com.dmg.algorithmlearn.sort;

import java.util.Arrays;

public class TestSort {

    public static void main(String[] args) {
        //测试八万个数据的排序时间
        int[] big = new int[80000];
        for (int i = 0; i < big.length; i++) {
            big[i] = (int)(Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
        //冒泡 8483毫秒
        //BubbleSort.bubble(big);
        //选择排序 用时：2124毫秒
        //SelectSort.selectSort(big);
        //插入排序 用时：452毫秒
        //InsertSort.insertSort(big);
        //希尔排序1 用时：4576毫秒
        //ShellSort.shellSort1(big);
        //希尔排序2 用时：15毫秒
        //ShellSort.shellSort2(big);
        //快速排序 用时：14毫秒
        //QuickSort.quickSort(big,0,big.length-1);
        //归并排序 用时：17毫秒
        //int[] temp = new int[big.length];
        //MergeSort.mergeSort(big,0, big.length-1, temp);
        //基数排序 用时：9毫秒
        //RadixSort.radixSort(big);
        //堆排序 用时：12毫秒
        HeapSort.heapSort(big);
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start )+ "毫秒");
        //System.out.println(Arrays.toString(big));
    }
}
