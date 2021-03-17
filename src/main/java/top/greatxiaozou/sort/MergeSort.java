package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;
/*
* 归并排序
* */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = MyUtils.randomArr();
        sort(arr1,0,arr1.length-1);
        MyUtils.print(arr1);

    }



    /**
     *
     * @param arr 需要排序的数组
     * @param left 数组的左边界
     * @param right 数组的右边界
     */
    public static void sort(int[] arr,int left,int right){
        if (left>=right) return; //在左右指针撞或越界时返回
        int mid = (left+right)/2; //将中位数设定为左子数组的右边界和右子数组的左边界
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);

        //排序
        merge(arr,left,mid+1,right);
    }


    /**
     *
     * @param arr 排序的数组
     * @param left 左边界
     * @param right 左半边的右边界，右半边的起始
     * @param rightBound 右边界（可以取到的）
     * 此处的rightBound可以取到，所以在实例化中间数组的时候要+1，传入时为len-1;
     * rightbound 为最右边可以取到的数
     */
    public static void merge(int[] arr,int left,int right,int rightBound){
        int mid = right-1;
        int i = left;
        int j = right;
        int k = 0;
        int[] temp = new int[rightBound-left+1];

        while (i<=mid&&j<=rightBound){
            temp[k++] = arr[i]<=arr[j]?arr[i++]:arr[j++];
        }

        //将剩余的数字排进数组
        while (i<=mid) temp[k++]=arr[i++];
        while (j<=rightBound) temp[k++]=arr[j++];

        for (int i1 = 0; i1 < temp.length; i1++) {
            arr[left+i1]=temp[i1];
        }
    }
}
