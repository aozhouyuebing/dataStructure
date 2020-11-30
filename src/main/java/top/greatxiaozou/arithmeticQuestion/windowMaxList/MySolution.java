package top.greatxiaozou.arithmeticQuestion.windowMaxList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 有一个整形数组arr和一个大小为w的窗口从数组的最左边滑倒最右边，窗口每次向右滑一个位置。
 * 请实现一个函数：
 * - 输入：整形数组arr，窗口大小为w
 * - 输出：一个长度为n-w+1的数组res，res[i]为每一种窗口状态下的最大值。
 */
//双端队列实现
public class MySolution {
    public static void main(String[] args) {
    }

    //自己写的双端队列解法
    public static int[] solution(int[] arr,int w){
        if (w>arr.length && arr==null) return null;

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] maxArr = new int[arr.length-w+1];
        int index = 0;
        for (int i=0;i<arr.length;i++){
            //开始
            while (!qmax.isEmpty() && arr[i]>=arr[qmax.peekLast()]){
                qmax.pollLast();
            }
            qmax.add(i);
            if (qmax.peek()<(i-w)+1){
                qmax.pollFirst();
            }
            //当遍历的i大于等于窗口大小-1时，如果窗位3，即遍历到2的时候就开始往最大数值中写入值
            if (i >= w-1){
                maxArr[index++] = arr[qmax.peekFirst()];
            }
        }
        return maxArr;
    }
}
