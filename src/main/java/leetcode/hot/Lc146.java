package leetcode.hot;

import java.util.HashMap;
import java.util.Map;

public class Lc146 {

    //运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写
//入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
// 进阶:
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例:
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//
// Related Topics 设计


    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class LRUCacheNode {
            LRUCacheNode pre;
            LRUCacheNode next;
            int k;
            int val;
        }

        Map<Integer, LRUCacheNode> m = new HashMap<>();

        LRUCacheNode head;

        LRUCacheNode tail;

        int cap;

        int len;

        private void addAfter(LRUCacheNode node, LRUCacheNode pos) {
            node.next = pos.next;
            node.pre = pos;
            pos.next.pre = node;
            pos.next = node;
        }

        private void remove(LRUCacheNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public LRUCache(int capacity) {
            cap = capacity;
            head = new LRUCacheNode();
            tail = new LRUCacheNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            LRUCacheNode node = m.get(key);
            if (node == null) {
                return -1;
            }
            remove(node);
            addAfter(node, head);
            return node.val;
        }

        public void put(int key, int value) {
            LRUCacheNode node = m.get(key);
            if (node != null) {
                node.val = value;
                get(key);
                return;
            }
            node = new LRUCacheNode();
            node.val = value;
            node.k = key;
            m.put(key, node);
            if (len <= cap) {
                len++;
            } else {
                m.remove(tail.pre.k);
                remove(tail.pre);
            }
            addAfter(node, head);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


}
