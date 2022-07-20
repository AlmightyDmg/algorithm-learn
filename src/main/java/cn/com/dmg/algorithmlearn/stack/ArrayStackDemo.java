package cn.com.dmg.algorithmlearn.stack;

/**
 * @ClassName ArrayStackDemo
 * @Description 使用数组模拟栈
 * @author zhum
 * @date 2022/7/19 11:09
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();

        stack.show();

    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判断是否栈满
     * @author zhum
     * @date 2022/7/19 11:11
     * @param
     * @return boolean
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }

    /**
     * 是否栈空
     * @author zhum
     * @date 2022/7/19 11:12
     * @param
     * @return boolean
     */
    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
           throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void show(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        //从栈顶往下遍历
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
