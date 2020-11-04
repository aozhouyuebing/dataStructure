package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;

import java.util.Queue;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = MyUtils.randomArr();
        sort(arr);
        MyUtils.print(arr);
    }

    public static void sort(int[] arr){
        int len = arr.length;
        //默认的取值范围是0-50
        int[] counts = new int[51];

        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }

        for (int i = 0,j=0; i < counts.length; i++) {
            while (counts[i]!=0){
                arr[j++] = i;
                counts[i]--;
            }
        }

    }
}
