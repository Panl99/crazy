package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @create 2020/12/6 23:13
 * @auther outman
 **/
public class SortDemo {
    public static void main(String[] args) {
        diskSort();
    }
    /**
     * 磁盘的容量单位有M、G、T，其关系为 1T = 1000G、1G = 1000M，如样例所示先输入磁盘的个数，再依次输入磁盘的容量大小，然后按照从小到大的顺序对磁盘容量进行排序并输出。
     * 依次输入：3 20M 1T 3G
     * 输出：20M 3G 1T
     */
    public static void diskSort() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        Map<String, Long> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String key = sc.nextLine();
            long reroteKey = Long.parseLong(key.substring(0, key.length() - 1));
            String keySuffix = key.substring(key.length() - 1);

            if (keySuffix.equalsIgnoreCase("T")) {
                reroteKey = reroteKey * 1000 * 1000;
            } else if (keySuffix.equalsIgnoreCase("G")) {
                reroteKey = reroteKey * 1000;
            } else if (keySuffix.equalsIgnoreCase("M")) {

            } else {
                System.out.println("input param invalid, param = " + key);
                continue;
            }
            map.put(key, reroteKey);
        }
        List<String> list = map.entrySet().stream().sorted(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(list);
    }
}
