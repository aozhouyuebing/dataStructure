package top.greatxiaozou.search;

/**
 * 二分查找的进阶玩法，使用二分查找来寻找数组中的任意一个局部最小值
 * 何谓局部最小值？
 * - 当这个数为数组头，如果它后一个数大于这个数，则为局部最小
 * - 如果这个数为数组尾，如果他的前一个数大于他，则他为局部最小
 * - 如果这个数在数组中间，两边的数均大于他，视为局部最小
 */
public class AreaMinNum {
    public static void main(String[] args) {
        int[] arr = new int[]{9,8,5,4,6,11,15};
        System.out.println(getAreaMin(arr));
    }

    public static int getAreaMin(int[] arr){
        //前面三个判断表示特殊情况直接返回
        if (arr == null || arr.length == 0) return -1; //not exist
        if (arr[0] < arr[1]) return arr[0];
        if (arr[arr.length-1]< arr[arr.length-2]) return arr[arr.length-1];

        int left = 1;
        int right = arr.length-2;
        int mid = 0;
        while (left<right){
            mid = left + ((right-left)>>>1);
//            mid = (left+right)/2;
//            System.out.println(mid);
            if (arr[mid] > arr[mid+1]){
                right = mid-1;
            }else if (arr[mid] > arr[mid-1]){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
