package top.greatxiaozou.Utils;

import java.util.Random;

public class MyUtils {

    //打印数组
    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //交换数组中两个数的位置
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //产出一组20个数字的随机数组
    public static int[] randomArr(){
        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = random.nextInt(51);
        }
        return arr;
    }
}
