package cn.com.dmg.algorithmlearn.linkedlist;

/**
 * @ClassName SingleLinkedListDemo
 * @Description 双向链表
 * @author zhum
 * @date 2022/7/18 11:30
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        System.out.println("双向链表功能测试");
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");

        //添加节点
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        //遍历
        doubleLinkedList.list();
        //修改
        doubleLinkedList.updateHeroNode(new HeroNode2(2,"卢俊义","火麒麟"));
        //删除
        doubleLinkedList.delHeroNode(3);
        //遍历
        doubleLinkedList.list();


    }

}


class DoubleLinkedList{
    /**头节点*/
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
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
        HeroNode2 temp = head;
        while (temp.next != null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }


    /**
     * 添加节点 不考虑顺序
     * 将节点添加到链表的最后
     * @author zhum
     * @date 2022/7/15 13:16
     * @param heroNode
     * @return void
     */
    public void add(HeroNode2 heroNode){
        //由于头结点不能变化 因此需要创建一个临时节点 辅助遍历
        HeroNode2 temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 根据 no 修改节点信息
     * @author zhum
     * @date 2022/7/15 14:04
     * @param newHeroNode
     * @return void
     */
    public void updateHeroNode(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head;
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
     * 直接找到需要删除的节点进行删除即可
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
        HeroNode2 temp = head.next;
        while (temp != null){
            if(temp.no == no){
                //当前节点的前一个节点的 next 指向当前节点的下一个节点
                temp.pre.next = temp.next;
                //当前节点的下一个节点（不为空）的 pre 指向当前节点的前一个节点
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有找到可以删除的节点");
    }

}

class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
