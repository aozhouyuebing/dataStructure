package top.greatxiaozou.sort;
/**
* 插入排序
* */

import top.greatxiaozou.Utils.MyUtils;

public class InsertionSort {
    public static void main(String[] args) {
        sort(MyUtils.randomArr());
    }
//    public static void sort2(int[] arr){
//        for (int i = 1; i < arr.length; i++) {
//            //从下标1开始，一个一个归位，保证前i个数组为有序数组
//            for (int j = i; j >0; j--) {
//
//            }
//        }
//        MyUtils.print(arr);
//    }



    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //从下标1开始，一个一个归位，保证前i个数组为有序数组
            for (int j = i; j >0 && arr[j]<arr[j-1]; j--) {
                MyUtils.swap(arr,j,j-1);
            }
        }
        MyUtils.print(arr);
    }
}
