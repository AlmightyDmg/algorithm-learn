package cn.com.dmg.algorithmlearn.sort;

import java.util.Arrays;

/**
 * @ClassName RadixSort
 * @Description 桶排序
 * @author zhum
 * @date 2022/7/27 15:11
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] numbers = {53,3,542,748,14,214,0,2,532,553};
        radixSort(numbers);
        System.out.println(Arrays.toString(numbers));

    }

    public static void radixSort(int[] numbers){
        //定义一个二维数组 表示十个通 每给通就是一个数组
        //二维数组包含十个一维数组 为了防止溢出 所以每个一维数组的大小就是 numbers.length
        int[][] bucket = new int[10][numbers.length];

        //为了记录每个桶中实际存放了多少个数据 我们定义一个一维数组来记录各个桶每次放入的数据的个数
        int[] bucketEle = new int[10];

        //得到数组中最大的数的位数
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //总共需要放入到桶中的次数
        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            //针对每个元素的位进行排序   个十百千万
            for (int j = 0; j < numbers.length; j++) {
                //取出每个元素的个位的数字
                int digitOfElement = numbers[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketEle[digitOfElement]] = numbers[j];
                bucketEle[digitOfElement] ++ ;
            }
            //原数组的下标
            int index = 0;
            //按照桶的顺序 将放入桶中的数据 放入到原来的数组
            for (int k = 0; k < bucket.length; k++) {
                //如果桶中有数据 我们才放入到原数组
                if(bucketEle[k] != 0){
                    //循环该桶
                    for (int l = 0; l < bucketEle[k]; l++) {
                        //取出元素 放入到原数组
                        numbers[index] = bucket[k][l];
                        index ++ ;
                    }
                    //存放完成之后 将bucketEle[k]重置为0
                    bucketEle[k] = 0;
                }
            }
        }



    }
}
