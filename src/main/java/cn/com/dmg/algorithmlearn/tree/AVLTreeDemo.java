package cn.com.dmg.algorithmlearn.tree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] numbers = {4,3,6,5,7,8};
        int[] numbers = {10,12,8,9,7,6};
        AVLTree avlTree = new AVLTree();
        for (int number : numbers) {
            avlTree.add(new AVLNode(number));
        }

        avlTree.infixOrder();

        System.out.println("没有处理之前");
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("左子树的高度：" + avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度：" + avlTree.getRoot().rightHeight());

    }
}

class AVLTree{

    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    //查找要删除的节点
    public AVLNode search(int value){
        if(root == null){
            return  null;
        } else {
            return root.search(value);
        }
    }
    //查找父节点
    public AVLNode searchParent(int value){
        if(root == null){
            return null;
        } else {
            return root.searchParent(value);
        }
    }
    /**
     * 返回最小节点的值
     * 删除最小节点
     * @author zhum
     * @date 2022/8/7 17:54
     * @param node 传入的节点（作为二叉排序树的根节点）
     * @return int 返回以node为根节点的最小节点的值
     */
    public int delRightTreeMin(AVLNode node){
        AVLNode target = node;
        //循环查找左节点 就会找到最小值
        while (target.left != null){
            target = target.left;
        }
        //这时target就指向了最小节点 删除最小节点
        delNode(target.value);
        return target.value;
    }
    //删除节点
    public void delNode(int value){
        if(root == null){
            return;
        } else {
            //1.找到需要删除的节点
            AVLNode targetNode = search(value);
            if(targetNode == null){
                return;
            }
            //如果当前的二叉排序树只有一个节点
            if(root.left == null && root.right == null){
                root = null;
                return;
            }
            //2.查找 targetNode 的父节点
            AVLNode parentNode = searchParent(value);
            //如果删除的节点是叶子节点
            if(targetNode.left == null && targetNode.right == null){
                //判断 target 是parent 的左 还是 右 节点
                if(parentNode.left != null && parentNode.left.value == value){
                    parentNode.left = null;
                } else if(parentNode.right != null && parentNode.right.value == value){
                    parentNode.right = null;
                }
                //如果删除的节点有两颗子树
            } else if(targetNode.left != null && targetNode.right != null){
                int i = delRightTreeMin(targetNode.right);
                targetNode.value = i;
                //如果删除的节点有一颗子树
            } else {
                //要删除的节点有左子节点
                if(targetNode.left != null){
                    if(parentNode == null){
                        root = targetNode.left;
                        return;
                    }
                    //如果 targetNode 是parent 的左子节点
                    if(parentNode.left.value == value){
                        parentNode.left = targetNode.left;
                        //如果 targetNode 是parent 的右子节点
                    } else {
                        parentNode.right = targetNode.left;
                    }
                    //要删除的节点有右子节点
                } else {
                    if(parentNode == null){
                        root = targetNode.right;
                        return;
                    }
                    //如果 targetNode 是parent 的左子节点
                    if(parentNode.left.value == value){
                        parentNode.left = targetNode.right;
                        //如果 targetNode 是parent 的右子节点
                    } else {
                        parentNode.right = targetNode.right;
                    }
                }

            }


        }
    }

    //添加
    public void add(AVLNode node){
        if(root == null){
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        }
    }

}

class AVLNode {
    int value;
    AVLNode left;
    AVLNode right;


    //返回左子树的高度
    public int leftHeight(){
        if(left == null){
            return 0;
        } else {
            return left.height();
        }
    }

    //返回右子树的高度
    public int rightHeight(){
        if(right == null){
            return 0;
        } else {
            return right.height();
        }
    }

    //返回以该节点为根节点的树的高度
    public int height(){
        return Math.max(left == null ? 0:left.height(),right == null ? 0: right.height()) + 1;
    }

    //左旋转
    public void leftRotate(){
        //1.创建新的节点，以当前根节点的值作为值
        AVLNode avlNode = new AVLNode(value);
        //2.把新的节点的左子树 设置为当前节点的左子树
        avlNode.left = left;
        //3.把新的节点的右子树设置成 当前节点的 右子树的 左子树
        avlNode.right = right.left;
        //4.把当前节点的值替换成 右子节点的值
        value = right.value;
        //5.把当前节点的右子树设置成 当前节点的 右子树 的 右子树
        right = right.right;
        //6.把当前节点的左子树（左子节点）设置成新的节点
        left = avlNode;
    }

    //右旋转
    public void rightRotate(){
        AVLNode avlNode = new AVLNode(value);
        avlNode.right = right;
        avlNode.left = left.right;
        value = left.value;
        left = left.left;
        right = avlNode;
    }

    //添加节点
    public void add(AVLNode AVLNode){
        if(AVLNode == null){
            return;
        }

        //判断传入的节点的值 和 当前子树的根节点的关系
        if(AVLNode.value < this.value){
            //如果当前节点的左子节点为空 直接添加
            if(this.left == null){
                this.left = AVLNode;
            } else {
                this.left.add(AVLNode);
            }
        }

        if(AVLNode.value > this.value){
            if(this.right == null){
                this.right = AVLNode;
            } else {
                this.right.add(AVLNode);
            }
        }

        //当添加完一个节点后  如果 右子树的高度 - 左子树的高度 > 1
        if(rightHeight() - leftHeight() > 1){
            //如果 当前节点的 右子树的左子树的高度 大于 当前节点的右子树的右子树的高度
            if(right != null && right.rightHeight() < right.leftHeight()){
                //先对右子树进行右旋转旋转
                right.rightRotate();
            }
            //再进行左旋转
            leftRotate();

            //这个return 必须要
            return;
        }

        if(leftHeight() - rightHeight() > 1){
            if(left != null && left.rightHeight() > left.leftHeight()){
                //先对当前节点的左节点 进行 左旋转
                left.leftRotate();
            }
            //再对当前节点进行右旋转
            rightRotate();
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    //查找需要删除的节点
    public AVLNode search(int value){
        if(value == this.value){
            return this;
        } else if(value < this.value){
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        } else {
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除节点的父节点
    public AVLNode searchParent(int value){
        if((this.left != null && this.left.value == value) ||
                this.right != null && this.right.value == value){
            return this;
        } else {
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            } else if(value > this.value && this.right != null){
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }



    public AVLNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                '}';
    }
}


