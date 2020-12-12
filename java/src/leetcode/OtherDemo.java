package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @create 2020/11/10 12:02
 * @auther outman
 **/
public class OtherDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //整数分解成两个质数和
        while (sc.hasNextLine()) {
            int num = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            while (num != 0) {
                nums.add(num);
                num = sc.nextInt();
            }
            sc.nextLine();
            goldBach(nums);
        }
        sc.close();
    }

    /**
     * 如果一个整数可以分解成两个质数的和，求有这样的质数的组数，比如18可以分解成7+11、5+13，即两组。
     * 支持一次输入多行，以0结束输入，输出以"end"字符串结束，下面是样例
     *      输入：
     *              2
     *              5
     *              10
     *              18
     *              0
     *      输出：
     *              0
     *              1
     *              2
     *              2
     *              end
     */
    public static void goldBach(List<Integer> nums){
        for (int n : nums) {
            int count = 0;
            if (n > 2) {
                for (int i = 2; i <= n/2; i++) {
                    if (ifPrime(i) && ifPrime(n-i)) {
                        count++;
//                        System.out.println("数为: " +i + " 和" + (n-i) );
                    }
                }
                System.out.println(count > 0 ? count : 0);
            } else {
                System.out.println(0);
            }
        }
        System.out.println("end");
    }
    //判断数是否是质数
    public static boolean ifPrime(int num){
        for (int i = 2; i <num; i++) {
            if (num % i==0) {
                return false;
            }
        }
        return true;
    }
}
