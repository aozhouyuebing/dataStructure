package top.greatxiaozou.arithmeticQuestion.twoStackForQueue;

import java.util.Stack;

public class Solution {
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();


    private void toPopStack(){
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }

    //模拟队列的压入
    public void push(int i){
        pushStack.push(i);
    }

    public int poll() throws Exception {
        if (pushStack.isEmpty() && popStack.isEmpty()){
            throw new Exception("队列为空，不能取");
        }
        toPopStack();
        return popStack.pop();
    }

    public int peek() throws Exception {
        if (pushStack.isEmpty() && popStack.isEmpty()){
            throw new Exception("队列为空，不能取");
        }
        toPopStack();
        return popStack.peek();
    }
}
