package leetcode.hot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Lc207 {
    //你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
//
//
//
// 示例 1:
//
// 输入: 2, [[1,0]]
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
//
// 示例 2:
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
//
//
//
// 提示：
//
//
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
// 你可以假定输入的先决条件中没有重复的边。
// 1 <= numCourses <= 10^5
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            //邻接表
            HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
            //入度数组
            int[] indegree = new int[numCourses];

            for (int i = 0; i < prerequisites.length; i++) {
                int[] l = prerequisites[i];
                if (adj.containsKey(l[1])) {
                    adj.get(l[1]).add(l[0]);
                } else {
                    HashSet<Integer> s = new HashSet<>();
                    s.add(l[0]);
                    adj.put(l[1], s);
                }
                indegree[l[0]]++;
            }

            Queue<Integer> todo = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    todo.add(i);
                }
            }

            int count = 0;
            while (!todo.isEmpty()) {
                int id = todo.poll();
                count++;
                if (adj.containsKey(id)) {
                    for (int i : adj.get(id)) {
                        indegree[i]--;
                        if (indegree[i] == 0) {
                            todo.add(i);
                        }
                    }
                }
            }

            return count == numCourses;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Lc207().new Solution().canFinish(2, new int[][]{{0, 1}}));
        System.out.println(new Lc207().new Solution().canFinish(5, new int[][]{{1, 3}, {2, 3}, {1, 4}, {2, 4}, {0, 1}, {0, 2}}));
        System.out.println(new Lc207().new Solution().canFinish(2, new int[][]{{0, 1}, {1, 0}}));
    }

}
