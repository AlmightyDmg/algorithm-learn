package cn.com.dmg.algorithmlearn.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Graph
 * @Description 图
 * @author zhum
 * @date 2022/8/8 16:12
 */
public class Graph {

    public static void main(String[] args) {
        //节点的个数
        int n = 5;
        String[] vertexValue = {"A","B","C","D","E"};

        //创建图
        Graph graph = new Graph(n);

        //添加节点
        for (String s : vertexValue) {
            graph.insertVertex(s);
        }

        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        //显示
        graph.showGraph();
        //测试dfs
        graph.dfs();

    }

    //存储顶点的集合
    private List<String> vertexList;
    //存储图对应的邻接矩阵
    private int[][] edges;
    //表示边的数目
    private int numOfEdges;
    //记录某个顶点是否被访问过
    private boolean[] isVisited;

    public Graph(int n){
        //初始化矩阵和 vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[n];
        numOfEdges = 0;
    }

    //深度优先遍历
    public void dfs(boolean[] isVisited,int i){
        //首先访问该节点
        System.out.println(getValueByIndex(i));
        //将访问过的节点设置为已访问
        isVisited[i] = true;
        //查找 i 的第一个临接节点w
        int w = getFirstNeighbor(i);
        //有临接节点
        while (w != -1){
            if(!isVisited[w]){
                //没有被访问过，则对w进行访问
                dfs(isVisited,w);
            }
            //如果w已经被访问过 查找下一个 邻接节点
            w = getNextNeighbor(i,w);
        }

    }

    //对dfs进行重载 遍历所有的节点 并 进行 dfs
    public void dfs(){
        //遍历所有的节点 进行 dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }



    //获得第一个邻接节点的下标
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if(edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    //根据前一个 邻接节点 的下标来获取 下一个临接节点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if(edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 插入边
     * @author zhum
     * @date 2022/8/8 16:18
     * @param v1 表示点的下标 即是第几个顶点  "A"-"B" "A"-0 "B"-1
     * @param v2
     * @param weight 表示 两个节点之间的关系
     * @return void
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回节点的个数
    public int getNumOfVertex(){
        return  vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }
    //返回节点 i 对应的值
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
