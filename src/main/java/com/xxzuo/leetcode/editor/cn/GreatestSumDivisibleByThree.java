//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 299 👎 0

  
  package com.xxzuo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestSumDivisibleByThree{
      public static void main(String[] args) {
           Solution solution = new GreatestSumDivisibleByThree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumDivThree(int[] nums) {
        // 首先我们 可以将每个数 都分成三种情况
        // 1. n % 3 == 0
        // 2. n % 3 == 1
        // 3. n % 3 == 2
        // 然后计算总和
        // 如果总和 可以被三整除 那我们不需要 减去别的数
        // 如果总和 被三整除 余 1， 此时 需要去掉一个 被三整除余1 的数 或者 去掉两个被三整除余2 的数
        // 如果总和 被三整除 余 2， 此时 需要去掉两个 个 被三整除余1 的数 或者 去掉一个被三整除余2 的数

        // 这样看 就很明显了 要使结果最大 也就是 减去的数最小
        // 用一个嵌套 list 来存储 三种数
        // 先对数组排序
        Arrays.sort(nums);
        List<List<Integer>> record = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            // 初始化
            record.add(new ArrayList<>());
        }
        int total = 0;
        for(int num : nums){
            // 分发 num
            record.get(num % 3).add(num);
            // 计算总和
            total += num;
        }

        int sub = Integer.MAX_VALUE;
        if(total % 3 == 0){
            return total;
        }else if(total % 3 == 1){
            if(record.get(1).size() >= 1){
                sub = Math.min(sub, record.get(1).get(0));
            }
            if(record.get(2).size() >= 2){
                sub = Math.min(sub, record.get(2).get(0) + record.get(2).get(1));
            }
        }else {
            if(record.get(1).size() >= 2){
                sub = Math.min(sub, record.get(1).get(0) + record.get(1).get(1));
            }
            if(record.get(2).size() >= 1){
                sub = Math.min(sub, record.get(2).get(0));
            }
        }

        return total - sub;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }