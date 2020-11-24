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

        System.out.println(types1(strings));
    }

    //方法1
    public static int types1(String[] strings){
        HashSet<String> types = new HashSet<>();

        for (String string : strings) {
            //使用字符串的toCharArray()方法来得到一个字符型的数组，方便遍历
            char[] chars = string.toCharArray();
            //使用一个布尔型的数组来记录，利用字符的ascall码来当字符索引
            boolean[] map = new boolean[26];

            for (int i = 0; i < chars.length; i++) {
                //出现过的字符，将其ascll码减去字符'a'之后记录到布尔数组里
                map[chars[i]-'a'] = true;
            }
            StringBuilder key=new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (map[i]){
                    //将出现过的字符添加到key里，由于遍历的顺序是固定的，所以待会往集合存的时候不需要关心顺序问题
                    key.append(String.valueOf((char) (i+'a')));
                }
            }
            //将key字符串化并存到集合中
            types.add(key.toString());
        }
        //返还types的大小，即字符出现的种类
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
