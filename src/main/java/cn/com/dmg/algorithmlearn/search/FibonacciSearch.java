package cn.com.dmg.algorithmlearn.search;

/**
 * @ClassName FibonacciSearch
 * @Description 斐波那契查找
 * @author zhum
 * @date 2022/8/3 16:16
 */
public class FibonacciSearch {
    static int maxSize = 20;
    public static void main(String[] args) {

    }

    public static int fibSearch(int[] a,int key){
        int low = 0;
        int high = a.length - 1;
        //表示斐波那契的分隔数值的下标
        int k = 0;

        return -1;
    }
    /**
     * 创建一个 斐波那契数列
     * @author zhum
     * @date 2022/8/3 16:16
     * @param
     * @return int[]
     */
    public static int[] fib(){
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

}
