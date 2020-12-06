package leetcode;

/**
 * @create 2020/11/28 19:42
 * @auther outman
 **/
public class StringDemo {
    public static void main(String[] args) {

        String s = "We are happy.";
        System.out.println(replaceBlack(s));
    }

    /**
     * 替换空格
     * 描述：实现一个函数，把字符串中的每个空格替换成"%20"。
     * 示例：
     *      输入："We are happy."
     *      输出："We%20are%20happy."
     * 注意：
     *      陷阱：如果直接使用replace：s.replace(" ", "%20"); 原来一个" "空格字符，替换后变成'%'、'2'、'0'三个字符。在原字符串上替换，可能会覆盖修改该字符串后面的内存，需要确定内存是否足够。（在新字符串上替换，我们可以自己分配足够内存）
     * 思路：
     *      从后往前复制，数组长度会增加
     *      使用StringBuilder、StringBuffer类; 时间复杂度：O(n);空间复杂度：O(n);
     */

    public static String replaceBlack(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(" ")) {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}



