package top.greatxiaozou.arithmeticQuestion.reverseStack;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        String[] values = sc.nextLine().split(" ");
        for(int i=num-1;i>=0;i--){
            stack.push(Integer.valueOf(values[i]));
        }

        reverseStack(stack);
        for(int i = 0;i<num;i++){
            System.out.print(stack.pop()+" ");
        }
    }

    /**
     *
     * @param stack 需要取出栈底元素的栈
     * @return 栈底元素
     * 该方法的功能是取出栈底的元素
     */
    public static int getAndRemoveLast(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()) return result;

        int last = getAndRemoveLast(stack);
        stack.push(result);
        return last;
    }

    public static void reverseStack(Stack<Integer> stack){
        int result = getAndRemoveLast(stack);
        if (!stack.isEmpty()){
            reverseStack(stack);
            //通过getAndRemoveLast逆序取出栈中所有的元素
            //然后压入栈中，
            stack.push(result);
        }
    }
}
