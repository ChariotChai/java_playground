package leetcode.backtracking;

//累加数是一个字符串，组成它的数字可以形成累加序列。
//
// 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
//
// 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
//
// 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
//
// 示例 1:
//
// 输入: "112358"
//输出: true
//解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//
//
// 示例 2:
//
// 输入: "199100199"
//输出: true
//解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
//
// 进阶:
//你如何处理一个溢出的过大的整数输入?
// Related Topics 回溯算法
public class Lc306 {

    class Solution {

        public boolean isAdditiveNumber(String num) {
            if (num.length() < 3) {
                return false;
            }
            return dfs(0, 0, num, 0);
        }

        public boolean dfs(int pp, int p, String leftDigit, int currentIndex) {
            int len = leftDigit.length();

            if (currentIndex == 0) {
                for (int i = 0; i <= len / 3; i++) {
                    if (i < len - 1 && leftDigit.charAt(i + 1) == '0') {
                        continue;
                    }
                    if (dfs(Integer.parseInt(leftDigit.substring(0, i + 1)), 0, leftDigit.substring(i + 1), currentIndex + 1)) {
                        return true;
                    }
                }
            } else if (currentIndex == 1) {
                for (int i = 0; i <= len / 3; i++) {
                    if (i < len - 1 && leftDigit.charAt(i + 1) == '0') {
                        continue;
                    }
                    if (dfs(pp, Integer.parseInt(leftDigit.substring(0, i + 1)), leftDigit.substring(i + 1), currentIndex + 1)) {
                        return true;
                    }
                }
            } else {
                for (int i = 0; i < len; i++) {
                    if (i < len - 1 && leftDigit.charAt(i + 1) == '0') {
                        continue;
                    }
                    int curr = Integer.parseInt(leftDigit.substring(0, i + 1));
                    if (curr == p + pp) {
                        return i == len - 1 || dfs(p, curr, leftDigit.substring(i + 1), currentIndex + 1);
                    }
                }
            }

            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Lc306().new Solution().isAdditiveNumber("112358"));
        System.out.println(new Lc306().new Solution().isAdditiveNumber("199100199"));
        System.out.println(new Lc306().new Solution().isAdditiveNumber("111"));
    }

}
