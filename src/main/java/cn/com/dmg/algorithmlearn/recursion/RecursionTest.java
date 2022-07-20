package cn.com.dmg.algorithmlearn.recursion;

/**
 * @ClassName RecursionTest
 * @Description 递归
 * @author zhum
 * @date 2022/7/20 11:28
 */
public class RecursionTest {
    public static void main(String[] args) {
        test1(4);

    }

    //打印问题
    public static void test1(int n){
        if(n > 2){
            test1(n-1);
        }
        System.out.println("n=" + n);
    }
    //阶乘问题
    public static int factorial(int n){
        if(n==1){
            return 1;
        } else {
            return factorial(n -1) * n;
        }
    }
}
