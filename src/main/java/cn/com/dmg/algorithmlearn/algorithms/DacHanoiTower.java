package cn.com.dmg.algorithmlearn.algorithms;

/**
 * @ClassName DacHanoiTower
 * @Description 汉诺塔分治算法
 * @author zhum
 * @date 2022/8/8 20:39
 */
public class DacHanoiTower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    public static void hanoiTower(int num,char a,char b,char c){
        //如果只有一个盘
        if(num == 1){
            System.out.println("第1个盘从" + a + "->" + c);
        //当我们有 n>=2 个盘的时候，总可以把所有的盘看做是两个盘 1.下面的一个盘 2.上面的所有盘
        } else {
            //1.先把最上面的盘 A->B 移动过程会使用到c
            hanoiTower(num - 1,a,c,b);
            //2.把最下面的盘从 A->C
            System.out.println("第" +num+"个盘从" + a + "->" + c);
            //3.把B塔的所有盘从B->C 移动过程使用A塔
            hanoiTower(num-1,b,a,c);
        }
    }
}
