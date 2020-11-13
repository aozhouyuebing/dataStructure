package top.greatxiaozou.arithmeticQuestion;

import java.util.HashSet;

/**
 * @author zqf
 * 描述：给出一个int数组和一个整数m，求输出该数组的子序列中的和%m的最大值
 * */
public class SubXulie {
    public static void main(String[] args) {

    }


    //暴力算法
    public static int solution(int[] nums,int m){
        HashSet<Integer> set = new HashSet<>();
        process(nums,0,0,set);
        int max=0;
        for (Integer integer : set) {
            max = Math.max(max,integer%m);
        }
        return max;
    }

    //处理数组，两个递归分别代表当前index的数要不要加入到sum中，所有sum的结果都放到set中，无需返回值
    public static void process(int[] arr, int index, int sum, HashSet<Integer> set){
        if (index==arr.length){
            set.add(sum);
        }else {
            process(arr,index+1,sum,set);
            process(arr,index+1,sum+arr[index],set);
        }
    }
}
