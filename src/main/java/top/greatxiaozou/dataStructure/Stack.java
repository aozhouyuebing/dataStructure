package top.greatxiaozou.dataStructure;
/**
 * @author zqf
 * @描述：栈的实现
 * */
public class Stack {
    int size;
    int[] data = new int[size];
    int top;

    //data的默认大小为100
    public Stack() {
        this(100);
    }

    public Stack(int size) {
        this.size = size;
        top = size-1;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        if (top==size-1){
            return true;
        }
        return false;
    }
    //判断栈是否已满
    public boolean isFull(){
        if (top==0){
            return true;
        }
        return false;
    }

    //把元素压入栈中
    public int push(int v){
        if (isFull()) return 0;
        data[top] = v;
        top--;
        return 1;
    }

    //元素弹出栈
    public int pop() throws Exception {
        if (isEmpty()) throw new Exception("栈为空");
        int result = data[top];
        data[top]=0;
        top++;
        return result;
    }

    //获取栈顶元素（不出栈）
    public int peek() throws Exception {
        if (isEmpty()) throw new Exception("栈为空");
        return data[top];
    }
}
