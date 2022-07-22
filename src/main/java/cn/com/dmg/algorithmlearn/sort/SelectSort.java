package cn.com.dmg.algorithmlearn.sort;

import java.util.Arrays;

/**
 * @ClassName SelectSort
 * @Description 选择排序
 * @author zhum
 * @date 2022/7/21 16:44
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] numbers = {-1,1,2,3,4,5,7,6};
        selectSort(numbers);
        System.out.println(Arrays.toString(numbers));


    }

    public static void selectSort(int[] numbers){
        /*
            从numbers[i]开始，每次选择一个最小数，放到当前位置
            总共需要进行 numbers.length - 1次选择
            @author zhum
            @date 2022/7/21 16:45
         */

        //进行选择 总共需要记性 numbers.length - 1次选择
        for (int i = 0; i < numbers.length - 1; i++) {
            //先假设当前位置的数就是最小值
            int minNumber = numbers[i];
            int minIndex = i;

            //选择一个最小数 从当前数的下一个数开始选择
            for (int j = i + 1; j < numbers.length; j++) {
                //判断
                if(numbers[j] < minNumber){
                    minNumber = numbers[j];
                    minIndex = j;
                }
            }

            //完成一轮循环之后 选择到了一个最小数  和当前位置的数进行交换
            if(minIndex != i){
                int temp = numbers[i];
                numbers[i] = minNumber;
                numbers[minIndex] = temp;
            }

        }

    }
}
