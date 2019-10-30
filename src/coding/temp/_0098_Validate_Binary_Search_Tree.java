/**
 *  @author Yunxiang He
 *  @date 01/29/2018
 */

package coding.temp;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.


Example 1:
        2
       / \
      1   3
    Binary tree [2,1,3], return true.

Example 2:
        1
       / \
      2   3
    Binary tree [1,2,3], return false.

*/

public class _0098_Validate_Binary_Search_Tree {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // lowerBound < node.val < upperBound
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long low, long up) {
        if (node == null) {
            return true;
        } else {
            return low < node.val && node.val < up && isValidBST(node.left, low, node.val) && isValidBST(node.right, node.val, up);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private TreeNode pre = null;

    public boolean isValidBST_inorder(TreeNode root) {
        return root == null || (isValidBST_inorder(root.left) && (pre == null || root.val > pre.val) && ((pre = root) == root)) && isValidBST_inorder(root.right);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean isValidBST_inorder2(TreeNode root) {
        TreeNode pre = null;
        TreeNode curr = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.pollFirst();
                if (pre != null && curr.val <= pre.val) {
                    return false;
                }
                pre = curr;
                curr = curr.right;
            }
        }
        return true;
    }
}
