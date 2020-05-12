package leetcode.hot;

import java.util.Arrays;

public class Lc621 {
    //给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务
//都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
//
// 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
//
// 你需要计算完成所有任务所需要的最短时间。
//
//
//
// 示例 ：
//
// 输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
//
//
//
// 提示：
//
//
// 任务的总个数为 [1, 10000]。
// n 的取值范围为 [0, 100]。
//
// Related Topics 贪心算法 队列 数组

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char t : tasks) {
                map[t - 'A']++;
            }
            Arrays.sort(map);
            //不妨记任务数最多的为 a0，a0 的数量为 m0；
            //考虑共有 m0 个桶
            //依次处理 m1 m2 等。如果 mi == m0，则这 m0 个桶都放一个
            //否则 mi < m0，只要按顺序依次放入 1 ~ m0 -1 号桶即可，同一类的任务，肯定会分在相邻桶的同一水平线上，或者是首个桶的l+1水平线上
            //无论哪种，都可以保证这两个任务之间至少隔着n个任务
            //前 m0 - 1 每个桶至少需要装 n 个任务，最后一个桶则无此要求，不足n个的用"空闲"补齐
            //最后总时长 = 空闲任务数 + 总任务数

            int maxCnt = map[25];
            int idleCnt = (maxCnt - 1) * n;
            for (int i = 24; i >= 0; i--) {
                if (map[i] == 0 || idleCnt <= 0) {
                    break;
                }
                idleCnt -= maxCnt == map[i] ? maxCnt - 1 : map[i];
            }
            return idleCnt > 0 ? idleCnt + tasks.length : tasks.length;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Lc621().new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
//leetcode submit region end(Prohibit modification and deletion)

}
