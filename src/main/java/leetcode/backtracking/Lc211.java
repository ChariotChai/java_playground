package leetcode.backtracking;


//设计一个支持以下两种操作的数据结构：
//
// void addWord(word)
//bool search(word)
//
//
// search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
//
// 示例:
//
// addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
//
//
// 说明:
//
// 你可以假设所有单词都是由小写字母 a-z 组成的。
// Related Topics 设计 字典树 回溯算法


public class Lc211 {


    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        class Node {
            char val;
            boolean leaf;
            Node[] children = new Node[26];

            Node child(char c) {
                return children[c - 'a'];
            }

            Node addChild(char c) {
                Node child = new Node();
                child.val = c;
                children[c - 'a'] = child;
                return child;
            }

            void markAsLeaf() {
                leaf = true;
            }

            boolean search(char[] cs, int index) {
                if (index >= cs.length) {
                    return leaf;
                }
                if (cs[index] == '.') {
                    for (Node n : children) {
                        if (n != null && n.search(cs, index + 1)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    Node n = children[cs[index] - 'a'];
                    return n != null && n.search(cs, index + 1);
                }
            }

        }

        Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                Node child = curr.child(c);
                if (child == null) {
                    child = curr.addChild(c);
                }
                curr = child;
            }
            curr.markAsLeaf();
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return root.search(word.toCharArray(), 0);
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        WordDictionary w = new Lc211().new WordDictionary();
        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        System.out.println(w.search("pad"));
        System.out.println(w.search("bad"));
        System.out.println(w.search(".ad"));
        System.out.println(w.search("m.d"));
        System.out.println(w.search("ma."));
    }

}
