package leetcode.backtracking;

//请你设计一个迭代器类，包括以下内容：
//
//
// 一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLengt
//h 。
// 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
// 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
//
//
//
//
// 示例：
//
// CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 it
//erator
//
//iterator.next(); // 返回 "ab"
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 "ac"
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 "bc"
//iterator.hasNext(); // 返回 false
//
//
//
//
// 提示：
//
//
// 1 <= combinationLength <= characters.length <= 15
// 每组测试数据最多包含 10^4 次函数调用。
// 题目保证每次调用函数 next 时都存在下一个字母组合。
//
// Related Topics 设计 回溯算法


import java.util.Arrays;

public class Lc1286 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class CombinationIterator {

        private char[] chars;

        private int[] indexes;

        public CombinationIterator(String characters, int combinationLength) {
            this.chars = characters.toCharArray();
            Arrays.sort(this.chars);
            this.indexes = new int[combinationLength];
        }

        public String next() {
            StringBuilder sb = new StringBuilder();
            for (int i : this.indexes) {
                sb.append(chars[i]);
            }

            //找到最后一个
            

            return sb.toString();
        }

        public boolean hasNext() {
            return this.indexes[0] == this.chars.length - this.indexes.length;
        }
    }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
