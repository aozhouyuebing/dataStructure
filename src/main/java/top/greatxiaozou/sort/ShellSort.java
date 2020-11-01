package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;

public class ShellSort {
    public static void main(String[] args) {
        sort(MyUtils.randomArr());
    }

    static void sort(int[] arr){
        //定义间隔
//        for (int h = arr.length/2; h>0; h=h/2) {

        //使用knuth序列
        int gap=1;
        while (gap<=arr.length/3) {
            gap = gap * 3 + 1;
        }
        for (int h=gap;h>0;h=(h-1)/3){
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >h-1 && arr[j]<arr[j-h]; j-=h) {
                    MyUtils.swap(arr,j,j-h);
                }
            }
        }
        MyUtils.print(arr);
    }
}
