package top.greatxiaozou.arithmeticQuestion.GetMinStack;

import java.util.Stack;

/**
 *
 */
public class GetMInStack1 {
    //数据栈
    private Stack<Integer> dataStack = new Stack();
    //最小栈
    private Stack<Integer> minStack = new Stack();


    //只压入最小的
    public void push(int newNum){
        dataStack.push(newNum);
        if (minStack.isEmpty()){
            minStack.push(newNum);
        }else if (minStack.peek()>=newNum){
            minStack.push(newNum);
        }
    }

    public int pop(){
        int val = dataStack.pop();
        if (!minStack.isEmpty()){
            if (val == minStack.peek()){
                minStack.pop();
            }
        }
        return val;
    }

    public int getMin() throws Exception {
        if (minStack.isEmpty()){
            throw new Exception("栈为空！");
        }
        return minStack.peek();
    }
}
