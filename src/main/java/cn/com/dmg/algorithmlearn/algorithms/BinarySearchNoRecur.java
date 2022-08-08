package cn.com.dmg.algorithmlearn.algorithms;

/**
 * @ClassName BinarySearchNoRecur
 * @Description 非递归方式进行二分查找
 * @author zhum
 * @date 2022/8/8 20:17
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(numbers, 3));

    }

    public static int binarySearch(int[] numbers,int target){
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(numbers[mid] == target){
                return mid;
            } else if(numbers[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
