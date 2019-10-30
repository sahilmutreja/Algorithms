/**
 *  @author Yunxiang He
 *  @date 06/27/2018
 */

package coding.temp;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*

Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.


For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.


Note:
    Both of the given trees will have between 1 and 100 nodes.


*/

public class _0872_Leaf_Similar_Trees {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean leafSimilar_DFS(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        if (root1 != null) {
            DFS(root1, l1);
        }
        if (root2 != null) {
            DFS(root2, l2);
        }
        return l1.equals(l2);
    }

    private void DFS(TreeNode root, List<Integer> l) {
        if (root.left == null && root.right == null) {
            l.add(root.val);
        } else {
            if (root.left != null) {
                DFS(root.left, l);
            }
            if (root.right != null) {
                DFS(root.right, l);
            }
        }
    }
}
