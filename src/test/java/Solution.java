import org.junit.Test;
import top.greatxiaozou.Utils.MyUtils;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,7,1,3,7,3,3,2,4,4,2};
        MyUtils.print(getNums(arr));
    }
    public static int[] getNums(int[] arr){
        int ab = 0;
        for (int i = 0;i<arr.length;i++){
            ab ^=arr[i];
        }
        int rab = (~ab)+1;
        int a =0,b=0;

        for(int i = 0;i<arr.length;i++){
            if((arr[i] & rab) == 0){
                a ^=arr[i];
            }else{
                b ^=arr[i];
            }
        }
        return new int[]{a,b};
    }

    @Test
    public void test01(){
        int[][] arr = new int[][]{{}};
        System.out.println(arr[0].length);
    }
}