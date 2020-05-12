package leetcode.hot;

import com.alibaba.fastjson.JSON;

public class Lc406 {
    //假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。
//
// 注意：
//总人数少于1100人。
//
// 示例
//
//
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
//
// Related Topics 贪心算法


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            sort(people, 0, people.length - 1);

            for (int i = people.length - 2; i >= 0; i--) {
                int[] curr = people[i];
                if (curr[1] > 0) {
                    shiftBack(people, i, curr[1]);
                }
            }

            return people;
        }

        private void shiftBack(int[][] arr, int pos, int shift) {
            int[] tmp = arr[pos];
            System.arraycopy(arr, pos + 1, arr, pos, shift);
            arr[pos + shift] = tmp;
        }

        private void sort(int[][] arr, int lo, int hi) {
            if (lo > hi) {
                return;
            }
            int[] base = arr[lo];
            int pivot = lo;
            for (int i = lo + 1; i <= hi; i++) {
                int[] t = arr[i];
                if (t[0] < base[0] || t[0] == base[0] && t[1] >= base[1]) {
                    swap(arr, ++pivot, i);
                }
            }
            swap(arr, pivot, lo);
            sort(arr, lo, pivot - 1);
            sort(arr, pivot + 1, hi);
        }

        private void swap(int[][] arr, int from, int to) {
            if (from == to) {
                return;
            }
            int[] tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        new Lc406().new Solution().reconstructQueue(people);
        System.out.println(JSON.toJSONString(people));
    }

}
