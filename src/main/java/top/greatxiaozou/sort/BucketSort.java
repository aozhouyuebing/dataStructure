package top.greatxiaozou.sort;

import top.greatxiaozou.Utils.MyUtils;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = MyUtils.randomArr();
        MyUtils.print(arr);
        System.out.println();
        sort(arr,5);
    }

    /**
     *
     * @param arr 需要排序的数组
     * @param bucketSize 桶的大小
     */
    public static void sort(int[] arr,int bucketSize){
        if (bucketSize==0) return;
        int min = arr[0];
        int max = arr[0];
        //求出数组的最大值和最小值
        for (int i : arr) {
            if (i<min){
                min = i;
            }else if (i>max){
                max = i;
            }
        }
        //桶的数量
        int bucketNum = (max-min)/bucketSize + 1;



//        for (int[] bucket : buckets) {
//            System.out.print(Arrays.toString(bucket)+" ");
//        }

    }
}
