package top.greatxiaozou.arithmeticQuestion;

import java.util.HashSet;

/**
 * @author zqf
 * 描述：给出一个int数组和一个整数m，求输出该数组的子序列中的和%m的最大值
 * */
public class SubXulie {
    public static void main(String[] args) {
        int[] ints = {1,7,5,89,4,2,56};
        System.out.println(solution(ints, 7));
        System.out.println(solution2(ints, 7));
        System.out.println(solution3(ints, 7));
    }

    //暴力算法

    /***
     * O(2^n)
     * @param nums
     * @param m
     * @return
     */
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

    /**
     * @ sum 数组中所有数的和
     * @ map 值为布尔类型，map[i][j]表示使用数组0-i位置上的值能不能得到j
     * 由于map，时间复杂度为O（n*sum）
     * 因为用到了累加和，所以当累加和不很大的时候可以使用这个方法
     */
    public static int solution2(int[] nums,int m){
        int n=nums.length;
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }

        //填表的第一行和第一列
        boolean[][] map = new boolean[n][sum+1];
        for (int i = 0; i < n; i++) {
            map[i][0] = true;
        }
        map[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < sum+1; j++) {
                map[i][j] = map[i-1][j];
                if (j-nums[i]>=0){
                    map[i][j] = map[i][j]|map[i-1][j-nums[i]];
                }
            }
        }

        int max=0;
        for (int i = 0; i < sum+1; i++) {
            if (map[n-1][i]){
                max = Math.max(max,i%m);
            }
        }
        return max;
    }

    /**
     *
     * @param arr 数组
     * @param m 需要模的数
     * @return 最大值
     *
     */
    public static int solution3(int[] arr, int m){
        boolean[][] map = new boolean[arr.length][m];

        //第一行和第一列设好了
        for (int i = 0; i < arr.length; i++) {
            map[i][0]=true;
        }
        map[0][arr[0]%m]=true;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] = map[i-1][j];
                int cur = arr[i]%m;
                //当使用i位置的数时
                if (j>=cur){
                    map[i][j] = map[i][j] | map[i-1][j-cur];
                }
                //当使用i位置的数并且余数cur大于j时
                else {
                    map[i][j] = map[i][j] | map[i-1][m+j-cur];
                }
            }
        }

        int max=0;
        for (int i = 0; i < m; i++) {
            if (map[arr.length-1][i]){
                max = i;
            }
        }
        return max;
    }
}
