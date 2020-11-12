package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;

import java.util.Arrays;

/*
* 选择排序
* */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,7,8,1,9,6,3,8,7,1,4};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;

            for (int j=i+1;j<arr.length;j++){
                minPos = arr[j]<arr[minPos]?j:minPos;
            }
            MyUtils.swap(arr,minPos,i);
        }
        MyUtils.print(arr);
    }
}
