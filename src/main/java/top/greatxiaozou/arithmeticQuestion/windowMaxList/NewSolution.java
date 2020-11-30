package top.greatxiaozou.arithmeticQuestion.windowMaxList;

import java.util.LinkedList;
import java.util.Scanner;

public class NewSolution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int w = Integer.parseInt(strs[1]);
        int[] arr = new int[n];
        String[] nums = sc.nextLine().split(" ");
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(nums[i]);
        }
        int[] max = getMax(arr,w);
        for(int i = 0;i<max.length;i++){
            System.out.print(max[i]+" ");
        }

    }

    public static int[] getMax(int[] arr,int w){
        if(w>arr.length || arr == null) return null;

        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        int[] max = new int[arr.length-w+1];
        for(int i = 0;i < arr.length;i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.add(i);
            if(qmax.peekFirst()==i-w){
                qmax.pollFirst();
            }
            if(i>=w-1){
                max[index++] = arr[qmax.peekFirst()];
            }
        }
        return max;
    }
}