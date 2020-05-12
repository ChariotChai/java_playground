package leetcode.hot;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Lc399 {
    //给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则
//返回 -1.0。
//
// 示例 :
//给定 a / b = 2.0, b / c = 3.0
//问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
//
// 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<p
//air<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.siz
//e()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
//
// 基于上述例子，输入如下：
//
//
//equations(方程式) = [ ["a", "b"], ["b", "c"] ],
//values(方程式结果) = [2.0, 3.0],
//queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]
//].
//
//
// 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
// Related Topics 并查集 图


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Edge {
            double d;
            String vertex;

            public Edge(String vertex, double d) {
                this.d = d;
                this.vertex = vertex;
            }
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, List<Edge>> adj = new HashMap<>();
            for (int i = 0; i < values.length; i++) {
                List<String> equation = equations.get(i);
                String from = equation.get(0);
                String to = equation.get(1);
                addEdge(adj, from, to, values[i]);
                addEdge(adj, to, from, 1 / values[i]);
            }

            int idx = 0;
            double[] ans = new double[queries.size()];
            for (List<String> query : queries) {
                String from = query.get(0);
                String to = query.get(1);
                if (!adj.containsKey(from) || !adj.containsKey(to)) {
                    ans[idx++] = -1;
                } else if (from.equals(to)) {
                    ans[idx++] = 1;
                } else {
                    ans[idx++] = dfs(adj, from, to, new HashSet<>());
                }
            }
            return ans;
        }

        private void addEdge(Map<String, List<Edge>> adj, String from, String to, double val) {
            Edge edge1 = new Edge(to, val);
            if (adj.containsKey(from)) {
                adj.get(from).add(edge1);
            } else {
                List<Edge> l = new LinkedList<>();
                l.add(edge1);
                adj.put(from, l);
            }
        }

        private double dfs(Map<String, List<Edge>> adj, String from, String to, Set<String> visited) {
            for (Edge e : adj.get(from)) {
                if (visited.contains(e.vertex)) {
                    continue;
                }
                if (e.vertex.equals(to)) {
                    return e.d;
                }
                visited.add(from);
                double d = dfs(adj, e.vertex, to, visited);
                if (d > 0) {
                    return e.d * d;
                }
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        //equations(方程式) = [ ["a", "b"], ["b", "c"] ],
//values(方程式结果) = [2.0, 3.0],
//queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = new double[]{2, 3};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        System.out.println(JSON.toJSONString(new Lc399().new Solution().calcEquation(equations, values, queries)));
    }

}
