package cn.com.dmg.algorithmlearn.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //int[] numbers = {3,5,2,7,1,0,6,-1};
        int[] numbers = {-1,1,2,3,4,5,7,6};
        bubble(numbers);
        System.out.println(Arrays.toString(numbers));


    }

    public static void bubble(int[] numbers){

        //需要循环的次数 numbers.length - 1  每次循环的目的是为了确定一个最大的数 所以只需要确定 numbers.length - 1
        for (int i = 0; i < numbers.length - 1; i++) {
            //优化：当发现有一次循环中，一次交换也没有发生 则认为数组已经有序，可以提前终止循环
            boolean isExchange = false;
            //每次循环需要对比的次数  外层循环一次 内层需要比较的次数就-1   整个循环完成就是为了找到那个最大的数
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if(numbers[j] > numbers[j+1]){
                    isExchange = true;
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
            //System.out.printf("第%d次交换后的结果为：" + Arrays.toString(numbers),i+1);
            //System.out.println();
            if(isExchange == false){
                return;
            }
        }
    }
}
