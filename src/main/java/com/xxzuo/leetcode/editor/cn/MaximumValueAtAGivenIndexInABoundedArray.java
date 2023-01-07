//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）： 
//
// 
// nums.length == n 
// nums[i] 是 正整数 ，其中 0 <= i < n 
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1 
// nums 中所有元素之和不超过 maxSum 
// nums[index] 的值被 最大化 
// 
//
// 返回你所构造的数组中的 nums[index] 。 
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
// 
//
// 示例 2： 
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= maxSum <= 10⁹ 
// 0 <= index < n 
// 
//
// Related Topics 贪心 二分查找 👍 132 👎 0

  
  package com.xxzuo.leetcode.editor.cn;
  public class MaximumValueAtAGivenIndexInABoundedArray{
      public static void main(String[] args) {
           Solution solution = new MaximumValueAtAGivenIndexInABoundedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        // 模拟金字塔堆叠
        // 先铺第一层
        // remain 为铺完该层 剩下的 数量
        int remain = maxSum - n;
        // res 为层数
        int res = 1;

        int left = index;
        int right = index;
        int leftUse = 0;
        int rightUse = 0;

        while (remain > 0){
            if(--left >= 0){
                leftUse++;
            }
            if(++right < n){
                rightUse++;
            }

            if(left <0 && right >= n){
                res += (remain%n == 0 ? remain / n : remain / n + 1);
                return res;
            }
            res++;
            remain -= (leftUse + rightUse + 1);
        }
        return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }