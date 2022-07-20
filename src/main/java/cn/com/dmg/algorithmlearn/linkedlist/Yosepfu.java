package cn.com.dmg.algorithmlearn.linkedlist;

/**
 * @ClassName Yosepfu
 * @Description 约瑟夫问题
 * @author zhum
 * @date 2022/7/18 14:11
 */
public class Yosepfu {

    public static void main(String[] args) {

        //构建环形链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        //遍历环形链表
        circleSingleLinkedList.list();

        //测试出圈
        circleSingleLinkedList.countBoy(1,2,5);

    }

}

/**
 * @ClassName
 * @Description 创建一个环形单向链表
 * @author zhum
 * @date 2022/7/18 13:40
 */
class CircleSingleLinkedList{
    //创建一个first节点 默认为空
    private Boy first = null;

    /**
     * 添加节点
     * @author zhum
     * @date 2022/7/18 13:42
     * @param nums 表示要添加几个节点
     * @return void
     */
    public void add(int nums){
        if(nums < 1){
            System.out.println("num 需要大于等于1");
        }

        //辅助节点
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            Boy boy = new Boy(i);
            //如果是第一个小孩 让 first 节点 和 辅助节点指向curBoy
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                //curBoy的next指向新的节点  新节点的next指向first
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历环形链表
     * @author zhum
     * @date 2022/7/18 13:49
     * @param
     * @return void
     */
    public void list(){
        //判断链表是否为空
        if(first == null){
            System.out.println("当前链表为空");
        }
        //辅助节点
        Boy curBoy = first;
        while (true){
            //遍历
            System.out.println(curBoy.getNo());
            //判断下一个节点是否为 first
            if(curBoy.getNext().getNo() == first.getNo()){
                break;
            }
            //节点后移
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 数小孩
     * @author zhum
     * @date 2022/7/18 14:12
     * @param startNo 表示从第几个数开始数
     * @param countNum 表示数多少个数
     * @param nums 表示最初有多少个小孩在圈中
     * @return void
     */
    public void countBoy(int startNo,int countNum,int nums){
        //数据校验
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("数据有误");
        }
        //创建辅助指针 指向 first 的前一个节点
        Boy helper = first;
        while (true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //报数之前 先让first 和 helper 移动 startNo-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数的时候 让first 和 helper 指针移动countNum-1 次，然后出圈（出圈的节点为first） 循环操作 直到只有一个节点
        while (true){
            if(helper == first){
                break;
            }
            //移动 first 和 helper
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //first指向的是要出圈的节点
            System.out.println("出圈的小孩编号为：" + first.getNo());
            //将要出圈的小孩移出
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号为" + first.getNo());
    }
}

/**
 * @ClassName Boy
 * @Description 创建一个节点类
 * @author zhum
 * @date 2022/7/18 13:37
 */
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }


}
