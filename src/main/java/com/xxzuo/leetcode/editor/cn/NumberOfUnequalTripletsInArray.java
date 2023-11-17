//给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目： 
//
// 
// 0 <= i < j < k < nums.length 
// nums[i]、nums[j] 和 nums[k] 两两不同 。 
// 
// 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。 
// 
// 
//
// 返回满足上述条件三元组的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,4,2,4,3]
//输出：3
//解释：下面列出的三元组均满足题目条件：
//- (0, 2, 4) 因为 4 != 2 != 3
//- (1, 2, 4) 因为 4 != 2 != 3
//- (2, 3, 4) 因为 2 != 4 != 3
//共计 3 个三元组，返回 3 。
//注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,1,1]
//输出：0
//解释：不存在满足条件的三元组，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 100 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 👍 87 👎 0

  
  package com.xxzuo.leetcode.editor.cn;

import java.util.HashMap;

public class NumberOfUnequalTripletsInArray{
      public static void main(String[] args) {
           Solution solution = new NumberOfUnequalTripletsInArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int unequalTriplets(int[] nums) {

        int len = nums.length;
        int res = 0;
        // 第一种 暴力
        // 直接三重循环遍历
//        for(int i = 0; i < len; i++){
//            for(int j = i + 1; j < len; j++){
//                for(int k = j + 1; k < len; k++){
//                    if(nums[i] != nums[k] && nums[i] != nums[j] && nums[j] != nums[k]){
//                        res++;
//                    }
//                }
//            }
//        }

        // 第二种方法 利用 hashMap 记录每个数据出现的次数
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int num : nums){
            record.put(num, record.getOrDefault(num, 0) + 1);
        }

        // 遍历时 我们将 数据分为 三部分
        // 1. 已经遍历过的数据
        // 2. 当前遍历到的数据
        // 3. 还未遍历到的数据
        // 最终结果 就是 这三个数据相加
        int pre = 0;
        for(Integer key : record.keySet()){
            res += pre * record.get(key) * (len - pre - record.get(key));
            pre += record.get(key);
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }