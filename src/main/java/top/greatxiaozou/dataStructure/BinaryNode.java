package top.greatxiaozou.dataStructure;

/**
 * 双向链表
 */
public class BinaryNode {
    public int data;
    //前驱节点
    public BinaryNode prev;
    //后继节点
    public BinaryNode next;

    public BinaryNode(int data) {
        this.data = data;
    }
    //是否有后继节点
    public boolean hanNext(){
        if (this.next==null) return false;
        return true;
    }
    //是否有前驱节点
    public boolean hanPrev(){
        if (this.prev==null) return false;
        return true;
    }
}
