package cn.com.dmg.algorithmlearn.tree;

/**
 * @ClassName BinaryTree
 * @Description 二叉树
 * @author zhum
 * @date 2022/8/3 17:34
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3,"卢俊义");
        HeroNode heroNode4 = new HeroNode(4,"林冲");
        HeroNode heroNode5 = new HeroNode(5,"关胜");
        //说明 先手动创建二叉树 后边再递归创建二叉树
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);

        binaryTree.setRoot(root);

        //1 2 3 5 4
        //binaryTree.preOrder();
        //2 1 5 3 4
        //binaryTree.infixOrder();
        //2 5 4 3 1
        //binaryTree.postOrder();

        System.out.println(binaryTree.preOrderSearch(5));
        System.out.println(binaryTree.infixOrderSearch(5));
        System.out.println(binaryTree.postOrderSearch(5));
    }

}

//定义一个二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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


    public HeroNode preOrderSearch(int no){
        if(this.root != null){
           return root.preOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if(this.root != null){
            return root.infixOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
            return null;
        }
    }

    public HeroNode postOrderSearch(int no){
        if(this.root != null){
            return root.postOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
            return null;
        }
    }



}

//先创建节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
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


    public HeroNode preOrderSearch(int no){
        if(this.no == no){
            return this;
        }

        HeroNode temp = null;
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
    public HeroNode infixOrderSearch(int no){


        HeroNode temp = null;
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

    public HeroNode postOrderSearch(int no){


        HeroNode temp = null;
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
