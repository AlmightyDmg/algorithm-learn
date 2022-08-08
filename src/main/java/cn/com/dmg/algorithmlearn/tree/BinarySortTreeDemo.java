package cn.com.dmg.algorithmlearn.tree;

/**
 * @ClassName BinarySortTreeDemo
 * @Description 二叉排序树
 * @author zhum
 * @date 2022/8/7 16:23
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] numbers = {7,3,10,12,5,1,9,2};

        BinarySortTree binarySortTree = new BinarySortTree();
        for (int number : numbers) {
            binarySortTree.add(new SortNode(number));
        }
        binarySortTree.infixOrder();

        binarySortTree.delNode(7);
        binarySortTree.infixOrder();
    }
}

class BinarySortTree{
    private SortNode root;
    //查找要删除的节点
    public SortNode search(int value){
        if(root == null){
            return  null;
        } else {
            return root.search(value);
        }
    }
    //查找父节点
    public SortNode searchParent(int value){
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
    public int delRightTreeMin(SortNode node){
        SortNode target = node;
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
            SortNode targetNode = search(value);
            if(targetNode == null){
                return;
            }
            //如果当前的二叉排序树只有一个节点
            if(root.left == null && root.right == null){
                root = null;
                return;
            }
            //2.查找 targetNode 的父节点
            SortNode parentNode = searchParent(value);
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
    public void add(SortNode node){
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

class SortNode{
    int value;
    SortNode left;
    SortNode right;

    //添加节点
    public void add(SortNode SortNode){
        if(SortNode == null){
            return;
        }

        //判断传入的节点的值 和 当前子树的根节点的关系
        if(SortNode.value < this.value){
            //如果当前节点的左子节点为空 直接添加
            if(this.left == null){
                this.left = SortNode;
            } else {
                this.left.add(SortNode);
            }
        }

        if(SortNode.value > this.value){
            if(this.right == null){
                this.right = SortNode;
            } else {
                this.right.add(SortNode);
            }
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
    public SortNode search(int value){
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
    public SortNode searchParent(int value){
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



    public SortNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SortNode{" +
                "value=" + value +
                '}';
    }
}
