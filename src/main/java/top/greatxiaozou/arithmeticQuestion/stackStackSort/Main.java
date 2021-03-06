package top.greatxiaozou.arithmeticQuestion.stackStackSort;

import java.util.*;

/**
 * 题目描述
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        String[] strs = sc.nextLine().split(" ");
        for(;n>0;n--){
            stack.push(Integer.parseInt(strs[n-1]));
        }
        sort(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void sort(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        //当要排序的栈不为空时进入循环
        while(!stack.isEmpty()){
            int cur = stack.pop();
            //当栈中元素大于辅助栈栈顶元素时，将辅助栈的弹出至栈中
            while(!help.isEmpty() && cur>help.peek()){
                stack.push(help.pop());
            }
            //当辅助栈为空或者cur<辅助站元素时
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}