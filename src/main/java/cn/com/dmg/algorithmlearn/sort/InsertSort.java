package cn.com.dmg.algorithmlearn.sort;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description 插入排序
 * @author zhum
 * @date 2022/7/21 17:28
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] numbers = {-1,2,3,4,5,6,7,1};
        insertSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void insertSort(int[] numbers){

        /*
            假定从数组的第一个数numbers[0]开始是一个有序数组
            从第二个数开始，在有序数组中进行比较 插入到合适的位置 形成一个新的有序数组
            ...一直持续到最后一个数

            需要插入的次数为 numbers.length - 1
            @author zhum
            @date 2022/7/21 17:28
         */

        for (int i = 0; i < numbers.length - 1; i++) {
            //有序数组中最右侧的数的索引
            int maxIndex = i;
            //待插入的数字
            int waitInsertNumber = numbers[maxIndex + 1];

            //进行比较
            while (maxIndex >=0 && waitInsertNumber < numbers[maxIndex]){
                //将位置进行后移
                numbers[maxIndex+1] = numbers[maxIndex];
                maxIndex --;
            }

            //最后插入
            numbers[maxIndex + 1] = waitInsertNumber;


        }



    }

}
