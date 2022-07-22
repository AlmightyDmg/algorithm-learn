package cn.com.dmg.algorithmlearn.sort;

import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Description 希尔排序
 * @author zhum
 * @date 2022/7/22 11:00
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] numbers = {8,9,7,2,3,5,4,6,0};
        shellSort2(numbers);
        System.out.println(Arrays.toString(numbers));

    }

    /**
     * 希尔排序 交换法
     * @author zhum
     * @date 2022/7/22 11:01
     * @param numbers
     * @return void
     */
    public static void shellSort1(int[] numbers){
        /*
            每次都设置步长 下一次的步长是上一次的一半  第一次的步长为 numbers.length - 1

            当分好步长之后，两两数据进行交换

            全都交换完成之后进行下一步

            @author zhum
            @date 2022/7/22 11:01
         */

        int temp;
        //计算步长
        for (int gap = numbers.length / 2; gap > 0 ; gap /= 2) {
            //每一个步长需要分出来多少组   每次向后移动一位
            for (int i = gap; i < numbers.length; i++) {
                //在该步长下每组的两个数进行比较
                for (int j = i-gap; j >=0 ; j -= gap) {
                    if(numbers[j] > numbers[j+gap]){
                        temp = numbers[j];
                        numbers[j] = numbers[j+gap];
                        numbers[j+gap] = temp;
                    }
                }
            }
        }
    }


    /**
     * 移位法
     * @author zhum
     * @date 2022/7/22 15:28
     * @param numbers
     * @return void
     */
    public static void shellSort2(int[] numbers){

        //计算步长
        for (int gap = numbers.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < numbers.length; i++) {
                int j = i;
                int temp = numbers[j];
                if(numbers[j] < numbers[j - gap]){
                    while (j-gap >= 0 && temp < numbers[j - gap]){
                        //移动
                        numbers[j] = numbers[j-gap];
                        j -= gap;
                    }
                    numbers[j] = temp;
                }

            }
        }
    }



}
