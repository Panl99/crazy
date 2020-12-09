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
        //磁盘容量排序
        diskSort();

        // 二分查找
        int[] nums = {3,4,6,20,40,45,51,62,70,99,110};
        System.out.println(binarySearch(nums, 20)); //3

        // 冒泡排序
        System.out.println(bubbleSort(nums));
        // 插入排序
        System.out.println(insertSort(nums));
        // 快速排序
        quickSort(nums, 0, 10);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        //希尔排序
        //归并排序
        //桶排序
        //基数排序
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

    /**
     * 二分查找
     * 原理：每次拿中间位置的值与待查找值比较，比待查找值大，则在前半部分继续查找；否则在后半部分继续查找。
     * 要求：查找的序列有序（否则要先排序，在查找）
     * 示例：[3,4,6,20,40,45,51,62,70,99,110]；查找：key=20
     */
    public static int binarySearch(int[] nums, int a) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == a) {
                return mid;
            } else if (a > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 冒泡排序
     * 原理：依次比较相邻两个元素，如果左边大于右边，则二者交换位置。如此重复。
     * 示例：[4,5,6,3,2,1]
     *      第1趟：[4,5,3,2,1,6]
     *      第2趟：[4,3,2,1,5,6]
     *      第3趟：[3,2,1,4,5,6]
     *      第4趟：[2,1,3,4,5,6]
     *      第5趟：[1,2,3,4,5,6]
     */
    public static int[] bubbleSort(int[] nums) {
        // 外层循环控制轮数
        for (int i = 0; i < nums.length - 1; i++) {
            // 内层循环控制每趟次数
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        return nums;
    }

    /**
     * 插入排序
     * 原理：将序列分为两个子序列，L默认拿第一个数，然后每次从R中拿一个插入L中从右到左比自己大的后边，将L中比自己大的整体后移，L序总是有序的。
     * 将一个数据插入已经拍好序的序列中，适用于少量数据排序，稳定。
     * 示例：[ 6, 2, 5, 8, 7 ]
     *      将该数组分为两个子集，L:[6];R:[2, 5, 8, 7 ]
     *      每次从R中拿一个插入L中从右到左比自己大的后边，将L中比自己大的整体后移。
     *      第1趟：L：[ 6 ]；            R：[2, 5, 7, 8 ]
     *      第2趟：L：[ 2, 6 ]；         R：[5, 7, 8 ]
     *      第3趟：L：[ 2, 5, 6 ]；      R：[7, 8 ]
     *      第4趟：L：[ 2, 5, 6, 7 ]；   R：[ 8 ]
     *      第5趟：L：[ 6, 2, 5, 7, 8 ]；R：[ ]
     */
    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertVal = nums[i];
            //被插入位置(和前一个数比较)
            int index = i - 1;
            while (index >= 0 && insertVal < nums[index]) {
                //将nums[index]向后移动
                nums[index + 1] = nums[index];
                //将index向前移动
                index--;
            }
            nums[index + 1] = insertVal;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        return nums;
    }

    /**
     * 快速排序
     * 原理：一趟排序将序列分为两部分，其中一部分的所有数据都比另一部分所有数据小。
     *      选择一个关键值作为基准值(一般第1个)，将比基准值大的放到右序列中，小的放到左序列中。
     *      （1）从后向前比较，用基准值和最后一个值进行比较。如果比基 准值小，则交换位置；如果比基准值大，则继续比较下一个值，直到 找到第1个比基准值小的值才交换位置。
     *      （2）在从后向前找到第1个比基准值小的值并交换位置后，从前向后开始比较。如果有比基准值大的，则交换位置；如果没有，则继续比较下一个，直到找到第1个比基准值大的值才交换位置。
     *      （3）重复执行以上过程，直到从前向后比较的索引大于等于从后向前比较的索引，则结束一次循环。这时对于基准值来说，左右两边都是有序的数据序列。
     *      （4）重复循环以上过程，分别比较左右两边的序列，直到整个数据序列有序。
     * 示例：[6,9,5,7,8]
     *      第一层递归：（基准值6前面的数据都比6小，6后面的数据都比6大）
     *          第1趟（5和6交换）：[5,9,6,7,8]
     *          第2趟（9和6交换）：[5,6,9,7,8]
     *      重复上述递归过程。
     */
    public static int[] quickSort(int[] nums, int low, int high) {
        int start = low; //从前向后比较的索引
        int end = high; //从后向前比较的索引
        int key = nums[low]; //基准值

        while (end > start) {
            //从后向前比较
            while (end > start && nums[end] >= key){
                end--;
            }
            //如果没有比基准值小的，则比较下一个，直到有比基准值小的，就交换位置，然后又从前向后比较。
            if (nums[end] <= key){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
            //从前向后比较
            while (end > start && nums[start] <= key) {
                start++;
            }
            //如果没有比基准值大的，则比较下一个，直到有比基准值大的，就交换位置。
            if (nums[start] >= key){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            //第一次循环比较结束
        }
        if (start > low) {
            quickSort(nums, low, start-1);
        }
        if (end < high) {
            quickSort(nums, end+1, high);
        }

        return nums;
    }
}
