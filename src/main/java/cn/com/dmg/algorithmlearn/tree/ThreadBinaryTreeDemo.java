package cn.com.dmg.algorithmlearn.tree;

/**
 * @ClassName ThreadBinaryTreeDemo
 * @Description 线索二叉树
 * @author zhum
 * @date 2022/8/5 11:26
 */
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {

    }
}

class ThreadBinaryTree{
    private ThreadHeroNode root;
    //为了能够线索化 需要创建指向前驱节点的指针 在递归进行线索化时 pre 总是保留前一个节点
    private ThreadHeroNode pre = null;

    public void setRoot(ThreadHeroNode root) {
        this.root = root;
    }

    //对二叉树进行中序线索化
    public void threadNodes(ThreadHeroNode node){
        if(node == null){
            return;
        }
        /*
            1.先线索化左子树
            2.线索化当前节点
            3.线索化右子树
            @author zhum
            @date 2022/8/5 11:35
         */
        threadNodes(node.getLeft());

        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre !=null && pre.getRight() == null){
            //让前驱节点的右指针 指向 当前节点
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        threadNodes(node.getRight());
    }

    //删除节点
    public void delNode(int no){
        if(root == null){
            return;
        }
        if(root.getNo() == no){
            root = null;
            return;
        }
        root.delNode(no);
    }

    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后续遍历
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }


    public ThreadHeroNode preOrderSearch(int no){
        if(this.root != null){
            return root.preOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
            return null;
        }
    }

    public ThreadHeroNode infixOrderSearch(int no){
        if(this.root != null){
            return root.infixOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
            return null;
        }
    }

    public ThreadHeroNode postOrderSearch(int no){
        if(this.root != null){
            return root.postOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
            return null;
        }
    }



}

class ThreadHeroNode {
    private int no;
    private String name;
    private ThreadHeroNode left;
    private ThreadHeroNode right;

    //0表示左子树 1表示前驱结点
    private int leftType;
    //0表示右子树 1表示后继节点
    private int rightType;

    public ThreadHeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 递归删除节点
     * @author zhum
     * @date 2022/8/4 13:55
     * @return
     */
    public void delNode(int no){
        //判断左子节点是否是需要删除的节点
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }
    }


    /**
     * 前序遍历
     * @author zhum
     * @date 2022/8/3 17:37
     * @param
     * @return int
     */
    public void preOrder(){
        //先输出当前节点
        System.out.println(this);
        //递归左子树
        if(this.left != null){
            this.left.preOrder();
        }
        //递归右子树
        if(this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     * @author zhum
     * @date 2022/8/3 17:37
     * @param
     * @return int
     */
    public void infixOrder(){
        //先递归左子树
        if(this.left != null){
            this.left.infixOrder();
        }

        //再输出当前节点
        System.out.println(this);

        //最后递归右子树
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     * @author zhum
     * @date 2022/8/3 17:37
     * @param
     * @return int
     */
    public void postOrder(){
        //先递归左子树
        if(this.left != null){
            this.left.postOrder();
        }
        //再递归右子树
        if(this.right != null){
            this.right.postOrder();
        }

        //最后输出当前节点
        System.out.println(this);
    }


    public ThreadHeroNode preOrderSearch(int no){
        if(this.no == no){
            return this;
        }

        ThreadHeroNode temp = null;
        if(this.left != null){
            temp = this.left.preOrderSearch(no);
        }
        if(temp != null){
            //找到了返回
            return temp;
        }

        if(this.right != null){
            temp = this.right.preOrderSearch(no);
        }
        //找到找不到都要返回
        return temp;
    }
    public ThreadHeroNode infixOrderSearch(int no){


        ThreadHeroNode temp = null;
        if(this.left != null){
            temp = this.left.infixOrderSearch(no);
        }
        if(temp != null){
            return temp;
        }

        if(this.no == no){
            return this;
        }

        if(this.right != null){
            temp = this.right.infixOrderSearch(no);
        }

        return temp;
    }

    public ThreadHeroNode postOrderSearch(int no){


        ThreadHeroNode temp = null;
        if(this.left != null){
            temp = this.left.postOrderSearch(no);
        }
        if(temp != null){
            return temp;
        }

        if(this.right != null){
            temp = this.right.postOrderSearch(no);
        }

        if(temp != null){
            return temp;
        }

        if(this.no == no){
            return this;
        }

        return null;

    }






    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadHeroNode getLeft() {
        return left;
    }

    public void setLeft(ThreadHeroNode left) {
        this.left = left;
    }

    public ThreadHeroNode getRight() {
        return right;
    }

    public void setRight(ThreadHeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
