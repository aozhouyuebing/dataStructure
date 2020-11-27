package top.greatxiaozou.arithmeticQuestion.twoStackForQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zqf
 * 牛客网： 利用两个栈实现一个队列
 * 题解
 */
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Main myQueue = new Main();

        for(int i=0; i< times;i++){
            String[] strs = scanner.nextLine().split(" ");
            if(strs[0].equals("add")){
                myQueue.add(Integer.parseInt(strs[1]));
            }else if(strs[0].equals("peek")){
                System.out.println(myQueue.peek());
            }else{
                myQueue.poll();
            }
        }

    }

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    private void toPopStack(){
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }

    public void add(int v){
        pushStack.push(v);
    }

    public int poll(){
        toPopStack();
        if(popStack.isEmpty()){
            throw new RuntimeException("队列为空");
        }

        return popStack.pop();
    }

    public int peek(){
        if(pushStack.isEmpty() && popStack.isEmpty()){
            throw new RuntimeException("队列为空");
        }
        toPopStack();
        return popStack.peek();
    }
}