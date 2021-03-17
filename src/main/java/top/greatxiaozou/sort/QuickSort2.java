package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;

import java.util.regex.*;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = MyUtils.randomArr();
        MyUtils.print(arr);

        quickSort(arr,0,arr.length-1);

        MyUtils.print(arr);


    }

    /**
     *
     * @param arr 要排序的数组
     * @param left 排序范围的左边界
     * @param right 排序范围的右边界
     *
     *             快速排序
     */
    public static void quickSort(int[] arr,int left,int right){
        if (left < right){
            int[] p = partition(arr,left,right);
            quickSort(arr,left,p[0]-1);
            quickSort(arr,p[1] + 1,right);
        }
    }

    /**
     *
     * @param arr 要排序的数组
     * @param left 要排序部分的左边界
     * @param right 要排序部分的右边界
     * @return 返回等于部分的范围
     */
    public static int[] partition(int[] arr,int left,int right){
        int less = left - 1;
        int more = right;
        int cur = left;

        while (cur < more){
            if (arr[cur] < arr[right]){
                MyUtils.swap(arr,cur,++less);
                cur++;
            }else if (arr[cur] > arr[right]){
                MyUtils.swap(arr,--more,cur);
            }else {
                cur++;
            }
        }

        //交换pivot数到中间
        MyUtils.swap(arr,more,right);
        return new int[]{less+1,more};
    }
}
