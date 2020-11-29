package top.greatxiaozou.search;

import top.greatxiaozou.Utils.MyUtils;
import top.greatxiaozou.sort.QuickSort;
import top.greatxiaozou.sort.ShellSort;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = MyUtils.randomArr();
        int[] arr = new int[]{1,1,2,4,4,11,13,14,16,20,25,30,30,35,35,41,41,46,50,5};
        ShellSort.sort(arr);
        MyUtils.print(arr);
        System.out.println();
//        System.out.println(binarysearch(arr, 0,arr.length-1,24));
        System.out.println(solution02(arr,11));
    }

    //二分查找的递归实现
    public static int binarysearch(int[] arr, int left, int right, int target){
        if (left==right && arr[left]==target) return left;
        if (left >= right) return -1;
        int mid = left + ((right-left)>>1);
        if (arr[mid]==target){
            return mid;
        }
        if (target>arr[mid]){
            return binarysearch(arr,mid+1,right,target);
        }else {
            return binarysearch(arr,left,mid-1,target);
        }
    }

    //二分查找的非递归实现
    public static int solution02(int[] arr,int target){
        if (null == arr || arr.length==0) return -1;
        int left = 0,right = arr.length-1;
        int mid = left+((right-left)>>1);

        if (arr[mid] == target) return mid;
        while (left<right){
            if (target>arr[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
            mid = left+((right-left)>>1);
            if (arr[mid] == target) return mid;
        }
        return -1;
    }
}
