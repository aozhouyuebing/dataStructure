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
        for (int i = arr.length-1; i > 0; i--) {
            for (int j=0 ;j < i; j++) {
                if (arr[j]>arr[j+1]){
                    MyUtils.swap(arr,j,j+1);
                }
            }
        }
        MyUtils.print(arr);
    }
}
