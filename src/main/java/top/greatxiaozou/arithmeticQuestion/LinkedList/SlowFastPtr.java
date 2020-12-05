package top.greatxiaozou.arithmeticQuestion.LinkedList;

public class SlowFastPtr {
    public static void main(String[] args) {

    }


    //返回中点和上中点
    public static Node midOrUpMid(Node head){
        //当链表长度小于3时，直接返回
        if(head==null || head.next==null || head.next.next ==null) return head;
        Node slow = head.next;
        Node fast = head.next.next;

        //当快指针可以迈两步时，快指针迈两步，慢指针迈一步
        while (fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //返回中点和下中点
    public static Node midOrDownMid(Node head){
        //如果链表长度小于3，选择性返回
        if(head==null && head.next==null ) return head;
        if(head.next.next ==null) return head.next;

        //在开始时多走一步，表示走到中点或者下中点
        Node slow = head.next.next;
        Node fast = head.next.next;

        //当快指针可以迈两步时，快指针迈两步，慢指针迈一步
        while(fast.next != null || fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //返回中点前一个和上中点前一个节点
    public static Node preMidOrUpMid(Node head){
        if(head==null || head.next==null || head.next.next ==null) return head;
        Node slow = head;
        Node fast = head.next.next;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
    }
    //返回中点的前一个节点和下中点的前一个节点
    public static Node preMidOrPreDownMid(Node head){
        //如果链表长度小于3，选择性返回
        if(head==null || head.next==null || head.next.next ==null) return head;

        //在开始时多走一步，表示走到中点或者下中点
        Node preSlow = head;
        Node slow = head.next;
        Node fast = head.next.next;

        //当快指针可以迈两步时，快指针迈两步，慢指针迈一步
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
class Node{
    int var = 0;
    Node next;

    public Node(int var){
        this.var = var;
        this.next = null;
    }
}