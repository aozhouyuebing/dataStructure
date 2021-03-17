package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;


/**
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
                //找到最小数的下标
                minPos = arr[j]<arr[minPos]?j:minPos;
            }
            //最小数下标和首（i）位置交换
            MyUtils.swap(arr,minPos,i);
        }
        MyUtils.print(arr);
    }
}
