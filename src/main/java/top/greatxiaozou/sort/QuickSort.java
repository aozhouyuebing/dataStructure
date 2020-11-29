package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;
/**
 * @author 澳洲月饼
 * 快速排序的一种实现
 * */
public class QuickSort {
    public static void main(String[] args) {
        int[] ints = MyUtils.randomArr();
//        MyUtils.print(ints);
//        System.out.println();
        sort(ints,0,ints.length-1);
        MyUtils.print(ints);
    }

    public static void sort(int[] arr,int left,int right){
        if (left>=right) return;

        int mid = partition(arr, left, right);
        sort(arr,left,mid-1);
        sort(arr,mid+1,right);
    }

    /**
     *
     * @param arr 要进行排序的数组
     * @param leftbound 数组的左边界
     * @param rightbound 数组的右边界
     * @return
     */
    public static int partition(int[] arr,int leftbound, int rightbound){
        int pivot = arr[rightbound];
        int left = leftbound;
        int right = rightbound-1;


        while (left<=right && left+right != 0){
            //找到在右指针左边的大于pivot的数
            while (arr[left] <= pivot && left <= right) left++;
            //找到在左指针右边的小于pivot的数
            while (arr[right] > pivot && left <= right && right>0) right--;
            //找到之后如果仍然满足左指针在右指针左边，则进行交换
            if (left<right) MyUtils.swap(arr,left,right);

        }
        MyUtils.print(arr);
        System.out.println();
        //此时左右指针相等并不同时为零，将基准数放到中间
            MyUtils.swap(arr,left,rightbound);

        return left;
    }
}
