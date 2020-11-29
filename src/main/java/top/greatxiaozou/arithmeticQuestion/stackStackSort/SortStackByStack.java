package top.greatxiaozou.arithmeticQuestion.stackStackSort;

import java.util.Stack;

public class SortStackByStack {
    public static void main(String[] args) {

    }
    public static void sort(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        if (stack.isEmpty()) return;
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && cur>help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }

    }
}
