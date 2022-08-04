package cn.com.dmg.algorithmlearn.search;

/**
 * @ClassName InsertValueSearch
 * @Description 插值查找算法
 * @author zhum
 * @date 2022/8/2 16:12
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i+1;
        }

        System.out.println(insertValueSearch(numbers, 0, numbers.length -1 , 10));


    }

    public static int insertValueSearch(int[] numbers,int left,int right,int findValue){
        //findValue < numbers[0] || findValue > numbers[numbers.length - 1] 这两个必须存在 否则会出现数组越界的情况
        if(left > right || findValue < numbers[0] || findValue > numbers[numbers.length - 1]){
            return -1;
        }
        //求出mid
        int mid = left + (right - left) * (findValue - numbers[left]) / (numbers[right] - numbers[left]);
        int midVal = numbers[mid];
        if(findValue > midVal){
            return insertValueSearch(numbers,mid + 1,right,findValue);
        } else if(findValue < midVal){
            return insertValueSearch(numbers,left,mid - 1,findValue);
        } else {
            return mid;
        }
    }


}
