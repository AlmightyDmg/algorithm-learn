package cn.com.dmg.algorithmlearn.linkedlist;

/**
 * @ClassName SingleLinkedList
 * @Description 单链表
 * @author zhum
 * @date 2022/7/15 11:55
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        /**测试 创建节点*/
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        //添加节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.sortAdd(hero4);
        singleLinkedList.sortAdd(hero1);
        singleLinkedList.sortAdd(hero3);
        singleLinkedList.sortAdd(hero2);

        //修改
        singleLinkedList.updateHeroNode(new HeroNode(2,"新名字","不及时"));

        //删除
        //singleLinkedList.delHeroNode(4);
        //显示
        singleLinkedList.list();
        //大小
        //System.out.println(SingleLinkedList.getLength(singleLinkedList.getHead()));

        //反转
        SingleLinkedList.reverseList(singleLinkedList.getHead());
        //显示
        singleLinkedList.list();
    }

}


class SingleLinkedList{
    /**头节点*/
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点 不考虑顺序
     * 将节点添加到链表的最后
     * @author zhum
     * @date 2022/7/15 13:16
     * @param heroNode
     * @return void
     */
    public void add(HeroNode heroNode){
        //由于头结点不能变化 因此需要创建一个临时节点 辅助遍历
        HeroNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 按照从小到大的顺序排序添加元素
     * 将需要添加的元素和最后一个元素比较，如果大于 排在后面 如果小于 排在前面
     * 遍历的过程中 如果遇到相同的编号 则进行提示
     * @author zhum
     * @date 2022/7/15 13:36
     * @param heroNode
     * @return void
     */
    public void sortAdd(HeroNode heroNode){
        HeroNode temp = head;
        while (temp.next != null){
            //当需要相同的时候 需要作出提示
            HeroNode next = temp.next;
            if(next.no == heroNode.no){
                System.out.println("序号相同 无法进行添加");
                return;
            }
            //如果插入的节点在当前两个节点中间的话，那么就将其插入
            if(temp.no < heroNode.no && next.no > heroNode.no){
                temp.next = heroNode;
                heroNode.next = next;
                return;
            }
            //节点后移
            temp = next;
        }

        //直接添加在末尾
        temp.next = heroNode;

    }

    /**
     * 根据 no 修改节点信息
     * @author zhum
     * @date 2022/7/15 14:04
     * @param newHeroNode
     * @return void
     */
    public void updateHeroNode(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null){
            //判断id是否相等
            if(temp.next.no == newHeroNode.no){
                temp.next.name = newHeroNode.name;
                temp.next.nickName = newHeroNode.nickName;
                return;
            }
            temp = temp.next;
        }

        System.out.println("没有找到匹配项");

    }

    /**
     * 删除节点 根据 no
     * @author zhum
     * @date 2022/7/15 14:14
     * @param no
     * @return void
     */
    public void delHeroNode(int no){
        if(head.next == null){
            System.out.println("数组为空");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null){
            HeroNode next = temp.next;
            //判断是否是需要删除的节点
            if(next.no == no){
                //删除
                temp.next = next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有找到可以删除的节点");
    }

    /**
     * 遍历链表
     * @author zhum
     * @date 2022/7/15 13:21
     * @param
     * @return void
     */
    public void list(){
        if(head.next == null){
            System.out.println("当前链表为空");
            return;
        }
        //还是头节点不能变 因此需要一个辅助节点进行遍历
        HeroNode temp = head;
        while (temp.next != null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    /**
     *
     * @author zhum
     * @date 2022/7/15 14:37
     * @param head 链表的头结点
     * @return int 返回有效节点的个数
     */
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length ++;
            cur = cur.next;
        }
        return length;
    }


    /**
     * 反转单链表
     * 1.创建一个新的头节点 reverseHead
     * 2.遍历原始的链表，每遍历一个节点 就将其取出，放到新链表的头部
     * 3.将原来的head.next指向reverseHead.next
     * @author zhum
     * @date 2022/7/15 14:57
     * @param head
     * @return void
     */
    public static void reverseList(HeroNode head){
        if(head.next == null){
            System.out.println("链表为空");
        }
        //1.创建一个新的头节点 reverseHead
        HeroNode reverseHead = new HeroNode(0,"","");
        //2.遍历原始的链表，每遍历一个节点 就将其取出，放到新链表的头部
        HeroNode temp = head;
        while (temp.next != null){
            //这个是当前需要被取出的节点
            HeroNode next = temp.next;
            //取出
            temp.next = next.next;
            //添加到新的链表中
            next.next = reverseHead.next;
            reverseHead.next = next;
            //这里就不需要 temp = temp.next了 因为前面有 temp.next = next.next;
        }
        //3.将原来的head.next指向reverseHead.next
        head.next = reverseHead.next;
    }

}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
