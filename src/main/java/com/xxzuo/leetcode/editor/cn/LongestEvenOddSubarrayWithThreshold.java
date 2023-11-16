//给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。 
//
// 请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
// 
//
// 
// nums[l] % 2 == 0 
// 对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2 
// 对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold 
// 
//
// 以整数形式返回满足题目要求的最长子数组的长度。 
//
// 注意：子数组 是数组中的一个连续非空元素序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,2,5,4], threshold = 5
//输出：3
//解释：在这个示例中，我们选择从 l = 1 开始、到 r = 3 结束的子数组 => [2,5,4] ，满足上述条件。
//因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。 
//
// 示例 2： 
//
// 输入：nums = [1,2], threshold = 2
//输出：1
//解释：
//在这个示例中，我们选择从 l = 1 开始、到 r = 1 结束的子数组 => [2] 。
//该子数组满足上述全部条件。可以证明 1 是满足题目要求的最大长度。
// 
//
// 示例 3： 
//
// 输入：nums = [2,3,4,5], threshold = 4
//输出：3
//解释：
//在这个示例中，我们选择从 l = 0 开始、到 r = 2 结束的子数组 => [2,3,4] 。 
//该子数组满足上述全部条件。
//因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 1 <= threshold <= 100 
// 
//
// Related Topics 数组 滑动窗口 👍 32 👎 0

  
  package com.xxzuo.leetcode.editor.cn;
  public class LongestEvenOddSubarrayWithThreshold{
      public static void main(String[] args) {
           Solution solution = new LongestEvenOddSubarrayWithThreshold().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        // 暴力枚举
        for(int left = 0; left < nums.length; left++){
            for(int right = left; right < nums.length; right++){
                if(check(left, right, nums, threshold)){
                    res = Math.max(res, right - left + 1);
                }
            }
        }
        return res;
    }

          /**
           * 判断当前窗口内 是否满足条件
           * @param left
           * @param right
           * @param nums
           * @param threshold
           * @return
           */
    public boolean check(int left, int right, int[] nums, int threshold){
        if(nums[left] % 2 != 0){
            return false;
        }

        for(int i = left; i<= right; i++){
            if(nums[i] > threshold || (i < right && nums[i] % 2 == nums[i + 1] % 2) ){
                return false;
            }
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }