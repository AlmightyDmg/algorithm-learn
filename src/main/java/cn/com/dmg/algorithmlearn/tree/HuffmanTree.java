package cn.com.dmg.algorithmlearn.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] numbers = {13,7,8,3,29,6,1};
        Node huffmanTree = createHuffmanTree(numbers);
        //使用前序遍历 看是否是赫夫曼树
        huffmanTree.preOrder();


    }

    public static Node createHuffmanTree(int[] numbers){
        //遍历数组 将每个元素封装为node节点 对node节点进行排序
        List<Node> nodes = new ArrayList<>();
        for (int number : numbers) {
            nodes.add(new Node(number));
        }

        //循环处理 创建赫夫曼树 到最后的时候 nodes 中只有一个节点
        while (nodes.size() > 1){
            //1.从小到大进行排序
            Collections.sort(nodes);
            //2.取出根节点权值最小的两个二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //3.创建一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //4.移除使用过的两个节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5.将新创建的树添加到集合中
            nodes.add(parent);
        }
        //返回赫夫曼树的头结点
        return nodes.get(0);
    }
}

class Node implements Comparable<Node>{
    //节点的权值
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }


    @Override
    public int compareTo(Node o) {
        //从小到大进行排序
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
