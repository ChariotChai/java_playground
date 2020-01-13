package leetcode.backtracking;

//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
//
// 示例:
//
// 输入: 2
//输出: 91
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
//
// Related Topics 数学 动态规划 回溯算法

public class Lc357 {

    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n > 10) {
                n = 10;
            }
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 10;
            }

            int sum = 0;
            int lastProduct = 1;
            for (int i = 2; i <= n; i++) {
                lastProduct *= (9 - i + 2);
                sum += lastProduct;
            }
            return sum * 9 + 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Lc357().new Solution().countNumbersWithUniqueDigits(0));
        System.out.println(new Lc357().new Solution().countNumbersWithUniqueDigits(1));
        System.out.println(new Lc357().new Solution().countNumbersWithUniqueDigits(2));
        System.out.println(new Lc357().new Solution().countNumbersWithUniqueDigits(3));
        System.out.println(new Lc357().new Solution().countNumbersWithUniqueDigits(9));
        System.out.println(new Lc357().new Solution().countNumbersWithUniqueDigits(10));
        System.out.println(new Lc357().new Solution().countNumbersWithUniqueDigits(11));
    }

}
