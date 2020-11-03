package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;
/*
* 归并排序
* */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,3,7,8,4,6,9};
        int[] arr1 = MyUtils.randomArr();
        sort(arr1,0,arr1.length-1);
        MyUtils.print(arr1);

    }

    public static void sort(int[] arr,int left,int right){
        if (left>=right) return;
        int mid = (left+right)/2;
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);

        merge(arr,left,mid+1,right);
    }
    //此处的rightBound可以取到，所以在实例化中间数组的时候要+1，传入时为len-1;
    //rightbound 为最右边可以取到的数
    public static void merge(int[] arr,int left,int right,int rightBound){
        int mid = right-1;
        int i = left;
        int j = right;
        int k = 0;
        int[] temp = new int[rightBound-left+1];

        while (i<=mid&&j<=rightBound){
            temp[k++] = arr[i]<=arr[j]?arr[i++]:arr[j++];
        }

        while (i<=mid) temp[k++]=arr[i++];
        while (j<=rightBound) temp[k++]=arr[j++];
        //MyUtils.print(temp);
        //System.arraycopy(temp,0,arr,0,temp.length);
        for (int i1 = 0; i1 < temp.length; i1++) {
            arr[left+i1]=temp[i1];
        }
    }
}
