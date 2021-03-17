package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = MyUtils.randomArr();
        MyUtils.print(arr);
        mergeSort(arr);
        MyUtils.print(arr);
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        sort(arr,0,arr.length-1);
    }

    /**
     *
     * @param arr 要归并的数组
     * @param left 左边界
     * @param right 右边界（默认为数组右边界
     */
    public static void sort(int[] arr,int left,int right){
        if(left == right){
            return;
        }
//        int mid = (right+left)/2;
        int mid = left + ((right-left) >> 1);

        //左边排序
        sort(arr,left,mid);

        //右边排序
        sort(arr,mid+1,right);

        //外排
        merge(arr, left, mid, right);

    }

    /**
     *
     * @param arr 要排序的数组
     * @param left 要merge的左边界
     * @param mid 要merge的中线
     * @param right  要merge的右边界
     */
    private static void merge(int[] arr,int left,int mid,int right){
        int[] help = new int[right-left+1];
        int p1 = left;
        int p2 = mid+1;
        int i = 0;

        while (p1 <= mid && p2 <= right){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        //必定有一个越界
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= right){
            help[i++] = arr[p2++];
        }

        //回归原数组
        if (help.length >= 0) System.arraycopy(help, 0, arr, left + 0, help.length);
    }












}
