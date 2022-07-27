package cn.com.dmg.algorithmlearn.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author zhum
 * @date 2022/7/25 16:33
 * @param
 * @return
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {8,4,5,7,1,3,6,2,0,234};
        int[] temp = new int[numbers.length];
        mergeSort(numbers,0,numbers.length-1,temp);

        System.out.println(Arrays.toString(numbers));

    }

    public static void mergeSort(int[] numbers,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            //向左进行递归分解
            mergeSort(numbers,left,mid,temp);
            //向右进行递归分解
            mergeSort(numbers,mid+1,right,temp);

            merge(numbers,left,mid,right,temp);
        }

    }


    /**
     * 合并
     * @author zhum
     * @date 2022/7/25 16:35
     * @param numbers 原始数组
     * @param left 左边起始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转数组
     * @return void
     */
    public static void merge(int[] numbers,int left,int mid,int right,int[] temp){
        //左边数组的开索引
        int i = left;
        //右边数组的开始索引
        int j = mid + 1;
        //临时数组的索引
        int t = 0;

        /*
            1.先把左右两边的（有序）数组按照规则填充到临时数组
            左右两边的有序序列，有一边填充完毕为止
            @author zhum
            @date 2022/7/25 16:39
         */
        while (i <= mid && j <= right){
            if(numbers[i] < numbers[j]){
                temp[t] = numbers[i];
                i++;
            } else {
                temp[t] = numbers[j];
                j++;
            }
            t++;
        }

        /*
            2.把剩余一边的所有数组填充到temp的最后
            @author zhum
            @date 2022/7/25 16:40
         */
        //左边的还有剩余 全部填充到temp
        while (i<=mid){
            temp[t] = numbers[i];
            t++;
            i++;
        }
        //右边的还有剩余 全部填充到temp
        while (j<=right){
            temp[t] = numbers[j];
            t++;
            j++;
        }

        /*
            3.将temp中的数组拷贝到numbers
            注意：并不是每次都拷贝 所有的数组
            最后一次的时候才是将所有的数据拷贝到原数组
            @author zhum
            @date 2022/7/25 16:41
         */
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            numbers[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }




    }

}
