package leetcode.hot;

public class Lc19 {

    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dumb = new ListNode(-1);
            dumb.next = head;

            ListNode slowPre = dumb;
            ListNode quick = head;
            ListNode slow = head;

            for (int i = 1; i < n; i++) {
                quick = quick.next;
                if (quick == null) {
                    return head;
                }
            }

            while (quick.next != null) {
                quick = quick.next;
                slow = slow.next;
                slowPre = slowPre.next;
            }

            slowPre.next = slow.next;
            slow.next = null;

            return dumb.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        new Lc19().new Solution().removeNthFromEnd(head, 1);
        System.out.println(head);
    }

}
