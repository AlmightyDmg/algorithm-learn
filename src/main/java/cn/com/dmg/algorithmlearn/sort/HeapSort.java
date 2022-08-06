package cn.com.dmg.algorithmlearn.sort;

import java.util.Arrays;

/**
 * @ClassName HeapSort
 * @Description 堆排序
 * @author zhum
 * @date 2022/8/6 16:33
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] numbers = {4,6,8,5,9};

        heapSort(numbers);

        System.out.println(Arrays.toString(numbers));

    }

    /**
     * 升序排序 大顶堆
     * 降序排序 小顶堆
     * @author zhum
     * @date 2022/8/6 16:34
     * @param numbers
     * @return void
     */
    public static void heapSort(int[] numbers){
        //将数组对应的二叉树 调整为 大顶堆
        for (int i = numbers.length/2; i >=0 ; i--) {
            adjustHeap(numbers,i, numbers.length);
        }

        int temp;
        for (int j = numbers.length - 1; j >0 ; j--) {
            //交换
            temp = numbers[j];
            numbers[j] = numbers[0];
            numbers[0] = temp;
            adjustHeap(numbers,0,j);
        }


    }

    /**
     * 完成 将以 i 对应的非叶子节点的树调整为 大顶堆
     * 举例 {4,6,8,5,9} -> i=1 ->{4,9,8,5,6}
     * 如果再次调用 i=0 {4,9,8,5,6} -> {9,6,8,5,4}
     * @author zhum
     * @date 2022/8/6 16:36
     * @param numbers 数组
     * @param i 非叶子节点的索引
     * @param length 表示多少个元素需要进行调整
     * @return void
     */
    public static void adjustHeap(int[] numbers,int i,int length){
        //先取出当前元素的值 保存在临时变量
        int temp = numbers[i];
        //k=i*2+1 表示的是i节点的左子节点
        for (int k = i*2+1; k < length; k=k*2+1) {
            //说明左子节点的值小于右子节点的值
            if(k+1 < length && numbers[k] < numbers[k+1]){
                //k 指向右子节点
                k++;
            }
            //如果子节点大于父节点
            if(numbers[k] > temp){
                //把较大的值赋予给当前节点
                numbers[i] = numbers[k];
                //i指向k 继续循环比较
                i = k;
            } else {
                break;
            }
        }
        //当for循环结束之后 我们已经将以i为父节点的最大值 放在了最顶上
        //将 temp 放到调整后的位置
        numbers[i] = temp;
    }
}
