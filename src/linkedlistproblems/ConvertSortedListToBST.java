package linkedlistproblems;

import java.util.ArrayList;
import java.util.List;
//Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.
//Input: head = [-10,-3,0,5,9]
//        Output: [0,-3,9,-10,null,5]
//        Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
public class ConvertSortedListToBST {

    List<Integer> values;

    ConvertSortedListToBST() {
        values = new ArrayList<>();
    }

    void convertIntoArray(ListNode node) {
        while (node != null) {
            this.values.add(node.val);
            node = node.next;
        }
    }

    TreeNode convertIntoBST(int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));

        if (l == r) {
            return node;
        }

        node.left = convertIntoBST(l, mid - 1);
        node.right = convertIntoBST(mid + 1, r);

        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.convertIntoArray(head);
        return convertIntoBST(0, this.values.size() - 1);
    }
}

