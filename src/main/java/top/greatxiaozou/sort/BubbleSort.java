package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;
/**
 * @author zqf
* 冒泡排序
* */
public class BubbleSort {
    public static void main(String[] args) {
        sort(MyUtils.randomArr());
    }

    public static void sort(int[] arr){
        for (int i = 0; i <arr.length-1; i++) {
            for (int j=0 ;j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    MyUtils.swap(arr,j,j+1);
                }
            }
        }
        MyUtils.print(arr);
    }
}
