package cn.com.dmg.algorithmlearn.sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description
 * @author zhum
 * @date 2022/7/22 16:23
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] numbers = {2,-1,1,0,-1,-2,0};
        quickSort(numbers,0,numbers.length-1);
        System.out.println(Arrays.toString(numbers));

    }

    /**
     * 快速排序
     * @author zhum
     * @date 2022/7/22 16:24
     * @param numbers
     * @param left
     * @param right
     * @return void
     */
    public static void quickSort(int[] numbers,int left,int right){
        //左下表
        int l = left;
        //右下标
        int r = right;
        //选取中轴值
        int pivot = numbers[(left + right) / 2];
        //while循环 是让比 pivot 小的值放在 pivot 左边 大的值放在pivot右边
        while (l < r){
            //在pivot左边找 找到比pivot大等的值
            while (numbers[l] < pivot){
                l++;
            }
            //在pivot右边找到比 pivot小等的值
            while (numbers[r] > pivot){
                r--;
            }

            //交换
            if(l >= r){
                //说明没有找到 不需要进行交换 退出(pivot左右两边的值已经按照 左边 小于等于 右边 大于等于 pivot)
                break;
            }

            int temp = numbers[l];
            numbers[l] = numbers[r];
            numbers[r] = temp;

            //如果交换完成之后 发现 numbers[l] == pivot r--  int[] numbers = {2,-1,1,0,-1,-2,0};
            if(numbers[l] == pivot){
                r--;
            }
            //如果交换完成之后 发现 numbers[r] == pivot l++
            if(numbers[r] == pivot){
                l++;
            }
        }

        if(l==r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r){
            quickSort(numbers,left,r);
        }
        //向右递归
        if(right > l){
            quickSort(numbers,l,right);
        }

    }

}
