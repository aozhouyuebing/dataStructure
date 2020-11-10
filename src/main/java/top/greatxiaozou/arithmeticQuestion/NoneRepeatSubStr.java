package top.greatxiaozou.arithmeticQuestion;

import java.security.ProtectionDomain;
import java.util.HashMap;

/**
 * @author 澳洲月饼
 * @date 2020-11-5
 * 描述：给出一个字符串，返回该字符串出现的最长的无重复字串的长度
 * 滑动窗格的经典题
 * */

public class NoneRepeatSubStr {
    public static void main(String[] args) {
       // System.out.println(solotion2("au"));
        char a = '9';
        System.out.println('0');
        System.out.println(a-48);
    }

    public static int solotion(String s){
        if (s==null||s.length()==0) return 0;
        char[] chars = s.toCharArray();

        //使用一个26空间的int数组来记录字符最后一次出现的位置
        int[] last = new int[26];

        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }
        //初始化
        int max = 1;
        last[chars[0]-'a'] = 0;
        int preMaxlen = 1;

        for (int i = 1; i < chars.length; i++) {
            preMaxlen = Math.min(preMaxlen+1,i-last[chars[i]-'a']);
            max = Math.max(preMaxlen,max);
            last[chars[i]-'a']=i;
        }
        return max;
    }
    public static int solotion2(String s){
        if (s==null||s.length()==0) return 0;
        char[] chars = s.toCharArray();

        //用map来存字符上一次出现的位置
        //key：字符
        //value：上次出现的位置
        HashMap<Character,Integer> map = new HashMap<>();

        //初始化
        int max = 1;
        map.put(chars[0],0);
        int preMaxlen = 1;

        for (int i = 1; i < chars.length; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i],i);
                preMaxlen++;

            }else {
                preMaxlen = Math.min(i-map.get(chars[i]),preMaxlen+1);
            }

            max = Math.max(preMaxlen,max);
            map.put(chars[i],i);
        }
        return max;
    }
}
