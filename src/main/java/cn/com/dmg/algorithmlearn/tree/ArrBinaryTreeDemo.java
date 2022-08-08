package cn.com.dmg.algorithmlearn.tree;
/**
 * @ClassName ArrBinaryTreeDemo
 * @Description 将数组中的数据存储到二叉树中
 * @author zhum
 * @date 2022/8/4 14:14
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);

    }
}

class ArrBinaryTree{
    //存储数据节点的数组
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 编写一个方法 完成顺序存储二叉树的前序遍历
     * @author zhum
     * @date 2022/8/4 14:17
     * @param index 数组的下标
     * @return void
     */
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
        }

        //输出当前
        System.out.println(arr[index]);
        //向左遍历  左 leftIndex = 2 * index + 1
        if((index * 2 + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        //向右遍历 右 rightIndex = 2*index+2
        if((index * 2 + 2) < arr.length){
            preOrder(index * 2 + 2);
        }
    }
}
