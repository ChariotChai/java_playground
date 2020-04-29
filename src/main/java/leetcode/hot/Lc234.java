package leetcode.hot;

import com.alibaba.fastjson.JSON;

public class Lc234 {

    //请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            //奇数个node时，slow指向中间node
            //偶数个node时，slow指向分界线前侧的node
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null) {
                fast = fast.next;
                if (fast.next != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            //翻转链表后半部分
            ListNode mid = invert(slow.next);
            System.out.println(JSON.toJSONString(mid));

            //mid.next 与 头结点开始比对
            ListNode start = head;
            while (mid != null) {
                if (start.val != mid.val) {
                    return false;
                }
                mid = mid.next;
                start = start.next;
            }
            return true;
        }

        private ListNode invert(ListNode head) {
            ListNode dump = new ListNode(-1);
            dump.next = head;

            while (head.next != null) {
                ListNode next = head.next;
                head.next = next.next;
                next.next = dump.next;
                dump.next = next;
            }

            return dump.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
//        ListNode l4 = new ListNode(1);
//        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        head.next = l1;

        System.out.println(JSON.toJSONString(new Lc234().new Solution().isPalindrome(head)));
    }
}
