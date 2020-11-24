package top.greatxiaozou.dataStructure;
/**
 * @author zqf
 * @描述：链表的实现
 * */

//由于大多数情况下data存的都是int，此处没用使用泛型data，而是直接规定的int
public class Node {
    //该节点的数据
    public int data;
    //下一个节点的位置
    public Node next;

    public Node() {
        this(0,null);
    }

    public Node(int data) {
        this(data,null);
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    //判断是否有下一个节点
    public boolean hasNext(){
        if (this.next==null)
            return false;
        return true;
    }
}
