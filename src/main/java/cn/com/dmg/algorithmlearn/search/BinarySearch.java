package cn.com.dmg.algorithmlearn.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinarySearch
 * @Description 二分查找（数组必须是有序的）
 * @author zhum
 * @date 2022/7/27 17:09
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,4,4,5,6,7,8,9};
        System.out.println(binarySearch2(arr, 4, 0, arr.length-1));


    }

    public static int binarySearch(int[] arr,int findVal,int left,int right){
        if(left > right ){
            return -1;
        }

        //中间索引
        int midIndex = (left + right) / 2;
        //找到
        if(arr[midIndex] == findVal){
            return midIndex;
        } else if(arr[midIndex] > findVal){
            //向左递归
            return binarySearch(arr,findVal,left,midIndex - 1);
        } else {
            //向右递归
            return binarySearch(arr,findVal,midIndex + 1,right);
        }

    }


    /**
     * 找到所有的值
     * @author zhum
     * @date 2022/7/28 15:56
     * @param arr
     * @param findVal
     * @param left
     * @param right
     * @return int
     */
    public static List<Integer> binarySearch2(int[] arr, int findVal, int left, int right){
        if(left > right ){
            return null;
        }

        //中间索引
        int midIndex = (left + right) / 2;
        //找到
        if(arr[midIndex] == findVal){
            //找到的时候不要马上返回 向左和右边边扫描 将满足的下标加入到集合中  最后将集合返回
            List<Integer> list = new ArrayList<>();
            int leftTemp = midIndex - 1;
            while (true){
                if(leftTemp < 0 || arr[leftTemp] != findVal){
                    break;
                }
                list.add(leftTemp);
                leftTemp--;
            }

            int rightTemp = midIndex + 1;
            while (true){
                if(rightTemp > arr.length - 1 || arr[rightTemp] != findVal){
                    break;
                }
                list.add(rightTemp);
                rightTemp++;
            }

            list.add(midIndex);
            return list;
        } else if(arr[midIndex] > findVal){
            //向左递归
            return binarySearch2(arr,findVal,left,midIndex - 1);
        } else {
            //向右递归
            return binarySearch2(arr,findVal,midIndex + 1,right);
        }

    }
}
