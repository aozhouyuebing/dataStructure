package top.greatxiaozou.dataStructure;
/**
 * @author zqf
 * 描述：队列
 * */

public class Queue {
    int size = 100;
    int[] data = new int[size];
    int front = 0;
    int rear = 0;

    public Queue(int size) {
        this.size = size;
    }

    public void push(int v){
        data[rear] = v;
        rear++;
    }
}
