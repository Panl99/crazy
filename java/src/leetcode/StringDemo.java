package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2020/11/28 19:42
 * @auther outman
 **/
public class StringDemo {
    public static void main(String[] args) {
        //替换空格
        String s = "We are happy.";
        System.out.println(replaceBlack(s));

        // Z字型变换
        String str = "ABCDEFGHIJK";
        System.out.println(convert(str, 3));
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

    /**
     * 6. Z字形变换
     * 描述：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *      比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *          L   C   I   R
     *          E T O E S I I G
     *          E   D   H   N
     *      之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *      请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
     * 示例：
     *      输入: s = "LEETCODEISHIRING", numRows = 3
     *      输出: "LCIRETOESIIGEDHN"
     * 示例2：
     *      输入: s = "LEETCODEISHIRING", numRows = 4
     *      输出: "LDREOEIIECIHNTSG"
     *      解释:
     *          L     D     R
     *          E   O E   I I
     *          E C   I H   N
     *          T     S     G
     * 思路：
     *      模拟使用行索引，遍历s时，将每个字符填到对应的行res[i]
     *      res[i] += c;把每个字符c加入对应行si
     *      i += flag；更新当前字符c对应的行索引
     *      flag = -flag；在达到Z字形转折点时，执行反向。
     * 时间复杂度：O(n);
     * 空间复杂度：O(n);
     */
    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        System.out.println(rows);
        return res.toString();
    }
}



