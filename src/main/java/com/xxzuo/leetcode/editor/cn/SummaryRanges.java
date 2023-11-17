//给定一个 无重复元素 的 有序 整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
//
// Related Topics 数组 👍 306 👎 0

  
  package com.xxzuo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges{
      public static void main(String[] args) {
           Solution solution = new SummaryRanges().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        String start = "";
        String end = "";
        List<String> res = new ArrayList<>();
        if(length == 0){
            return res;
        }
        // 如果只有一个 肯定前后区间都是它
        if(length == 1){
            res.add(String.valueOf(nums[0]));
            return res;
        }
        for (int i = 0; i < length; i++){
            // 第一个开始的 肯定是 区间起始
            if(i == 0){
                start = String.valueOf(nums[i]);
            }else {
                // 判断当前数字 是不是比前面一个正好大1
                // 如果正好不是正好大一 说明 肯定是新区间的开始
                if(nums[i] != nums[i - 1] + 1){
                    start = String.valueOf(nums[i]);
                }
            }
            // 判断当前数字 是不是正好比 后面一个数 小1
            // 如果不是正好小1  那么说明当前数字肯定是 一个区间的结尾
            if(i < length - 1 && nums[i] + 1 != nums[i+1]){
                end = String.valueOf(nums[i]);
                // 判断开始 和 结尾两个数字是否相同
                if(end.equals(start)){
                    res.add(start);
                }else {
                    res.add(start.concat("->").concat(end));
                }
            }
            // 最后一个数时 特殊判断
            if(i == length - 1){
                end = String.valueOf(nums[i]);
                // 如果正好 前一个数+1 那就是区间的结尾
                // 如果不是 前一个数 +1 那就单独成一个区间 开始结尾都是自己
                if(nums[i] == nums[i - 1] + 1){
                    if(end.equals(start)){
                        res.add(start);
                    }else {
                        res.add(start.concat("->").concat(end));
                    }
                }else {
                    res.add(end);
                }
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }