package cn.com.dmg.algorithmlearn.queue;

/**
 * @ClassName ArrayQueueDemo
 * @Description 使用数组模拟队列
 * @author zhum
 * @date 2022/7/14 17:43
 */
public class ArrayQueueDemo {
}

//使用数组模拟队列 编写一个ArrayQueue
class ArrayQueue{
    //数组的最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //用于存放数组的队列
    private  int arr[];
    //构造函数
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头的前一个位置
        this.front = -1;
        //指向队列尾部的具体位置
        this.rear = -1;
    }
    //判断队列是否满了
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据
    public void addQueue(int n){
        //判断队列是否已满
        if(isFull()){
            System.out.println("队列已满，无法添加");
            return;
        }

        //添加数据
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据  数据出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("队列为空，不能取数据");
        }
        front ++;
        return arr[front];
    }
    //显示数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //显示队列的头数据是多少 （不是取数据）
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
