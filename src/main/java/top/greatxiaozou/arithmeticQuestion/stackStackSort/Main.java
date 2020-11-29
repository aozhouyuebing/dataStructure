package top.greatxiaozou.arithmeticQuestion.stackStackSort;

import java.util.*;
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

        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty() && cur>help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}