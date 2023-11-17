//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1837 👎 0


package com.xxzuo.leetcode.editor.cn;

import com.xxzuo.leetcode.editor.cn.common.TreeNode;

import java.util.HashMap;

public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        private HashMap<TreeNode, Integer> record;
        public int rob(TreeNode root) {
            record = new HashMap<>();
            return dfs(root);
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if(record.containsKey(root)){
                return record.get(root);
            }
            if (root.left == null && root.right == null) {
                record.put(root, root.val);
                return root.val;
            }

            if (root.left == null) {

                int rightVal = Math.max(dfs(root.right), root.val + dfs(root.right.left) + dfs(root.right.right));
                record.put(root, rightVal);
                return rightVal;
            }
            if (root.right == null) {
                int leftVal = Math.max(dfs(root.left), root.val + dfs(root.left.left) + dfs(root.left.right));
                record.put(root, leftVal);
                return leftVal;
            }
            int res = Math.max(dfs(root.left) + dfs(root.right), root.val + dfs(root.left.left) + dfs(root.left.right) + dfs(root.right.left) + dfs(root.right.right));
            record.put(root, res);
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}