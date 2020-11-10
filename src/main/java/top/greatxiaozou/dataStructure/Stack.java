package top.greatxiaozou.dataStructure;
/**
 * @author zqf
 * @描述：栈的实现
 * */
public class Stack {
    //data的默认大小为100
    int size = 100;
    int[] data = new int[size];
    int top=size-1;

    public Stack(int size) {
        this.size = size;
        top = size-1;
    }

    public boolean isEmpty(){
        if (top==size-1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if (top==0){
            return true;
        }
        return false;
    }

    public int push(int v){
        if (isFull()) return 0;
        data[top] = v;
        top--;
        return 1;
    }

    public int pop() throws Exception {
        if (isEmpty()) throw new Exception("栈为空");
        int result = data[top];
        data[top]=0;
        top++;
        return result;
    }
}
