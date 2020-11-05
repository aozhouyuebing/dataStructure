package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;
/**
 * @author 澳洲月饼
 * 快速排序的一种实现
 * */
public class QuickSort {
    public static void main(String[] args) {
        int[] ints = MyUtils.randomArr();
        MyUtils.print(ints);
        System.out.println();
        sort(ints,0,ints.length-1);
        MyUtils.print(ints);
    }

    public static void sort(int[] arr,int left,int right){
        if (left>=right) return;

        int mid = partition(arr, left, right);
        sort(arr,left,mid-1);
        sort(arr,mid+1,right);
    }

    public static int partition(int[] arr,int leftbound, int rightbound){
        int pivot = arr[rightbound];
        int left = leftbound;
        int right = rightbound-1;

        while (left<=right&&left+right!=0){
            while (arr[left]<=pivot && left<=right) left++;
            while (arr[right]>pivot && left<=right&&right>0) right--;
            //大右小左
            if (left<right) MyUtils.swap(arr,left,right);

        }
        //中轴放到中间
        MyUtils.swap(arr,left,rightbound);
        return left;
    }
}
