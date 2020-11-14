package top.greatxiaozou.arithmeticQuestion;

import java.util.HashSet;

/**
 * @author zqf
 * 题目：只由小写字母组成的一批字符串，返回字符串的类数
 * 如果两个字符串所含字符种类完全一样，就称为一类字符串
 * */
public class DifferentTypes {
    public static void main(String[] args) {
        String[] strings = {"abc","bac","babab","babc"};

        System.out.println(types2(strings));
    }

    //方法1
    public static int types1(String[] strings){
        HashSet<String> types = new HashSet<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            boolean[] map = new boolean[26];

            for (int i = 0; i < chars.length; i++) {
                map[chars[i]-'a'] = true;
            }
            StringBuilder key=new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (map[i]){
                    key.append(String.valueOf((char) (i+'a')));
                }
            }
            types.add(key.toString());
        }
        return types.size();
    }

    //方法2
    public static int types2(String[] strings){
        HashSet<Integer> types = new HashSet<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            //由于固定了是26个字母，而一个int类型是32位的，可以单独使用一个int类型的01位图来代表哈希map
            int map = 0;
            for (char aChar : chars) {
                //如果存在，就将字符的位置异或到map上
                map |= (1<<(aChar-'a'));
            }

            //将处理好的map添加进集合，集合可以自动去重
            types.add(map);
        }
        //返回集合的大小
        return types.size();
    }

}
