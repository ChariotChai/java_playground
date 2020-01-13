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
            return dfs("", "", num, 0);
        }

        private boolean dfs(String pp, String p, String leftDigits, int currentIndex) {
            int len = leftDigits.length();
            for (int i = 0; i < len; i++) {
                if (i > 0 && leftDigits.charAt(0) == '0') {
                    return false;
                }
                if (currentIndex <= 1) {
                    if (i > len / 2) {
                        break;
                    }
                    if (dfs(p, leftDigits.substring(0, i + 1), leftDigits.substring(i + 1), currentIndex + 1)) {
                        return true;
                    }
                } else {
                    String curr = leftDigits.substring(0, i + 1);
                    if (numStringAddCmp(pp, p, curr)) {
                        return i == len - 1 || dfs(p, curr, leftDigits.substring(i + 1), currentIndex + 1);
                    }
                }
            }
            return false;
        }

        private boolean numStringAddCmp(String x, String y, String expect) {
            int xlen = x.length();
            int ylen = y.length();
            int elen = expect.length();

            int maxLen = Math.max(xlen, ylen);
            if (maxLen != elen && maxLen != elen - 1) {
                return false;
            }

            int i = 0;
            int carry = 0;
            while (i < elen) {
                if (i >= xlen && i >= ylen) {
                    break;
                }
                int sum = (i < xlen ? x.charAt(xlen - i - 1) - '0' : 0) + (i < ylen ? y.charAt(ylen - i - 1) - '0' : 0) + carry;
                if (sum % 10 != expect.charAt(elen - i - 1) - '0') {
                    return false;
                }
                carry = sum / 10;
                i++;
            }

            return i == elen || i == elen - 1 && carry == 1 && expect.charAt(0) == '1';
        }

    }

    public static void main(String[] args) {
        System.out.println(new Lc306().new Solution().isAdditiveNumber("112358"));
        System.out.println(new Lc306().new Solution().isAdditiveNumber("199100199"));
        System.out.println(new Lc306().new Solution().isAdditiveNumber("111"));
        System.out.println(new Lc306().new Solution().isAdditiveNumber("1001"));
        System.out.println(new Lc306().new Solution().isAdditiveNumber("9910011992"));
        System.out.println(new Lc306().new Solution().isAdditiveNumber("198019823962"));
        System.out.println(new Lc306().new Solution().isAdditiveNumber("199001200"));
        System.out.println(new Lc306().new Solution().isAdditiveNumber("123"));
    }

}
